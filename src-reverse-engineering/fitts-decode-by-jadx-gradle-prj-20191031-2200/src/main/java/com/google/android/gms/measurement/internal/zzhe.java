package com.google.android.gms.measurement.internal;

final class zzhe implements Runnable {
    private final /* synthetic */ boolean zzaz;
    private final /* synthetic */ zzgp zzpt;

    zzhe(zzgp zzgp, boolean z) {
        this.zzpt = zzgp;
        this.zzaz = z;
    }

    public final void run() {
        boolean isEnabled = this.zzpt.zzj.isEnabled();
        boolean zzib = this.zzpt.zzj.zzib();
        this.zzpt.zzj.zza(this.zzaz);
        if (zzib == this.zzaz) {
            this.zzpt.zzj.zzab().zzgs().zza("Default data collection state already set to", Boolean.valueOf(this.zzaz));
        }
        if (this.zzpt.zzj.isEnabled() == isEnabled || this.zzpt.zzj.isEnabled() != this.zzpt.zzj.zzib()) {
            this.zzpt.zzj.zzab().zzgp().zza("Default data collection is different than actual status", Boolean.valueOf(this.zzaz), Boolean.valueOf(isEnabled));
        }
        this.zzpt.zzil();
    }
}
