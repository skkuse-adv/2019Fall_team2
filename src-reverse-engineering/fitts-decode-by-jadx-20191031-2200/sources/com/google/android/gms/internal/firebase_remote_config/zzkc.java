package com.google.android.gms.internal.firebase_remote_config;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzkc extends AbstractList<String> implements zzhx, RandomAccess {
    /* access modifiers changed from: private */
    public final zzhx zzxl;

    public zzkc(zzhx zzhx) {
        this.zzxl = zzhx;
    }

    public final zzhx zzhr() {
        return this;
    }

    public final Object zzbd(int i) {
        return this.zzxl.zzbd(i);
    }

    public final int size() {
        return this.zzxl.size();
    }

    public final void zzd(zzfx zzfx) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzkb(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzke(this);
    }

    public final List<?> zzhq() {
        return this.zzxl.zzhq();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzxl.get(i);
    }
}
