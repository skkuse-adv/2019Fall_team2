package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzhw<K> implements Iterator<Entry<K, Object>> {
    private Iterator<Entry<K, Object>> zzuw;

    public zzhw(Iterator<Entry<K, Object>> it) {
        this.zzuw = it;
    }

    public final boolean hasNext() {
        return this.zzuw.hasNext();
    }

    public final void remove() {
        this.zzuw.remove();
    }

    public final /* synthetic */ Object next() {
        Entry entry = (Entry) this.zzuw.next();
        return entry.getValue() instanceof zzhr ? new zzht(entry) : entry;
    }
}
