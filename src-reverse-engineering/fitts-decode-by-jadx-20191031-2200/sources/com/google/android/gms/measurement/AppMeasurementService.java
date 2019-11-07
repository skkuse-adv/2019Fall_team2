package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzit;
import com.google.android.gms.measurement.internal.zzix;

public final class AppMeasurementService extends Service implements zzix {
    private zzit<AppMeasurementService> zzm;

    private final zzit<AppMeasurementService> zze() {
        if (this.zzm == null) {
            this.zzm = new zzit<>(this);
        }
        return this.zzm;
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

    @MainThread
    public final int onStartCommand(Intent intent, int i, int i2) {
        return zze().onStartCommand(intent, i, i2);
    }

    @MainThread
    public final IBinder onBind(Intent intent) {
        return zze().onBind(intent);
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
        return stopSelfResult(i);
    }

    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void zza(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}
