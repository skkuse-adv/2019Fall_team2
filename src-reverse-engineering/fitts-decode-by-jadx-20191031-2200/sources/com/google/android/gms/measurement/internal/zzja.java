package com.google.android.gms.measurement.internal;

final class zzja implements Runnable {
    private final /* synthetic */ long zzcd;
    private final /* synthetic */ zziw zzsi;

    zzja(zziw zziw, long j) {
        this.zzsi = zziw;
        this.zzcd = j;
    }

    public final void run() {
        this.zzsi.zzab(this.zzcd);
    }
}
