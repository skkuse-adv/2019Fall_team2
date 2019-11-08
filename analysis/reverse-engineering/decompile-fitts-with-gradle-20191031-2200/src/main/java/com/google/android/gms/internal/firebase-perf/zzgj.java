package com.google.android.gms.internal.firebase-perf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzgj {
    private static final zzgj zztu = new zzgj();
    private final zzgn zztv = new zzfo();
    private final ConcurrentMap<Class<?>, zzgo<?>> zztw = new ConcurrentHashMap();

    public static zzgj zzio() {
        return zztu;
    }

    public final <T> zzgo<T> zze(Class<T> cls) {
        String str = "messageType";
        zzes.zza(cls, str);
        zzgo<T> zzgo = (zzgo) this.zztw.get(cls);
        if (zzgo != null) {
            return zzgo;
        }
        zzgo<T> zzd = this.zztv.zzd(cls);
        zzes.zza(cls, str);
        zzes.zza(zzd, "schema");
        zzgo zzgo2 = (zzgo) this.zztw.putIfAbsent(cls, zzd);
        return zzgo2 != null ? zzgo2 : zzd;
    }

    public final <T> zzgo<T> zzn(T t) {
        return zze(t.getClass());
    }

    private zzgj() {
    }
}
