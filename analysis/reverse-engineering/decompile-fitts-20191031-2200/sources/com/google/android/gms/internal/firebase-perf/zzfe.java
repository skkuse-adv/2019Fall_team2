package com.google.android.gms.internal.firebase-perf;

import java.util.Map.Entry;

final class zzfe<K> implements Entry<K, Object> {
    private Entry<K, zzfc> zzsb;

    private zzfe(Entry<K, zzfc> entry) {
        this.zzsb = entry;
    }

    public final K getKey() {
        return this.zzsb.getKey();
    }

    public final Object getValue() {
        if (((zzfc) this.zzsb.getValue()) == null) {
            return null;
        }
        return zzfc.zzht();
    }

    public final zzfc zzhu() {
        return (zzfc) this.zzsb.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzfx) {
            return ((zzfc) this.zzsb.getValue()).zzh((zzfx) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
