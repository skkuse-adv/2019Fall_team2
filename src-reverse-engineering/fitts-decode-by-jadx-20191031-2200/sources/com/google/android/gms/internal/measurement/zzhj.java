package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzhj extends AbstractSet<Entry<K, V>> {
    private final /* synthetic */ zzhc zzalq;

    private zzhj(zzhc zzhc) {
        this.zzalq = zzhc;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new zzhk(this.zzalq, null);
    }

    public int size() {
        return this.zzalq.size();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.zzalq.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzalq.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzalq.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzalq.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzhj(zzhc zzhc, zzhb zzhb) {
        this(zzhc);
    }
}
