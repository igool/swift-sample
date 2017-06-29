package com.igool;

import com.facebook.swift.codec.ThriftField;
import com.igool.file.service.thrift.FileService;
import com.igool.ping.service.thrift.HelloServiceImpl;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by igool on 2017/6/28.
 */
public class FileServiceImpl implements FileService {
    private static final Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);
    public void close() {
        this.close();
    }

    public boolean deleteFile(@ThriftField(value = 1, name = "filePath", requiredness = ThriftField.Requiredness.NONE) String filePath, @ThriftField(value = 2, name = "isPub", requiredness = ThriftField.Requiredness.NONE) boolean isPub) throws TException {
        return false;
    }

    public String storeFile(@ThriftField(value = 1, name = "fileName", requiredness = ThriftField.Requiredness.NONE) String fileName, @ThriftField(value = 2, name = "fileSource", requiredness = ThriftField.Requiredness.NONE) byte[] fileSource, @ThriftField(value = 3, name = "isPub", requiredness = ThriftField.Requiredness.NONE) boolean isPub) throws TException {
        log.info("store file ");
        return "empty str";
    }
}
