package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzgk;
import com.google.android.gms.measurement.internal.zzgn;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class zzz {
    private static volatile zzz zzab = null;
    private static Boolean zzah = null;
    /* access modifiers changed from: private */
    public static Boolean zzai = null;
    private static boolean zzaj = false;
    private static Boolean zzak = null;
    private static String zzal = "use_dynamite_api";
    private static String zzam = "allow_remote_dynamite";
    protected final Clock zzac;
    private final ExecutorService zzad;
    private final AppMeasurementSdk zzae;
    /* access modifiers changed from: private */
    public List<Pair<zzgn, zzd>> zzaf;
    private int zzag;
    /* access modifiers changed from: private */
    public boolean zzap;
    private String zzaq;
    /* access modifiers changed from: private */
    public zzk zzar;
    /* access modifiers changed from: private */
    public final String zzu;

    static class zza extends zzt {
        private final zzgk zzbs;

        zza(zzgk zzgk) {
            this.zzbs = zzgk;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            this.zzbs.interceptEvent(str, str2, bundle, j);
        }

        public final int id() {
            return System.identityHashCode(this.zzbs);
        }
    }

    abstract class zzb implements Runnable {
        final long timestamp;
        final long zzbt;
        private final boolean zzbu;

        zzb(zzz zzz) {
            this(true);
        }

        /* access modifiers changed from: 0000 */
        public abstract void zzf() throws RemoteException;

        /* access modifiers changed from: protected */
        public void zzk() {
        }

        zzb(boolean z) {
            this.timestamp = zzz.this.zzac.currentTimeMillis();
            this.zzbt = zzz.this.zzac.elapsedRealtime();
            this.zzbu = z;
        }

        public void run() {
            if (zzz.this.zzap) {
                zzk();
                return;
            }
            try {
                zzf();
            } catch (Exception e) {
                zzz.this.zza(e, false, this.zzbu);
                zzk();
            }
        }
    }

    class zzc implements ActivityLifecycleCallbacks {
        zzc() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzz.this.zza((zzb) new zzbd(this, activity, bundle));
        }

        public final void onActivityStarted(Activity activity) {
            zzz.this.zza((zzb) new zzbc(this, activity));
        }

        public final void onActivityResumed(Activity activity) {
            zzz.this.zza((zzb) new zzbf(this, activity));
        }

        public final void onActivityPaused(Activity activity) {
            zzz.this.zza((zzb) new zzbe(this, activity));
        }

        public final void onActivityStopped(Activity activity) {
            zzz.this.zza((zzb) new zzbh(this, activity));
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzl zzl = new zzl();
            zzz.this.zza((zzb) new zzbg(this, activity, zzl));
            Bundle zzb = zzl.zzb(50);
            if (zzb != null) {
                bundle.putAll(zzb);
            }
        }

        public final void onActivityDestroyed(Activity activity) {
            zzz.this.zza((zzb) new zzbi(this, activity));
        }
    }

    static class zzd extends zzt {
        private final zzgn zzbv;

        zzd(zzgn zzgn) {
            this.zzbv = zzgn;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            this.zzbv.onEvent(str, str2, bundle, j);
        }

        public final int id() {
            return System.identityHashCode(this.zzbv);
        }
    }

    public static zzz zza(@NonNull Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    public static zzz zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzab == null) {
            synchronized (zzz.class) {
                if (zzab == null) {
                    zzz zzz = new zzz(context, str, str2, str3, bundle);
                    zzab = zzz;
                }
            }
        }
        return zzab;
    }

    public final AppMeasurementSdk zzg() {
        return this.zzae;
    }

    private zzz(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zza(str2, str3)) {
            this.zzu = "FA";
        } else {
            this.zzu = str;
        }
        this.zzac = DefaultClock.getInstance();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.zzad = threadPoolExecutor;
        this.zzae = new AppMeasurementSdk(this);
        boolean z = false;
        if (!(!zzb(context) || zzh())) {
            this.zzaq = null;
            this.zzap = true;
            return;
        }
        if (!zza(str2, str3)) {
            this.zzaq = "fa";
            if (str2 == null || str3 == null) {
                boolean z2 = str2 == null;
                if (str3 == null) {
                    z = true;
                }
                boolean z3 = z2 ^ z;
            } else {
                this.zzap = true;
                return;
            }
        } else {
            this.zzaq = str2;
        }
        zzy zzy = new zzy(this, str2, str3, context, bundle);
        zza((zzb) zzy);
        Application application = (Application) context.getApplicationContext();
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new zzc());
        }
    }

    private static boolean zzb(Context context) {
        try {
            GoogleServices.initialize(context);
            if (GoogleServices.getGoogleAppId() != null) {
                return true;
            }
        } catch (IllegalStateException unused) {
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean zza(String str, String str2) {
        return (str2 == null || str == null || zzh()) ? false : true;
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        this.zzad.execute(zzb2);
    }

    /* access modifiers changed from: protected */
    public final zzk zza(Context context, boolean z) {
        VersionPolicy versionPolicy;
        if (z) {
            try {
                versionPolicy = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
            } catch (LoadingException e) {
                zza((Exception) e, true, false);
                return null;
            }
        } else {
            versionPolicy = DynamiteModule.PREFER_LOCAL;
        }
        return zzn.asInterface(DynamiteModule.load(context, versionPolicy, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
    }

    /* access modifiers changed from: private */
    public static int zzc(Context context) {
        return DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    public static int zzd(Context context) {
        return DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
    }

    /* access modifiers changed from: private */
    public final void zza(Exception exc, boolean z, boolean z2) {
        this.zzap |= z;
        if (!z && z2) {
            zza(5, "Error with data collection. Data lost.", (Object) exc, (Object) null, (Object) null);
        }
    }

    private static boolean zzh() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void zza(zzgk zzgk) {
        zza((zzb) new zzal(this, zzgk));
    }

    public final void zza(zzgn zzgn) {
        Preconditions.checkNotNull(zzgn);
        zza((zzb) new zzau(this, zzgn));
    }

    public final void zzb(zzgn zzgn) {
        Preconditions.checkNotNull(zzgn);
        zza((zzb) new zzaz(this, zzgn));
    }

    public final void logEvent(@NonNull String str, Bundle bundle) {
        zza(null, str, bundle, false, true, null);
    }

    public final void logEventInternal(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, null);
    }

    public final void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, bundle, true, false, Long.valueOf(j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zzay zzay = new zzay(this, l, str, str2, bundle, z, z2);
        zza((zzb) zzay);
    }

    public final void setUserProperty(String str, String str2) {
        zza((String) null, str, (Object) str2, false);
    }

    public final void setUserPropertyInternal(String str, String str2, Object obj) {
        zza(str, str2, obj, true);
    }

    private final void zza(String str, String str2, Object obj, boolean z) {
        zzbb zzbb = new zzbb(this, str, str2, obj, z);
        zza((zzb) zzbb);
    }

    public final void setConditionalUserProperty(Bundle bundle) {
        zza((zzb) new zzba(this, bundle));
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zza((zzb) new zzab(this, str, str2, bundle));
    }

    public final List<Bundle> getConditionalUserProperties(String str, String str2) {
        zzl zzl = new zzl();
        zza((zzb) new zzaa(this, str, str2, zzl));
        List<Bundle> list = (List) zzl.zza(zzl.zzb(5000), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void setUserId(String str) {
        zza((zzb) new zzad(this, str));
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        zza((zzb) new zzac(this, activity, str, str2));
    }

    public final void setMeasurementEnabled(boolean z) {
        zza((zzb) new zzaf(this, z));
    }

    public final void resetAnalyticsData() {
        zza((zzb) new zzae(this));
    }

    public final void setMinimumSessionDuration(long j) {
        zza((zzb) new zzah(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zza((zzb) new zzag(this, j));
    }

    public final void beginAdUnitExposure(String str) {
        zza((zzb) new zzaj(this, str));
    }

    public final void endAdUnitExposure(String str) {
        zza((zzb) new zzai(this, str));
    }

    public final String getGmpAppId() {
        zzl zzl = new zzl();
        zza((zzb) new zzak(this, zzl));
        return zzl.zza(500);
    }

    public final String zzi() {
        zzl zzl = new zzl();
        zza((zzb) new zzan(this, zzl));
        return zzl.zza(50);
    }

    public final long generateEventId() {
        zzl zzl = new zzl();
        zza((zzb) new zzam(this, zzl));
        Long l = (Long) zzl.zza(zzl.zzb(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zzac.currentTimeMillis()).nextLong();
        int i = this.zzag + 1;
        this.zzag = i;
        return nextLong + ((long) i);
    }

    public final String getCurrentScreenName() {
        zzl zzl = new zzl();
        zza((zzb) new zzap(this, zzl));
        return zzl.zza(500);
    }

    public final String getCurrentScreenClass() {
        zzl zzl = new zzl();
        zza((zzb) new zzao(this, zzl));
        return zzl.zza(500);
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zzl zzl = new zzl();
        zzar zzar2 = new zzar(this, str, str2, z, zzl);
        zza((zzb) zzar2);
        Bundle zzb2 = zzl.zzb(5000);
        if (zzb2 == null || zzb2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzb2.size());
        for (String str3 : zzb2.keySet()) {
            Object obj = zzb2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zzaq zzaq2 = new zzaq(this, false, 5, str, obj, null, null);
        zza((zzb) zzaq2);
    }

    public final Bundle zza(Bundle bundle, boolean z) {
        zzl zzl = new zzl();
        zza((zzb) new zzat(this, bundle, zzl));
        if (z) {
            return zzl.zzb(5000);
        }
        return null;
    }

    public final int getMaxUserProperties(String str) {
        zzl zzl = new zzl();
        zza((zzb) new zzas(this, str, zzl));
        Integer num = (Integer) zzl.zza(zzl.zzb(10000), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    @WorkerThread
    public final String getAppInstanceId() {
        zzl zzl = new zzl();
        zza((zzb) new zzav(this, zzl));
        return zzl.zza(120000);
    }

    public final String getAppIdOrigin() {
        return this.zzaq;
    }

    public final Object zzb(int i) {
        zzl zzl = new zzl();
        zza((zzb) new zzax(this, zzl, i));
        return zzl.zza(zzl.zzb(15000), Object.class);
    }

    public final void setDataCollectionEnabled(boolean z) {
        zza((zzb) new zzaw(this, z));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:19|20|21|23|24) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0056 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zze(android.content.Context r3) {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.zzz> r0 = com.google.android.gms.internal.measurement.zzz.class
            monitor-enter(r0)
            r1 = 0
            java.lang.Boolean r2 = zzah     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            if (r2 == 0) goto L_0x000e
            java.lang.Boolean r2 = zzai     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            if (r2 == 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            return
        L_0x000e:
            java.lang.String r2 = "app_measurement_internal_disable_startup_flags"
            boolean r2 = zza(r3, r2)     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            if (r2 == 0) goto L_0x0024
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            zzah = r3     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            zzai = r3     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            return
        L_0x0024:
            java.lang.String r2 = "com.google.android.gms.measurement.prefs"
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r2, r1)     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            java.lang.String r2 = zzal     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            boolean r2 = r3.getBoolean(r2, r1)     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            zzah = r2     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            java.lang.String r2 = zzam     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            boolean r2 = r3.getBoolean(r2, r1)     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            zzai = r2     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            java.lang.String r2 = zzal     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            r3.remove(r2)     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            java.lang.String r2 = zzam     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            r3.remove(r2)     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            r3.apply()     // Catch:{ ClassCastException | IllegalStateException | NullPointerException -> 0x0056 }
            goto L_0x0062
        L_0x0054:
            r3 = move-exception
            goto L_0x0064
        L_0x0056:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0054 }
            zzah = r3     // Catch:{ all -> 0x0054 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0054 }
            zzai = r3     // Catch:{ all -> 0x0054 }
        L_0x0062:
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            return
        L_0x0064:
            monitor-exit(r0)     // Catch:{ all -> 0x0054 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzz.zze(android.content.Context):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0059, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        zzak = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        zzaj = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006d, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x005b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzf(android.content.Context r8) {
        /*
            zze(r8)
            java.lang.Class<com.google.android.gms.internal.measurement.zzz> r8 = com.google.android.gms.internal.measurement.zzz.class
            monitor-enter(r8)
            boolean r0 = zzaj     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r8)     // Catch:{ all -> 0x006e }
            goto L_0x0060
        L_0x000c:
            r0 = 0
            r1 = 1
            java.lang.String r2 = "android.os.SystemProperties"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            java.lang.String r3 = "get"
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 0
            r5[r7] = r6     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r1] = r6     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r5)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            java.lang.String r4 = "measurement.dynamite.enabled"
            r3[r7] = r4     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            java.lang.String r4 = ""
            r3[r1] = r4     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            java.lang.Object r2 = r2.invoke(r0, r3)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            java.lang.String r3 = "true"
            boolean r3 = r3.equals(r2)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            if (r3 == 0) goto L_0x0045
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            zzak = r2     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            goto L_0x0056
        L_0x0045:
            java.lang.String r3 = "false"
            boolean r2 = r3.equals(r2)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            if (r2 == 0) goto L_0x0054
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r7)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            zzak = r2     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
            goto L_0x0056
        L_0x0054:
            zzak = r0     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x005b }
        L_0x0056:
            zzaj = r1     // Catch:{ all -> 0x006e }
            goto L_0x005f
        L_0x0059:
            r0 = move-exception
            goto L_0x006b
        L_0x005b:
            zzak = r0     // Catch:{ all -> 0x0059 }
            zzaj = r1     // Catch:{ all -> 0x006e }
        L_0x005f:
            monitor-exit(r8)     // Catch:{ all -> 0x006e }
        L_0x0060:
            java.lang.Boolean r8 = zzak
            if (r8 != 0) goto L_0x0066
            java.lang.Boolean r8 = zzah
        L_0x0066:
            boolean r8 = r8.booleanValue()
            return r8
        L_0x006b:
            zzaj = r1     // Catch:{ all -> 0x006e }
            throw r0     // Catch:{ all -> 0x006e }
        L_0x006e:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x006e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzz.zzf(android.content.Context):boolean");
    }

    private static boolean zza(Context context, @Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData != null) {
                    return applicationInfo.metaData.getBoolean(str);
                }
            }
        } catch (NameNotFoundException unused) {
        }
        return false;
    }
}
