package com.google.android.gms.internal.firebase-perf;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzat {
    @SuppressLint({"StaticFieldLeak"})
    private static final zzat zzbe = new zzat();
    private final ScheduledExecutorService zzbf;
    public final ConcurrentLinkedQueue<zzbo> zzbg;
    private final Runtime zzbh;
    @Nullable
    private ScheduledFuture zzbi;
    private long zzbj;

    private zzat() {
        this(Executors.newSingleThreadScheduledExecutor(), Runtime.getRuntime());
    }

    @VisibleForTesting
    private zzat(ScheduledExecutorService scheduledExecutorService, Runtime runtime) {
        this.zzbi = null;
        this.zzbj = -1;
        this.zzbf = scheduledExecutorService;
        this.zzbg = new ConcurrentLinkedQueue<>();
        this.zzbh = runtime;
    }

    public static zzat zzz() {
        return zzbe;
    }

    public final void zzb(long j) {
        if (j > 0) {
            if (this.zzbi != null) {
                if (this.zzbj != j) {
                    zzt();
                    zze(j);
                }
                return;
            }
            zze(j);
        }
    }

    public final void zzt() {
        ScheduledFuture scheduledFuture = this.zzbi;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.zzbi = null;
            this.zzbj = -1;
        }
    }

    public final void zzu() {
        zzaa();
    }

    private final synchronized void zze(long j) {
        this.zzbj = j;
        try {
            this.zzbi = this.zzbf.scheduleAtFixedRate(new zzas(this), 0, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            String str = "Unable to start collecting Memory Metrics: ";
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                str.concat(valueOf);
            } else {
                new String(str);
            }
        }
    }

    private final synchronized void zzaa() {
        try {
            this.zzbf.schedule(new zzav(this), 0, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            String str = "Unable to collect Memory Metric: ";
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                str.concat(valueOf);
            } else {
                new String(str);
            }
        }
    }

    private final zzbo zzab() {
        return (zzbo) zzbo.zzcy().zzr(TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis())).zze(zzah.zza(zzba.BYTES.zzp(this.zzbh.totalMemory() - this.zzbh.freeMemory()))).zzhi();
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Boolean zzac() throws Exception {
        return Boolean.valueOf(this.zzbg.add(zzab()));
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzad() {
        this.zzbg.add(zzab());
    }
}
