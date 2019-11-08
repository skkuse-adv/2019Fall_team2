package com.google.android.gms.measurement.internal;

final class zzfp implements Runnable {
    private final /* synthetic */ zzq zzpf;
    private final /* synthetic */ zzn zzpg;
    private final /* synthetic */ zzfk zzph;

    zzfp(zzfk zzfk, zzq zzq, zzn zzn) {
        this.zzph = zzfk;
        this.zzpf = zzq;
        this.zzpg = zzn;
    }

    public final void run() {
        this.zzph.zzkz.zzjq();
        this.zzph.zzkz.zzb(this.zzpf, this.zzpg);
    }
}
