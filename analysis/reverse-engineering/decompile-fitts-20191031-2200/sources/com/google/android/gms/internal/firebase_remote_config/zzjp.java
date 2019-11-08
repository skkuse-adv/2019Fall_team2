package com.google.android.gms.internal.firebase_remote_config;

import java.util.Map.Entry;

final class zzjp implements Comparable<zzjp>, Entry<K, V> {
    private V value;
    private final /* synthetic */ zzjk zzwy;
    private final K zzxc;

    zzjp(zzjk zzjk, Entry<K, V> entry) {
        this(zzjk, (Comparable) entry.getKey(), entry.getValue());
    }

    zzjp(zzjk zzjk, K k, V v) {
        this.zzwy = zzjk;
        this.zzxc = k;
        this.value = v;
    }

    public final V getValue() {
        return this.value;
    }

    public final V setValue(V v) {
        this.zzwy.zziu();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return equals(this.zzxc, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final int hashCode() {
        K k = this.zzxc;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzxc);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final /* synthetic */ Object getKey() {
        return this.zzxc;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzjp) obj).getKey());
    }
}
