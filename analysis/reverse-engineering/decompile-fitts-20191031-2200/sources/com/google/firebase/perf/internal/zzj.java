package com.google.firebase.perf.internal;

final class zzj implements Runnable {
    private final /* synthetic */ zzc zzdd;
    private final /* synthetic */ boolean zzdh;

    zzj(zzc zzc, boolean z) {
        this.zzdd = zzc;
        this.zzdh = z;
    }

    public final void run() {
        this.zzdd.zzc(this.zzdh);
    }
}
