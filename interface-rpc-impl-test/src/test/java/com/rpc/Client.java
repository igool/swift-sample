package com.rpc;

import com.facebook.swift.service.ThriftClientManager;
import com.igool.file.service.thrift.FileService;
import com.igool.ping.service.thrift.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


//客户端调用
@SuppressWarnings("resource")
public class Client {
	private static final Logger log = LoggerFactory.getLogger(Client.class);
	public static void main(String[] args) {
		spring();
	}

	public static void spring() {
		try {
			final ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-thrift-client.xml");
			HelloService helloService = (HelloService) context.getBean("helloService");
            FileService fileService = (FileService) context.getBean("fileService");
			/*while (true) {
				log.info(helloService.ping());
			//}
			//关闭连接的钩子
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					ThriftClientManager thriftClientManager = (ThriftClientManager) context.getBeansOfType(ThriftClientManager.class);
					thriftClientManager.close();
				}
			});
			}*/
			int max = 100000;
			Long start = System.currentTimeMillis();
			for (int i = 0; i < max; i++) {
				helloService.ping();
				//helloService.close();
			}
			// helloService.close();
			// clientManager.close();
			Long end = System.currentTimeMillis();
			Long elapse = end - start;
			int perform = Double.valueOf(max / (elapse / 1000d)).intValue();

			log.info("thrift " + max + " 次RPC调用，耗时：" + elapse + "毫秒，平均" + perform + "次/秒");
            log.info("file servie {}",fileService.deleteFile("test", true));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
