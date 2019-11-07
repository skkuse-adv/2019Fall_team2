package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import java.util.List;

public final class zzdy extends zzg {
    private String zzce;
    private String zzcg;
    private String zzcm;
    private String zzco;
    private long zzcr;
    private String zzcu;
    private List<String> zzcw;
    private int zzds;
    private int zzjr;
    private long zzjt;
    private long zzs;

    zzdy(zzfj zzfj, long j) {
        super(zzfj);
        this.zzs = j;
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0195 A[Catch:{ IllegalStateException -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0196 A[Catch:{ IllegalStateException -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x019f A[Catch:{ IllegalStateException -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01b2 A[Catch:{ IllegalStateException -> 0x01c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0242  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzbl() {
        /*
            r13 = this;
            android.content.Context r0 = r13.getContext()
            java.lang.String r0 = r0.getPackageName()
            android.content.Context r1 = r13.getContext()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String r2 = "Unknown"
            java.lang.String r3 = ""
            r4 = 0
            java.lang.String r5 = "unknown"
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != 0) goto L_0x002d
            com.google.android.gms.measurement.internal.zzef r7 = r13.zzab()
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzef.zzam(r0)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r7.zza(r9, r8)
            goto L_0x0088
        L_0x002d:
            java.lang.String r5 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x0032 }
            goto L_0x0043
        L_0x0032:
            com.google.android.gms.measurement.internal.zzef r7 = r13.zzab()
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzef.zzam(r0)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r7.zza(r9, r8)
        L_0x0043:
            if (r5 != 0) goto L_0x0048
            java.lang.String r5 = "manual_install"
            goto L_0x0051
        L_0x0048:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x0051
            r5 = r3
        L_0x0051:
            android.content.Context r7 = r13.getContext()     // Catch:{ NameNotFoundException -> 0x0076 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0076 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r4)     // Catch:{ NameNotFoundException -> 0x0076 }
            if (r7 == 0) goto L_0x0088
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0076 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0076 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0076 }
            if (r9 != 0) goto L_0x0070
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0076 }
            goto L_0x0071
        L_0x0070:
            r8 = r2
        L_0x0071:
            java.lang.String r2 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0077 }
            int r6 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0077 }
            goto L_0x0088
        L_0x0076:
            r8 = r2
        L_0x0077:
            com.google.android.gms.measurement.internal.zzef r7 = r13.zzab()
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzef.zzam(r0)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r7.zza(r10, r9, r8)
        L_0x0088:
            r13.zzce = r0
            r13.zzco = r5
            r13.zzcm = r2
            r13.zzjr = r6
            r5 = 0
            r13.zzjt = r5
            r13.zzae()
            android.content.Context r2 = r13.getContext()
            com.google.android.gms.common.api.Status r2 = com.google.android.gms.common.api.internal.GoogleServices.initialize(r2)
            r7 = 1
            if (r2 == 0) goto L_0x00aa
            boolean r8 = r2.isSuccess()
            if (r8 == 0) goto L_0x00aa
            r8 = 1
            goto L_0x00ab
        L_0x00aa:
            r8 = 0
        L_0x00ab:
            com.google.android.gms.measurement.internal.zzfj r9 = r13.zzj
            java.lang.String r9 = r9.zzhx()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            java.lang.String r10 = "am"
            if (r9 != 0) goto L_0x00c7
            com.google.android.gms.measurement.internal.zzfj r9 = r13.zzj
            java.lang.String r9 = r9.zzhy()
            boolean r9 = r10.equals(r9)
            if (r9 == 0) goto L_0x00c7
            r9 = 1
            goto L_0x00c8
        L_0x00c7:
            r9 = 0
        L_0x00c8:
            r8 = r8 | r9
            if (r8 != 0) goto L_0x00f4
            if (r2 != 0) goto L_0x00db
            com.google.android.gms.measurement.internal.zzef r2 = r13.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()
            java.lang.String r9 = "GoogleService failed to initialize (no status)"
            r2.zzao(r9)
            goto L_0x00f4
        L_0x00db:
            com.google.android.gms.measurement.internal.zzef r9 = r13.zzab()
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzgk()
            int r11 = r2.getStatusCode()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.String r2 = r2.getStatusMessage()
            java.lang.String r12 = "GoogleService failed to initialize, status"
            r9.zza(r12, r11, r2)
        L_0x00f4:
            if (r8 == 0) goto L_0x0161
            com.google.android.gms.measurement.internal.zzs r2 = r13.zzad()
            java.lang.Boolean r2 = r2.zzbq()
            com.google.android.gms.measurement.internal.zzs r8 = r13.zzad()
            boolean r8 = r8.zzbp()
            if (r8 == 0) goto L_0x011e
            com.google.android.gms.measurement.internal.zzfj r2 = r13.zzj
            boolean r2 = r2.zzhw()
            if (r2 == 0) goto L_0x0161
            com.google.android.gms.measurement.internal.zzef r2 = r13.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgq()
            java.lang.String r8 = "Collection disabled with firebase_analytics_collection_deactivated=1"
            r2.zzao(r8)
            goto L_0x0161
        L_0x011e:
            if (r2 == 0) goto L_0x013c
            boolean r8 = r2.booleanValue()
            if (r8 != 0) goto L_0x013c
            com.google.android.gms.measurement.internal.zzfj r2 = r13.zzj
            boolean r2 = r2.zzhw()
            if (r2 == 0) goto L_0x0161
            com.google.android.gms.measurement.internal.zzef r2 = r13.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgq()
            java.lang.String r8 = "Collection disabled with firebase_analytics_collection_enabled=0"
            r2.zzao(r8)
            goto L_0x0161
        L_0x013c:
            if (r2 != 0) goto L_0x0152
            boolean r2 = com.google.android.gms.common.api.internal.GoogleServices.isMeasurementExplicitlyDisabled()
            if (r2 == 0) goto L_0x0152
            com.google.android.gms.measurement.internal.zzef r2 = r13.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgq()
            java.lang.String r8 = "Collection disabled with google_app_measurement_enable=0"
            r2.zzao(r8)
            goto L_0x0161
        L_0x0152:
            com.google.android.gms.measurement.internal.zzef r2 = r13.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()
            java.lang.String r8 = "Collection enabled"
            r2.zzao(r8)
            r2 = 1
            goto L_0x0162
        L_0x0161:
            r2 = 0
        L_0x0162:
            r13.zzcg = r3
            r13.zzcu = r3
            r13.zzcr = r5
            r13.zzae()
            com.google.android.gms.measurement.internal.zzfj r5 = r13.zzj
            java.lang.String r5 = r5.zzhx()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x018b
            com.google.android.gms.measurement.internal.zzfj r5 = r13.zzj
            java.lang.String r5 = r5.zzhy()
            boolean r5 = r10.equals(r5)
            if (r5 == 0) goto L_0x018b
            com.google.android.gms.measurement.internal.zzfj r5 = r13.zzj
            java.lang.String r5 = r5.zzhx()
            r13.zzcu = r5
        L_0x018b:
            java.lang.String r5 = com.google.android.gms.common.api.internal.GoogleServices.getGoogleAppId()     // Catch:{ IllegalStateException -> 0x01c4 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ IllegalStateException -> 0x01c4 }
            if (r6 == 0) goto L_0x0196
            goto L_0x0197
        L_0x0196:
            r3 = r5
        L_0x0197:
            r13.zzcg = r3     // Catch:{ IllegalStateException -> 0x01c4 }
            boolean r3 = android.text.TextUtils.isEmpty(r5)     // Catch:{ IllegalStateException -> 0x01c4 }
            if (r3 != 0) goto L_0x01b0
            com.google.android.gms.common.internal.StringResourceValueReader r3 = new com.google.android.gms.common.internal.StringResourceValueReader     // Catch:{ IllegalStateException -> 0x01c4 }
            android.content.Context r5 = r13.getContext()     // Catch:{ IllegalStateException -> 0x01c4 }
            r3.<init>(r5)     // Catch:{ IllegalStateException -> 0x01c4 }
            java.lang.String r5 = "admob_app_id"
            java.lang.String r3 = r3.getString(r5)     // Catch:{ IllegalStateException -> 0x01c4 }
            r13.zzcu = r3     // Catch:{ IllegalStateException -> 0x01c4 }
        L_0x01b0:
            if (r2 == 0) goto L_0x01d6
            com.google.android.gms.measurement.internal.zzef r2 = r13.zzab()     // Catch:{ IllegalStateException -> 0x01c4 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()     // Catch:{ IllegalStateException -> 0x01c4 }
            java.lang.String r3 = "App package, google app id"
            java.lang.String r5 = r13.zzce     // Catch:{ IllegalStateException -> 0x01c4 }
            java.lang.String r6 = r13.zzcg     // Catch:{ IllegalStateException -> 0x01c4 }
            r2.zza(r3, r5, r6)     // Catch:{ IllegalStateException -> 0x01c4 }
            goto L_0x01d6
        L_0x01c4:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzef r3 = r13.zzab()
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzef.zzam(r0)
            java.lang.String r5 = "getGoogleAppId or isMeasurementEnabled failed with exception. appId"
            r3.zza(r5, r0, r2)
        L_0x01d6:
            r0 = 0
            r13.zzcw = r0
            com.google.android.gms.measurement.internal.zzs r0 = r13.zzad()
            java.lang.String r2 = r13.zzce
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzak.zzix
            boolean r0 = r0.zze(r2, r3)
            if (r0 == 0) goto L_0x022c
            r13.zzae()
            com.google.android.gms.measurement.internal.zzs r0 = r13.zzad()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.zzk(r2)
            if (r0 == 0) goto L_0x0228
            int r2 = r0.size()
            if (r2 != 0) goto L_0x020b
            com.google.android.gms.measurement.internal.zzef r2 = r13.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgn()
            java.lang.String r3 = "Safelisted event list cannot be empty. Ignoring"
            r2.zzao(r3)
        L_0x0209:
            r7 = 0
            goto L_0x0228
        L_0x020b:
            java.util.Iterator r2 = r0.iterator()
        L_0x020f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.measurement.internal.zzjs r5 = r13.zzz()
            java.lang.String r6 = "safelisted event"
            boolean r3 = r5.zzq(r6, r3)
            if (r3 != 0) goto L_0x020f
            goto L_0x0209
        L_0x0228:
            if (r7 == 0) goto L_0x022c
            r13.zzcw = r0
        L_0x022c:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 < r2) goto L_0x0242
            if (r1 == 0) goto L_0x023f
            android.content.Context r0 = r13.getContext()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r13.zzds = r0
            return
        L_0x023f:
            r13.zzds = r4
            return
        L_0x0242:
            r13.zzds = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzdy.zzbl():void");
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0107  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzn zzai(java.lang.String r35) {
        /*
            r34 = this;
            r0 = r34
            r34.zzo()
            r34.zzm()
            com.google.android.gms.measurement.internal.zzn r29 = new com.google.android.gms.measurement.internal.zzn
            java.lang.String r2 = r34.zzag()
            java.lang.String r3 = r34.getGmpAppId()
            r34.zzbi()
            java.lang.String r4 = r0.zzcm
            int r1 = r34.zzgf()
            long r5 = (long) r1
            r34.zzbi()
            java.lang.String r7 = r0.zzco
            com.google.android.gms.measurement.internal.zzs r1 = r34.zzad()
            long r8 = r1.zzao()
            r34.zzbi()
            r34.zzo()
            long r10 = r0.zzjt
            r12 = 0
            int r1 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x004f
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzjs r1 = r1.zzz()
            android.content.Context r10 = r34.getContext()
            android.content.Context r11 = r34.getContext()
            java.lang.String r11 = r11.getPackageName()
            long r10 = r1.zzc(r10, r11)
            r0.zzjt = r10
        L_0x004f:
            long r10 = r0.zzjt
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            boolean r13 = r1.isEnabled()
            com.google.android.gms.measurement.internal.zzeo r1 = r34.zzac()
            boolean r1 = r1.zzmc
            r12 = 1
            r14 = r1 ^ 1
            r34.zzo()
            r34.zzm()
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            boolean r1 = r1.isEnabled()
            if (r1 != 0) goto L_0x0071
            r16 = 0
            goto L_0x0077
        L_0x0071:
            java.lang.String r1 = r34.zzge()
            r16 = r1
        L_0x0077:
            r34.zzbi()
            r17 = r13
            long r12 = r0.zzcr
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            long r19 = r1.zzic()
            int r21 = r34.zzgg()
            com.google.android.gms.measurement.internal.zzs r1 = r34.zzad()
            java.lang.Boolean r1 = r1.zzbr()
            boolean r22 = r1.booleanValue()
            com.google.android.gms.measurement.internal.zzs r1 = r34.zzad()
            r1.zzm()
            java.lang.String r15 = "google_analytics_ssaid_collection_enabled"
            java.lang.Boolean r1 = r1.zzj(r15)
            if (r1 == 0) goto L_0x00ac
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x00aa
            goto L_0x00ac
        L_0x00aa:
            r1 = 0
            goto L_0x00ad
        L_0x00ac:
            r1 = 1
        L_0x00ad:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r24 = r1.booleanValue()
            com.google.android.gms.measurement.internal.zzeo r1 = r34.zzac()
            boolean r25 = r1.zzhi()
            java.lang.String r26 = r34.zzah()
            com.google.android.gms.measurement.internal.zzs r1 = r34.zzad()
            java.lang.String r15 = r34.zzag()
            r27 = r12
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzak.zzij
            boolean r1 = r1.zze(r15, r12)
            if (r1 == 0) goto L_0x00ec
            com.google.android.gms.measurement.internal.zzs r1 = r34.zzad()
            java.lang.String r12 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r1 = r1.zzj(r12)
            if (r1 == 0) goto L_0x00ec
            boolean r1 = r1.booleanValue()
            r12 = 1
            r1 = r1 ^ r12
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r30 = r1
            goto L_0x00ee
        L_0x00ec:
            r30 = 0
        L_0x00ee:
            long r12 = r0.zzs
            com.google.android.gms.measurement.internal.zzs r1 = r34.zzad()
            java.lang.String r15 = r34.zzag()
            r31 = r12
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzak.zzix
            boolean r1 = r1.zze(r15, r12)
            if (r1 == 0) goto L_0x0107
            java.util.List<java.lang.String> r1 = r0.zzcw
            r33 = r1
            goto L_0x0109
        L_0x0107:
            r33 = 0
        L_0x0109:
            r1 = r29
            r12 = r35
            r13 = r17
            r15 = r16
            r16 = r27
            r18 = r19
            r20 = r21
            r21 = r22
            r22 = r24
            r23 = r25
            r24 = r26
            r25 = r30
            r26 = r31
            r28 = r33
            r1.<init>(r2, r3, r4, r5, r7, r8, r10, r12, r13, r14, r15, r16, r18, r20, r21, r22, r23, r24, r25, r26, r28)
            return r29
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzdy.zzai(java.lang.String):com.google.android.gms.measurement.internal.zzn");
    }

    @WorkerThread
    private final String zzge() {
        try {
            Class loadClass = getContext().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (loadClass == null) {
                return null;
            }
            try {
                Object invoke = loadClass.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
                if (invoke == null) {
                    return null;
                }
                try {
                    return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception unused) {
                    zzab().zzgp().zzao("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                zzab().zzgo().zzao("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final String zzag() {
        zzbi();
        return this.zzce;
    }

    /* access modifiers changed from: 0000 */
    public final String getGmpAppId() {
        zzbi();
        return this.zzcg;
    }

    /* access modifiers changed from: 0000 */
    public final String zzah() {
        zzbi();
        return this.zzcu;
    }

    /* access modifiers changed from: 0000 */
    public final int zzgf() {
        zzbi();
        return this.zzjr;
    }

    /* access modifiers changed from: 0000 */
    public final int zzgg() {
        zzbi();
        return this.zzds;
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    public final List<String> zzbh() {
        return this.zzcw;
    }

    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    public final /* bridge */ /* synthetic */ zza zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzgp zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzdy zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzhv zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzhq zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzeb zzu() {
        return super.zzu();
    }

    public final /* bridge */ /* synthetic */ zziw zzv() {
        return super.zzv();
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
