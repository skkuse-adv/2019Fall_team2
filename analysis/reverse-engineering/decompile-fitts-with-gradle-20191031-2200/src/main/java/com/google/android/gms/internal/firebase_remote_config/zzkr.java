package com.google.android.gms.internal.firebase_remote_config;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public enum zzkr {
    INT(Integer.valueOf(0)),
    LONG(Long.valueOf(0)),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.valueOf(false)),
    STRING(""),
    BYTE_STRING(zzfx.zzov),
    ENUM(null),
    MESSAGE(null);

    private zzkr(Object obj) {
    }
}
