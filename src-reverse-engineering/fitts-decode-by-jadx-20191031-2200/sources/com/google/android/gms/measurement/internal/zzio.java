package com.google.android.gms.measurement.internal;

final class zzio implements Runnable {
    private final /* synthetic */ zzin zzrs;
    private final /* synthetic */ zzdx zzrv;

    zzio(zzin zzin, zzdx zzdx) {
        this.zzrs = zzin;
        this.zzrv = zzdx;
    }

    public final void run() {
        synchronized (this.zzrs) {
            this.zzrs.zzrt = false;
            if (!this.zzrs.zzrd.isConnected()) {
                this.zzrs.zzrd.zzab().zzgr().zzao("Connected to remote service");
                this.zzrs.zzrd.zza(this.zzrv);
            }
        }
    }
}
