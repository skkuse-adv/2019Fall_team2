package com.google.android.gms.measurement.internal;

final class zziu implements Runnable {
    private final /* synthetic */ zzjg zzsa;
    private final /* synthetic */ Runnable zzsb;

    zziu(zzit zzit, zzjg zzjg, Runnable runnable) {
        this.zzsa = zzjg;
        this.zzsb = runnable;
    }

    public final void run() {
        this.zzsa.zzjq();
        this.zzsa.zzf(this.zzsb);
        this.zzsa.zzjl();
    }
}
