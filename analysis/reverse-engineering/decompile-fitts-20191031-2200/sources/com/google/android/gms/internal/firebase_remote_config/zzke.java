package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;

final class zzke implements Iterator<String> {
    private final /* synthetic */ zzkc zzxk;
    private Iterator<String> zzyg = this.zzxk.zzxl.iterator();

    zzke(zzkc zzkc) {
        this.zzxk = zzkc;
    }

    public final boolean hasNext() {
        return this.zzyg.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return (String) this.zzyg.next();
    }
}
