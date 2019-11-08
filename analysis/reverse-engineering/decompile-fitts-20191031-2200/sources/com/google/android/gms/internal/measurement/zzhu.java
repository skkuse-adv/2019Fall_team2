package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzhu extends AbstractList<String> implements zzfp, RandomAccess {
    /* access modifiers changed from: private */
    public final zzfp zzamd;

    public zzhu(zzfp zzfp) {
        this.zzamd = zzfp;
    }

    public final zzfp zzvg() {
        return this;
    }

    public final Object zzbw(int i) {
        return this.zzamd.zzbw(i);
    }

    public final int size() {
        return this.zzamd.size();
    }

    public final void zzc(zzdp zzdp) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzht(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzhw(this);
    }

    public final List<?> zzvf() {
        return this.zzamd.zzvf();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzamd.get(i);
    }
}
