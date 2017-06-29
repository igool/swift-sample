package com.igool.ping.service.thrift;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by igool on 2017/6/27.
 */
public class HelloServiceImpl implements HelloService  {
    private static final Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);

    public void close() {
        this.close();
    }

    public String ping() throws TException {
        log.info("ping ");
        return "127.0.0.1";
    }
}
