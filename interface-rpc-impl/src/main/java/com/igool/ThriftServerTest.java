package com.igool;

import com.facebook.swift.service.ThriftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by igool on 2017/6/27.
 */
public class ThriftServerTest {
    private static final Logger log = LoggerFactory.getLogger(ThriftServerTest.class);
    public static void main(String[] args) {

        ServerCreator serverCreator = new ServerCreator().invoke();
        ThriftServer server = serverCreator.getServer();

        server.start();
        log.info("服务已启动!");

        //serverCreator.stop();
        //serverCreator.checkExecutorsTerminated();

    }
}
