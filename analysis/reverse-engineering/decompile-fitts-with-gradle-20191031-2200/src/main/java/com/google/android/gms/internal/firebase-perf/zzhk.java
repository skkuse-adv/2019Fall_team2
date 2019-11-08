package com.google.android.gms.internal.firebase-perf;

import java.util.ListIterator;

final class zzhk implements ListIterator<String> {
    private final /* synthetic */ zzhh zzuu;
    private ListIterator<String> zzuv = this.zzuu.zzus.listIterator(this.zzuw);
    private final /* synthetic */ int zzuw;

    zzhk(zzhh zzhh, int i) {
        this.zzuu = zzhh;
        this.zzuw = i;
    }

    public final boolean hasNext() {
        return this.zzuv.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzuv.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzuv.nextIndex();
    }

    public final int previousIndex() {
        return this.zzuv.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return (String) this.zzuv.previous();
    }

    public final /* synthetic */ Object next() {
        return (String) this.zzuv.next();
    }
}
