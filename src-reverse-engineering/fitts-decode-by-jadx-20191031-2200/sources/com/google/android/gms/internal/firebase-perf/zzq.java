package com.google.android.gms.internal.firebase-perf;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

public abstract class zzq<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzq = new Object[0];

    zzq() {
    }

    public abstract boolean contains(Object obj);

    /* renamed from: zzb */
    public abstract zzaf<E> iterator();

    /* access modifiers changed from: 0000 */
    public Object[] zzc() {
        return null;
    }

    public final Object[] toArray() {
        return toArray(zzq);
    }

    public final <T> T[] toArray(T[] tArr) {
        zzf.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzc = zzc();
            if (zzc != null) {
                return Arrays.copyOfRange(zzc, zzd(), zze(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: 0000 */
    public int zzd() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: 0000 */
    public int zze() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public zzr<E> zzf() {
        return isEmpty() ? zzr.zzg() : zzr.zza(toArray());
    }

    /* access modifiers changed from: 0000 */
    public int zza(Object[] objArr, int i) {
        zzaf zzaf = (zzaf) iterator();
        while (zzaf.hasNext()) {
            int i2 = i + 1;
            objArr[i] = zzaf.next();
            i = i2;
        }
        return i;
    }
}
