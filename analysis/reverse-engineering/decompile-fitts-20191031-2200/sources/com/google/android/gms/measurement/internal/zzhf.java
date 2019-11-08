package com.google.android.gms.measurement.internal;

final class zzhf implements Runnable {
    private final /* synthetic */ boolean zzaz;
    private final /* synthetic */ zzgp zzpt;

    zzhf(zzgp zzgp, boolean z) {
        this.zzpt = zzgp;
        this.zzaz = z;
    }

    public final void run() {
        this.zzpt.zzg(this.zzaz);
    }
}
