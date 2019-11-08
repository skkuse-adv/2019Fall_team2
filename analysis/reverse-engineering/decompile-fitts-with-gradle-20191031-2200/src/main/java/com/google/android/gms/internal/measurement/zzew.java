package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey.zzd;

final class zzew implements zzgf {
    private static final zzew zzahu = new zzew();

    private zzew() {
    }

    public static zzew zzua() {
        return zzahu;
    }

    public final boolean zza(Class<?> cls) {
        return zzey.class.isAssignableFrom(cls);
    }

    public final zzgg zzb(Class<?> cls) {
        Class<zzey> cls2 = zzey.class;
        if (!cls2.isAssignableFrom(cls)) {
            String str = "Unsupported message type: ";
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
        try {
            return (zzgg) zzey.zzd(cls.asSubclass(cls2)).zza(zzd.zzaif, (Object) null, (Object) null);
        } catch (Exception e) {
            String str2 = "Unable to get message info for ";
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e);
        }
    }
}
