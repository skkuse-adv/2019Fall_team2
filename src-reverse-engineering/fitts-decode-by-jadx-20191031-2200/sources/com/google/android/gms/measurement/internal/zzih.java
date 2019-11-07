package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

final class zzih implements Runnable {
    private final /* synthetic */ zzai zzdm;
    private final /* synthetic */ String zzdn;
    private final /* synthetic */ zzn zzpg;
    private final /* synthetic */ zzhv zzrd;
    private final /* synthetic */ boolean zzrm;
    private final /* synthetic */ boolean zzro;

    zzih(zzhv zzhv, boolean z, boolean z2, zzai zzai, zzn zzn, String str) {
        this.zzrd = zzhv;
        this.zzro = z;
        this.zzrm = z2;
        this.zzdm = zzai;
        this.zzpg = zzn;
        this.zzdn = str;
    }

    public final void run() {
        zzdx zzd = this.zzrd.zzrf;
        if (zzd == null) {
            this.zzrd.zzab().zzgk().zzao("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zzro) {
            this.zzrd.zza(zzd, (AbstractSafeParcelable) this.zzrm ? null : this.zzdm, this.zzpg);
        } else {
            try {
                if (TextUtils.isEmpty(this.zzdn)) {
                    zzd.zza(this.zzdm, this.zzpg);
                } else {
                    zzd.zza(this.zzdm, this.zzdn, this.zzrd.zzab().zzgu());
                }
            } catch (RemoteException e) {
                this.zzrd.zzab().zzgk().zza("Failed to send event to the service", e);
            }
        }
        this.zzrd.zzir();
    }
}
