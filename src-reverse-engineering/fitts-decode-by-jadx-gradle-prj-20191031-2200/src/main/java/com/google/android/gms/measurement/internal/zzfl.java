package com.google.android.gms.measurement.internal;

final class zzfl implements Runnable {
    private final /* synthetic */ zzgm zzpd;
    private final /* synthetic */ zzfj zzpe;

    zzfl(zzfj zzfj, zzgm zzgm) {
        this.zzpe = zzfj;
        this.zzpd = zzgm;
    }

    public final void run() {
        this.zzpe.zza(this.zzpd);
        this.zzpe.start();
    }
}
