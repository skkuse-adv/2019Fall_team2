package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzp;

final class zzh implements Runnable {
    private final /* synthetic */ zzp zzdi;
    private final /* synthetic */ AppMeasurementDynamiteService zzdj;

    zzh(AppMeasurementDynamiteService appMeasurementDynamiteService, zzp zzp) {
        this.zzdj = appMeasurementDynamiteService;
        this.zzdi = zzp;
    }

    public final void run() {
        this.zzdj.zzj.zzs().getAppInstanceId(this.zzdi);
    }
}
