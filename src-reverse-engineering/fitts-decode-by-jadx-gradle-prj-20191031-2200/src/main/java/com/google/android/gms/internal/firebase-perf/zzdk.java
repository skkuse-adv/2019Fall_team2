package com.google.android.gms.internal.firebase-perf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzdk<E> extends AbstractList<E> implements zzey<E> {
    private boolean zzms = true;

    zzdk() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public boolean add(E e) {
        zzgg();
        return super.add(e);
    }

    public void add(int i, E e) {
        zzgg();
        super.add(i, e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzgg();
        return super.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzgg();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzgg();
        super.clear();
    }

    public boolean zzge() {
        return this.zzms;
    }

    public final void zzgf() {
        this.zzms = false;
    }

    public E remove(int i) {
        zzgg();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        zzgg();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        zzgg();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzgg();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzgg();
        return super.set(i, e);
    }

    /* access modifiers changed from: protected */
    public final void zzgg() {
        if (!this.zzms) {
            throw new UnsupportedOperationException();
        }
    }
}
