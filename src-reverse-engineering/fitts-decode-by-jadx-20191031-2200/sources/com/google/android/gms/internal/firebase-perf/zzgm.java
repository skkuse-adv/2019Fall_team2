package com.google.android.gms.internal.firebase-perf;

import java.util.ArrayList;
import java.util.List;

final class zzgm<E> extends zzdk<E> {
    private static final zzgm<Object> zztx;
    private final List<E> zzse;

    public static <E> zzgm<E> zzir() {
        return zztx;
    }

    zzgm() {
        this(new ArrayList(10));
    }

    private zzgm(List<E> list) {
        this.zzse = list;
    }

    public final void add(int i, E e) {
        zzgg();
        this.zzse.add(i, e);
        this.modCount++;
    }

    public final E get(int i) {
        return this.zzse.get(i);
    }

    public final E remove(int i) {
        zzgg();
        E remove = this.zzse.remove(i);
        this.modCount++;
        return remove;
    }

    public final E set(int i, E e) {
        zzgg();
        E e2 = this.zzse.set(i, e);
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.zzse.size();
    }

    public final /* synthetic */ zzey zzao(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzse);
            return new zzgm(arrayList);
        }
        throw new IllegalArgumentException();
    }

    static {
        zzgm<Object> zzgm = new zzgm<>(new ArrayList(0));
        zztx = zzgm;
        zzgm.zzgf();
    }
}
