package com.igool.file.service.test.thrift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("User")
public final class User
{
    public User() {
    }

    private int id;

    @ThriftField(value=1, name="id", requiredness=Requiredness.NONE)
    public int getId() { return id; }

    @ThriftField
    public void setId(final int id) { this.id = id; }

    private String name;

    @ThriftField(value=2, name="name", requiredness=Requiredness.NONE)
    public String getName() { return name; }

    @ThriftField
    public void setName(final String name) { this.name = name; }

    private boolean sex;

    @ThriftField(value=3, name="sex", requiredness=Requiredness.NONE)
    public boolean isSex() { return sex; }

    @ThriftField
    public void setSex(final boolean sex) { this.sex = sex; }

    private Status status;

    @ThriftField(value=4, name="status", requiredness=Requiredness.NONE)
    public Status getStatus() { return status; }

    @ThriftField
    public void setStatus(final Status status) { this.status = status; }

    private List<Long> ids;

    @ThriftField(value=5, name="ids", requiredness=Requiredness.NONE)
    public List<Long> getIds() { return ids; }

    @ThriftField
    public void setIds(final List<Long> ids) { this.ids = ids; }

    private Account account;

    @ThriftField(value=6, name="account", requiredness=Requiredness.NONE)
    public Account getAccount() { return account; }

    @ThriftField
    public void setAccount(final Account account) { this.account = account; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("name", name)
            .add("sex", sex)
            .add("status", status)
            .add("ids", ids)
            .add("account", account)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User other = (User)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(name, other.name) &&
            Objects.equals(sex, other.sex) &&
            Objects.equals(status, other.status) &&
            Objects.equals(ids, other.ids) &&
            Objects.equals(account, other.account);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            name,
            sex,
            status,
            ids,
            account
        });
    }
}
