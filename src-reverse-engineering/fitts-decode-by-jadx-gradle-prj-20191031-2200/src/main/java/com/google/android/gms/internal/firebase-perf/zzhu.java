package com.google.android.gms.internal.firebase-perf;

public enum zzhu {
    DOUBLE(zzhx.DOUBLE, 1),
    FLOAT(zzhx.FLOAT, 5),
    INT64(zzhx.LONG, 0),
    UINT64(zzhx.LONG, 0),
    INT32(zzhx.INT, 0),
    FIXED64(zzhx.LONG, 1),
    FIXED32(zzhx.INT, 5),
    BOOL(zzhx.BOOLEAN, 0),
    STRING(zzhx.STRING, 2),
    GROUP(zzhx.MESSAGE, 3),
    MESSAGE(zzhx.MESSAGE, 2),
    BYTES(zzhx.BYTE_STRING, 2),
    UINT32(zzhx.INT, 0),
    ENUM(zzhx.ENUM, 0),
    SFIXED32(zzhx.INT, 5),
    SFIXED64(zzhx.LONG, 1),
    SINT32(zzhx.INT, 0),
    SINT64(zzhx.LONG, 0);
    
    private final zzhx zzwl;
    private final int zzwm;

    private zzhu(zzhx zzhx, int i) {
        this.zzwl = zzhx;
        this.zzwm = i;
    }

    public final zzhx zzjn() {
        return this.zzwl;
    }

    public final int zzjo() {
        return this.zzwm;
    }
}
