package com.igool.file.service.test.thrift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("ICommonUserService")
public interface ICommonUserService extends Closeable
{
    @ThriftService("ICommonUserService")
    public interface Async extends Closeable
    {
        void close();

        @ThriftMethod(value = "getUsersByName")
        ListenableFuture<Map<String, List<User>>> getUsersByName(
            @ThriftField(value=1, name="names", requiredness=Requiredness.NONE) final List<String> names
        );

        @ThriftMethod(value = "login")
        ListenableFuture<User> login(
            @ThriftField(value=1, name="id", requiredness=Requiredness.NONE) final int id,
            @ThriftField(value=2, name="name", requiredness=Requiredness.NONE) final String name
        );

        @ThriftMethod(value = "testCase1")
        ListenableFuture<List<String>> testCase1(
            @ThriftField(value=1, name="num1", requiredness=Requiredness.NONE) final Map<Integer, String> num1,
            @ThriftField(value=2, name="num2", requiredness=Requiredness.NONE) final List<User> num2,
            @ThriftField(value=3, name="num3", requiredness=Requiredness.NONE) final List<String> num3,
            @ThriftField(value=4, name="num4", requiredness=Requiredness.NONE) final long num4,
            @ThriftField(value=5, name="num5", requiredness=Requiredness.NONE) final String num5
        );

        @ThriftMethod(value = "getGroupUsers")
        ListenableFuture<Map<Long, List<Long>>> getGroupUsers(
            @ThriftField(value=1, name="names", requiredness=Requiredness.NONE) final List<String> names,
            @ThriftField(value=2, name="userList", requiredness=Requiredness.NONE) final List<User> userList,
            @ThriftField(value=3, name="lns", requiredness=Requiredness.NONE) final List<Long> lns,
            @ThriftField(value=4, name="ll", requiredness=Requiredness.NONE) final long ll
        );

        @ThriftMethod(value = "getUserById")
        ListenableFuture<User> getUserById(
            @ThriftField(value=1, name="id", requiredness=Requiredness.NONE) final long id
        );

        @ThriftMethod(value = "saveUser")
        ListenableFuture<Boolean> saveUser(
            @ThriftField(value=1, name="user", requiredness=Requiredness.NONE) final User user
        );

        @ThriftMethod(value = "getUserByIds")
        ListenableFuture<Map<Long, User>> getUserByIds(
            @ThriftField(value=1, name="ids", requiredness=Requiredness.NONE) final List<User> ids
        );

        @ThriftMethod(value = "getUserIds")
        ListenableFuture<List<User>> getUserIds(
            @ThriftField(value=1, name="id", requiredness=Requiredness.NONE) final long id
        );
    }
    void close();


    @ThriftMethod(value = "getUsersByName")
    Map<String, List<User>> getUsersByName(
        @ThriftField(value=1, name="names", requiredness=Requiredness.NONE) final List<String> names
    ) throws org.apache.thrift.TException;

    @ThriftMethod(value = "login")
    User login(
        @ThriftField(value=1, name="id", requiredness=Requiredness.NONE) final int id,
        @ThriftField(value=2, name="name", requiredness=Requiredness.NONE) final String name
    ) throws org.apache.thrift.TException;

    @ThriftMethod(value = "testCase1")
    List<String> testCase1(
        @ThriftField(value=1, name="num1", requiredness=Requiredness.NONE) final Map<Integer, String> num1,
        @ThriftField(value=2, name="num2", requiredness=Requiredness.NONE) final List<User> num2,
        @ThriftField(value=3, name="num3", requiredness=Requiredness.NONE) final List<String> num3,
        @ThriftField(value=4, name="num4", requiredness=Requiredness.NONE) final long num4,
        @ThriftField(value=5, name="num5", requiredness=Requiredness.NONE) final String num5
    ) throws org.apache.thrift.TException;

    @ThriftMethod(value = "getGroupUsers")
    Map<Long, List<Long>> getGroupUsers(
        @ThriftField(value=1, name="names", requiredness=Requiredness.NONE) final List<String> names,
        @ThriftField(value=2, name="userList", requiredness=Requiredness.NONE) final List<User> userList,
        @ThriftField(value=3, name="lns", requiredness=Requiredness.NONE) final List<Long> lns,
        @ThriftField(value=4, name="ll", requiredness=Requiredness.NONE) final long ll
    ) throws org.apache.thrift.TException;

    @ThriftMethod(value = "getUserById")
    User getUserById(
        @ThriftField(value=1, name="id", requiredness=Requiredness.NONE) final long id
    ) throws org.apache.thrift.TException;

    @ThriftMethod(value = "saveUser")
    boolean saveUser(
        @ThriftField(value=1, name="user", requiredness=Requiredness.NONE) final User user
    ) throws org.apache.thrift.TException;

    @ThriftMethod(value = "getUserByIds")
    Map<Long, User> getUserByIds(
        @ThriftField(value=1, name="ids", requiredness=Requiredness.NONE) final List<User> ids
    ) throws org.apache.thrift.TException;

    @ThriftMethod(value = "getUserIds")
    List<User> getUserIds(
        @ThriftField(value=1, name="id", requiredness=Requiredness.NONE) final long id
    ) throws org.apache.thrift.TException;
}