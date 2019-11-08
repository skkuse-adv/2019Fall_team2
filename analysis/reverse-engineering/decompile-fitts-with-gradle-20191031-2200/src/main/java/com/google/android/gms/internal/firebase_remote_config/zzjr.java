package com.google.android.gms.internal.firebase_remote_config;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzjr extends AbstractSet<Entry<K, V>> {
    private final /* synthetic */ zzjk zzwy;

    private zzjr(zzjk zzjk) {
        this.zzwy = zzjk;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new zzjs(this.zzwy, null);
    }

    public int size() {
        return this.zzwy.size();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.zzwy.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzwy.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzwy.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzwy.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzjr(zzjk zzjk, zzjj zzjj) {
        this(zzjk);
    }
}
