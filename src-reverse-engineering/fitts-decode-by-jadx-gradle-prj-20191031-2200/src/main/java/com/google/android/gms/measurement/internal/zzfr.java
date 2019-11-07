package com.google.android.gms.measurement.internal;

final class zzfr implements Runnable {
    private final /* synthetic */ zzq zzpf;
    private final /* synthetic */ zzfk zzph;

    zzfr(zzfk zzfk, zzq zzq) {
        this.zzph = zzfk;
        this.zzpf = zzq;
    }

    public final void run() {
        this.zzph.zzkz.zzjq();
        this.zzph.zzkz.zze(this.zzpf);
    }
}
