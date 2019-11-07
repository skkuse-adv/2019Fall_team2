package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhi.zze;

final class zzhj implements zzin {
    private static final zzhj zztf = new zzhj();

    private zzhj() {
    }

    public static zzhj zzgx() {
        return zztf;
    }

    public final boolean zzh(Class<?> cls) {
        return zzhi.class.isAssignableFrom(cls);
    }

    public final zzio zzi(Class<?> cls) {
        Class<zzhi> cls2 = zzhi.class;
        if (!cls2.isAssignableFrom(cls)) {
            String str = "Unsupported message type: ";
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        try {
            return (zzio) zzhi.zzg(cls.asSubclass(cls2)).zzb(zze.zzto, null, null);
        } catch (Exception e) {
            String str2 = "Unable to get message info for ";
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e);
        }
    }
}
