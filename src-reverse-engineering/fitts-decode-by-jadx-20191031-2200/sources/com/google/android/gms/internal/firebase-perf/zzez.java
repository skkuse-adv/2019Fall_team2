package com.google.android.gms.internal.firebase-perf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public enum zzez {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, Integer.valueOf(0)),
    LONG(Long.TYPE, Long.class, Long.valueOf(0)),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.valueOf(false)),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzdl.class, zzdl.class, zzdl.zzmt),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzrx;

    private zzez(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzrx = cls2;
    }

    public final Class<?> zzhs() {
        return this.zzrx;
    }
}
