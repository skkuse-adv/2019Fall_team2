package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Map;

public final class zza extends zzd {
    private final Map<String, Long> zzby = new ArrayMap();
    private final Map<String, Integer> zzbz = new ArrayMap();
    private long zzca;

    public zza(zzfj zzfj) {
        super(zzfj);
    }

    public final void beginAdUnitExposure(String str, long j) {
        if (str == null || str.length() == 0) {
            zzab().zzgk().zzao("Ad unit id must be a non-empty string");
        } else {
            zzaa().zza((Runnable) new zzc(this, str, j));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(String str, long j) {
        zzm();
        zzo();
        Preconditions.checkNotEmpty(str);
        if (this.zzbz.isEmpty()) {
            this.zzca = j;
        }
        Integer num = (Integer) this.zzbz.get(str);
        if (num != null) {
            this.zzbz.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.zzbz.size() >= 100) {
            zzab().zzgn().zzao("Too many ads visible");
        } else {
            this.zzbz.put(str, Integer.valueOf(1));
            this.zzby.put(str, Long.valueOf(j));
        }
    }

    public final void endAdUnitExposure(String str, long j) {
        if (str == null || str.length() == 0) {
            zzab().zzgk().zzao("Ad unit id must be a non-empty string");
        } else {
            zzaa().zza((Runnable) new zzb(this, str, j));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(String str, long j) {
        zzm();
        zzo();
        Preconditions.checkNotEmpty(str);
        Integer num = (Integer) this.zzbz.get(str);
        if (num != null) {
            zzhr zzin = zzt().zzin();
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.zzbz.remove(str);
                Long l = (Long) this.zzby.get(str);
                if (l == null) {
                    zzab().zzgk().zzao("First ad unit exposure time was never set");
                } else {
                    long longValue = j - l.longValue();
                    this.zzby.remove(str);
                    zza(str, longValue, zzin);
                }
                if (this.zzbz.isEmpty()) {
                    long j2 = this.zzca;
                    if (j2 == 0) {
                        zzab().zzgk().zzao("First ad exposure time was never set");
                        return;
                    } else {
                        zza(j - j2, zzin);
                        this.zzca = 0;
                    }
                }
                return;
            }
            this.zzbz.put(str, Integer.valueOf(intValue));
            return;
        }
        zzab().zzgk().zza("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    @WorkerThread
    private final void zza(long j, zzhr zzhr) {
        if (zzhr == null) {
            zzab().zzgs().zzao("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            zzab().zzgs().zza("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzhq.zza(zzhr, bundle, true);
            zzq().logEvent("am", "_xa", bundle);
        }
    }

    @WorkerThread
    private final void zza(String str, long j, zzhr zzhr) {
        if (zzhr == null) {
            zzab().zzgs().zzao("Not logging ad unit exposure. No active activity");
        } else if (j < 1000) {
            zzab().zzgs().zza("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zzhq.zza(zzhr, bundle, true);
            zzq().logEvent("am", "_xu", bundle);
        }
    }

    @WorkerThread
    public final void zzc(long j) {
        zzhr zzin = zzt().zzin();
        for (String str : this.zzby.keySet()) {
            zza(str, j - ((Long) this.zzby.get(str)).longValue(), zzin);
        }
        if (!this.zzby.isEmpty()) {
            zza(j - this.zzca, zzin);
        }
        zzd(j);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzd(long j) {
        for (String put : this.zzby.keySet()) {
            this.zzby.put(put, Long.valueOf(j));
        }
        if (!this.zzby.isEmpty()) {
            this.zzca = j;
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
