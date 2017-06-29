package com.igool.thrift.rpc;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.igool.thrift.rpc.zookeeper.ThriftServerAddressProvider;

/**
 * 客户端代理
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ThriftServiceClientProxyFactory implements FactoryBean, InitializingBean,Closeable {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	private ThriftServerAddressProvider serverAddressProvider;
	private ThriftClientManager clientManager;

	private Object proxyClient;
	private Class<?> objectClass;



	public void setServerAddressProvider(ThriftServerAddressProvider serverAddressProvider) {
		this.serverAddressProvider = serverAddressProvider;
	}

	public void setClientManager(ThriftClientManager clientManager) {
		this.clientManager = clientManager;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		// 加载service接口
		objectClass = classLoader.loadClass(serverAddressProvider.getService() );
		InetSocketAddress address = serverAddressProvider.selector();
		if(address==null){
			throw new ThriftException("No provider available for remote service");
		}
		FramedClientConnector framedClientConnector =  new FramedClientConnector(new InetSocketAddress(address.getHostName(), address.getPort()));
		proxyClient =  clientManager.createClient(framedClientConnector
				,
				objectClass).get();
		logger.info("init service {}",proxyClient);
	}

	@Override
	public Object getObject() throws Exception {
		return proxyClient;
	}

	@Override
	public Class<?> getObjectType() {
		return objectClass;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	
	@Override
	public void close() {
		if(clientManager!=null){
			try {
				clientManager.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (serverAddressProvider != null) {
			try {
				serverAddressProvider.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
