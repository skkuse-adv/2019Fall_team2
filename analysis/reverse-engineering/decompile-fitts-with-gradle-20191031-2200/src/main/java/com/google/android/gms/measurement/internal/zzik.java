package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzp;

final class zzik implements Runnable {
    private final /* synthetic */ String zzas;
    private final /* synthetic */ boolean zzbi;
    private final /* synthetic */ zzp zzdi;
    private final /* synthetic */ zzn zzpg;
    private final /* synthetic */ zzhv zzrd;
    private final /* synthetic */ String zzx;

    zzik(zzhv zzhv, String str, String str2, boolean z, zzn zzn, zzp zzp) {
        this.zzrd = zzhv;
        this.zzx = str;
        this.zzas = str2;
        this.zzbi = z;
        this.zzpg = zzn;
        this.zzdi = zzp;
    }

    public final void run() {
        String str = "Failed to get user properties";
        Bundle bundle = new Bundle();
        try {
            zzdx zzd = this.zzrd.zzrf;
            if (zzd == null) {
                this.zzrd.zzab().zzgk().zza(str, this.zzx, this.zzas);
                return;
            }
            bundle = zzjs.zzc(zzd.zza(this.zzx, this.zzas, this.zzbi, this.zzpg));
            this.zzrd.zzir();
            this.zzrd.zzz().zza(this.zzdi, bundle);
        } catch (RemoteException e) {
            this.zzrd.zzab().zzgk().zza(str, this.zzx, e);
        } finally {
            this.zzrd.zzz().zza(this.zzdi, bundle);
        }
    }
}
