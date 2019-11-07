package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzjs implements Iterator<Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzjk zzwy;
    private Iterator<Entry<K, V>> zzwz;
    private boolean zzxd;

    private zzjs(zzjk zzjk) {
        this.zzwy = zzjk;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzwy.zzwt.size() || (!this.zzwy.zzwu.isEmpty() && zziw().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zzxd) {
            this.zzxd = false;
            this.zzwy.zziu();
            if (this.pos < this.zzwy.zzwt.size()) {
                zzjk zzjk = this.zzwy;
                int i = this.pos;
                this.pos = i - 1;
                zzjk.zzbn(i);
                return;
            }
            zziw().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Entry<K, V>> zziw() {
        if (this.zzwz == null) {
            this.zzwz = this.zzwy.zzwu.entrySet().iterator();
        }
        return this.zzwz;
    }

    public final /* synthetic */ Object next() {
        this.zzxd = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzwy.zzwt.size()) {
            return (Entry) this.zzwy.zzwt.get(this.pos);
        }
        return (Entry) zziw().next();
    }

    /* synthetic */ zzjs(zzjk zzjk, zzjj zzjj) {
        this(zzjk);
    }
}
