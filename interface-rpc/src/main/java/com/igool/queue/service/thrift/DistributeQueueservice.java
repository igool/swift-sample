package com.igool.queue.service.thrift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("DistributeQueueservice")
public interface DistributeQueueservice extends Closeable
{
    @ThriftService("DistributeQueueservice")
    public interface Async extends Closeable
    {
        void close();

        @ThriftMethod(value = "addQueueEntry")
        ListenableFuture<Void> addQueueEntry(
            @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final String key,
            @ThriftField(value=2, name="itemEntry", requiredness=Requiredness.NONE) final ItemEntry itemEntry
        );

        @ThriftMethod(value = "getQueueList")
        ListenableFuture<List<ItemEntry>> getQueueList(
            @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final String key
        );

        @ThriftMethod(value = "addQueueStr")
        ListenableFuture<Void> addQueueStr(
            @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final String key,
            @ThriftField(value=2, name="jsonStr", requiredness=Requiredness.NONE) final String jsonStr
        );

        @ThriftMethod(value = "getQueueListStr")
        ListenableFuture<List<String>> getQueueListStr(
            @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final String key
        );
    }
    void close();


    @ThriftMethod(value = "addQueueEntry")
    void addQueueEntry(
        @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final String key,
        @ThriftField(value=2, name="itemEntry", requiredness=Requiredness.NONE) final ItemEntry itemEntry
    ) throws org.apache.thrift.TException;

    @ThriftMethod(value = "getQueueList")
    List<ItemEntry> getQueueList(
        @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final String key
    ) throws org.apache.thrift.TException;

    @ThriftMethod(value = "addQueueStr")
    void addQueueStr(
        @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final String key,
        @ThriftField(value=2, name="jsonStr", requiredness=Requiredness.NONE) final String jsonStr
    ) throws org.apache.thrift.TException;

    @ThriftMethod(value = "getQueueListStr")
    List<String> getQueueListStr(
        @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final String key
    ) throws org.apache.thrift.TException;
}