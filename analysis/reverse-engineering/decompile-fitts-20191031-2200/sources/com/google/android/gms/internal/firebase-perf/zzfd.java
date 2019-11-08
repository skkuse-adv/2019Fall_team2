package com.google.android.gms.internal.firebase-perf;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzfd<K> implements Iterator<Entry<K, Object>> {
    private Iterator<Entry<K, Object>> zzsa;

    public zzfd(Iterator<Entry<K, Object>> it) {
        this.zzsa = it;
    }

    public final boolean hasNext() {
        return this.zzsa.hasNext();
    }

    public final void remove() {
        this.zzsa.remove();
    }

    public final /* synthetic */ Object next() {
        Entry entry = (Entry) this.zzsa.next();
        return entry.getValue() instanceof zzfc ? new zzfe(entry) : entry;
    }
}
