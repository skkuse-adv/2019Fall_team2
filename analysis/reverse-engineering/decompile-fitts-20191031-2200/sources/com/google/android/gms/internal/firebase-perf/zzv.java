package com.google.android.gms.internal.firebase-perf;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

public abstract class zzv<K, V> implements Serializable, Map<K, V> {
    private transient zzx<Entry<K, V>> zzu;
    private transient zzx<K> zzv;
    private transient zzq<V> zzw;

    public static <K, V> zzv<K, V> zzj() {
        return zzz.zzab;
    }

    public abstract V get(Object obj);

    /* access modifiers changed from: 0000 */
    public abstract zzx<Entry<K, V>> zzk();

    /* access modifiers changed from: 0000 */
    public abstract zzx<K> zzl();

    /* access modifiers changed from: 0000 */
    public abstract zzq<V> zzm();

    /* access modifiers changed from: 0000 */
    public abstract boolean zzn();

    public static <K, V> zzv<K, V> zza(Map<? extends K, ? extends V> map) {
        if (!(map instanceof zzv) || (map instanceof SortedMap)) {
            Set entrySet = map.entrySet();
            zzy zzy = new zzy(entrySet instanceof Collection ? entrySet.size() : 4);
            zzy.zza(entrySet);
            return zzy.zzp();
        }
        zzv<K, V> zzv2 = (zzv) map;
        zzv2.zzn();
        return zzv2;
    }

    zzv() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        return ((zzq) values()).contains(obj);
    }

    public final V getOrDefault(Object obj, V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    public int hashCode() {
        return zzag.zza((zzx) entrySet());
    }

    public String toString() {
        int size = size();
        zzo.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824));
        sb.append('{');
        boolean z = true;
        for (Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            z = false;
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    public /* synthetic */ Set entrySet() {
        zzx<Entry<K, V>> zzx = this.zzu;
        if (zzx != null) {
            return zzx;
        }
        zzx<Entry<K, V>> zzk = zzk();
        this.zzu = zzk;
        return zzk;
    }

    public /* synthetic */ Collection values() {
        zzq<V> zzq = this.zzw;
        if (zzq != null) {
            return zzq;
        }
        zzq<V> zzm = zzm();
        this.zzw = zzm;
        return zzm;
    }

    public /* synthetic */ Set keySet() {
        zzx<K> zzx = this.zzv;
        if (zzx != null) {
            return zzx;
        }
        zzx<K> zzl = zzl();
        this.zzv = zzl;
        return zzl;
    }
}
