package com.igool.ping.service.thrift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("HelloService")
public interface HelloService extends Closeable
{
    @ThriftService("HelloService")
    public interface Async extends Closeable
    {
        void close();

        @ThriftMethod(value = "ping")
        ListenableFuture<String> ping();
    }
    void close();


    @ThriftMethod(value = "ping")
    String ping() throws org.apache.thrift.TException;
}