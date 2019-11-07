package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzhy implements Runnable {
    private final /* synthetic */ zzn zzpg;
    private final /* synthetic */ zzhv zzrd;
    private final /* synthetic */ AtomicReference zzrl;

    zzhy(zzhv zzhv, AtomicReference atomicReference, zzn zzn) {
        this.zzrd = zzhv;
        this.zzrl = atomicReference;
        this.zzpg = zzn;
    }

    public final void run() {
        synchronized (this.zzrl) {
            try {
                zzdx zzd = this.zzrd.zzrf;
                if (zzd == null) {
                    this.zzrd.zzab().zzgk().zzao("Failed to get app instance id");
                    this.zzrl.notify();
                    return;
                }
                this.zzrl.set(zzd.zzc(this.zzpg));
                String str = (String) this.zzrl.get();
                if (str != null) {
                    this.zzrd.zzq().zzbg(str);
                    this.zzrd.zzac().zzlq.zzau(str);
                }
                this.zzrd.zzir();
                this.zzrl.notify();
            } catch (RemoteException e) {
                try {
                    this.zzrd.zzab().zzgk().zza("Failed to get app instance id", e);
                    this.zzrl.notify();
                } catch (Throwable th) {
                    this.zzrl.notify();
                    throw th;
                }
            }
        }
    }
}
