package com.igool.file.service.thrift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("FileService")
public interface FileService extends Closeable
{
    @ThriftService("FileService")
    public interface Async extends Closeable
    {
        void close();

        @ThriftMethod(value = "deleteFile")
        ListenableFuture<Boolean> deleteFile(
            @ThriftField(value=1, name="filePath", requiredness=Requiredness.NONE) final String filePath,
            @ThriftField(value=2, name="isPub", requiredness=Requiredness.NONE) final boolean isPub
        );

        @ThriftMethod(value = "storeFile")
        ListenableFuture<String> storeFile(
            @ThriftField(value=1, name="fileName", requiredness=Requiredness.NONE) final String fileName,
            @ThriftField(value=2, name="fileSource", requiredness=Requiredness.NONE) final byte[] fileSource,
            @ThriftField(value=3, name="isPub", requiredness=Requiredness.NONE) final boolean isPub
        );
    }
    void close();


    @ThriftMethod(value = "deleteFile")
    boolean deleteFile(
        @ThriftField(value=1, name="filePath", requiredness=Requiredness.NONE) final String filePath,
        @ThriftField(value=2, name="isPub", requiredness=Requiredness.NONE) final boolean isPub
    ) throws org.apache.thrift.TException;

    @ThriftMethod(value = "storeFile")
    String storeFile(
        @ThriftField(value=1, name="fileName", requiredness=Requiredness.NONE) final String fileName,
        @ThriftField(value=2, name="fileSource", requiredness=Requiredness.NONE) final byte[] fileSource,
        @ThriftField(value=3, name="isPub", requiredness=Requiredness.NONE) final boolean isPub
    ) throws org.apache.thrift.TException;
}