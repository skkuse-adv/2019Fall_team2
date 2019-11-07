package com.google.android.gms.internal.firebase-perf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzhh extends AbstractList<String> implements zzfi, RandomAccess {
    /* access modifiers changed from: private */
    public final zzfi zzus;

    public zzhh(zzfi zzfi) {
        this.zzus = zzfi;
    }

    public final zzfi zzhw() {
        return this;
    }

    public final Object getRaw(int i) {
        return this.zzus.getRaw(i);
    }

    public final int size() {
        return this.zzus.size();
    }

    public final void zzc(zzdl zzdl) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzhk(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzhj(this);
    }

    public final List<?> zzhv() {
        return this.zzus.zzhv();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzus.get(i);
    }
}
