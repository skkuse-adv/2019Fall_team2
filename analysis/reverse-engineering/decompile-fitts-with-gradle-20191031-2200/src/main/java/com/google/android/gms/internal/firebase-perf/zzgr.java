package com.google.android.gms.internal.firebase-perf;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzgr implements Iterator<Entry<K, V>> {
    private int pos;
    private Iterator<Entry<K, V>> zzui;
    private final /* synthetic */ zzgp zzuj;

    private zzgr(zzgp zzgp) {
        this.zzuj = zzgp;
        this.pos = this.zzuj.zztz.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzuj.zztz.size()) || zzjc().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Entry<K, V>> zzjc() {
        if (this.zzui == null) {
            this.zzui = this.zzuj.zzuc.entrySet().iterator();
        }
        return this.zzui;
    }

    public final /* synthetic */ Object next() {
        if (zzjc().hasNext()) {
            return (Entry) zzjc().next();
        }
        List zzb = this.zzuj.zztz;
        int i = this.pos - 1;
        this.pos = i;
        return (Entry) zzb.get(i);
    }

    /* synthetic */ zzgr(zzgp zzgp, zzgs zzgs) {
        this(zzgp);
    }
}
