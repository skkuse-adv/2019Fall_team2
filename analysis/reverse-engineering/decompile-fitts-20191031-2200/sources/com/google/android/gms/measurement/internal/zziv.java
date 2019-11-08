package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

final /* synthetic */ class zziv implements Runnable {
    private final zzit zzrw;
    private final zzef zzsc;
    private final JobParameters zzsd;

    zziv(zzit zzit, zzef zzef, JobParameters jobParameters) {
        this.zzrw = zzit;
        this.zzsc = zzef;
        this.zzsd = jobParameters;
    }

    public final void run() {
        this.zzrw.zza(this.zzsc, this.zzsd);
    }
}
