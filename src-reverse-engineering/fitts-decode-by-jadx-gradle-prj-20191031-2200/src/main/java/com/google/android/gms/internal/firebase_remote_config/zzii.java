package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

public final class zzii<K, V> {
    static <K, V> void zza(zzgs zzgs, zzih<K, V> zzih, K k, V v) throws IOException {
        zzha.zza(zzgs, zzih.zzvi, 1, k);
        zzha.zza(zzgs, zzih.zzvk, 2, v);
    }

    static <K, V> int zza(zzih<K, V> zzih, K k, V v) {
        return zzha.zza(zzih.zzvi, 1, k) + zzha.zza(zzih.zzvk, 2, v);
    }
}
