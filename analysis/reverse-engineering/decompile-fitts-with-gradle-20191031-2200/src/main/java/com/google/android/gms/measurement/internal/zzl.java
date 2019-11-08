package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzp;

final class zzl implements Runnable {
    private final /* synthetic */ String zzas;
    private final /* synthetic */ zzp zzdi;
    private final /* synthetic */ AppMeasurementDynamiteService zzdj;
    private final /* synthetic */ String zzx;

    zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, zzp zzp, String str, String str2) {
        this.zzdj = appMeasurementDynamiteService;
        this.zzdi = zzp;
        this.zzx = str;
        this.zzas = str2;
    }

    public final void run() {
        this.zzdj.zzj.zzs().zza(this.zzdi, this.zzx, this.zzas);
    }
}
