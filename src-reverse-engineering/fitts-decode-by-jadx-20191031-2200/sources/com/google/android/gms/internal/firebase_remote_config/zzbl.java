package com.google.android.gms.internal.firebase_remote_config;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public class zzbl<K, V> extends AbstractMap<K, V> implements Cloneable {
    int size;
    private Object[] zzed;

    final class zza implements Entry<K, V> {
        private int index;

        zza(int i) {
            this.index = i;
        }

        public final K getKey() {
            return zzbl.this.zzf(this.index);
        }

        public final V getValue() {
            return zzbl.this.zzg(this.index);
        }

        public final V setValue(V v) {
            return zzbl.this.set(this.index, v);
        }

        public final int hashCode() {
            Object key = getKey();
            Object value = getValue();
            int i = 0;
            int hashCode = key != null ? key.hashCode() : 0;
            if (value != null) {
                i = value.hashCode();
            }
            return hashCode ^ i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = getKey();
            Object key2 = entry.getKey();
            if (key == key2 || (key != null && key.equals(key2))) {
                Object value = getValue();
                Object value2 = entry.getValue();
                if (value == value2 || (value != null && value.equals(value2))) {
                    return true;
                }
            }
            return false;
        }
    }

    final class zzb extends AbstractSet<Entry<K, V>> {
        zzb() {
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new zzc();
        }

        public final int size() {
            return zzbl.this.size;
        }
    }

    final class zzc implements Iterator<Entry<K, V>> {
        private boolean zzee;
        private int zzef;

        zzc() {
        }

        public final boolean hasNext() {
            return this.zzef < zzbl.this.size;
        }

        public final void remove() {
            int i = this.zzef - 1;
            if (this.zzee || i < 0) {
                throw new IllegalArgumentException();
            }
            zzbl.this.remove(i);
            this.zzef--;
            this.zzee = true;
        }

        public final /* synthetic */ Object next() {
            int i = this.zzef;
            zzbl zzbl = zzbl.this;
            if (i != zzbl.size) {
                this.zzef = i + 1;
                this.zzee = false;
                return new zza(i);
            }
            throw new NoSuchElementException();
        }
    }

    public final int size() {
        return this.size;
    }

    public final K zzf(int i) {
        if (i < 0 || i >= this.size) {
            return null;
        }
        return this.zzed[i << 1];
    }

    public final V zzg(int i) {
        if (i < 0 || i >= this.size) {
            return null;
        }
        return zzh((i << 1) + 1);
    }

    public final V set(int i, V v) {
        int i2 = this.size;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = (i << 1) + 1;
        V zzh = zzh(i3);
        this.zzed[i3] = v;
        return zzh;
    }

    public final V remove(int i) {
        return zzi(i << 1);
    }

    public final boolean containsKey(Object obj) {
        return -2 != zze(obj);
    }

    public final V get(Object obj) {
        return zzh(zze(obj) + 1);
    }

    public final V put(K k, V v) {
        int i;
        int zze = zze(k) >> 1;
        if (zze == -1) {
            zze = this.size;
        }
        if (zze >= 0) {
            int i2 = zze + 1;
            if (i2 >= 0) {
                Object[] objArr = this.zzed;
                int i3 = i2 << 1;
                if (objArr == null) {
                    i = 0;
                } else {
                    i = objArr.length;
                }
                if (i3 > i) {
                    int i4 = ((i / 2) * 3) + 1;
                    if (i4 % 2 != 0) {
                        i4++;
                    }
                    if (i4 < i3) {
                        i4 = i3;
                    }
                    if (i4 == 0) {
                        this.zzed = null;
                    } else {
                        int i5 = this.size;
                        Object[] objArr2 = this.zzed;
                        if (i5 == 0 || i4 != objArr2.length) {
                            Object[] objArr3 = new Object[i4];
                            this.zzed = objArr3;
                            if (i5 != 0) {
                                System.arraycopy(objArr2, 0, objArr3, 0, i5 << 1);
                            }
                        }
                    }
                }
                int i6 = zze << 1;
                V zzh = zzh(i6 + 1);
                zza(i6, k, v);
                if (i2 > this.size) {
                    this.size = i2;
                }
                return zzh;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IndexOutOfBoundsException();
    }

    public final V remove(Object obj) {
        return zzi(zze(obj));
    }

    private final void zza(int i, K k, V v) {
        Object[] objArr = this.zzed;
        objArr[i] = k;
        objArr[i + 1] = v;
    }

    private final V zzh(int i) {
        if (i < 0) {
            return null;
        }
        return this.zzed[i];
    }

    private final int zze(Object obj) {
        int i = this.size << 1;
        Object[] objArr = this.zzed;
        int i2 = 0;
        while (i2 < i) {
            Object obj2 = objArr[i2];
            if (obj == null) {
                if (obj2 != null) {
                    i2 += 2;
                }
            } else if (!obj.equals(obj2)) {
                i2 += 2;
            }
            return i2;
        }
        return -2;
    }

    private final V zzi(int i) {
        int i2 = this.size << 1;
        if (i < 0 || i >= i2) {
            return null;
        }
        V zzh = zzh(i + 1);
        Object[] objArr = this.zzed;
        int i3 = (i2 - i) - 2;
        if (i3 != 0) {
            System.arraycopy(objArr, i + 2, objArr, i, i3);
        }
        this.size--;
        zza(i2 - 2, null, null);
        return zzh;
    }

    public void clear() {
        this.size = 0;
        this.zzed = null;
    }

    public final boolean containsValue(Object obj) {
        int i = this.size << 1;
        Object[] objArr = this.zzed;
        int i2 = 1;
        while (i2 < i) {
            Object obj2 = objArr[i2];
            if (obj == null) {
                if (obj2 != null) {
                    i2 += 2;
                }
            } else if (!obj.equals(obj2)) {
                i2 += 2;
            }
            return true;
        }
        return false;
    }

    public final Set<Entry<K, V>> entrySet() {
        return new zzb();
    }

    /* access modifiers changed from: private */
    /* renamed from: zzbs */
    public final zzbl<K, V> clone() {
        try {
            zzbl<K, V> zzbl = (zzbl) super.clone();
            Object[] objArr = this.zzed;
            if (objArr != null) {
                int length = objArr.length;
                Object[] objArr2 = new Object[length];
                zzbl.zzed = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
            }
            return zzbl;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
