package com.google.android.gms.internal.firebase_remote_config;

import java.util.ListIterator;

final class zzkb implements ListIterator<String> {
    private ListIterator<String> zzxi = this.zzxk.zzxl.listIterator(this.zzxj);
    private final /* synthetic */ int zzxj;
    private final /* synthetic */ zzkc zzxk;

    zzkb(zzkc zzkc, int i) {
        this.zzxk = zzkc;
        this.zzxj = i;
    }

    public final boolean hasNext() {
        return this.zzxi.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzxi.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzxi.nextIndex();
    }

    public final int previousIndex() {
        return this.zzxi.previousIndex();
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
        return (String) this.zzxi.previous();
    }

    public final /* synthetic */ Object next() {
        return (String) this.zzxi.next();
    }
}
