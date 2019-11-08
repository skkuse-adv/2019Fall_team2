package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzjp {
    final String name;
    final String origin;
    final Object value;
    final String zzce;
    final long zztr;

    zzjp(String str, String str2, String str3, long j, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(obj);
        this.zzce = str;
        this.origin = str2;
        this.name = str3;
        this.zztr = j;
        this.value = obj;
    }
}
