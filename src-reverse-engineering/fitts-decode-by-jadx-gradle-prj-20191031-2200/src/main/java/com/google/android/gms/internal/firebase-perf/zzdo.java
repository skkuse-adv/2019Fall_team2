package com.google.android.gms.internal.firebase-perf;

import java.util.NoSuchElementException;

final class zzdo extends zzdq {
    private final int limit = this.zzmw.size();
    private int position = 0;
    private final /* synthetic */ zzdl zzmw;

    zzdo(zzdl zzdl) {
        this.zzmw = zzdl;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzmw.zzr(i);
        }
        throw new NoSuchElementException();
    }
}
