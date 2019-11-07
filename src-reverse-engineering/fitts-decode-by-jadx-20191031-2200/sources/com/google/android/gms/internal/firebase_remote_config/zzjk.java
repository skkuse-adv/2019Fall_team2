package com.google.android.gms.internal.firebase_remote_config;

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

class zzjk<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzqg;
    private final int zzws;
    /* access modifiers changed from: private */
    public List<zzjp> zzwt;
    /* access modifiers changed from: private */
    public Map<K, V> zzwu;
    private volatile zzjr zzwv;
    /* access modifiers changed from: private */
    public Map<K, V> zzww;
    private volatile zzjl zzwx;

    static <FieldDescriptorType extends zzhc<FieldDescriptorType>> zzjk<FieldDescriptorType, Object> zzbl(int i) {
        return new zzjj(i);
    }

    private zzjk(int i) {
        this.zzws = i;
        this.zzwt = Collections.emptyList();
        this.zzwu = Collections.emptyMap();
        this.zzww = Collections.emptyMap();
    }

    public void zzes() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzqg) {
            if (this.zzwu.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzwu);
            }
            this.zzwu = map;
            if (this.zzww.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzww);
            }
            this.zzww = map2;
            this.zzqg = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzqg;
    }

    public final int zzir() {
        return this.zzwt.size();
    }

    public final Entry<K, V> zzbm(int i) {
        return (Entry) this.zzwt.get(i);
    }

    public final Iterable<Entry<K, V>> zzis() {
        if (this.zzwu.isEmpty()) {
            return zzjo.zzix();
        }
        return this.zzwu.entrySet();
    }

    public int size() {
        return this.zzwt.size() + this.zzwu.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((K) comparable) >= 0 || this.zzwu.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((K) comparable);
        if (zza >= 0) {
            return ((zzjp) this.zzwt.get(zza)).getValue();
        }
        return this.zzwu.get(comparable);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zziu();
        int zza = zza(k);
        if (zza >= 0) {
            return ((zzjp) this.zzwt.get(zza)).setValue(v);
        }
        zziu();
        if (this.zzwt.isEmpty() && !(this.zzwt instanceof ArrayList)) {
            this.zzwt = new ArrayList(this.zzws);
        }
        int i = -(zza + 1);
        if (i >= this.zzws) {
            return zziv().put(k, v);
        }
        int size = this.zzwt.size();
        int i2 = this.zzws;
        if (size == i2) {
            zzjp zzjp = (zzjp) this.zzwt.remove(i2 - 1);
            zziv().put((Comparable) zzjp.getKey(), zzjp.getValue());
        }
        this.zzwt.add(i, new zzjp(this, k, v));
        return null;
    }

    public void clear() {
        zziu();
        if (!this.zzwt.isEmpty()) {
            this.zzwt.clear();
        }
        if (!this.zzwu.isEmpty()) {
            this.zzwu.clear();
        }
    }

    public V remove(Object obj) {
        zziu();
        Comparable comparable = (Comparable) obj;
        int zza = zza((K) comparable);
        if (zza >= 0) {
            return zzbn(zza);
        }
        if (this.zzwu.isEmpty()) {
            return null;
        }
        return this.zzwu.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzbn(int i) {
        zziu();
        V value = ((zzjp) this.zzwt.remove(i)).getValue();
        if (!this.zzwu.isEmpty()) {
            Iterator it = zziv().entrySet().iterator();
            this.zzwt.add(new zzjp(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final int zza(K k) {
        int size = this.zzwt.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) ((zzjp) this.zzwt.get(size)).getKey());
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
            int compareTo2 = k.compareTo((Comparable) ((zzjp) this.zzwt.get(i2)).getKey());
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
        if (this.zzwv == null) {
            this.zzwv = new zzjr(this, null);
        }
        return this.zzwv;
    }

    /* access modifiers changed from: 0000 */
    public final Set<Entry<K, V>> zzit() {
        if (this.zzwx == null) {
            this.zzwx = new zzjl(this, null);
        }
        return this.zzwx;
    }

    /* access modifiers changed from: private */
    public final void zziu() {
        if (this.zzqg) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zziv() {
        zziu();
        if (this.zzwu.isEmpty() && !(this.zzwu instanceof TreeMap)) {
            this.zzwu = new TreeMap();
            this.zzww = ((TreeMap) this.zzwu).descendingMap();
        }
        return (SortedMap) this.zzwu;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjk)) {
            return super.equals(obj);
        }
        zzjk zzjk = (zzjk) obj;
        int size = size();
        if (size != zzjk.size()) {
            return false;
        }
        int zzir = zzir();
        if (zzir != zzjk.zzir()) {
            return entrySet().equals(zzjk.entrySet());
        }
        for (int i = 0; i < zzir; i++) {
            if (!zzbm(i).equals(zzjk.zzbm(i))) {
                return false;
            }
        }
        if (zzir != size) {
            return this.zzwu.equals(zzjk.zzwu);
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < zzir(); i2++) {
            i += ((zzjp) this.zzwt.get(i2)).hashCode();
        }
        return this.zzwu.size() > 0 ? i + this.zzwu.hashCode() : i;
    }

    /* synthetic */ zzjk(int i, zzjj zzjj) {
        this(i);
    }
}
