package com.google.android.gms.internal.measurement;

import java.util.Map.Entry;

final class zzfl<K> implements Entry<K, Object> {
    private Entry<K, zzfj> zzajl;

    private zzfl(Entry<K, zzfj> entry) {
        this.zzajl = entry;
    }

    public final K getKey() {
        return this.zzajl.getKey();
    }

    public final Object getValue() {
        if (((zzfj) this.zzajl.getValue()) == null) {
            return null;
        }
        return zzfj.zzvc();
    }

    public final zzfj zzve() {
        return (zzfj) this.zzajl.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzgi) {
            return ((zzfj) this.zzajl.getValue()).zzi((zzgi) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
