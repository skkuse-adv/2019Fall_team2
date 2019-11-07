package com.google.android.gms.measurement.internal;

final class zzgu implements Runnable {
    private final /* synthetic */ zzgk zzbc;
    private final /* synthetic */ zzgp zzpt;

    zzgu(zzgp zzgp, zzgk zzgk) {
        this.zzpt = zzgp;
        this.zzbc = zzgk;
    }

    public final void run() {
        this.zzpt.zza(this.zzbc);
    }
}
