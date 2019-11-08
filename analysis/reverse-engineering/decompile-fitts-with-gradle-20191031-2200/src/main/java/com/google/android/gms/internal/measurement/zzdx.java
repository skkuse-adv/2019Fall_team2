package com.google.android.gms.internal.measurement;

final class zzdx {
    private final byte[] buffer;
    private final zzee zzadn;

    private zzdx(int i) {
        this.buffer = new byte[i];
        this.zzadn = zzee.zzf(this.buffer);
    }

    public final zzdp zzse() {
        this.zzadn.zzth();
        return new zzdz(this.buffer);
    }

    public final zzee zzsf() {
        return this.zzadn;
    }

    /* synthetic */ zzdx(int i, zzdo zzdo) {
        this(i);
    }
}
