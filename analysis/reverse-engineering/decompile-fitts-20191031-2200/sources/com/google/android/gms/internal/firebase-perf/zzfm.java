package com.google.android.gms.internal.firebase-perf;

final class zzfm extends zzfh {
    private zzfm() {
        super();
    }

    /* access modifiers changed from: 0000 */
    public final void zza(Object obj, long j) {
        zzc(obj, j).zzgf();
    }

    /* access modifiers changed from: 0000 */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzey zzc = zzc(obj, j);
        zzey zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzge()) {
                zzc = zzc.zzao(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzhm.zza(obj, j, (Object) zzc2);
    }

    private static <E> zzey<E> zzc(Object obj, long j) {
        return (zzey) zzhm.zzo(obj, j);
    }
}
