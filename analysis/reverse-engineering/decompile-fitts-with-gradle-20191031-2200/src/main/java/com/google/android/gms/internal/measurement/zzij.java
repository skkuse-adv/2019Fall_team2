package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public enum zzij {
    INT(Integer.valueOf(0)),
    LONG(Long.valueOf(0)),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.valueOf(false)),
    STRING(""),
    BYTE_STRING(zzdp.zzadh),
    ENUM(null),
    MESSAGE(null);

    private zzij(Object obj) {
    }
}
