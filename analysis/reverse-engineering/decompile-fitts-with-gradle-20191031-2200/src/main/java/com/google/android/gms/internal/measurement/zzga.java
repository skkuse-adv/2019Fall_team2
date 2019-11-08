package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzga<K, V> {
    static <K, V> void zza(zzee zzee, zzfz<K, V> zzfz, K k, V v) throws IOException {
        zzeo.zza(zzee, zzfz.zzakb, 1, k);
        zzeo.zza(zzee, zzfz.zzakd, 2, v);
    }

    static <K, V> int zza(zzfz<K, V> zzfz, K k, V v) {
        return zzeo.zza(zzfz.zzakb, 1, k) + zzeo.zza(zzfz.zzakd, 2, v);
    }
}
