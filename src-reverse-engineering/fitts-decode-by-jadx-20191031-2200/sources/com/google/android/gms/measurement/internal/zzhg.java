package com.google.android.gms.measurement.internal;

final class zzhg implements Runnable {
    private final /* synthetic */ long zzba;
    private final /* synthetic */ zzgp zzpt;

    zzhg(zzgp zzgp, long j) {
        this.zzpt = zzgp;
        this.zzba = j;
    }

    public final void run() {
        this.zzpt.zzac().zzlv.set(this.zzba);
        this.zzpt.zzab().zzgr().zza("Session timeout duration set", Long.valueOf(this.zzba));
    }
}
