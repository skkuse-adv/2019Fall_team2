package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;

public final class zzgp extends zzg {
    protected zzhj zzpu;
    private zzgk zzpv;
    private final Set<zzgn> zzpw = new CopyOnWriteArraySet();
    private boolean zzpx;
    private final AtomicReference<String> zzpy = new AtomicReference<>();
    protected boolean zzpz = true;

    protected zzgp(zzfj zzfj) {
        super(zzfj);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return false;
    }

    public final void zzif() {
        if (getContext().getApplicationContext() instanceof Application) {
            ((Application) getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzpu);
        }
    }

    public final Boolean zzig() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzaa().zza(atomicReference, 15000, "boolean test flag value", new zzgo(this, atomicReference));
    }

    public final String zzih() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzaa().zza(atomicReference, 15000, "String test flag value", new zzgy(this, atomicReference));
    }

    public final Long zzii() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzaa().zza(atomicReference, 15000, "long test flag value", new zzha(this, atomicReference));
    }

    public final Integer zzij() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzaa().zza(atomicReference, 15000, "int test flag value", new zzhd(this, atomicReference));
    }

    public final Double zzik() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzaa().zza(atomicReference, 15000, "double test flag value", new zzhc(this, atomicReference));
    }

    public final void setMeasurementEnabled(boolean z) {
        zzbi();
        zzm();
        zzaa().zza((Runnable) new zzhf(this, z));
    }

    public final void zza(boolean z) {
        zzbi();
        zzm();
        zzaa().zza((Runnable) new zzhe(this, z));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzg(boolean z) {
        zzo();
        zzm();
        zzbi();
        zzab().zzgr().zza("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzac().setMeasurementEnabled(z);
        zzil();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzil() {
        if (zzad().zze(zzr().zzag(), zzak.zzik)) {
            zzo();
            String zzho = zzac().zzlx.zzho();
            if (zzho != null) {
                if ("unset".equals(zzho)) {
                    zza(SettingsJsonConstants.APP_KEY, "_npa", (Object) null, zzx().currentTimeMillis());
                } else {
                    zza(SettingsJsonConstants.APP_KEY, "_npa", (Object) Long.valueOf(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(zzho) ? 1 : 0), zzx().currentTimeMillis());
                }
            }
        }
        if (!this.zzj.isEnabled() || !this.zzpz) {
            zzab().zzgr().zzao("Updating Scion state (FE)");
            zzs().zzip();
            return;
        }
        zzab().zzgr().zzao("Recording app launch after enabling measurement for the first time (FE)");
        zzim();
    }

    public final void setMinimumSessionDuration(long j) {
        zzm();
        zzaa().zza((Runnable) new zzhh(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzm();
        zzaa().zza((Runnable) new zzhg(this, j));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        logEvent(str, str2, bundle, false, true, zzx().currentTimeMillis());
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        logEvent(str, str2, bundle, true, true, zzx().currentTimeMillis());
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zza(String str, String str2, Bundle bundle) {
        zzm();
        zzo();
        zza(str, str2, zzx().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzm();
        zzo();
        zza(str, str2, j, bundle, true, this.zzpv == null || zzjs.zzbq(str2), false, null);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        zzhr zzhr;
        int i;
        int i2;
        ArrayList arrayList;
        long j2;
        Bundle bundle2;
        Class cls;
        String str9 = str;
        String str10 = str2;
        long j3 = j;
        Bundle bundle3 = bundle;
        String str11 = str3;
        Preconditions.checkNotEmpty(str);
        if (!zzad().zze(str11, zzak.zzip)) {
            Preconditions.checkNotEmpty(str2);
        }
        Preconditions.checkNotNull(bundle);
        zzo();
        zzbi();
        if (!this.zzj.isEnabled()) {
            zzab().zzgr().zzao("Event not sent since app measurement is disabled");
            return;
        }
        if (zzad().zze(zzr().zzag(), zzak.zzix)) {
            List zzbh = zzr().zzbh();
            if (zzbh != null && !zzbh.contains(str10)) {
                zzab().zzgr().zza("Dropping non-safelisted event. event name, origin", str10, str9);
                return;
            }
        }
        int i3 = 0;
        if (!this.zzpx) {
            this.zzpx = true;
            try {
                String str12 = "com.google.android.gms.tagmanager.TagManagerService";
                if (!this.zzj.zzia()) {
                    cls = Class.forName(str12, true, getContext().getClassLoader());
                } else {
                    cls = Class.forName(str12);
                }
                try {
                    cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
                } catch (Exception e) {
                    zzab().zzgn().zza("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                zzab().zzgq().zzao("Tag Manager is not found and thus will not be used");
            }
        }
        if (zzad().zze(zzr().zzag(), zzak.zzje) && "_cmp".equals(str10)) {
            String str13 = "gclid";
            if (bundle3.containsKey(str13)) {
                zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lgclid", (Object) bundle3.getString(str13), zzx().currentTimeMillis());
            }
        }
        if (z3) {
            zzae();
            if (!"_iap".equals(str10)) {
                zzjs zzz = this.zzj.zzz();
                String str14 = NotificationCompat.CATEGORY_EVENT;
                int i4 = 2;
                if (zzz.zzp(str14, str10)) {
                    if (!zzz.zza(str14, zzgj.zzpn, str10)) {
                        i4 = 13;
                    } else if (zzz.zza(str14, 40, str10)) {
                        i4 = 0;
                    }
                }
                if (i4 != 0) {
                    zzab().zzgm().zza("Invalid public event name. Event will not be logged (FE)", zzy().zzaj(str10));
                    this.zzj.zzz();
                    this.zzj.zzz().zza(i4, "_ev", zzjs.zza(str10, 40, true), str10 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        zzae();
        zzhr zzin = zzt().zzin();
        String str15 = "_sc";
        if (zzin != null && !bundle3.containsKey(str15)) {
            zzin.zzqx = true;
        }
        zzhq.zza(zzin, bundle3, z && z3);
        boolean equals = "am".equals(str9);
        boolean zzbq = zzjs.zzbq(str2);
        if (z && this.zzpv != null && !zzbq && !equals) {
            zzab().zzgr().zza("Passing event to registered event handler (FE)", zzy().zzaj(str10), zzy().zzc(bundle3));
            this.zzpv.interceptEvent(str, str2, bundle, j);
        } else if (this.zzj.zzie()) {
            int zzbl = zzz().zzbl(str10);
            if (zzbl != 0) {
                zzab().zzgm().zza("Invalid event name. Event will not be logged (FE)", zzy().zzaj(str10));
                zzz();
                String zza = zzjs.zza(str10, 40, true);
                if (str10 != null) {
                    i3 = str2.length();
                }
                this.zzj.zzz().zza(str3, zzbl, "_ev", zza, i3);
                return;
            }
            String str16 = "_sn";
            String str17 = "_o";
            String str18 = "_si";
            List listOf = CollectionUtils.listOf((T[]) new String[]{str17, str16, str15, str18});
            String str19 = str11;
            String str20 = str10;
            Bundle zza2 = zzz().zza(str3, str2, bundle, listOf, z3, true);
            zzhr zzhr2 = (zza2 == null || !zza2.containsKey(str15) || !zza2.containsKey(str18)) ? null : new zzhr(zza2.getString(str16), zza2.getString(str15), Long.valueOf(zza2.getLong(str18)).longValue());
            zzhr zzhr3 = zzhr2 == null ? zzin : zzhr2;
            String str21 = "_ae";
            if (zzad().zzz(str19)) {
                zzae();
                if (zzt().zzin() != null && str21.equals(str20)) {
                    long zzjb = zzv().zzjb();
                    if (zzjb > 0) {
                        zzz().zzb(zza2, zzjb);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(zza2);
            long nextLong = zzz().zzjw().nextLong();
            if (!zzad().zze(zzr().zzag(), zzak.zzid) || zzac().zzma.get() <= 0 || !zzac().zzx(j) || !zzac().zzmd.get()) {
                str4 = str17;
            } else {
                zzab().zzgs().zzao("Current session is expired, remove the session number and Id");
                if (zzad().zze(zzr().zzag(), zzak.zzhz)) {
                    str4 = str17;
                    zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", (Object) null, zzx().currentTimeMillis());
                } else {
                    str4 = str17;
                }
                if (zzad().zze(zzr().zzag(), zzak.zzia)) {
                    zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sno", (Object) null, zzx().currentTimeMillis());
                }
            }
            if (!zzad().zzy(zzr().zzag()) || zza2.getLong("extend_session", 0) != 1) {
                long j4 = j;
            } else {
                zzab().zzgs().zzao("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                this.zzj.zzv().zza(j, true);
            }
            String[] strArr = (String[]) zza2.keySet().toArray(new String[bundle.size()]);
            Arrays.sort(strArr);
            int length = strArr.length;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                str5 = "_eid";
                if (i5 >= length) {
                    break;
                }
                String str22 = strArr[i5];
                Object obj = zza2.get(str22);
                zzz();
                String[] strArr2 = strArr;
                Bundle[] zzb = zzjs.zzb(obj);
                if (zzb != null) {
                    i = length;
                    zza2.putInt(str22, zzb.length);
                    int i7 = 0;
                    while (i7 < zzb.length) {
                        Bundle bundle4 = zzb[i7];
                        zzhq.zza(zzhr3, bundle4, true);
                        String str23 = str5;
                        int i8 = i6;
                        int i9 = i7;
                        int i10 = i5;
                        long j5 = nextLong;
                        Bundle bundle5 = bundle4;
                        ArrayList arrayList3 = arrayList2;
                        zzhr zzhr4 = zzhr3;
                        String str24 = str21;
                        Bundle bundle6 = zza2;
                        Bundle zza3 = zzz().zza(str3, "_ep", bundle5, listOf, z3, false);
                        zza3.putString("_en", str20);
                        zza3.putLong(str23, j5);
                        zza3.putString("_gn", str22);
                        zza3.putInt("_ll", zzb.length);
                        int i11 = i9;
                        zza3.putInt("_i", i11);
                        arrayList3.add(zza3);
                        int i12 = i11 + 1;
                        zza2 = bundle6;
                        nextLong = j5;
                        arrayList2 = arrayList3;
                        i7 = i12;
                        i5 = i10;
                        zzhr3 = zzhr4;
                        i6 = i8;
                        str21 = str24;
                        str5 = str23;
                    }
                    zzhr = zzhr3;
                    i2 = i5;
                    j2 = nextLong;
                    arrayList = arrayList2;
                    str8 = str21;
                    bundle2 = zza2;
                    i6 += zzb.length;
                } else {
                    zzhr = zzhr3;
                    i = length;
                    i2 = i5;
                    int i13 = i6;
                    j2 = nextLong;
                    arrayList = arrayList2;
                    str8 = str21;
                    bundle2 = zza2;
                }
                zza2 = bundle2;
                nextLong = j2;
                arrayList2 = arrayList;
                length = i;
                zzhr3 = zzhr;
                str21 = str8;
                long j6 = j;
                i5 = i2 + 1;
                strArr = strArr2;
            }
            String str25 = str5;
            int i14 = i6;
            long j7 = nextLong;
            ArrayList arrayList4 = arrayList2;
            String str26 = str21;
            Bundle bundle7 = zza2;
            if (i14 != 0) {
                bundle7.putLong(str25, j7);
                bundle7.putInt("_epc", i14);
            }
            int i15 = 0;
            while (i15 < arrayList4.size()) {
                Bundle bundle8 = (Bundle) arrayList4.get(i15);
                if (i15 != 0) {
                    str7 = "_ep";
                    str6 = str20;
                } else {
                    str7 = str20;
                    str6 = str7;
                }
                String str27 = str4;
                bundle8.putString(str27, str);
                if (z2) {
                    bundle8 = zzz().zzg(bundle8);
                }
                Bundle bundle9 = bundle8;
                zzab().zzgr().zza("Logging event (FE)", zzy().zzaj(str6), zzy().zzc(bundle9));
                ArrayList arrayList5 = arrayList4;
                zzai zzai = new zzai(str7, new zzah(bundle9), str, j);
                zzs().zzc(zzai, str3);
                if (!equals) {
                    for (zzgn onEvent : this.zzpw) {
                        onEvent.onEvent(str, str2, new Bundle(bundle9), j);
                    }
                }
                i15++;
                str20 = str6;
                str4 = str27;
                arrayList4 = arrayList5;
            }
            String str28 = str20;
            zzae();
            if (zzt().zzin() != null && str26.equals(str28)) {
                zzv().zza(true, true);
            }
        }
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        zzm();
        zzb(str == null ? SettingsJsonConstants.APP_KEY : str, str2, j, bundle == null ? new Bundle() : bundle, z2, !z2 || this.zzpv == null || zzjs.zzbq(str2), !z, null);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle zzh = zzjs.zzh(bundle);
        zzfc zzaa = zzaa();
        zzgr zzgr = new zzgr(this, str, str2, j, zzh, z, z2, z3, str3);
        zzaa.zza((Runnable) zzgr);
    }

    public final void zzb(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzx().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = SettingsJsonConstants.APP_KEY;
        }
        String str3 = str;
        int i = 6;
        int i2 = 0;
        if (z) {
            i = zzz().zzbm(str2);
        } else {
            zzjs zzz = zzz();
            String str4 = "user property";
            if (zzz.zzp(str4, str2)) {
                if (!zzz.zza(str4, zzgl.zzpp, str2)) {
                    i = 15;
                } else if (zzz.zza(str4, 24, str2)) {
                    i = 0;
                }
            }
        }
        String str5 = "_ev";
        if (i != 0) {
            zzz();
            String zza = zzjs.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzj.zzz().zza(i, str5, zza, i2);
        } else if (obj != null) {
            int zzc = zzz().zzc(str2, obj);
            if (zzc != 0) {
                zzz();
                String zza2 = zzjs.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzj.zzz().zza(zzc, str5, zza2, i2);
                return;
            }
            Object zzd = zzz().zzd(str2, obj);
            if (zzd != null) {
                zza(str3, str2, j, zzd);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzfc zzaa = zzaa();
        zzgq zzgq = new zzgq(this, str, str2, obj, j);
        zzaa.zza((Runnable) zzgq);
    }

    /* JADX WARNING: type inference failed for: r11v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r10v14, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Object, code=null, for r11v0, types: [java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v2
  assigns: []
  uses: []
  mth insns count: 71
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1507)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARNING: Unknown variable types count: 5 */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzo()
            r8.zzm()
            r8.zzbi()
            com.google.android.gms.measurement.internal.zzs r0 = r8.zzad()
            com.google.android.gms.measurement.internal.zzdy r1 = r8.zzr()
            java.lang.String r1 = r1.zzag()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzak.zzik
            boolean r0 = r0.zze(r1, r2)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0077
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0077
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0067
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0067
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L_0x004c
            r4 = r2
            goto L_0x004e
        L_0x004c:
            r4 = 0
        L_0x004e:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzeo r0 = r8.zzac()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzlx
            long r4 = r10.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0062
            java.lang.String r11 = "true"
        L_0x0062:
            r0.zzau(r11)
            r6 = r10
            goto L_0x0075
        L_0x0067:
            if (r11 != 0) goto L_0x0077
            com.google.android.gms.measurement.internal.zzeo r10 = r8.zzac()
            com.google.android.gms.measurement.internal.zzev r10 = r10.zzlx
            java.lang.String r0 = "unset"
            r10.zzau(r0)
            r6 = r11
        L_0x0075:
            r3 = r1
            goto L_0x0079
        L_0x0077:
            r3 = r10
            r6 = r11
        L_0x0079:
            com.google.android.gms.measurement.internal.zzfj r10 = r8.zzj
            boolean r10 = r10.isEnabled()
            if (r10 != 0) goto L_0x008f
            com.google.android.gms.measurement.internal.zzef r9 = r8.zzab()
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzgr()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zzao(r10)
            return
        L_0x008f:
            com.google.android.gms.measurement.internal.zzfj r10 = r8.zzj
            boolean r10 = r10.zzie()
            if (r10 != 0) goto L_0x0098
            return
        L_0x0098:
            com.google.android.gms.measurement.internal.zzef r10 = r8.zzab()
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzgr()
            com.google.android.gms.measurement.internal.zzed r11 = r8.zzy()
            java.lang.String r11 = r11.zzaj(r3)
            java.lang.String r0 = "Setting user property (FE)"
            r10.zza(r0, r11, r6)
            com.google.android.gms.measurement.internal.zzjn r10 = new com.google.android.gms.measurement.internal.zzjn
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzhv r9 = r8.zzs()
            r9.zzb(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List<zzjn> zzh(boolean z) {
        zzm();
        zzbi();
        zzab().zzgr().zzao("Fetching user attributes (FE)");
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzj.zzaa().zza((Runnable) new zzgt(this, atomicReference, z));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzab().zzgn().zza("Interrupted waiting for get user properties", e);
                }
            }
            List<zzjn> list = (List) atomicReference.get();
            if (list == null) {
                zzab().zzgn().zzao("Timed out waiting for get user properties");
                list = Collections.emptyList();
            }
            return list;
        }
    }

    @Nullable
    public final String zzi() {
        zzm();
        return (String) this.zzpy.get();
    }

    @Nullable
    public final String zzy(long j) {
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot retrieve app instance id from analytics worker thread");
            return null;
        } else if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot retrieve app instance id from main thread");
            return null;
        } else {
            long elapsedRealtime = zzx().elapsedRealtime();
            String zzz = zzz(120000);
            long elapsedRealtime2 = zzx().elapsedRealtime() - elapsedRealtime;
            if (zzz == null && elapsedRealtime2 < 120000) {
                zzz = zzz(120000 - elapsedRealtime2);
            }
            return zzz;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzbg(@Nullable String str) {
        this.zzpy.set(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        zzab().zzgn().zzao("Interrupted waiting for app instance id");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzz(long r4) {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            monitor-enter(r0)
            com.google.android.gms.measurement.internal.zzfc r1 = r3.zzaa()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.zzgs r2 = new com.google.android.gms.measurement.internal.zzgs     // Catch:{ all -> 0x002d }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x002d }
            r1.zza(r2)     // Catch:{ all -> 0x002d }
            r0.wait(r4)     // Catch:{ InterruptedException -> 0x001d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            java.lang.Object r4 = r0.get()
            java.lang.String r4 = (java.lang.String) r4
            return r4
        L_0x001d:
            com.google.android.gms.measurement.internal.zzef r4 = r3.zzab()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgn()     // Catch:{ all -> 0x002d }
            java.lang.String r5 = "Interrupted waiting for app instance id"
            r4.zzao(r5)     // Catch:{ all -> 0x002d }
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r4
        L_0x002d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgp.zzz(long):java.lang.String");
    }

    public final void resetAnalyticsData(long j) {
        zzbg(null);
        zzaa().zza((Runnable) new zzgv(this, j));
    }

    @WorkerThread
    public final void zzim() {
        zzo();
        zzm();
        zzbi();
        if (this.zzj.zzie()) {
            zzs().zzim();
            this.zzpz = false;
            String zzhh = zzac().zzhh();
            if (!TextUtils.isEmpty(zzhh)) {
                zzw().zzbi();
                if (!zzhh.equals(VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzhh);
                    logEvent(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
                }
            }
        }
    }

    @WorkerThread
    public final void zza(zzgk zzgk) {
        zzo();
        zzm();
        zzbi();
        if (zzgk != null) {
            zzgk zzgk2 = this.zzpv;
            if (zzgk != zzgk2) {
                Preconditions.checkState(zzgk2 == null, "EventInterceptor already set.");
            }
        }
        this.zzpv = zzgk;
    }

    public final void zza(zzgn zzgn) {
        zzm();
        zzbi();
        Preconditions.checkNotNull(zzgn);
        if (!this.zzpw.add(zzgn)) {
            zzab().zzgn().zzao("OnEventListener already registered");
        }
    }

    public final void zzb(zzgn zzgn) {
        zzm();
        zzbi();
        Preconditions.checkNotNull(zzgn);
        if (!this.zzpw.remove(zzgn)) {
            zzab().zzgn().zzao("OnEventListener had not been registered");
        }
    }

    public final void setConditionalUserProperty(Bundle bundle) {
        setConditionalUserProperty(bundle, zzx().currentTimeMillis());
    }

    public final void setConditionalUserProperty(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzm();
        Bundle bundle2 = new Bundle(bundle);
        String str = "app_id";
        if (!TextUtils.isEmpty(bundle2.getString(str))) {
            zzab().zzgn().zzao("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove(str);
        zza(bundle2, j);
    }

    public final void zzd(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zzl();
        zza(new Bundle(bundle), zzx().currentTimeMillis());
    }

    private final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzgg.zza(bundle, "app_id", String.class, null);
        String str = "origin";
        zzgg.zza(bundle, str, String.class, null);
        String str2 = "name";
        zzgg.zza(bundle, str2, String.class, null);
        String str3 = "value";
        zzgg.zza(bundle, str3, Object.class, null);
        String str4 = "trigger_event_name";
        zzgg.zza(bundle, str4, String.class, null);
        Long valueOf = Long.valueOf(0);
        String str5 = "trigger_timeout";
        zzgg.zza(bundle, str5, Long.class, valueOf);
        zzgg.zza(bundle, "timed_out_event_name", String.class, null);
        zzgg.zza(bundle, "timed_out_event_params", Bundle.class, null);
        zzgg.zza(bundle, "triggered_event_name", String.class, null);
        zzgg.zza(bundle, "triggered_event_params", Bundle.class, null);
        String str6 = "time_to_live";
        zzgg.zza(bundle, str6, Long.class, valueOf);
        zzgg.zza(bundle, "expired_event_name", String.class, null);
        zzgg.zza(bundle, "expired_event_params", Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString(str2));
        Preconditions.checkNotEmpty(bundle.getString(str));
        Preconditions.checkNotNull(bundle.get(str3));
        bundle.putLong("creation_timestamp", j);
        String string = bundle.getString(str2);
        Object obj = bundle.get(str3);
        if (zzz().zzbm(string) != 0) {
            zzab().zzgk().zza("Invalid conditional user property name", zzy().zzal(string));
        } else if (zzz().zzc(string, obj) != 0) {
            zzab().zzgk().zza("Invalid conditional user property value", zzy().zzal(string), obj);
        } else {
            Object zzd = zzz().zzd(string, obj);
            if (zzd == null) {
                zzab().zzgk().zza("Unable to normalize conditional user property value", zzy().zzal(string), obj);
                return;
            }
            zzgg.zza(bundle, zzd);
            long j2 = bundle.getLong(str5);
            if (TextUtils.isEmpty(bundle.getString(str4)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle.getLong(str6);
                if (j3 > 15552000000L || j3 < 1) {
                    zzab().zzgk().zza("Invalid conditional user property time to live", zzy().zzal(string), Long.valueOf(j3));
                    return;
                }
                zzaa().zza((Runnable) new zzgx(this, bundle));
                return;
            }
            zzab().zzgk().zza("Invalid conditional user property timeout", zzy().zzal(string), Long.valueOf(j2));
        }
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzm();
        zza((String) null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zzl();
        zza(str, str2, str3, bundle);
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzx().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString("name", str2);
        bundle2.putLong("creation_timestamp", currentTimeMillis);
        if (str3 != null) {
            bundle2.putString("expired_event_name", str3);
            bundle2.putBundle("expired_event_params", bundle);
        }
        zzaa().zza((Runnable) new zzgw(this, bundle2));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zze(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = "app_id";
        zzo();
        zzbi();
        Preconditions.checkNotNull(bundle);
        String str2 = "name";
        Preconditions.checkNotEmpty(bundle2.getString(str2));
        String str3 = "origin";
        Preconditions.checkNotEmpty(bundle2.getString(str3));
        String str4 = "value";
        Preconditions.checkNotNull(bundle2.get(str4));
        if (!this.zzj.isEnabled()) {
            zzab().zzgr().zzao("Conditional property not sent since collection is disabled");
            return;
        }
        zzjn zzjn = new zzjn(bundle2.getString(str2), bundle2.getLong("triggered_timestamp"), bundle2.get(str4), bundle2.getString(str3));
        try {
            zzai zza = zzz().zza(bundle2.getString(str), bundle2.getString("triggered_event_name"), bundle2.getBundle("triggered_event_params"), bundle2.getString(str3), 0, true, false);
            zzq zzq = new zzq(bundle2.getString(str), bundle2.getString(str3), zzjn, bundle2.getLong("creation_timestamp"), false, bundle2.getString("trigger_event_name"), zzz().zza(bundle2.getString(str), bundle2.getString("timed_out_event_name"), bundle2.getBundle("timed_out_event_params"), bundle2.getString(str3), 0, true, false), bundle2.getLong("trigger_timeout"), zza, bundle2.getLong("time_to_live"), zzz().zza(bundle2.getString(str), bundle2.getString("expired_event_name"), bundle2.getBundle("expired_event_params"), bundle2.getString(str3), 0, true, false));
            zzs().zzd(zzq);
        } catch (IllegalArgumentException unused) {
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzf(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = "creation_timestamp";
        String str2 = "origin";
        String str3 = "app_id";
        zzo();
        zzbi();
        Preconditions.checkNotNull(bundle);
        String str4 = "name";
        Preconditions.checkNotEmpty(bundle2.getString(str4));
        if (!this.zzj.isEnabled()) {
            zzab().zzgr().zzao("Conditional property not cleared since collection is disabled");
            return;
        }
        zzjn zzjn = new zzjn(bundle2.getString(str4), 0, null, null);
        try {
            zzai zza = zzz().zza(bundle2.getString(str3), bundle2.getString("expired_event_name"), bundle2.getBundle("expired_event_params"), bundle2.getString(str2), bundle2.getLong(str), true, false);
            zzjn zzjn2 = zzjn;
            zzq zzq = new zzq(bundle2.getString(str3), bundle2.getString(str2), zzjn2, bundle2.getLong(str), bundle2.getBoolean("active"), bundle2.getString("trigger_event_name"), null, bundle2.getLong("trigger_timeout"), null, bundle2.getLong("time_to_live"), zza);
            zzs().zzd(zzq);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final ArrayList<Bundle> zzn(String str, String str2) {
        zzm();
        return zze(null, str, str2);
    }

    public final ArrayList<Bundle> zzd(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzl();
        return zze(str, str2, str3);
    }

    private final ArrayList<Bundle> zze(String str, String str2, String str3) {
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                zzfc zzaa = this.zzj.zzaa();
                zzgz zzgz = new zzgz(this, atomicReference, str, str2, str3);
                zzaa.zza((Runnable) zzgz);
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzab().zzgn().zza("Interrupted waiting for get conditional user properties", str, e);
                }
            }
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzjs.zzd(list);
            }
            zzab().zzgn().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zzm();
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zzl();
        return zzb(str, str2, str3, z);
    }

    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                zzfc zzaa = this.zzj.zzaa();
                zzhb zzhb = new zzhb(this, atomicReference, str, str2, str3, z);
                zzaa.zza((Runnable) zzhb);
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzab().zzgn().zza("Interrupted waiting for get user properties", e);
                }
            }
            List<zzjn> list = (List) atomicReference.get();
            if (list == null) {
                zzab().zzgn().zzao("Timed out waiting for get user properties");
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzjn zzjn : list) {
                arrayMap.put(zzjn.name, zzjn.getValue());
            }
            return arrayMap;
        }
    }

    @Nullable
    public final String getCurrentScreenName() {
        zzhr zzio = this.zzj.zzt().zzio();
        if (zzio != null) {
            return zzio.zzqu;
        }
        return null;
    }

    @Nullable
    public final String getCurrentScreenClass() {
        zzhr zzio = this.zzj.zzt().zzio();
        if (zzio != null) {
            return zzio.zzqv;
        }
        return null;
    }

    @Nullable
    public final String getGmpAppId() {
        if (this.zzj.zzhx() != null) {
            return this.zzj.zzhx();
        }
        try {
            return GoogleServices.getGoogleAppId();
        } catch (IllegalStateException e) {
            this.zzj.zzab().zzgk().zza("getGoogleAppId failed with exception", e);
            return null;
        }
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
