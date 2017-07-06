package com.igool;

import com.facebook.nifty.core.NettyServerConfig;
import com.facebook.nifty.core.ThriftServerDef;
import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftEventHandler;
import com.facebook.swift.service.ThriftServer;
import com.facebook.swift.service.ThriftServiceProcessor;
import com.google.common.collect.ImmutableList;
import com.igool.file.service.thrift.FileServiceImpl;
import com.igool.ping.service.thrift.HelloServiceImpl;
//import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newCachedThreadPool;
import static java.util.concurrent.Executors.newFixedThreadPool;
/**
 * Created by igool on 2017/6/27.
 */
public class ServerCreator {
    private ExecutorService taskWorkerExecutor;
    private ThriftServer server;
    private ExecutorService bossExecutor;
    private ExecutorService ioWorkerExecutor;

    public ThriftServer getServer() {
        return server;
    }

    public ServerCreator invoke() {
        List serviceList = new ArrayList();
        serviceList.add(new HelloServiceImpl());
        serviceList.add(new FileServiceImpl());
        ThriftServiceProcessor processor = new ThriftServiceProcessor(
                new ThriftCodecManager(),
                ImmutableList.<ThriftEventHandler>of(),
                serviceList
        );

        taskWorkerExecutor = newFixedThreadPool(1);

        ThriftServerDef serverDef = ThriftServerDef.newBuilder()
                .listen(12345)
                .withProcessor(processor)
                .using(taskWorkerExecutor)
                .build();

        bossExecutor = newCachedThreadPool();
        ioWorkerExecutor = newCachedThreadPool();

        NettyServerConfig serverConfig = NettyServerConfig.newBuilder()
                .setBossThreadExecutor(bossExecutor)
                .setWorkerThreadExecutor(ioWorkerExecutor)
                .build();

        server = new ThriftServer(serverConfig, serverDef);
        return this;
    }

    /*public void checkExecutorsTerminated() {
        Assert.assertTrue(bossExecutor.isTerminated());
        Assert.assertTrue(ioWorkerExecutor.isTerminated());
        Assert.assertTrue(taskWorkerExecutor.isTerminated());
    }*/

    public void stop() {
        server.close();
    }
}

