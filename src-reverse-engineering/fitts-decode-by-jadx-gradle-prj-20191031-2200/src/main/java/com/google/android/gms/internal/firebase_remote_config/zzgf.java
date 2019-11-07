package com.google.android.gms.internal.firebase_remote_config;

final class zzgf {
    private final byte[] buffer;
    private final zzgs zzpb;

    private zzgf(int i) {
        this.buffer = new byte[i];
        this.zzpb = zzgs.zzc(this.buffer);
    }

    public final zzfx zzez() {
        if (this.zzpb.zzgb() == 0) {
            return new zzgh(this.buffer);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zzgs zzfa() {
        return this.zzpb;
    }

    /* synthetic */ zzgf(int i, zzga zzga) {
        this(i);
    }
}
