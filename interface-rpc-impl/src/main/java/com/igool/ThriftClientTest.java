package com.igool;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.swift.service.ThriftClientManager;
import com.igool.file.service.thrift.FileService;
import com.igool.ping.service.thrift.HelloService;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;

/**
 * Created by igool on 2017/6/27.
 */
public class ThriftClientTest {
    private static final Logger log = LoggerFactory.getLogger(ThriftClientTest.class);
    public static void main(String[] args) throws ExecutionException, InterruptedException, TException, TException {
        final ThriftClientManager clientManager = new ThriftClientManager();
        FramedClientConnector framedClientConnector =  new FramedClientConnector(new InetSocketAddress("localhost", 12345));
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                try{
                    //do something
                    log.info("The JVM Hook is execute");
                    clientManager.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //while (true){

            HelloService helloService = clientManager.createClient(framedClientConnector
                   ,
                    HelloService.class).get();
            FileService fileService = clientManager.createClient(
                    framedClientConnector,
                    FileService.class).get();
           log.info(helloService.ping());

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
            fileService.storeFile(null,null,true);
           // fileService.close();
            helloService.ping();

            Thread.sleep(1000);
        }
   // }
}
