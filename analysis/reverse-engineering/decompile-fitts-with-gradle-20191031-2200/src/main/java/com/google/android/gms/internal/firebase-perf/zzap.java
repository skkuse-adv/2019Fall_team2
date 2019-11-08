package com.google.android.gms.internal.firebase-perf;

import android.os.Build.VERSION;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.Nullable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzap {
    private static final long zzau = TimeUnit.SECONDS.toMicros(1);
    @Nullable
    private static zzap zzav = null;
    @Nullable
    private ScheduledFuture zzaw = null;
    private final ScheduledExecutorService zzax;
    private long zzay;
    private final long zzaz;
    private final String zzba;
    public final ConcurrentLinkedQueue<zzbu> zzbb;

    private zzap() {
        long j = -1;
        this.zzay = -1;
        this.zzbb = new ConcurrentLinkedQueue<>();
        this.zzax = Executors.newSingleThreadScheduledExecutor();
        String num = Integer.toString(Process.myPid());
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 11);
        sb.append("/proc/");
        sb.append(num);
        sb.append("/stat");
        this.zzba = sb.toString();
        if (VERSION.SDK_INT >= 21) {
            j = Os.sysconf(OsConstants._SC_CLK_TCK);
        }
        this.zzaz = j;
    }

    public static zzap zzs() {
        if (zzav == null) {
            zzav = new zzap();
        }
        return zzav;
    }

    public final void zzb(long j) {
        long j2 = this.zzaz;
        if (j2 != -1 && j2 != 0 && j > 0) {
            if (this.zzaw != null) {
                if (this.zzay != j) {
                    zzt();
                    zzc(j);
                }
                return;
            }
            zzc(j);
        }
    }

    public final void zzt() {
        ScheduledFuture scheduledFuture = this.zzaw;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.zzaw = null;
            this.zzay = -1;
        }
    }

    public final void zzu() {
        zzv();
    }

    private final synchronized void zzc(long j) {
        this.zzay = j;
        try {
            this.zzaw = this.zzax.scheduleAtFixedRate(new zzar(this), 0, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            String str = "Unable to start collecting Cpu Metrics: ";
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                str.concat(valueOf);
            } else {
                new String(str);
            }
        }
    }

    private final synchronized void zzv() {
        try {
            this.zzax.schedule(new zzaq(this), 0, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            String str = "Unable to collect Cpu Metric: ";
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                str.concat(valueOf);
            } else {
                new String(str);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0068, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0071, code lost:
        throw r2;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.firebase-perf.zzbu zzw() {
        /*
            r12 = this;
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
            java.lang.String r2 = r12.zzba     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0066 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0066 }
            long r1 = r1.toMicros(r2)     // Catch:{ all -> 0x0066 }
            java.lang.String r3 = r0.readLine()     // Catch:{ all -> 0x0066 }
            java.lang.String r4 = " "
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ all -> 0x0066 }
            r4 = 13
            r4 = r3[r4]     // Catch:{ all -> 0x0066 }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ all -> 0x0066 }
            r6 = 15
            r6 = r3[r6]     // Catch:{ all -> 0x0066 }
            long r6 = java.lang.Long.parseLong(r6)     // Catch:{ all -> 0x0066 }
            r8 = 14
            r8 = r3[r8]     // Catch:{ all -> 0x0066 }
            long r8 = java.lang.Long.parseLong(r8)     // Catch:{ all -> 0x0066 }
            r10 = 16
            r3 = r3[r10]     // Catch:{ all -> 0x0066 }
            long r10 = java.lang.Long.parseLong(r3)     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.firebase-perf.zzbu$zza r3 = com.google.android.gms.internal.firebase-perf.zzbu.zzdl()     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.firebase-perf.zzbu$zza r1 = r3.zzu(r1)     // Catch:{ all -> 0x0066 }
            long r8 = r8 + r10
            long r2 = r12.zzd(r8)     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.firebase-perf.zzbu$zza r1 = r1.zzw(r2)     // Catch:{ all -> 0x0066 }
            long r4 = r4 + r6
            long r2 = r12.zzd(r4)     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.firebase-perf.zzbu$zza r1 = r1.zzv(r2)     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.firebase-perf.zzfx r1 = r1.zzhi()     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.firebase-perf.zzep r1 = (com.google.android.gms.internal.firebase-perf.zzep) r1     // Catch:{ all -> 0x0066 }
            com.google.android.gms.internal.firebase-perf.zzbu r1 = (com.google.android.gms.internal.firebase-perf.zzbu) r1     // Catch:{ all -> 0x0066 }
            r0.close()     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
            return r1
        L_0x0066:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r0 = move-exception
            com.google.android.gms.internal.firebase-perf.zzak.zza(r1, r0)     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
        L_0x0071:
            throw r2     // Catch:{ IOException -> 0x0091, ArrayIndexOutOfBoundsException -> 0x0076, NumberFormatException -> 0x0074, NullPointerException -> 0x0072 }
        L_0x0072:
            r0 = move-exception
            goto L_0x0077
        L_0x0074:
            r0 = move-exception
            goto L_0x0077
        L_0x0076:
            r0 = move-exception
        L_0x0077:
            java.lang.String r1 = "Unexpected '/proc/[pid]/stat' file format encountered: "
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r2 = r0.length()
            if (r2 == 0) goto L_0x008b
            r1.concat(r0)
            goto L_0x00ab
        L_0x008b:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
            goto L_0x00ab
        L_0x0091:
            r0 = move-exception
            java.lang.String r1 = "Unable to read 'proc/[pid]/stat' file: "
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r2 = r0.length()
            if (r2 == 0) goto L_0x00a6
            r1.concat(r0)
            goto L_0x00ab
        L_0x00a6:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-perf.zzap.zzw():com.google.android.gms.internal.firebase-perf.zzbu");
    }

    private final long zzd(long j) {
        double d = (double) j;
        double d2 = (double) this.zzaz;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        double d4 = (double) zzau;
        Double.isNaN(d4);
        return Math.round(d3 * d4);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzx() {
        zzbu zzw = zzw();
        if (zzw != null) {
            this.zzbb.add(zzw);
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ void zzy() {
        zzbu zzw = zzw();
        if (zzw != null) {
            this.zzbb.add(zzw);
        }
    }
}
