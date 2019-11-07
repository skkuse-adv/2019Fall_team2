package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzgv implements Runnable {
    private final /* synthetic */ zzgp zzpt;
    private final /* synthetic */ long zzqf;

    zzgv(zzgp zzgp, long j) {
        this.zzpt = zzgp;
        this.zzqf = j;
    }

    public final void run() {
        zzgp zzgp = this.zzpt;
        long j = this.zzqf;
        zzgp.zzo();
        zzgp.zzm();
        zzgp.zzbi();
        zzgp.zzab().zzgr().zzao("Resetting analytics data (FE)");
        zzgp.zzv().zziz();
        if (zzgp.zzad().zzr(zzgp.zzr().zzag())) {
            zzgp.zzac().zzlo.set(j);
        }
        boolean isEnabled = zzgp.zzj.isEnabled();
        if (!zzgp.zzad().zzbp()) {
            zzgp.zzac().zzf(!isEnabled);
        }
        zzgp.zzs().resetAnalyticsData();
        zzgp.zzpz = !isEnabled;
        this.zzpt.zzs().zza(new AtomicReference<>());
    }
}
