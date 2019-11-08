package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

final class zzir implements Runnable {
    private final /* synthetic */ zzin zzrs;

    zzir(zzin zzin) {
        this.zzrs = zzin;
    }

    public final void run() {
        zzhv zzhv = this.zzrs.zzrd;
        Context context = zzhv.getContext();
        this.zzrs.zzrd.zzae();
        zzhv.onServiceDisconnected(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
