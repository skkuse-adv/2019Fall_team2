package com.google.android.gms.internal.firebase-perf;

import java.util.Map;
import java.util.Map.Entry;

final class zzft implements zzfu {
    zzft() {
    }

    public final zzfs<?, ?> zzi(Object obj) {
        return ((zzfp) obj).zzia();
    }

    public final Map<?, ?> zzj(Object obj) {
        return (zzfr) obj;
    }

    public final Object zzk(Object obj) {
        ((zzfr) obj).zzgf();
        return obj;
    }

    public final Object zzd(Object obj, Object obj2) {
        zzfr zzfr = (zzfr) obj;
        zzfr zzfr2 = (zzfr) obj2;
        if (!zzfr2.isEmpty()) {
            if (!zzfr.isMutable()) {
                zzfr = zzfr.zzic();
            }
            zzfr.zza(zzfr2);
        }
        return zzfr;
    }

    public final int zzc(int i, Object obj, Object obj2) {
        zzfr zzfr = (zzfr) obj;
        zzfp zzfp = (zzfp) obj2;
        int i2 = 0;
        if (zzfr.isEmpty()) {
            return 0;
        }
        for (Entry entry : zzfr.entrySet()) {
            i2 += zzfp.zzb(i, entry.getKey(), entry.getValue());
        }
        return i2;
    }
}
