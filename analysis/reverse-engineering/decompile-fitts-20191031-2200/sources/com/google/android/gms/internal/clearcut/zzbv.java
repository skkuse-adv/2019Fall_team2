package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg.zzd;
import java.io.IOException;
import java.util.Map.Entry;

final class zzbv extends zzbu<zze> {
    zzbv() {
    }

    /* access modifiers changed from: 0000 */
    public final int zza(Entry<?, ?> entry) {
        return ((zze) entry.getKey()).number;
    }

    /* access modifiers changed from: 0000 */
    public final zzby<zze> zza(Object obj) {
        return ((zzd) obj).zzjv;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzfr zzfr, Entry<?, ?> entry) throws IOException {
        zze zze = (zze) entry.getKey();
        switch (zzbw.zzgq[zze.zzjx.ordinal()]) {
            case 1:
                zzfr.zza(zze.number, ((Double) entry.getValue()).doubleValue());
                break;
            case 2:
                zzfr.zza(zze.number, ((Float) entry.getValue()).floatValue());
                return;
            case 3:
                zzfr.zzi(zze.number, ((Long) entry.getValue()).longValue());
                return;
            case 4:
                zzfr.zza(zze.number, ((Long) entry.getValue()).longValue());
                return;
            case 5:
                zzfr.zzc(zze.number, ((Integer) entry.getValue()).intValue());
                return;
            case 6:
                zzfr.zzc(zze.number, ((Long) entry.getValue()).longValue());
                return;
            case 7:
                zzfr.zzf(zze.number, ((Integer) entry.getValue()).intValue());
                return;
            case 8:
                zzfr.zzb(zze.number, ((Boolean) entry.getValue()).booleanValue());
                return;
            case 9:
                zzfr.zzd(zze.number, ((Integer) entry.getValue()).intValue());
                return;
            case 10:
                zzfr.zzm(zze.number, ((Integer) entry.getValue()).intValue());
                return;
            case 11:
                zzfr.zzj(zze.number, ((Long) entry.getValue()).longValue());
                return;
            case 12:
                zzfr.zze(zze.number, ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                zzfr.zzb(zze.number, ((Long) entry.getValue()).longValue());
                return;
            case 14:
                zzfr.zzc(zze.number, ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                zzfr.zza(zze.number, (zzbb) entry.getValue());
                return;
            case 16:
                zzfr.zza(zze.number, (String) entry.getValue());
                return;
            case 17:
                zzfr.zzb(zze.number, entry.getValue(), zzea.zzcm().zze(entry.getValue().getClass()));
                return;
            case 18:
                zzfr.zza(zze.number, entry.getValue(), zzea.zzcm().zze(entry.getValue().getClass()));
                break;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(Object obj, zzby<zze> zzby) {
        ((zzd) obj).zzjv = zzby;
    }

    /* access modifiers changed from: 0000 */
    public final zzby<zze> zzb(Object obj) {
        zzby<zze> zza = zza(obj);
        if (!zza.isImmutable()) {
            return zza;
        }
        zzby<zze> zzby = (zzby) zza.clone();
        zza(obj, zzby);
        return zzby;
    }

    /* access modifiers changed from: 0000 */
    public final void zzc(Object obj) {
        zza(obj).zzv();
    }

    /* access modifiers changed from: 0000 */
    public final boolean zze(zzdo zzdo) {
        return zzdo instanceof zzd;
    }
}
