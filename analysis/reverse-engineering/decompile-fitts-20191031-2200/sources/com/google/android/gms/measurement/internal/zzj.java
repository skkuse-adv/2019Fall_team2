package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzp;

final class zzj implements Runnable {
    private final /* synthetic */ zzp zzdi;
    private final /* synthetic */ AppMeasurementDynamiteService zzdj;
    private final /* synthetic */ zzai zzdm;
    private final /* synthetic */ String zzdn;

    zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, zzp zzp, zzai zzai, String str) {
        this.zzdj = appMeasurementDynamiteService;
        this.zzdi = zzp;
        this.zzdm = zzai;
        this.zzdn = str;
    }

    public final void run() {
        this.zzdj.zzj.zzs().zza(this.zzdi, this.zzdm, this.zzdn);
    }
}
