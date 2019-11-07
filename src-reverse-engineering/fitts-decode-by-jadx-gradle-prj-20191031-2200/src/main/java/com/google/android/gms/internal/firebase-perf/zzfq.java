package com.google.android.gms.internal.firebase-perf;

final class zzfq implements zzfy {
    private zzfy[] zzsr;

    zzfq(zzfy... zzfyArr) {
        this.zzsr = zzfyArr;
    }

    public final boolean zza(Class<?> cls) {
        for (zzfy zza : this.zzsr) {
            if (zza.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzfv zzb(Class<?> cls) {
        zzfy[] zzfyArr;
        for (zzfy zzfy : this.zzsr) {
            if (zzfy.zza(cls)) {
                return zzfy.zzb(cls);
            }
        }
        String str = "No factory is available for message type: ";
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
