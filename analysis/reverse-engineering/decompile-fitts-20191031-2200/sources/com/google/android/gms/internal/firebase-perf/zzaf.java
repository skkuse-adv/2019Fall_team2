package com.google.android.gms.internal.firebase-perf;

import java.util.Iterator;

public abstract class zzaf<E> implements Iterator<E> {
    protected zzaf() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
