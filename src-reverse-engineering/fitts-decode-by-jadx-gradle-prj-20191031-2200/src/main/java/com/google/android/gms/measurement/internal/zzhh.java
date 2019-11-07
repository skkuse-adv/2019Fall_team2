package com.google.android.gms.measurement.internal;

final class zzhh implements Runnable {
    private final /* synthetic */ long zzba;
    private final /* synthetic */ zzgp zzpt;

    zzhh(zzgp zzgp, long j) {
        this.zzpt = zzgp;
        this.zzba = j;
    }

    public final void run() {
        this.zzpt.zzac().zzlu.set(this.zzba);
        this.zzpt.zzab().zzgr().zza("Minimum session duration set", Long.valueOf(this.zzba));
    }
}
