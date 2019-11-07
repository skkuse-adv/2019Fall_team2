package com.google.android.gms.internal.firebase_remote_config;

import java.util.NoSuchElementException;

final class zzga extends zzgc {
    private final int limit = this.zzoy.size();
    private int position = 0;
    private final /* synthetic */ zzfx zzoy;

    zzga(zzfx zzfx) {
        this.zzoy = zzfx;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzoy.zzw(i);
        }
        throw new NoSuchElementException();
    }
}
