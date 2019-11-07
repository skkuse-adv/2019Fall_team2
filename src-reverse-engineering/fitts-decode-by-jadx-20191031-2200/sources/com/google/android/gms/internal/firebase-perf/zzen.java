package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzd;

final class zzen implements zzfy {
    private static final zzen zzqf = new zzen();

    private zzen() {
    }

    public static zzen zzhd() {
        return zzqf;
    }

    public final boolean zza(Class<?> cls) {
        return zzep.class.isAssignableFrom(cls);
    }

    public final zzfv zzb(Class<?> cls) {
        Class<zzep> cls2 = zzep.class;
        if (!cls2.isAssignableFrom(cls)) {
            String str = "Unsupported message type: ";
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        try {
            return (zzfv) zzep.zzc(cls.asSubclass(cls2)).zza(zzd.zzqx, (Object) null, (Object) null);
        } catch (Exception e) {
            String str2 = "Unable to get message info for ";
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e);
        }
    }
}
