package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzp;

final class zzi implements Runnable {
    private final /* synthetic */ String zzas;
    private final /* synthetic */ zzp zzdi;
    private final /* synthetic */ AppMeasurementDynamiteService zzdj;
    private final /* synthetic */ boolean zzdl;
    private final /* synthetic */ String zzx;

    zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, zzp zzp, String str, String str2, boolean z) {
        this.zzdj = appMeasurementDynamiteService;
        this.zzdi = zzp;
        this.zzx = str;
        this.zzas = str2;
        this.zzdl = z;
    }

    public final void run() {
        this.zzdj.zzj.zzs().zza(this.zzdi, this.zzx, this.zzas, this.zzdl);
    }
}
