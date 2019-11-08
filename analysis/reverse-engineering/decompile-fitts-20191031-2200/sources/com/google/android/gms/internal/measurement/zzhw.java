package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class zzhw implements Iterator<String> {
    private final /* synthetic */ zzhu zzamc;
    private Iterator<String> zzamy = this.zzamc.zzamd.iterator();

    zzhw(zzhu zzhu) {
        this.zzamc = zzhu;
    }

    public final boolean hasNext() {
        return this.zzamy.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return (String) this.zzamy.next();
    }
}
