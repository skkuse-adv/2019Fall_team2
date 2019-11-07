package com.google.android.gms.internal.firebase-perf;

import java.util.Iterator;

final class zzhj implements Iterator<String> {
    private Iterator<String> zzut = this.zzuu.zzus.iterator();
    private final /* synthetic */ zzhh zzuu;

    zzhj(zzhh zzhh) {
        this.zzuu = zzhh;
    }

    public final boolean hasNext() {
        return this.zzut.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return (String) this.zzut.next();
    }
}
