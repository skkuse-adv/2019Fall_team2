package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class zzig implements Runnable {
    private final /* synthetic */ zzn zzpg;
    private final /* synthetic */ zzhv zzrd;
    private final /* synthetic */ boolean zzrm;
    private final /* synthetic */ boolean zzro;
    private final /* synthetic */ zzq zzrp;
    private final /* synthetic */ zzq zzrq;

    zzig(zzhv zzhv, boolean z, boolean z2, zzq zzq, zzn zzn, zzq zzq2) {
        this.zzrd = zzhv;
        this.zzro = z;
        this.zzrm = z2;
        this.zzrp = zzq;
        this.zzpg = zzn;
        this.zzrq = zzq2;
    }

    public final void run() {
        zzdx zzd = this.zzrd.zzrf;
        if (zzd == null) {
            this.zzrd.zzab().zzgk().zzao("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zzro) {
            this.zzrd.zza(zzd, (AbstractSafeParcelable) this.zzrm ? null : this.zzrp, this.zzpg);
        } else {
            try {
                if (TextUtils.isEmpty(this.zzrq.packageName)) {
                    zzd.zza(this.zzrp, this.zzpg);
                } else {
                    zzd.zzb(this.zzrp);
                }
            } catch (RemoteException e) {
                this.zzrd.zzab().zzgk().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.zzrd.zzir();
    }
}
