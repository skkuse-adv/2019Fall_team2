package com.google.android.gms.internal.firebase-perf;

final class zzdt {
    private final byte[] buffer;
    private final zzec zzmz;

    private zzdt(int i) {
        this.buffer = new byte[i];
        this.zzmz = zzec.zzb(this.buffer);
    }

    public final zzdl zzgl() {
        this.zzmz.zzgp();
        return new zzdv(this.buffer);
    }

    public final zzec zzgm() {
        return this.zzmz;
    }

    /* synthetic */ zzdt(int i, zzdo zzdo) {
        this(i);
    }
}
