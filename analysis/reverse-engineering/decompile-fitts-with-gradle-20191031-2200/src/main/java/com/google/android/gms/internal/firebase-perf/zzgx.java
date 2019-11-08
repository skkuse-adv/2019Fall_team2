package com.google.android.gms.internal.firebase-perf;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzgx implements Iterator<Entry<K, V>> {
    private int pos;
    private Iterator<Entry<K, V>> zzui;
    private final /* synthetic */ zzgp zzuj;
    private boolean zzum;

    private zzgx(zzgp zzgp) {
        this.zzuj = zzgp;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzuj.zztz.size() || (!this.zzuj.zzua.isEmpty() && zzjc().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zzum) {
            this.zzum = false;
            this.zzuj.zziv();
            if (this.pos < this.zzuj.zztz.size()) {
                zzgp zzgp = this.zzuj;
                int i = this.pos;
                this.pos = i - 1;
                zzgp.zzav(i);
                return;
            }
            zzjc().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Entry<K, V>> zzjc() {
        if (this.zzui == null) {
            this.zzui = this.zzuj.zzua.entrySet().iterator();
        }
        return this.zzui;
    }

    public final /* synthetic */ Object next() {
        this.zzum = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzuj.zztz.size()) {
            return (Entry) this.zzuj.zztz.get(this.pos);
        }
        return (Entry) zzjc().next();
    }

    /* synthetic */ zzgx(zzgp zzgp, zzgs zzgs) {
        this(zzgp);
    }
}
