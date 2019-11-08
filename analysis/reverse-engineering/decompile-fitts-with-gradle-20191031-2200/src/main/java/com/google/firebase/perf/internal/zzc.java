package com.google.firebase.perf.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.internal.firebase-perf.zzaw;
import com.google.android.gms.internal.firebase-perf.zzbk;
import com.google.android.gms.internal.firebase-perf.zzbn;
import com.google.android.gms.internal.firebase-perf.zzbr;
import com.google.android.gms.internal.firebase-perf.zzbr.zzb;
import com.google.android.gms.internal.firebase-perf.zzbt;
import com.google.android.gms.internal.firebase-perf.zzcd;
import com.google.android.gms.internal.firebase-perf.zzci;
import com.google.android.gms.internal.firebase-perf.zzcn;
import com.google.android.gms.internal.firebase-perf.zzcn.zza;
import com.google.android.gms.internal.firebase-perf.zzda;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.perf.FirebasePerformance;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class zzc {
    @SuppressLint({"StaticFieldLeak"})
    private static zzc zzcn;
    private final ExecutorService zzco;
    private FirebaseApp zzcp;
    @Nullable
    private FirebasePerformance zzcq;
    private FirebaseInstanceId zzcr;
    private Context zzcs;
    private ClearcutLogger zzct;
    private String zzcu;
    private final zzb zzcv = zzbr.zzdg();
    private zzs zzcw;
    private zza zzcx;
    private FeatureControl zzcy;
    private boolean zzcz;

    @Nullable
    public static zzc zzba() {
        if (zzcn == null) {
            synchronized (zzc.class) {
                if (zzcn == null) {
                    try {
                        FirebaseApp.getInstance();
                        zzc zzc = new zzc(null, null, null, null, null, null);
                        zzcn = zzc;
                    } catch (IllegalStateException unused) {
                        return null;
                    }
                }
            }
        }
        return zzcn;
    }

    @VisibleForTesting(otherwise = 2)
    private zzc(@Nullable ExecutorService executorService, @Nullable ClearcutLogger clearcutLogger, @Nullable zzs zzs, @Nullable zza zza, @Nullable FirebaseInstanceId firebaseInstanceId, @Nullable FeatureControl featureControl) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.zzco = threadPoolExecutor;
        this.zzct = null;
        this.zzcw = null;
        this.zzcx = null;
        this.zzcr = null;
        this.zzcy = null;
        this.zzco.execute(new zzf(this));
    }

    public final void zza(@NonNull zzda zzda, zzbt zzbt) {
        this.zzco.execute(new zze(this, zzda, zzbt));
        SessionManager.zzcf().zzch();
    }

    public final void zza(@NonNull zzci zzci, zzbt zzbt) {
        this.zzco.execute(new zzh(this, zzci, zzbt));
        SessionManager.zzcf().zzch();
    }

    public final void zza(zzcd zzcd, zzbt zzbt) {
        this.zzco.execute(new zzg(this, zzcd, zzbt));
        SessionManager.zzcf().zzch();
    }

    public final void zzb(boolean z) {
        this.zzco.execute(new zzj(this, z));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzbb() {
        this.zzcp = FirebaseApp.getInstance();
        this.zzcq = FirebasePerformance.getInstance();
        this.zzcs = this.zzcp.getApplicationContext();
        this.zzcu = this.zzcp.getOptions().getApplicationId();
        this.zzcv.zzu(this.zzcu).zzb(zzbn.zzcv().zzp(this.zzcs.getPackageName()).zzq("1.0.0.252929170").zzr(zzd(this.zzcs)));
        zzbc();
        if (this.zzct == null) {
            try {
                this.zzct = ClearcutLogger.anonymousLogger(this.zzcs, "FIREPERF");
            } catch (SecurityException e) {
                String str = "Caught SecurityException while init ClearcutLogger: ";
                String valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() != 0) {
                    str.concat(valueOf);
                } else {
                    new String(str);
                }
                this.zzct = null;
            }
        }
        zzs zzs = this.zzcw;
        if (zzs == null) {
            zzs = new zzs(this.zzcs, 100, 500);
        }
        this.zzcw = zzs;
        zza zza = this.zzcx;
        if (zza == null) {
            zza = zza.zzaj();
        }
        this.zzcx = zza;
        FeatureControl featureControl = this.zzcy;
        if (featureControl == null) {
            featureControl = FeatureControl.zzao();
        }
        this.zzcy = featureControl;
        this.zzcz = zzbk.zzg(this.zzcs);
    }

    @WorkerThread
    private final void zza(@NonNull zzcn zzcn2) {
        if (this.zzct != null && isPerformanceCollectionEnabled() && zzcn2.zzfb().zzdb()) {
            Context context = this.zzcs;
            ArrayList arrayList = new ArrayList();
            if (zzcn2.zzfc()) {
                arrayList.add(new zzk(zzcn2.zzfd()));
            }
            if (zzcn2.zzfe()) {
                arrayList.add(new zzl(zzcn2.zzff(), context));
            }
            if (zzcn2.zzfa()) {
                arrayList.add(new zzd(zzcn2.zzfb()));
            }
            if (zzcn2.zzfg()) {
                arrayList.add(new zzi(zzcn2.zzfh()));
            }
            boolean z = false;
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z = true;
                        break;
                    }
                    Object obj = arrayList.get(i);
                    i++;
                    if (!((zzr) obj).zzbe()) {
                        break;
                    }
                }
            }
            if (z) {
                if (!this.zzcw.zzb(zzcn2)) {
                    if (zzcn2.zzfe()) {
                        this.zzcx.zza(zzaw.NETWORK_TRACE_EVENT_RATE_LIMITED.toString(), 1);
                    } else if (zzcn2.zzfc()) {
                        this.zzcx.zza(zzaw.TRACE_EVENT_RATE_LIMITED.toString(), 1);
                    }
                    if (this.zzcz) {
                        if (zzcn2.zzfe()) {
                            String str = "Rate Limited NetworkRequestMetric - ";
                            String valueOf = String.valueOf(zzcn2.zzff().getUrl());
                            if (valueOf.length() != 0) {
                                str.concat(valueOf);
                            } else {
                                new String(str);
                            }
                            return;
                        } else if (zzcn2.zzfc()) {
                            String str2 = "Rate Limited TraceMetric - ";
                            String valueOf2 = String.valueOf(zzcn2.zzfd().getName());
                            if (valueOf2.length() != 0) {
                                str2.concat(valueOf2);
                            } else {
                                new String(str2);
                            }
                        }
                    }
                    return;
                }
                try {
                    this.zzct.newEvent(zzcn2.toByteArray()).log();
                } catch (SecurityException unused) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(zzcd zzcd, zzbt zzbt) {
        if (isPerformanceCollectionEnabled()) {
            if (this.zzcz) {
                String.format("Logging GaugeMetric. Cpu Metrics: %d, Memory Metrics: %d, Has Metadata: %b, Session ID: %s", new Object[]{Integer.valueOf(zzcd.zzdv()), Integer.valueOf(zzcd.zzdw()), Boolean.valueOf(zzcd.zzdt()), zzcd.zzds()});
            }
            if (!this.zzcy.zzap()) {
                boolean z = this.zzcz;
                return;
            }
            zza zzfi = zzcn.zzfi();
            zzbc();
            zzfi.zzb(this.zzcv.zzf(zzbt)).zzb(zzcd);
            zza((zzcn) zzfi.zzhi());
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(@NonNull zzda zzda, zzbt zzbt) {
        Map map;
        if (isPerformanceCollectionEnabled()) {
            if (this.zzcz) {
                String.format("Logging TraceMetric - %s %dms", new Object[]{zzda.getName(), Long.valueOf(zzda.getDurationUs() / 1000)});
            }
            if (!this.zzcy.zzap()) {
                zzda = (zzda) ((zzda.zzb) zzda.zzhl()).zzfx().zzhi();
                if (this.zzcz) {
                    String.format("Sessions are disabled. Dropping all sessions from Trace - %s", new Object[]{zzda.getName()});
                }
            }
            zzbc();
            zza zzfi = zzcn.zzfi();
            zzb zzf = ((zzb) this.zzcv.clone()).zzf(zzbt);
            zzbd();
            FirebasePerformance firebasePerformance = this.zzcq;
            if (firebasePerformance != null) {
                map = firebasePerformance.getAttributes();
            } else {
                map = Collections.emptyMap();
            }
            zza((zzcn) zzfi.zzb(zzf.zzc(map)).zzb(zzda).zzhi());
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(@NonNull zzci zzci, zzbt zzbt) {
        long j;
        if (isPerformanceCollectionEnabled()) {
            if (this.zzcz) {
                long j2 = 0;
                if (!zzci.zzeq()) {
                    j = 0;
                } else {
                    j = zzci.zzer();
                }
                if (zzci.zzeg()) {
                    j2 = zzci.zzeh();
                }
                String.format("Logging NetworkRequestMetric - %s %db %dms,", new Object[]{zzci.getUrl(), Long.valueOf(j2), Long.valueOf(j / 1000)});
            }
            if (!this.zzcy.zzap()) {
                zzci = (zzci) ((zzci.zza) zzci.zzhl()).zzez().zzhi();
                if (this.zzcz) {
                    String.format("Sessions are disabled. Dropping all sessions from Network Request - %s", new Object[]{zzci.getUrl()});
                }
            }
            zzbc();
            zza((zzcn) zzcn.zzfi().zzb(this.zzcv.zzf(zzbt)).zze(zzci).zzhi());
        }
    }

    @WorkerThread
    public final void zzc(boolean z) {
        this.zzcw.zzb(z);
    }

    private static String zzd(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException unused) {
            return "";
        }
    }

    @WorkerThread
    private final void zzbc() {
        if (!this.zzcv.zzdb() && isPerformanceCollectionEnabled()) {
            if (this.zzcr == null) {
                this.zzcr = FirebaseInstanceId.getInstance();
            }
            String id = this.zzcr.getId();
            if (id != null && !id.isEmpty()) {
                this.zzcv.zzv(id);
            }
        }
    }

    private final boolean isPerformanceCollectionEnabled() {
        zzbd();
        FirebasePerformance firebasePerformance = this.zzcq;
        if (firebasePerformance != null) {
            return firebasePerformance.isPerformanceCollectionEnabled();
        }
        return false;
    }

    private final void zzbd() {
        if (this.zzcq == null) {
            this.zzcq = this.zzcp != null ? FirebasePerformance.getInstance() : null;
        }
    }
}
