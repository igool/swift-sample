package com.igool.file.service.test.thrift;

import com.facebook.swift.codec.*;

public enum Status
{
    NORMAL(0), BLOCKED(1);

    private final int value;

    Status(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
