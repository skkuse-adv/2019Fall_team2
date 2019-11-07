package com.google.android.gms.internal.firebase-perf;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map.Entry;

public final class zzy<K, V> {
    private int size;
    private Object[] zzz;

    public zzy() {
        this(4);
    }

    zzy(int i) {
        this.zzz = new Object[(i * 2)];
        this.size = 0;
    }

    private final void ensureCapacity(int i) {
        int i2 = i << 1;
        Object[] objArr = this.zzz;
        if (i2 > objArr.length) {
            this.zzz = Arrays.copyOf(objArr, zzs.zzd(objArr.length, i2));
        }
    }

    public final zzy<K, V> zzb(K k, V v) {
        ensureCapacity(this.size + 1);
        zzo.zza((Object) k, (Object) v);
        Object[] objArr = this.zzz;
        int i = this.size;
        objArr[i * 2] = k;
        objArr[(i * 2) + 1] = v;
        this.size = i + 1;
        return this;
    }

    public final zzy<K, V> zza(Iterable<? extends Entry<? extends K, ? extends V>> iterable) {
        if (iterable instanceof Collection) {
            ensureCapacity(this.size + ((Collection) iterable).size());
        }
        for (Entry entry : iterable) {
            zzb(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzv<K, V> zzp() {
        return zzz.zza(this.size, this.zzz);
    }
}
