package com.google.android.gms.internal.firebase_remote_config;

public enum zzko {
    DOUBLE(zzkr.DOUBLE, 1),
    FLOAT(zzkr.FLOAT, 5),
    INT64(zzkr.LONG, 0),
    UINT64(zzkr.LONG, 0),
    INT32(zzkr.INT, 0),
    FIXED64(zzkr.LONG, 1),
    FIXED32(zzkr.INT, 5),
    BOOL(zzkr.BOOLEAN, 0),
    STRING(zzkr.STRING, 2),
    GROUP(zzkr.MESSAGE, 3),
    MESSAGE(zzkr.MESSAGE, 2),
    BYTES(zzkr.BYTE_STRING, 2),
    UINT32(zzkr.INT, 0),
    ENUM(zzkr.ENUM, 0),
    SFIXED32(zzkr.INT, 5),
    SFIXED64(zzkr.LONG, 1),
    SINT32(zzkr.INT, 0),
    SINT64(zzkr.LONG, 0);
    
    private final zzkr zzzb;
    private final int zzzc;

    private zzko(zzkr zzkr, int i) {
        this.zzzb = zzkr;
        this.zzzc = i;
    }

    public final zzkr zzjj() {
        return this.zzzb;
    }

    public final int zzjk() {
        return this.zzzc;
    }
}
