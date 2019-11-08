package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzp;

final class zzib implements Runnable {
    private final /* synthetic */ zzp zzdi;
    private final /* synthetic */ zzn zzpg;
    private final /* synthetic */ zzhv zzrd;

    zzib(zzhv zzhv, zzn zzn, zzp zzp) {
        this.zzrd = zzhv;
        this.zzpg = zzn;
        this.zzdi = zzp;
    }

    public final void run() {
        String str = "Failed to get app instance id";
        try {
            zzdx zzd = this.zzrd.zzrf;
            if (zzd == null) {
                this.zzrd.zzab().zzgk().zzao(str);
                return;
            }
            String zzc = zzd.zzc(this.zzpg);
            if (zzc != null) {
                this.zzrd.zzq().zzbg(zzc);
                this.zzrd.zzac().zzlq.zzau(zzc);
            }
            this.zzrd.zzir();
            this.zzrd.zzz().zzb(this.zzdi, zzc);
        } catch (RemoteException e) {
            this.zzrd.zzab().zzgk().zza(str, e);
        } finally {
            this.zzrd.zzz().zzb(this.zzdi, (String) null);
        }
    }
}
