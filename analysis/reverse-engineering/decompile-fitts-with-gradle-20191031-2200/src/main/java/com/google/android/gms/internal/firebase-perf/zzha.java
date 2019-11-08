package com.google.android.gms.internal.firebase-perf;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzha extends AbstractSet<Entry<K, V>> {
    private final /* synthetic */ zzgp zzuj;

    private zzha(zzgp zzgp) {
        this.zzuj = zzgp;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new zzgx(this.zzuj, null);
    }

    public int size() {
        return this.zzuj.size();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.zzuj.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzuj.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzuj.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzuj.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzha(zzgp zzgp, zzgs zzgs) {
        this(zzgp);
    }
}
