package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zzid implements Runnable {
    private final /* synthetic */ zzhr zzqy;
    private final /* synthetic */ zzhv zzrd;

    zzid(zzhv zzhv, zzhr zzhr) {
        this.zzrd = zzhv;
        this.zzqy = zzhr;
    }

    public final void run() {
        zzdx zzd = this.zzrd.zzrf;
        if (zzd == null) {
            this.zzrd.zzab().zzgk().zzao("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zzqy == null) {
                zzd.zza(0, (String) null, (String) null, this.zzrd.getContext().getPackageName());
            } else {
                zzd.zza(this.zzqy.zzqw, this.zzqy.zzqu, this.zzqy.zzqv, this.zzrd.getContext().getPackageName());
            }
            this.zzrd.zzir();
        } catch (RemoteException e) {
            this.zzrd.zzab().zzgk().zza("Failed to send current screen to the service", e);
        }
    }
}
