package com.google.android.gms.internal.firebase-perf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public enum zzhx {
    INT(Integer.valueOf(0)),
    LONG(Long.valueOf(0)),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.valueOf(false)),
    STRING(""),
    BYTE_STRING(zzdl.zzmt),
    ENUM(null),
    MESSAGE(null);

    private zzhx(Object obj) {
    }
}
