package com.google.android.gms.internal.firebase_remote_config;

import java.util.Date;

public final class zzet {
    private final zzen zzlh;

    private zzet(Date date, int i, zzen zzen) {
        this.zzlh = zzen;
    }

    public static zzet zzg(zzen zzen) {
        return new zzet(zzen.zzcr(), 0, zzen);
    }

    public static zzet zzd(Date date) {
        return new zzet(date, 1, null);
    }

    public static zzet zze(Date date) {
        return new zzet(date, 2, null);
    }

    public final zzen zzcx() {
        return this.zzlh;
    }
}
