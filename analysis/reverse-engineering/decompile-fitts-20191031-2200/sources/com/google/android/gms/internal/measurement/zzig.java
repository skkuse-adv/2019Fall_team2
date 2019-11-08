package com.google.android.gms.internal.measurement;

public enum zzig {
    DOUBLE(zzij.DOUBLE, 1),
    FLOAT(zzij.FLOAT, 5),
    INT64(zzij.LONG, 0),
    UINT64(zzij.LONG, 0),
    INT32(zzij.INT, 0),
    FIXED64(zzij.LONG, 1),
    FIXED32(zzij.INT, 5),
    BOOL(zzij.BOOLEAN, 0),
    STRING(zzij.STRING, 2),
    GROUP(zzij.MESSAGE, 3),
    MESSAGE(zzij.MESSAGE, 2),
    BYTES(zzij.BYTE_STRING, 2),
    UINT32(zzij.INT, 0),
    ENUM(zzij.ENUM, 0),
    SFIXED32(zzij.INT, 5),
    SFIXED64(zzij.LONG, 1),
    SINT32(zzij.INT, 0),
    SINT64(zzij.LONG, 0);
    
    private final zzij zzant;
    private final int zzanu;

    private zzig(zzij zzij, int i) {
        this.zzant = zzij;
        this.zzanu = i;
    }

    public final zzij zzwz() {
        return this.zzant;
    }

    public final int zzxa() {
        return this.zzanu;
    }
}
