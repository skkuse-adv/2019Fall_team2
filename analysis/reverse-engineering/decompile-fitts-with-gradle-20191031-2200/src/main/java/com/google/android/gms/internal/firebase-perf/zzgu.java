package com.google.android.gms.internal.firebase-perf;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzgu extends zzha {
    private final /* synthetic */ zzgp zzuj;

    private zzgu(zzgp zzgp) {
        this.zzuj = zzgp;
        super(zzgp, null);
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new zzgr(this.zzuj, null);
    }

    /* synthetic */ zzgu(zzgp zzgp, zzgs zzgs) {
        this(zzgp);
    }
}
