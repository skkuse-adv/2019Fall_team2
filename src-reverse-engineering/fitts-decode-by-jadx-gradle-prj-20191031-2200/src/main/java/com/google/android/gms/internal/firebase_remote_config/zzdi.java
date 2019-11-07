package com.google.android.gms.internal.firebase_remote_config;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class zzdi<T> implements Iterator<T> {
    private int zzgw = zzdk.zzgz;
    private T zzgx;

    protected zzdi() {
    }

    /* access modifiers changed from: protected */
    public abstract T zzcg();

    /* access modifiers changed from: protected */
    public final T zzch() {
        this.zzgw = zzdk.zzha;
        return null;
    }

    public final boolean hasNext() {
        zzdt.checkState(this.zzgw != zzdk.zzhb);
        int i = zzdh.zzgv[this.zzgw - 1];
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            this.zzgw = zzdk.zzhb;
            this.zzgx = zzcg();
            if (this.zzgw != zzdk.zzha) {
                this.zzgw = zzdk.zzgy;
                return true;
            }
        }
        return false;
    }

    public final T next() {
        if (hasNext()) {
            this.zzgw = zzdk.zzgz;
            T t = this.zzgx;
            this.zzgx = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
