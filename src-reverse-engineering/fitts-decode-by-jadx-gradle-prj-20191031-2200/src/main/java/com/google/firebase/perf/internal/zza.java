package com.google.firebase.perf.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.FrameMetricsAggregator;
import com.google.android.gms.internal.firebase-perf.zzaw;
import com.google.android.gms.internal.firebase-perf.zzax;
import com.google.android.gms.internal.firebase-perf.zzaz;
import com.google.android.gms.internal.firebase-perf.zzbg;
import com.google.android.gms.internal.firebase-perf.zzbt;
import com.google.android.gms.internal.firebase-perf.zzda;
import com.google.android.gms.internal.firebase-perf.zzda.zzb;
import com.google.firebase.perf.metrics.Trace;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class zza implements ActivityLifecycleCallbacks {
    private static volatile zza zzbr;
    private boolean mRegistered = false;
    private zzc zzbs = null;
    private final zzax zzbt;
    private boolean zzbu = true;
    private final WeakHashMap<Activity, Boolean> zzbv = new WeakHashMap<>();
    private zzbg zzbw;
    private zzbg zzbx;
    private final Map<String, Long> zzby = new HashMap();
    private AtomicInteger zzbz = new AtomicInteger(0);
    private zzbt zzca = zzbt.BACKGROUND;
    private Set<WeakReference<C0000zza>> zzcb = new HashSet();
    private boolean zzcc = false;
    private FrameMetricsAggregator zzcd;
    private final WeakHashMap<Activity, Trace> zzce = new WeakHashMap<>();

    /* renamed from: com.google.firebase.perf.internal.zza$zza reason: collision with other inner class name */
    public interface C0000zza {
        void zza(zzbt zzbt);
    }

    public static zza zzaj() {
        if (zzbr != null) {
            return zzbr;
        }
        return zza((zzc) null, new zzax());
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    private static zza zza(zzc zzc, zzax zzax) {
        if (zzbr == null) {
            synchronized (zza.class) {
                if (zzbr == null) {
                    zzbr = new zza(null, zzax);
                }
            }
        }
        return zzbr;
    }

    private zza(zzc zzc, zzax zzax) {
        this.zzbt = zzax;
        this.zzcc = zzan();
        if (this.zzcc) {
            this.zzcd = new FrameMetricsAggregator();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzc(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.mRegistered     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0019 }
            boolean r0 = r2 instanceof android.app.Application     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0017
            android.app.Application r2 = (android.app.Application) r2     // Catch:{ all -> 0x0019 }
            r2.registerActivityLifecycleCallbacks(r1)     // Catch:{ all -> 0x0019 }
            r2 = 1
            r1.mRegistered = r2     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.zza.zzc(android.content.Context):void");
    }

    public final void zza(@NonNull String str, long j) {
        synchronized (this.zzby) {
            Long l = (Long) this.zzby.get(str);
            if (l == null) {
                this.zzby.put(str, Long.valueOf(1));
            } else {
                this.zzby.put(str, Long.valueOf(l.longValue() + 1));
            }
        }
    }

    public final void zzc(int i) {
        this.zzbz.addAndGet(1);
    }

    public synchronized void onActivityStarted(Activity activity) {
        if (zza(activity)) {
            this.zzcd.add(activity);
            zzam();
            Trace trace = new Trace(zzb(activity), this.zzbs, this.zzbt, this);
            trace.start();
            this.zzce.put(activity, trace);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityStopped(android.app.Activity r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = r10.zza(r11)     // Catch:{ all -> 0x00e8 }
            r1 = 0
            if (r0 == 0) goto L_0x00b5
            java.util.WeakHashMap<android.app.Activity, com.google.firebase.perf.metrics.Trace> r0 = r10.zzce     // Catch:{ all -> 0x00e8 }
            boolean r0 = r0.containsKey(r11)     // Catch:{ all -> 0x00e8 }
            if (r0 == 0) goto L_0x00b5
            java.util.WeakHashMap<android.app.Activity, com.google.firebase.perf.metrics.Trace> r0 = r10.zzce     // Catch:{ all -> 0x00e8 }
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x00e8 }
            com.google.firebase.perf.metrics.Trace r0 = (com.google.firebase.perf.metrics.Trace) r0     // Catch:{ all -> 0x00e8 }
            if (r0 == 0) goto L_0x00b5
            java.util.WeakHashMap<android.app.Activity, com.google.firebase.perf.metrics.Trace> r2 = r10.zzce     // Catch:{ all -> 0x00e8 }
            r2.remove(r11)     // Catch:{ all -> 0x00e8 }
            androidx.core.app.FrameMetricsAggregator r2 = r10.zzcd     // Catch:{ all -> 0x00e8 }
            android.util.SparseIntArray[] r2 = r2.remove(r11)     // Catch:{ all -> 0x00e8 }
            if (r2 == 0) goto L_0x004b
            r2 = r2[r1]     // Catch:{ all -> 0x00e8 }
            if (r2 == 0) goto L_0x004b
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x002f:
            int r7 = r2.size()     // Catch:{ all -> 0x00e8 }
            if (r3 >= r7) goto L_0x004e
            int r7 = r2.keyAt(r3)     // Catch:{ all -> 0x00e8 }
            int r8 = r2.valueAt(r3)     // Catch:{ all -> 0x00e8 }
            int r4 = r4 + r8
            r9 = 700(0x2bc, float:9.81E-43)
            if (r7 <= r9) goto L_0x0043
            int r6 = r6 + r8
        L_0x0043:
            r9 = 16
            if (r7 <= r9) goto L_0x0048
            int r5 = r5 + r8
        L_0x0048:
            int r3 = r3 + 1
            goto L_0x002f
        L_0x004b:
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x004e:
            if (r4 <= 0) goto L_0x005a
            com.google.android.gms.internal.firebase-perf.zzaw r2 = com.google.android.gms.internal.firebase-perf.zzaw.FRAMES_TOTAL     // Catch:{ all -> 0x00e8 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e8 }
            long r7 = (long) r4     // Catch:{ all -> 0x00e8 }
            r0.putMetric(r2, r7)     // Catch:{ all -> 0x00e8 }
        L_0x005a:
            if (r5 <= 0) goto L_0x0066
            com.google.android.gms.internal.firebase-perf.zzaw r2 = com.google.android.gms.internal.firebase-perf.zzaw.FRAMES_SLOW     // Catch:{ all -> 0x00e8 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e8 }
            long r7 = (long) r5     // Catch:{ all -> 0x00e8 }
            r0.putMetric(r2, r7)     // Catch:{ all -> 0x00e8 }
        L_0x0066:
            if (r6 <= 0) goto L_0x0072
            com.google.android.gms.internal.firebase-perf.zzaw r2 = com.google.android.gms.internal.firebase-perf.zzaw.FRAMES_FROZEN     // Catch:{ all -> 0x00e8 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00e8 }
            long r7 = (long) r6     // Catch:{ all -> 0x00e8 }
            r0.putMetric(r2, r7)     // Catch:{ all -> 0x00e8 }
        L_0x0072:
            android.content.Context r2 = r11.getApplicationContext()     // Catch:{ all -> 0x00e8 }
            boolean r2 = com.google.android.gms.internal.firebase-perf.zzbk.zzg(r2)     // Catch:{ all -> 0x00e8 }
            if (r2 == 0) goto L_0x00b2
            java.lang.String r2 = zzb(r11)     // Catch:{ all -> 0x00e8 }
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x00e8 }
            int r3 = r3.length()     // Catch:{ all -> 0x00e8 }
            int r3 = r3 + 81
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e8 }
            r7.<init>(r3)     // Catch:{ all -> 0x00e8 }
            java.lang.String r3 = "sendScreenTrace name:"
            r7.append(r3)     // Catch:{ all -> 0x00e8 }
            r7.append(r2)     // Catch:{ all -> 0x00e8 }
            java.lang.String r2 = " _fr_tot:"
            r7.append(r2)     // Catch:{ all -> 0x00e8 }
            r7.append(r4)     // Catch:{ all -> 0x00e8 }
            java.lang.String r2 = " _fr_slo:"
            r7.append(r2)     // Catch:{ all -> 0x00e8 }
            r7.append(r5)     // Catch:{ all -> 0x00e8 }
            java.lang.String r2 = " _fr_fzn:"
            r7.append(r2)     // Catch:{ all -> 0x00e8 }
            r7.append(r6)     // Catch:{ all -> 0x00e8 }
            r7.toString()     // Catch:{ all -> 0x00e8 }
        L_0x00b2:
            r0.stop()     // Catch:{ all -> 0x00e8 }
        L_0x00b5:
            java.util.WeakHashMap<android.app.Activity, java.lang.Boolean> r0 = r10.zzbv     // Catch:{ all -> 0x00e8 }
            boolean r0 = r0.containsKey(r11)     // Catch:{ all -> 0x00e8 }
            if (r0 == 0) goto L_0x00e6
            java.util.WeakHashMap<android.app.Activity, java.lang.Boolean> r0 = r10.zzbv     // Catch:{ all -> 0x00e8 }
            r0.remove(r11)     // Catch:{ all -> 0x00e8 }
            java.util.WeakHashMap<android.app.Activity, java.lang.Boolean> r11 = r10.zzbv     // Catch:{ all -> 0x00e8 }
            boolean r11 = r11.isEmpty()     // Catch:{ all -> 0x00e8 }
            if (r11 == 0) goto L_0x00e6
            com.google.android.gms.internal.firebase-perf.zzbg r11 = new com.google.android.gms.internal.firebase-perf.zzbg     // Catch:{ all -> 0x00e8 }
            r11.<init>()     // Catch:{ all -> 0x00e8 }
            r10.zzbw = r11     // Catch:{ all -> 0x00e8 }
            com.google.android.gms.internal.firebase-perf.zzbt r11 = com.google.android.gms.internal.firebase-perf.zzbt.BACKGROUND     // Catch:{ all -> 0x00e8 }
            r10.zzb(r11)     // Catch:{ all -> 0x00e8 }
            r10.zza(r1)     // Catch:{ all -> 0x00e8 }
            com.google.android.gms.internal.firebase-perf.zzaz r11 = com.google.android.gms.internal.firebase-perf.zzaz.FOREGROUND_TRACE_NAME     // Catch:{ all -> 0x00e8 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00e8 }
            com.google.android.gms.internal.firebase-perf.zzbg r0 = r10.zzbx     // Catch:{ all -> 0x00e8 }
            com.google.android.gms.internal.firebase-perf.zzbg r1 = r10.zzbw     // Catch:{ all -> 0x00e8 }
            r10.zza(r11, r0, r1)     // Catch:{ all -> 0x00e8 }
        L_0x00e6:
            monitor-exit(r10)
            return
        L_0x00e8:
            r11 = move-exception
            monitor-exit(r10)
            goto L_0x00ec
        L_0x00eb:
            throw r11
        L_0x00ec:
            goto L_0x00eb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.zza.onActivityStopped(android.app.Activity):void");
    }

    public synchronized void onActivityResumed(Activity activity) {
        if (this.zzbv.isEmpty()) {
            this.zzbx = new zzbg();
            this.zzbv.put(activity, Boolean.valueOf(true));
            if (this.zzbu) {
                zzb(zzbt.FOREGROUND);
                zza(true);
                this.zzbu = false;
                return;
            }
            zzb(zzbt.FOREGROUND);
            zza(true);
            zza(zzaz.BACKGROUND_TRACE_NAME.toString(), this.zzbw, this.zzbx);
            return;
        }
        this.zzbv.put(activity, Boolean.valueOf(true));
    }

    public final boolean zzak() {
        return this.zzbu;
    }

    public final zzbt zzal() {
        return this.zzca;
    }

    public final void zza(WeakReference<C0000zza> weakReference) {
        synchronized (this.zzcb) {
            this.zzcb.add(weakReference);
        }
    }

    public final void zzb(WeakReference<C0000zza> weakReference) {
        synchronized (this.zzcb) {
            this.zzcb.remove(weakReference);
        }
    }

    private final void zzb(zzbt zzbt2) {
        this.zzca = zzbt2;
        synchronized (this.zzcb) {
            Iterator it = this.zzcb.iterator();
            while (it.hasNext()) {
                C0000zza zza = (C0000zza) ((WeakReference) it.next()).get();
                if (zza != null) {
                    zza.zza(this.zzca);
                } else {
                    it.remove();
                }
            }
        }
    }

    private final void zza(String str, zzbg zzbg, zzbg zzbg2) {
        zzam();
        zzb zzb = zzda.zzfu().zzad(str).zzak(zzbg.zzcr()).zzal(zzbg.zza(zzbg2)).zzb(SessionManager.zzcf().zzcg().zzbp());
        int andSet = this.zzbz.getAndSet(0);
        synchronized (this.zzby) {
            zzb.zze(this.zzby);
            if (andSet != 0) {
                zzb.zzd(zzaw.TRACE_STARTED_NOT_STOPPED.toString(), (long) andSet);
            }
            this.zzby.clear();
        }
        zzc zzc = this.zzbs;
        if (zzc != null) {
            zzc.zza((zzda) zzb.zzhi(), zzbt.FOREGROUND_BACKGROUND);
        }
    }

    private final void zza(boolean z) {
        zzam();
        zzc zzc = this.zzbs;
        if (zzc != null) {
            zzc.zzb(z);
        }
    }

    private final void zzam() {
        if (this.zzbs == null) {
            this.zzbs = zzc.zzba();
        }
    }

    private final boolean zza(Activity activity) {
        return (!this.zzcc || activity.getWindow() == null || (activity.getWindow().getAttributes().flags & 16777216) == 0) ? false : true;
    }

    private static boolean zzan() {
        try {
            Class.forName("androidx.core.app.FrameMetricsAggregator");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static String zzb(Activity activity) {
        String valueOf = String.valueOf(activity.getClass().getSimpleName());
        String str = "_st_";
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }
}
