package com.google.android.gms.internal.measurement;

import java.util.List;

final class zzft extends zzfs {
    private zzft() {
        super();
    }

    /* access modifiers changed from: 0000 */
    public final <L> List<L> zza(Object obj, long j) {
        zzff zzc = zzc(obj, j);
        if (zzc.zzrx()) {
            return zzc;
        }
        int size = zzc.size();
        zzff zzap = zzc.zzap(size == 0 ? 10 : size << 1);
        zzhv.zza(obj, j, (Object) zzap);
        return zzap;
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzry();
    }

    /* access modifiers changed from: 0000 */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzff zzc = zzc(obj, j);
        zzff zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzrx()) {
                zzc = zzc.zzap(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzhv.zza(obj, j, (Object) zzc2);
    }

    private static <E> zzff<E> zzc(Object obj, long j) {
        return (zzff) zzhv.zzp(obj, j);
    }
}
