package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public final class zzfc extends zzge {
    /* access modifiers changed from: private */
    public static final AtomicLong zznj = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */
    public zzfg zzna;
    /* access modifiers changed from: private */
    public zzfg zznb;
    private final PriorityBlockingQueue<zzfh<?>> zznc = new PriorityBlockingQueue<>();
    private final BlockingQueue<zzfh<?>> zznd = new LinkedBlockingQueue();
    private final UncaughtExceptionHandler zzne = new zzfe(this, "Thread death: Uncaught exception on worker thread");
    private final UncaughtExceptionHandler zznf = new zzfe(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */
    public final Object zzng = new Object();
    /* access modifiers changed from: private */
    public final Semaphore zznh = new Semaphore(2);
    /* access modifiers changed from: private */
    public volatile boolean zzni;

    zzfc(zzfj zzfj) {
        super(zzfj);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return false;
    }

    public final void zzo() {
        if (Thread.currentThread() != this.zzna) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final void zzn() {
        if (Thread.currentThread() != this.zznb) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final boolean zzhp() {
        return Thread.currentThread() == this.zzna;
    }

    public final <V> Future<V> zza(Callable<V> callable) throws IllegalStateException {
        zzbi();
        Preconditions.checkNotNull(callable);
        zzfh zzfh = new zzfh(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzna) {
            if (!this.zznc.isEmpty()) {
                zzab().zzgn().zzao("Callable skipped the worker queue.");
            }
            zzfh.run();
        } else {
            zza(zzfh);
        }
        return zzfh;
    }

    public final <V> Future<V> zzb(Callable<V> callable) throws IllegalStateException {
        zzbi();
        Preconditions.checkNotNull(callable);
        zzfh zzfh = new zzfh(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzna) {
            zzfh.run();
        } else {
            zza(zzfh);
        }
        return zzfh;
    }

    public final void zza(Runnable runnable) throws IllegalStateException {
        zzbi();
        Preconditions.checkNotNull(runnable);
        zza(new zzfh<>(this, runnable, false, "Task exception on worker thread"));
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:16|17|(1:19)(1:20)|21|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        r2 = zzab().zzgn();
        r3 = "Timed out waiting for ";
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r4.length() == 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        r3 = r3.concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r3 = new java.lang.String(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r2.zzao(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r2 = zzab().zzgn();
        r3 = "Interrupted waiting for ";
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (r4.length() != 0) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        r3 = r3.concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
        r3 = new java.lang.String(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        r2.zzao(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000e, code lost:
        r1 = r1.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r1 != null) goto L_0x0036;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0037 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T zza(java.util.concurrent.atomic.AtomicReference<T> r1, long r2, java.lang.String r4, java.lang.Runnable r5) {
        /*
            r0 = this;
            monitor-enter(r1)
            com.google.android.gms.measurement.internal.zzfc r2 = r0.zzaa()     // Catch:{ all -> 0x005c }
            r2.zza(r5)     // Catch:{ all -> 0x005c }
            r2 = 15000(0x3a98, double:7.411E-320)
            r1.wait(r2)     // Catch:{ InterruptedException -> 0x0037 }
            monitor-exit(r1)     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r1.get()
            if (r1 != 0) goto L_0x0036
            com.google.android.gms.measurement.internal.zzef r2 = r0.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgn()
            java.lang.String r3 = "Timed out waiting for "
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r5 = r4.length()
            if (r5 == 0) goto L_0x002d
            java.lang.String r3 = r3.concat(r4)
            goto L_0x0033
        L_0x002d:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r3)
            r3 = r4
        L_0x0033:
            r2.zzao(r3)
        L_0x0036:
            return r1
        L_0x0037:
            com.google.android.gms.measurement.internal.zzef r2 = r0.zzab()     // Catch:{ all -> 0x005c }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgn()     // Catch:{ all -> 0x005c }
            java.lang.String r3 = "Interrupted waiting for "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x005c }
            int r5 = r4.length()     // Catch:{ all -> 0x005c }
            if (r5 == 0) goto L_0x0050
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x005c }
            goto L_0x0056
        L_0x0050:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x005c }
            r4.<init>(r3)     // Catch:{ all -> 0x005c }
            r3 = r4
        L_0x0056:
            r2.zzao(r3)     // Catch:{ all -> 0x005c }
            r2 = 0
            monitor-exit(r1)     // Catch:{ all -> 0x005c }
            return r2
        L_0x005c:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x005c }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfc.zza(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    private final void zza(zzfh<?> zzfh) {
        synchronized (this.zzng) {
            this.zznc.add(zzfh);
            if (this.zzna == null) {
                this.zzna = new zzfg(this, "Measurement Worker", this.zznc);
                this.zzna.setUncaughtExceptionHandler(this.zzne);
                this.zzna.start();
            } else {
                this.zzna.zzhr();
            }
        }
    }

    public final void zzb(Runnable runnable) throws IllegalStateException {
        zzbi();
        Preconditions.checkNotNull(runnable);
        zzfh zzfh = new zzfh(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzng) {
            this.zznd.add(zzfh);
            if (this.zznb == null) {
                this.zznb = new zzfg(this, "Measurement Network", this.zznd);
                this.zznb.setUncaughtExceptionHandler(this.zznf);
                this.zznb.start();
            } else {
                this.zznb.zzhr();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    public final /* bridge */ /* synthetic */ zzeo zzac() {
        return super.zzac();
    }

    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }
}
