package com.google.android.gms.internal.firebase_remote_config;

import java.util.List;

final class zzib extends zzia {
    private zzib() {
        super();
    }

    /* access modifiers changed from: 0000 */
    public final <L> List<L> zza(Object obj, long j) {
        zzhn zzc = zzc(obj, j);
        if (zzc.zzer()) {
            return zzc;
        }
        int size = zzc.size();
        zzhn zzu = zzc.zzu(size == 0 ? 10 : size << 1);
        zzkd.zza(obj, j, (Object) zzu);
        return zzu;
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzes();
    }

    /* access modifiers changed from: 0000 */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzhn zzc = zzc(obj, j);
        zzhn zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzer()) {
                zzc = zzc.zzu(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzkd.zza(obj, j, (Object) zzc2);
    }

    private static <E> zzhn<E> zzc(Object obj, long j) {
        return (zzhn) zzkd.zzp(obj, j);
    }
}
