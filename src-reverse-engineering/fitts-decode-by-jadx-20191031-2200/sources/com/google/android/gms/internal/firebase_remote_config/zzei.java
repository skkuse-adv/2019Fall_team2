package com.google.android.gms.internal.firebase_remote_config;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class zzei {
    @GuardedBy("ConfigCacheClient.class")
    private static final Map<String, zzei> zzkg = new HashMap();
    private static final Executor zzkk = zzem.zzko;
    private final ExecutorService zzkh;
    private final zzex zzki;
    @GuardedBy("this")
    @Nullable
    private Task<zzen> zzkj = null;

    private zzei(ExecutorService executorService, zzex zzex) {
        this.zzkh = executorService;
        this.zzki = zzex;
    }

    public final Task<zzen> zzb(zzen zzen) {
        zzd(zzen);
        return zza(zzen, false);
    }

    @Nullable
    public final zzen zzco() {
        return zzb(5);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r6 = zzcp();
        r0 = java.util.concurrent.TimeUnit.SECONDS;
        r1 = new com.google.android.gms.internal.firebase_remote_config.zzeo(null);
        r6.addOnSuccessListener(zzkk, (com.google.android.gms.tasks.OnSuccessListener<? super TResult>) r1);
        r6.addOnFailureListener(zzkk, (com.google.android.gms.tasks.OnFailureListener) r1);
        r6.addOnCanceledListener(zzkk, (com.google.android.gms.tasks.OnCanceledListener) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r1.await(5, r0) == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r6.isSuccessful() == false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        return (com.google.android.gms.internal.firebase_remote_config.zzen) r6.getResult();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        throw new java.util.concurrent.ExecutionException(r6.getException());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        throw new java.util.concurrent.TimeoutException("Task await timed out.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        return null;
     */
    @androidx.annotation.VisibleForTesting
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.firebase_remote_config.zzen zzb(long r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.android.gms.tasks.Task<com.google.android.gms.internal.firebase_remote_config.zzen> r5 = r4.zzkj     // Catch:{ all -> 0x005b }
            if (r5 == 0) goto L_0x0017
            com.google.android.gms.tasks.Task<com.google.android.gms.internal.firebase_remote_config.zzen> r5 = r4.zzkj     // Catch:{ all -> 0x005b }
            boolean r5 = r5.isSuccessful()     // Catch:{ all -> 0x005b }
            if (r5 == 0) goto L_0x0017
            com.google.android.gms.tasks.Task<com.google.android.gms.internal.firebase_remote_config.zzen> r5 = r4.zzkj     // Catch:{ all -> 0x005b }
            java.lang.Object r5 = r5.getResult()     // Catch:{ all -> 0x005b }
            com.google.android.gms.internal.firebase_remote_config.zzen r5 = (com.google.android.gms.internal.firebase_remote_config.zzen) r5     // Catch:{ all -> 0x005b }
            monitor-exit(r4)     // Catch:{ all -> 0x005b }
            return r5
        L_0x0017:
            monitor-exit(r4)     // Catch:{ all -> 0x005b }
            r5 = 0
            com.google.android.gms.tasks.Task r6 = r4.zzcp()     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            com.google.android.gms.internal.firebase_remote_config.zzeo r1 = new com.google.android.gms.internal.firebase_remote_config.zzeo     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            r1.<init>()     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            java.util.concurrent.Executor r2 = zzkk     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            r6.addOnSuccessListener(r2, r1)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            java.util.concurrent.Executor r2 = zzkk     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            r6.addOnFailureListener(r2, r1)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            java.util.concurrent.Executor r2 = zzkk     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            r6.addOnCanceledListener(r2, r1)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            r2 = 5
            boolean r0 = r1.await(r2, r0)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            if (r0 == 0) goto L_0x0052
            boolean r0 = r6.isSuccessful()     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            if (r0 == 0) goto L_0x0048
            java.lang.Object r6 = r6.getResult()     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            com.google.android.gms.internal.firebase_remote_config.zzen r6 = (com.google.android.gms.internal.firebase_remote_config.zzen) r6     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            return r6
        L_0x0048:
            java.util.concurrent.ExecutionException r0 = new java.util.concurrent.ExecutionException     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            java.lang.Exception r6 = r6.getException()     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            r0.<init>(r6)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            throw r0     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
        L_0x0052:
            java.util.concurrent.TimeoutException r6 = new java.util.concurrent.TimeoutException     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            java.lang.String r0 = "Task await timed out."
            r6.<init>(r0)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
            throw r6     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005a }
        L_0x005a:
            return r5
        L_0x005b:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x005b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzei.zzb(long):com.google.android.gms.internal.firebase_remote_config.zzen");
    }

    public final Task<zzen> zzc(zzen zzen) {
        return zza(zzen, true);
    }

    public final Task<zzen> zza(zzen zzen, boolean z) {
        return Tasks.call(this.zzkh, new zzeh(this, zzen)).onSuccessTask(this.zzkh, new zzek(this, z, zzen));
    }

    public final synchronized Task<zzen> zzcp() {
        if (this.zzkj == null || (this.zzkj.isComplete() && !this.zzkj.isSuccessful())) {
            ExecutorService executorService = this.zzkh;
            zzex zzex = this.zzki;
            zzex.getClass();
            this.zzkj = Tasks.call(executorService, zzej.zza(zzex));
        }
        return this.zzkj;
    }

    public final void clear() {
        synchronized (this) {
            this.zzkj = Tasks.forResult(null);
        }
        this.zzki.zzdc();
    }

    private final synchronized void zzd(zzen zzen) {
        this.zzkj = Tasks.forResult(zzen);
    }

    public static synchronized zzei zza(ExecutorService executorService, zzex zzex) {
        zzei zzei;
        synchronized (zzei.class) {
            String fileName = zzex.getFileName();
            if (!zzkg.containsKey(fileName)) {
                zzkg.put(fileName, new zzei(executorService, zzex));
            }
            zzei = (zzei) zzkg.get(fileName);
        }
        return zzei;
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Task zza(boolean z, zzen zzen, Void voidR) throws Exception {
        if (z) {
            zzd(zzen);
        }
        return Tasks.forResult(zzen);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ Void zze(zzen zzen) throws Exception {
        return this.zzki.zzh(zzen);
    }
}
