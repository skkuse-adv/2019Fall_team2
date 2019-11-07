package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzp;

final class zzk implements Runnable {
    private final /* synthetic */ zzp zzdi;
    private final /* synthetic */ AppMeasurementDynamiteService zzdj;

    zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, zzp zzp) {
        this.zzdj = appMeasurementDynamiteService;
        this.zzdi = zzp;
    }

    public final void run() {
        this.zzdj.zzj.zzz().zza(this.zzdi, this.zzdj.zzj.zzib());
    }
}
