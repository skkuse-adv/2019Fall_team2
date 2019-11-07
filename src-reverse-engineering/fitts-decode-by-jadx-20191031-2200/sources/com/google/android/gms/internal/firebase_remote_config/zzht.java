package com.google.android.gms.internal.firebase_remote_config;

import java.util.Map.Entry;

final class zzht<K> implements Entry<K, Object> {
    private Entry<K, zzhr> zzus;

    private zzht(Entry<K, zzhr> entry) {
        this.zzus = entry;
    }

    public final K getKey() {
        return this.zzus.getKey();
    }

    public final Object getValue() {
        if (((zzhr) this.zzus.getValue()) == null) {
            return null;
        }
        return zzhr.zzhn();
    }

    public final zzhr zzhp() {
        return (zzhr) this.zzus.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zziq) {
            return ((zzhr) this.zzus.getValue()).zzi((zziq) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
