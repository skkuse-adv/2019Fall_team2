package com.google.android.gms.internal.measurement;

import java.io.Serializable;

public final class zzda {
    public static <T> zzdb<T> zza(zzdb<T> zzdb) {
        if ((zzdb instanceof zzdc) || (zzdb instanceof zzdd)) {
            return zzdb;
        }
        if (zzdb instanceof Serializable) {
            return new zzdd(zzdb);
        }
        return new zzdc(zzdb);
    }

    public static <T> zzdb<T> zzg(T t) {
        return new zzde(t);
    }
}
