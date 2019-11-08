package com.google.android.gms.internal.firebase-perf;

public final class zzfp<K, V> {
    private final zzfs<K, V> zzsp;

    private zzfp(zzhu zzhu, K k, zzhu zzhu2, V v) {
        this.zzsp = new zzfs<>(zzhu, k, zzhu2, v);
    }

    public static <K, V> zzfp<K, V> zza(zzhu zzhu, K k, zzhu zzhu2, V v) {
        return new zzfp<>(zzhu, k, zzhu2, v);
    }

    static <K, V> int zza(zzfs<K, V> zzfs, K k, V v) {
        return zzeh.zza(zzfs.zzst, 1, k) + zzeh.zza(zzfs.zzsv, 2, v);
    }

    public final int zzb(int i, K k, V v) {
        return zzec.zzy(i) + zzec.zzaf(zza(this.zzsp, k, v));
    }

    /* access modifiers changed from: 0000 */
    public final zzfs<K, V> zzia() {
        return this.zzsp;
    }
}
