package com.google.firebase.perf.metrics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase-perf.zzax;
import com.google.android.gms.internal.firebase-perf.zzbg;
import com.google.firebase.perf.internal.zzc;
import java.util.concurrent.TimeUnit;

public class AppStartTrace implements ActivityLifecycleCallbacks {
    private static final long zzfl = TimeUnit.MINUTES.toMicros(1);
    private static volatile AppStartTrace zzfm;
    private boolean mRegistered = false;
    private zzc zzbs = null;
    private Context zzfn;
    private boolean zzfq = false;
    /* access modifiers changed from: private */
    public zzbg zzfr = null;
    private zzbg zzfs = null;
    private zzbg zzft = null;
    /* access modifiers changed from: private */
    public boolean zzfu = false;

    public static class zza implements Runnable {
        private final AppStartTrace zzfw;

        public zza(AppStartTrace appStartTrace) {
            this.zzfw = appStartTrace;
        }

        public final void run() {
            if (this.zzfw.zzfr == null) {
                this.zzfw.zzfu = true;
            }
        }
    }

    @Keep
    public static void setLauncherActivityOnCreateTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnResumeTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnStartTime(String str) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public static AppStartTrace zzci() {
        if (zzfm != null) {
            return zzfm;
        }
        return zzb(null, new zzax());
    }

    private static AppStartTrace zzb(zzc zzc, zzax zzax) {
        if (zzfm == null) {
            synchronized (AppStartTrace.class) {
                if (zzfm == null) {
                    zzfm = new AppStartTrace(null, zzax);
                }
            }
        }
        return zzfm;
    }

    private AppStartTrace(@Nullable zzc zzc, @NonNull zzax zzax) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzc(@androidx.annotation.NonNull android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.mRegistered     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x001c }
            boolean r0 = r2 instanceof android.app.Application     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a
            r0 = r2
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ all -> 0x001c }
            r0.registerActivityLifecycleCallbacks(r1)     // Catch:{ all -> 0x001c }
            r0 = 1
            r1.mRegistered = r0     // Catch:{ all -> 0x001c }
            r1.zzfn = r2     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r1)
            return
        L_0x001c:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.zzc(android.content.Context):void");
    }

    private final synchronized void zzcj() {
        if (this.mRegistered) {
            ((Application) this.zzfn).unregisterActivityLifecycleCallbacks(this);
            this.mRegistered = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityCreated(android.app.Activity r4, android.os.Bundle r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.firebase.perf.internal.SessionManager r5 = com.google.firebase.perf.internal.SessionManager.zzcf()     // Catch:{ all -> 0x0036 }
            com.google.android.gms.internal.firebase-perf.zzbt r0 = com.google.android.gms.internal.firebase-perf.zzbt.FOREGROUND     // Catch:{ all -> 0x0036 }
            r5.zzc(r0)     // Catch:{ all -> 0x0036 }
            boolean r5 = r3.zzfu     // Catch:{ all -> 0x0036 }
            if (r5 != 0) goto L_0x0034
            com.google.android.gms.internal.firebase-perf.zzbg r5 = r3.zzfr     // Catch:{ all -> 0x0036 }
            if (r5 == 0) goto L_0x0013
            goto L_0x0034
        L_0x0013:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0036 }
            r5.<init>(r4)     // Catch:{ all -> 0x0036 }
            com.google.android.gms.internal.firebase-perf.zzbg r4 = new com.google.android.gms.internal.firebase-perf.zzbg     // Catch:{ all -> 0x0036 }
            r4.<init>()     // Catch:{ all -> 0x0036 }
            r3.zzfr = r4     // Catch:{ all -> 0x0036 }
            com.google.android.gms.internal.firebase-perf.zzbg r4 = com.google.firebase.perf.provider.FirebasePerfProvider.zzcq()     // Catch:{ all -> 0x0036 }
            com.google.android.gms.internal.firebase-perf.zzbg r5 = r3.zzfr     // Catch:{ all -> 0x0036 }
            long r4 = r4.zza(r5)     // Catch:{ all -> 0x0036 }
            long r0 = zzfl     // Catch:{ all -> 0x0036 }
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0032
            r4 = 1
            r3.zzfq = r4     // Catch:{ all -> 0x0036 }
        L_0x0032:
            monitor-exit(r3)
            return
        L_0x0034:
            monitor-exit(r3)
            return
        L_0x0036:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityStarted(android.app.Activity r1) {
        /*
            r0 = this;
            monitor-enter(r0)
            boolean r1 = r0.zzfu     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x0017
            com.google.android.gms.internal.firebase-perf.zzbg r1 = r0.zzfs     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x0017
            boolean r1 = r0.zzfq     // Catch:{ all -> 0x0019 }
            if (r1 == 0) goto L_0x000e
            goto L_0x0017
        L_0x000e:
            com.google.android.gms.internal.firebase-perf.zzbg r1 = new com.google.android.gms.internal.firebase-perf.zzbg     // Catch:{ all -> 0x0019 }
            r1.<init>()     // Catch:{ all -> 0x0019 }
            r0.zzfs = r1     // Catch:{ all -> 0x0019 }
            monitor-exit(r0)
            return
        L_0x0017:
            monitor-exit(r0)
            return
        L_0x0019:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityStarted(android.app.Activity):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0139, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x013b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityResumed(android.app.Activity r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.zzfu     // Catch:{ all -> 0x013c }
            if (r0 != 0) goto L_0x013a
            com.google.android.gms.internal.firebase-perf.zzbg r0 = r5.zzft     // Catch:{ all -> 0x013c }
            if (r0 != 0) goto L_0x013a
            boolean r0 = r5.zzfq     // Catch:{ all -> 0x013c }
            if (r0 == 0) goto L_0x000f
            goto L_0x013a
        L_0x000f:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x013c }
            r0.<init>(r6)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzbg r0 = new com.google.android.gms.internal.firebase-perf.zzbg     // Catch:{ all -> 0x013c }
            r0.<init>()     // Catch:{ all -> 0x013c }
            r5.zzft = r0     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzbg r0 = com.google.firebase.perf.provider.FirebasePerfProvider.zzcq()     // Catch:{ all -> 0x013c }
            java.lang.Class r6 = r6.getClass()     // Catch:{ all -> 0x013c }
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzbg r1 = r5.zzft     // Catch:{ all -> 0x013c }
            long r1 = r0.zza(r1)     // Catch:{ all -> 0x013c }
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x013c }
            int r3 = r3.length()     // Catch:{ all -> 0x013c }
            int r3 = r3 + 47
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x013c }
            r4.<init>(r3)     // Catch:{ all -> 0x013c }
            java.lang.String r3 = "onResume(): "
            r4.append(r3)     // Catch:{ all -> 0x013c }
            r4.append(r6)     // Catch:{ all -> 0x013c }
            java.lang.String r6 = ": "
            r4.append(r6)     // Catch:{ all -> 0x013c }
            r4.append(r1)     // Catch:{ all -> 0x013c }
            java.lang.String r6 = " microseconds"
            r4.append(r6)     // Catch:{ all -> 0x013c }
            r4.toString()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r6 = com.google.android.gms.internal.firebase-perf.zzda.zzfu()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzaz r1 = com.google.android.gms.internal.firebase-perf.zzaz.APP_START_TRACE_NAME     // Catch:{ all -> 0x013c }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r6 = r6.zzad(r1)     // Catch:{ all -> 0x013c }
            long r1 = r0.zzcr()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r6 = r6.zzak(r1)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzbg r1 = r5.zzft     // Catch:{ all -> 0x013c }
            long r1 = r0.zza(r1)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r6 = r6.zzal(r1)     // Catch:{ all -> 0x013c }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x013c }
            r2 = 3
            r1.<init>(r2)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r2 = com.google.android.gms.internal.firebase-perf.zzda.zzfu()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzaz r3 = com.google.android.gms.internal.firebase-perf.zzaz.ON_CREATE_TRACE_NAME     // Catch:{ all -> 0x013c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r2 = r2.zzad(r3)     // Catch:{ all -> 0x013c }
            long r3 = r0.zzcr()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r2 = r2.zzak(r3)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzbg r3 = r5.zzfr     // Catch:{ all -> 0x013c }
            long r3 = r0.zza(r3)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r0 = r2.zzal(r3)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzfx r0 = r0.zzhi()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzep r0 = (com.google.android.gms.internal.firebase-perf.zzep) r0     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda r0 = (com.google.android.gms.internal.firebase-perf.zzda) r0     // Catch:{ all -> 0x013c }
            r1.add(r0)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r0 = com.google.android.gms.internal.firebase-perf.zzda.zzfu()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzaz r2 = com.google.android.gms.internal.firebase-perf.zzaz.ON_START_TRACE_NAME     // Catch:{ all -> 0x013c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r2 = r0.zzad(r2)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzbg r3 = r5.zzfr     // Catch:{ all -> 0x013c }
            long r3 = r3.zzcr()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r2 = r2.zzak(r3)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzbg r3 = r5.zzfr     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzbg r4 = r5.zzfs     // Catch:{ all -> 0x013c }
            long r3 = r3.zza(r4)     // Catch:{ all -> 0x013c }
            r2.zzal(r3)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzfx r0 = r0.zzhi()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzep r0 = (com.google.android.gms.internal.firebase-perf.zzep) r0     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda r0 = (com.google.android.gms.internal.firebase-perf.zzda) r0     // Catch:{ all -> 0x013c }
            r1.add(r0)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r0 = com.google.android.gms.internal.firebase-perf.zzda.zzfu()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzaz r2 = com.google.android.gms.internal.firebase-perf.zzaz.ON_RESUME_TRACE_NAME     // Catch:{ all -> 0x013c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r2 = r0.zzad(r2)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzbg r3 = r5.zzfs     // Catch:{ all -> 0x013c }
            long r3 = r3.zzcr()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r2 = r2.zzak(r3)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzbg r3 = r5.zzfs     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzbg r4 = r5.zzft     // Catch:{ all -> 0x013c }
            long r3 = r3.zza(r4)     // Catch:{ all -> 0x013c }
            r2.zzal(r3)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzfx r0 = r0.zzhi()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzep r0 = (com.google.android.gms.internal.firebase-perf.zzep) r0     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda r0 = (com.google.android.gms.internal.firebase-perf.zzda) r0     // Catch:{ all -> 0x013c }
            r1.add(r0)     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda$zzb r0 = r6.zze(r1)     // Catch:{ all -> 0x013c }
            com.google.firebase.perf.internal.SessionManager r1 = com.google.firebase.perf.internal.SessionManager.zzcf()     // Catch:{ all -> 0x013c }
            com.google.firebase.perf.internal.zzq r1 = r1.zzcg()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzcr r1 = r1.zzbp()     // Catch:{ all -> 0x013c }
            r0.zzb(r1)     // Catch:{ all -> 0x013c }
            com.google.firebase.perf.internal.zzc r0 = r5.zzbs     // Catch:{ all -> 0x013c }
            if (r0 != 0) goto L_0x011e
            com.google.firebase.perf.internal.zzc r0 = com.google.firebase.perf.internal.zzc.zzba()     // Catch:{ all -> 0x013c }
            r5.zzbs = r0     // Catch:{ all -> 0x013c }
        L_0x011e:
            com.google.firebase.perf.internal.zzc r0 = r5.zzbs     // Catch:{ all -> 0x013c }
            if (r0 == 0) goto L_0x0131
            com.google.firebase.perf.internal.zzc r0 = r5.zzbs     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzfx r6 = r6.zzhi()     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzep r6 = (com.google.android.gms.internal.firebase-perf.zzep) r6     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzda r6 = (com.google.android.gms.internal.firebase-perf.zzda) r6     // Catch:{ all -> 0x013c }
            com.google.android.gms.internal.firebase-perf.zzbt r1 = com.google.android.gms.internal.firebase-perf.zzbt.FOREGROUND_BACKGROUND     // Catch:{ all -> 0x013c }
            r0.zza(r6, r1)     // Catch:{ all -> 0x013c }
        L_0x0131:
            boolean r6 = r5.mRegistered     // Catch:{ all -> 0x013c }
            if (r6 == 0) goto L_0x0138
            r5.zzcj()     // Catch:{ all -> 0x013c }
        L_0x0138:
            monitor-exit(r5)
            return
        L_0x013a:
            monitor-exit(r5)
            return
        L_0x013c:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityResumed(android.app.Activity):void");
    }

    public synchronized void onActivityStopped(Activity activity) {
    }
}
