package com.google.android.gms.internal.firebase-perf;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzgp<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zznq;
    private final int zzty;
    /* access modifiers changed from: private */
    public List<zzgy> zztz;
    /* access modifiers changed from: private */
    public Map<K, V> zzua;
    private volatile zzha zzub;
    /* access modifiers changed from: private */
    public Map<K, V> zzuc;
    private volatile zzgu zzud;

    static <FieldDescriptorType extends zzej<FieldDescriptorType>> zzgp<FieldDescriptorType, Object> zzat(int i) {
        return new zzgs(i);
    }

    private zzgp(int i) {
        this.zzty = i;
        this.zztz = Collections.emptyList();
        this.zzua = Collections.emptyMap();
        this.zzuc = Collections.emptyMap();
    }

    public void zzgf() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zznq) {
            if (this.zzua.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzua);
            }
            this.zzua = map;
            if (this.zzuc.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzuc);
            }
            this.zzuc = map2;
            this.zznq = true;
        }
    }

    public final boolean isImmutable() {
        return this.zznq;
    }

    public final int zzis() {
        return this.zztz.size();
    }

    public final Entry<K, V> zzau(int i) {
        return (Entry) this.zztz.get(i);
    }

    public final Iterable<Entry<K, V>> zzit() {
        if (this.zzua.isEmpty()) {
            return zzgt.zzjd();
        }
        return this.zzua.entrySet();
    }

    public int size() {
        return this.zztz.size() + this.zzua.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((K) comparable) >= 0 || this.zzua.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((K) comparable);
        if (zza >= 0) {
            return ((zzgy) this.zztz.get(zza)).getValue();
        }
        return this.zzua.get(comparable);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zziv();
        int zza = zza(k);
        if (zza >= 0) {
            return ((zzgy) this.zztz.get(zza)).setValue(v);
        }
        zziv();
        if (this.zztz.isEmpty() && !(this.zztz instanceof ArrayList)) {
            this.zztz = new ArrayList(this.zzty);
        }
        int i = -(zza + 1);
        if (i >= this.zzty) {
            return zziw().put(k, v);
        }
        int size = this.zztz.size();
        int i2 = this.zzty;
        if (size == i2) {
            zzgy zzgy = (zzgy) this.zztz.remove(i2 - 1);
            zziw().put((Comparable) zzgy.getKey(), zzgy.getValue());
        }
        this.zztz.add(i, new zzgy(this, k, v));
        return null;
    }

    public void clear() {
        zziv();
        if (!this.zztz.isEmpty()) {
            this.zztz.clear();
        }
        if (!this.zzua.isEmpty()) {
            this.zzua.clear();
        }
    }

    public V remove(Object obj) {
        zziv();
        Comparable comparable = (Comparable) obj;
        int zza = zza((K) comparable);
        if (zza >= 0) {
            return zzav(zza);
        }
        if (this.zzua.isEmpty()) {
            return null;
        }
        return this.zzua.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzav(int i) {
        zziv();
        V value = ((zzgy) this.zztz.remove(i)).getValue();
        if (!this.zzua.isEmpty()) {
            Iterator it = zziw().entrySet().iterator();
            this.zztz.add(new zzgy(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final int zza(K k) {
        int size = this.zztz.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) ((zzgy) this.zztz.get(size)).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) ((zzgy) this.zztz.get(i2)).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public Set<Entry<K, V>> entrySet() {
        if (this.zzub == null) {
            this.zzub = new zzha(this, null);
        }
        return this.zzub;
    }

    /* access modifiers changed from: 0000 */
    public final Set<Entry<K, V>> zziu() {
        if (this.zzud == null) {
            this.zzud = new zzgu(this, null);
        }
        return this.zzud;
    }

    /* access modifiers changed from: private */
    public final void zziv() {
        if (this.zznq) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zziw() {
        zziv();
        if (this.zzua.isEmpty() && !(this.zzua instanceof TreeMap)) {
            this.zzua = new TreeMap();
            this.zzuc = ((TreeMap) this.zzua).descendingMap();
        }
        return (SortedMap) this.zzua;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgp)) {
            return super.equals(obj);
        }
        zzgp zzgp = (zzgp) obj;
        int size = size();
        if (size != zzgp.size()) {
            return false;
        }
        int zzis = zzis();
        if (zzis != zzgp.zzis()) {
            return entrySet().equals(zzgp.entrySet());
        }
        for (int i = 0; i < zzis; i++) {
            if (!zzau(i).equals(zzgp.zzau(i))) {
                return false;
            }
        }
        if (zzis != size) {
            return this.zzua.equals(zzgp.zzua);
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < zzis(); i2++) {
            i += ((zzgy) this.zztz.get(i2)).hashCode();
        }
        return this.zzua.size() > 0 ? i + this.zzua.hashCode() : i;
    }

    /* synthetic */ zzgp(int i, zzgs zzgs) {
        this(i);
    }
}
