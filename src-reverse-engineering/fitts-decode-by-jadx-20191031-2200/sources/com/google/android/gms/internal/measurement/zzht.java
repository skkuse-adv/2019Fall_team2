package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

final class zzht implements ListIterator<String> {
    private ListIterator<String> zzama = this.zzamc.zzamd.listIterator(this.zzamb);
    private final /* synthetic */ int zzamb;
    private final /* synthetic */ zzhu zzamc;

    zzht(zzhu zzhu, int i) {
        this.zzamc = zzhu;
        this.zzamb = i;
    }

    public final boolean hasNext() {
        return this.zzama.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzama.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzama.nextIndex();
    }

    public final int previousIndex() {
        return this.zzama.previousIndex();
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
        return (String) this.zzama.previous();
    }

    public final /* synthetic */ Object next() {
        return (String) this.zzama.next();
    }
}
