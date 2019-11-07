package com.google.firebase.perf.metrics;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.firebase-perf.zzcr;
import com.google.android.gms.internal.firebase-perf.zzda;
import com.google.android.gms.internal.firebase-perf.zzda.zzb;
import com.google.firebase.perf.internal.zzq;
import java.util.Arrays;
import java.util.List;

final class zzd {
    private final Trace zzgk;

    zzd(@NonNull Trace trace) {
        this.zzgk = trace;
    }

    /* access modifiers changed from: 0000 */
    public final zzda zzco() {
        zzb zzal = zzda.zzfu().zzad(this.zzgk.getName()).zzak(this.zzgk.zzcl().zzcr()).zzal(this.zzgk.zzcl().zza(this.zzgk.zzcm()));
        for (zza zza : this.zzgk.zzck().values()) {
            zzal.zzd(zza.getName(), zza.getCount());
        }
        List<Trace> zzcn = this.zzgk.zzcn();
        if (!zzcn.isEmpty()) {
            for (Trace zzd : zzcn) {
                zzal.zzg(new zzd(zzd).zzco());
            }
        }
        zzal.zzf(this.zzgk.getAttributes());
        zzcr[] zza2 = zzq.zza(this.zzgk.getSessions());
        if (zza2 != null) {
            zzal.zzf((Iterable<? extends zzcr>) Arrays.asList(zza2));
        }
        return (zzda) zzal.zzhi();
    }
}
