package com.igool.queue.service.thrift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("ItemEntry")
public final class ItemEntry
{
    public ItemEntry() {
    }

    private String acid;

    @ThriftField(value=1, name="acid", requiredness=Requiredness.NONE)
    public String getAcid() { return acid; }

    @ThriftField
    public void setAcid(final String acid) { this.acid = acid; }

    private int marklable;

    @ThriftField(value=2, name="marklable", requiredness=Requiredness.NONE)
    public int getMarklable() { return marklable; }

    @ThriftField
    public void setMarklable(final int marklable) { this.marklable = marklable; }

    private String base64code;

    @ThriftField(value=3, name="base64code", requiredness=Requiredness.NONE)
    public String getBase64code() { return base64code; }

    @ThriftField
    public void setBase64code(final String base64code) { this.base64code = base64code; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("acid", acid)
            .add("marklable", marklable)
            .add("base64code", base64code)
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

        ItemEntry other = (ItemEntry)o;

        return
            Objects.equals(acid, other.acid) &&
            Objects.equals(marklable, other.marklable) &&
            Objects.equals(base64code, other.base64code);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            acid,
            marklable,
            base64code
        });
    }
}
