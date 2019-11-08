package com.google.android.gms.internal.firebase_remote_config;

import java.util.ArrayList;
import java.util.List;

final class zzje<E> extends zzfr<E> {
    private static final zzje<Object> zzwn;
    private final List<E> zzuz;

    public static <E> zzje<E> zzil() {
        return zzwn;
    }

    zzje() {
        this(new ArrayList(10));
    }

    private zzje(List<E> list) {
        this.zzuz = list;
    }

    public final void add(int i, E e) {
        zzet();
        this.zzuz.add(i, e);
        this.modCount++;
    }

    public final E get(int i) {
        return this.zzuz.get(i);
    }

    public final E remove(int i) {
        zzet();
        E remove = this.zzuz.remove(i);
        this.modCount++;
        return remove;
    }

    public final E set(int i, E e) {
        zzet();
        E e2 = this.zzuz.set(i, e);
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.zzuz.size();
    }

    public final /* synthetic */ zzhn zzu(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzuz);
            return new zzje(arrayList);
        }
        throw new IllegalArgumentException();
    }

    static {
        zzje<Object> zzje = new zzje<>(new ArrayList(0));
        zzwn = zzje;
        zzje.zzes();
    }
}
