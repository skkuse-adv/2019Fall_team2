package com.google.firebase.perf.internal;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.firebase-perf.zzap;
import com.google.android.gms.internal.firebase-perf.zzat;
import com.google.android.gms.internal.firebase-perf.zzbo;
import com.google.android.gms.internal.firebase-perf.zzbt;
import com.google.android.gms.internal.firebase-perf.zzbu;
import com.google.android.gms.internal.firebase-perf.zzbz;
import com.google.android.gms.internal.firebase-perf.zzcd;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Keep
public class GaugeManager {
    private static GaugeManager zzdn = new GaugeManager();
    private final FeatureControl zzcy;
    private final ScheduledExecutorService zzdo;
    private final zzap zzdp;
    private final zzat zzdq;
    @Nullable
    private zzc zzdr;
    @Nullable
    private zzp zzds;
    private zzbt zzdt;
    @Nullable
    private String zzdu;
    @Nullable
    private ScheduledFuture zzdv;
    private final ConcurrentLinkedQueue<zza> zzdw;

    class zza {
        /* access modifiers changed from: private */
        public final zzcd zzdg;
        /* access modifiers changed from: private */
        public final zzbt zzdt;

        zza(GaugeManager gaugeManager, zzcd zzcd, zzbt zzbt) {
            this.zzdg = zzcd;
            this.zzdt = zzbt;
        }
    }

    private GaugeManager() {
        this(Executors.newSingleThreadScheduledExecutor(), null, FeatureControl.zzao(), null, zzap.zzs(), zzat.zzz());
    }

    @VisibleForTesting
    private GaugeManager(ScheduledExecutorService scheduledExecutorService, zzc zzc, FeatureControl featureControl, zzp zzp, zzap zzap, zzat zzat) {
        this.zzdt = zzbt.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.zzdu = null;
        this.zzdv = null;
        this.zzdw = new ConcurrentLinkedQueue<>();
        this.zzdo = scheduledExecutorService;
        this.zzdr = null;
        this.zzcy = featureControl;
        this.zzds = null;
        this.zzdp = zzap;
        this.zzdq = zzat;
    }

    public final void zze(Context context) {
        this.zzds = new zzp(context);
    }

    public static synchronized GaugeManager zzbf() {
        GaugeManager gaugeManager;
        synchronized (GaugeManager.class) {
            gaugeManager = zzdn;
        }
        return gaugeManager;
    }

    public final void zza(String str, zzbt zzbt) {
        long j;
        boolean z;
        long j2;
        String str2 = str;
        zzbt zzbt2 = zzbt;
        if (this.zzdu != null) {
            zzbg();
        }
        int i = zzn.zzdx[zzbt.ordinal()];
        if (i == 1) {
            j = this.zzcy.zzav();
        } else if (i != 2) {
            j = -1;
        } else {
            j = this.zzcy.zzat();
        }
        if (j == -1 || j <= 0) {
            j = -1;
        }
        boolean z2 = false;
        if (this.zzcy.zzaq() && j != -1) {
            this.zzdp.zzb(j);
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            j = -1;
        }
        int i2 = zzn.zzdx[zzbt.ordinal()];
        if (i2 == 1) {
            j2 = this.zzcy.zzaw();
        } else if (i2 != 2) {
            j2 = -1;
        } else {
            j2 = this.zzcy.zzau();
        }
        if (j2 == -1 || j2 <= 0) {
            j2 = -1;
        }
        if (this.zzcy.zzar() && j2 != -1) {
            this.zzdq.zzb(j2);
            z2 = true;
        }
        if (z2) {
            if (j != -1) {
                j2 = Math.min(j, j2);
            }
            j = j2;
        }
        if (j != -1) {
            this.zzdu = str2;
            this.zzdt = zzbt2;
            try {
                long j3 = j * 20;
                this.zzdv = this.zzdo.scheduleAtFixedRate(new zzm(this, str2, zzbt2), j3, j3, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                String str3 = "Unable to start collecting Gauges: ";
                String valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() != 0) {
                    str3.concat(valueOf);
                } else {
                    new String(str3);
                }
            }
        }
    }

    public final void zzbg() {
        String str = this.zzdu;
        if (str != null) {
            zzbt zzbt = this.zzdt;
            this.zzdp.zzt();
            this.zzdq.zzt();
            ScheduledFuture scheduledFuture = this.zzdv;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.zzdo.schedule(new zzo(this, str, zzbt), 20, TimeUnit.MILLISECONDS);
            this.zzdu = null;
            this.zzdt = zzbt.APPLICATION_PROCESS_STATE_UNKNOWN;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final void zze(String str, zzbt zzbt) {
        com.google.android.gms.internal.firebase-perf.zzcd.zza zzdx = zzcd.zzdx();
        while (!this.zzdp.zzbb.isEmpty()) {
            zzdx.zzb((zzbu) this.zzdp.zzbb.poll());
        }
        while (!this.zzdq.zzbg.isEmpty()) {
            zzdx.zzb((zzbo) this.zzdq.zzbg.poll());
        }
        zzdx.zzz(str);
        zzc((zzcd) zzdx.zzhi(), zzbt);
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzc(String str, zzbt zzbt) {
        if (this.zzds == null) {
            return false;
        }
        zzc((zzcd) zzcd.zzdx().zzz(str).zzb((zzbz) zzbz.zzdo().zzx(this.zzds.getProcessName()).zzi(this.zzds.zzbl()).zzj(this.zzds.zzbj()).zzk(this.zzds.zzbk()).zzhi()).zzhi(), zzbt);
        return true;
    }

    private final void zzc(zzcd zzcd, zzbt zzbt) {
        zzc zzc = this.zzdr;
        if (zzc == null) {
            zzc = zzc.zzba();
        }
        this.zzdr = zzc;
        zzc zzc2 = this.zzdr;
        if (zzc2 != null) {
            zzc2.zza(zzcd, zzbt);
            while (!this.zzdw.isEmpty()) {
                zza zza2 = (zza) this.zzdw.poll();
                this.zzdr.zza(zza2.zzdg, zza2.zzdt);
            }
            return;
        }
        this.zzdw.add(new zza(this, zzcd, zzbt));
    }

    public final void zzbh() {
        zza(this.zzcy.zzaq(), this.zzcy.zzar(), this.zzdp, this.zzdq);
    }

    public static void zzbi() {
        zza(true, true, zzap.zzs(), zzat.zzz());
    }

    private static void zza(boolean z, boolean z2, zzap zzap, zzat zzat) {
        if (z) {
            zzap.zzu();
        }
        if (z2) {
            zzat.zzu();
        }
    }
}
