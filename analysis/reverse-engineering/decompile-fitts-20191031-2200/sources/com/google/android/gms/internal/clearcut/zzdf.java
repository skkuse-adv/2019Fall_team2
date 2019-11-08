package com.google.android.gms.internal.clearcut;

final class zzdf implements zzdn {
    private zzdn[] zzma;

    zzdf(zzdn... zzdnArr) {
        this.zzma = zzdnArr;
    }

    public final boolean zza(Class<?> cls) {
        for (zzdn zza : this.zzma) {
            if (zza.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzdm zzb(Class<?> cls) {
        zzdn[] zzdnArr;
        for (zzdn zzdn : this.zzma) {
            if (zzdn.zza(cls)) {
                return zzdn.zzb(cls);
            }
        }
        String str = "No factory is available for message type: ";
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
