package com.google.android.gms.internal.firebase_remote_config;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzcq implements Iterator<T> {
    private int index = 0;
    private final int length = Array.getLength(this.zzgi.zzgh);
    private final /* synthetic */ zzcn zzgi;

    zzcq(zzcn zzcn) {
        this.zzgi = zzcn;
    }

    public final boolean hasNext() {
        return this.index < this.length;
    }

    public final T next() {
        if (hasNext()) {
            Object obj = this.zzgi.zzgh;
            int i = this.index;
            this.index = i + 1;
            return Array.get(obj, i);
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
