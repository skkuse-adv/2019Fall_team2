package com.google.android.gms.internal.firebase-perf;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

final class zzab extends zzr<Entry<K, V>> {
    private final /* synthetic */ zzac zzaf;

    zzab(zzac zzac) {
        this.zzaf = zzac;
    }

    public final int size() {
        return this.zzaf.size;
    }

    public final /* synthetic */ Object get(int i) {
        zzf.zza(i, this.zzaf.size);
        int i2 = i * 2;
        return new SimpleImmutableEntry(this.zzaf.zzz[i2], this.zzaf.zzz[i2 + 1]);
    }
}
