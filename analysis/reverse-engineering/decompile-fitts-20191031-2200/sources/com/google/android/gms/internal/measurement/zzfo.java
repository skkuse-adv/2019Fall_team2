package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzfo<K> implements Iterator<Entry<K, Object>> {
    private Iterator<Entry<K, Object>> zzajp;

    public zzfo(Iterator<Entry<K, Object>> it) {
        this.zzajp = it;
    }

    public final boolean hasNext() {
        return this.zzajp.hasNext();
    }

    public final void remove() {
        this.zzajp.remove();
    }

    public final /* synthetic */ Object next() {
        Entry entry = (Entry) this.zzajp.next();
        return entry.getValue() instanceof zzfj ? new zzfl(entry) : entry;
    }
}
