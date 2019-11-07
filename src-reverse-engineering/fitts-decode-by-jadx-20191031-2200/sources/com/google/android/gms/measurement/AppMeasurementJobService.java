package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.google.android.gms.measurement.internal.zzit;
import com.google.android.gms.measurement.internal.zzix;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzix {
    private zzit<AppMeasurementJobService> zzm;

    private final zzit<AppMeasurementJobService> zze() {
        if (this.zzm == null) {
            this.zzm = new zzit<>(this);
        }
        return this.zzm;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public final void zza(Intent intent) {
    }

    @MainThread
    public final void onCreate() {
        super.onCreate();
        zze().onCreate();
    }

    @MainThread
    public final void onDestroy() {
        zze().onDestroy();
        super.onDestroy();
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        return zze().onStartJob(jobParameters);
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        return zze().onUnbind(intent);
    }

    @MainThread
    public final void onRebind(Intent intent) {
        zze().onRebind(intent);
    }

    public final boolean zza(int i) {
        throw new UnsupportedOperationException();
    }

    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
