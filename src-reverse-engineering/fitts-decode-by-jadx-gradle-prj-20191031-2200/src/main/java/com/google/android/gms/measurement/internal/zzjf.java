package com.google.android.gms.measurement.internal;

final class zzjf extends zzaa {
    private final /* synthetic */ zzjg zzsa;
    private final /* synthetic */ zzjc zzsm;

    zzjf(zzjc zzjc, zzgh zzgh, zzjg zzjg) {
        this.zzsm = zzjc;
        this.zzsa = zzjg;
        super(zzgh);
    }

    public final void run() {
        this.zzsm.cancel();
        this.zzsm.zzab().zzgs().zzao("Starting upload from DelayedRunnable");
        this.zzsa.zzjl();
    }
}
