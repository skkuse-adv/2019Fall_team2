package com.google.android.gms.internal.clearcut;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public enum zzfq {
    INT(Integer.valueOf(0)),
    LONG(Long.valueOf(0)),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.valueOf(false)),
    STRING(""),
    BYTE_STRING(zzbb.zzfi),
    ENUM(null),
    MESSAGE(null);

    private zzfq(Object obj) {
    }
}
