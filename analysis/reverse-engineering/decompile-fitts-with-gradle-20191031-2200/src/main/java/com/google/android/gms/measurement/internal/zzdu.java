package com.google.android.gms.measurement.internal;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class zzdu<V> {
    private static final Object zzjo = new Object();
    private final String zzjj;
    private final zzdv<V> zzjk;
    private final V zzjl;
    private final Object zzjn;
    @GuardedBy("overrideLock")
    private volatile V zzjp;
    @GuardedBy("cachingLock")
    private volatile V zzjq;

    private zzdu(@NonNull String str, @NonNull V v, @NonNull V v2, @Nullable zzdv<V> zzdv) {
        this.zzjn = new Object();
        this.zzjp = null;
        this.zzjq = null;
        this.zzjj = str;
        this.zzjl = v;
        this.zzjk = zzdv;
    }

    public final String getKey() {
        return this.zzjj;
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 173 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0021, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(@androidx.annotation.Nullable V r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zzjn
            monitor-enter(r0)
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            if (r5 == 0) goto L_0x0007
            return r5
        L_0x0007:
            com.google.android.gms.measurement.internal.zzr r5 = com.google.android.gms.measurement.internal.zzak.zzfv
            if (r5 != 0) goto L_0x000e
            V r5 = r4.zzjl
            return r5
        L_0x000e:
            java.lang.Object r5 = zzjo
            monitor-enter(r5)
            boolean r0 = com.google.android.gms.measurement.internal.zzr.isMainThread()     // Catch:{ all -> 0x0086 }
            if (r0 == 0) goto L_0x0022
            V r0 = r4.zzjq     // Catch:{ all -> 0x0086 }
            if (r0 != 0) goto L_0x001e
            V r0 = r4.zzjl     // Catch:{ all -> 0x0086 }
            goto L_0x0020
        L_0x001e:
            V r0 = r4.zzjq     // Catch:{ all -> 0x0086 }
        L_0x0020:
            monitor-exit(r5)     // Catch:{ all -> 0x0086 }
            return r0
        L_0x0022:
            boolean r0 = com.google.android.gms.measurement.internal.zzr.isMainThread()     // Catch:{ all -> 0x0086 }
            if (r0 != 0) goto L_0x007e
            com.google.android.gms.measurement.internal.zzr r0 = com.google.android.gms.measurement.internal.zzak.zzfv     // Catch:{ all -> 0x0086 }
            java.util.List r0 = com.google.android.gms.measurement.internal.zzak.zzfw     // Catch:{ SecurityException -> 0x0062 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ SecurityException -> 0x0062 }
        L_0x0032:
            boolean r1 = r0.hasNext()     // Catch:{ SecurityException -> 0x0062 }
            if (r1 == 0) goto L_0x0066
            java.lang.Object r1 = r0.next()     // Catch:{ SecurityException -> 0x0062 }
            com.google.android.gms.measurement.internal.zzdu r1 = (com.google.android.gms.measurement.internal.zzdu) r1     // Catch:{ SecurityException -> 0x0062 }
            java.lang.Object r2 = zzjo     // Catch:{ SecurityException -> 0x0062 }
            monitor-enter(r2)     // Catch:{ SecurityException -> 0x0062 }
            boolean r3 = com.google.android.gms.measurement.internal.zzr.isMainThread()     // Catch:{ all -> 0x005f }
            if (r3 != 0) goto L_0x0057
            com.google.android.gms.measurement.internal.zzdv<V> r3 = r1.zzjk     // Catch:{ all -> 0x005f }
            if (r3 == 0) goto L_0x0052
            com.google.android.gms.measurement.internal.zzdv<V> r3 = r1.zzjk     // Catch:{ all -> 0x005f }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x005f }
            goto L_0x0053
        L_0x0052:
            r3 = 0
        L_0x0053:
            r1.zzjq = r3     // Catch:{ all -> 0x005f }
            monitor-exit(r2)     // Catch:{ all -> 0x005f }
            goto L_0x0032
        L_0x0057:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005f }
            java.lang.String r1 = "Refreshing flag cache must be done on a worker thread."
            r0.<init>(r1)     // Catch:{ all -> 0x005f }
            throw r0     // Catch:{ all -> 0x005f }
        L_0x005f:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x005f }
            throw r0     // Catch:{ SecurityException -> 0x0062 }
        L_0x0062:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzak.zza(r0)     // Catch:{ all -> 0x0086 }
        L_0x0066:
            monitor-exit(r5)     // Catch:{ all -> 0x0086 }
            com.google.android.gms.measurement.internal.zzdv<V> r5 = r4.zzjk
            if (r5 != 0) goto L_0x0070
            com.google.android.gms.measurement.internal.zzr r5 = com.google.android.gms.measurement.internal.zzak.zzfv
            V r5 = r4.zzjl
            return r5
        L_0x0070:
            java.lang.Object r5 = r5.get()     // Catch:{ SecurityException -> 0x0075 }
            return r5
        L_0x0075:
            r5 = move-exception
            com.google.android.gms.measurement.internal.zzak.zza(r5)
            com.google.android.gms.measurement.internal.zzr r5 = com.google.android.gms.measurement.internal.zzak.zzfv
            V r5 = r4.zzjl
            return r5
        L_0x007e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0086 }
            java.lang.String r1 = "Tried to refresh flag cache on main thread or on package side."
            r0.<init>(r1)     // Catch:{ all -> 0x0086 }
            throw r0     // Catch:{ all -> 0x0086 }
        L_0x0086:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0086 }
            throw r0
        L_0x0089:
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            throw r5
        L_0x008b:
            r5 = move-exception
            goto L_0x0089
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzdu.get(java.lang.Object):java.lang.Object");
    }
}
