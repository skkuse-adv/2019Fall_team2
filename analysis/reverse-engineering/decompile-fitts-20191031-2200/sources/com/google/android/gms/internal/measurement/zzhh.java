package com.google.android.gms.internal.measurement;

import java.util.Map.Entry;

final class zzhh implements Comparable<zzhh>, Entry<K, V> {
    private V value;
    private final /* synthetic */ zzhc zzalq;
    private final K zzalu;

    zzhh(zzhc zzhc, Entry<K, V> entry) {
        this(zzhc, (Comparable) entry.getKey(), entry.getValue());
    }

    zzhh(zzhc zzhc, K k, V v) {
        this.zzalq = zzhc;
        this.zzalu = k;
        this.value = v;
    }

    public final V getValue() {
        return this.value;
    }

    public final V setValue(V v) {
        this.zzalq.zzwk();
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
        return equals(this.zzalu, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final int hashCode() {
        K k = this.zzalu;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzalu);
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
        return this.zzalu;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzhh) obj).getKey());
    }
}
