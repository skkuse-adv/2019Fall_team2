package com.google.android.gms.measurement.internal;

final class zzjb implements Runnable {
    private final /* synthetic */ long zzcd;
    private final /* synthetic */ zziw zzsi;

    zzjb(zziw zziw, long j) {
        this.zzsi = zziw;
        this.zzcd = j;
    }

    public final void run() {
        this.zzsi.zzaa(this.zzcd);
    }
}
