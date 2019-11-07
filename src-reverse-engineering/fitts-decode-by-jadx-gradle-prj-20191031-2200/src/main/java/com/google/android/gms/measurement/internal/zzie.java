package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zzie implements Runnable {
    private final /* synthetic */ zzn zzpg;
    private final /* synthetic */ zzhv zzrd;

    zzie(zzhv zzhv, zzn zzn) {
        this.zzrd = zzhv;
        this.zzpg = zzn;
    }

    public final void run() {
        zzdx zzd = this.zzrd.zzrf;
        if (zzd == null) {
            this.zzrd.zzab().zzgk().zzao("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzd.zzb(this.zzpg);
            this.zzrd.zzir();
        } catch (RemoteException e) {
            this.zzrd.zzab().zzgk().zza("Failed to send measurementEnabled to the service", e);
        }
    }
}
