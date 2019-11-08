package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzjm implements Iterator<Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzjk zzwy;
    private Iterator<Entry<K, V>> zzwz;

    private zzjm(zzjk zzjk) {
        this.zzwy = zzjk;
        this.pos = this.zzwy.zzwt.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzwy.zzwt.size()) || zziw().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Entry<K, V>> zziw() {
        if (this.zzwz == null) {
            this.zzwz = this.zzwy.zzww.entrySet().iterator();
        }
        return this.zzwz;
    }

    public final /* synthetic */ Object next() {
        if (zziw().hasNext()) {
            return (Entry) zziw().next();
        }
        List zzb = this.zzwy.zzwt;
        int i = this.pos - 1;
        this.pos = i;
        return (Entry) zzb.get(i);
    }

    /* synthetic */ zzjm(zzjk zzjk, zzjj zzjj) {
        this(zzjk);
    }
}
