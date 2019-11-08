package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhi.zze;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class zzgu implements zzku {
    private final zzgs zzpb;

    public static zzgu zza(zzgs zzgs) {
        zzgu zzgu = zzgs.zzpw;
        if (zzgu != null) {
            return zzgu;
        }
        return new zzgu(zzgs);
    }

    private zzgu(zzgs zzgs) {
        zzhm.zza(zzgs, "output");
        this.zzpb = zzgs;
    }

    public final int zzgd() {
        return zze.zztx;
    }

    public final void zzn(int i, int i2) throws IOException {
        this.zzpb.zzg(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzpb.zza(i, j);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zzpb.zzc(i, j);
    }

    public final void zza(int i, float f) throws IOException {
        this.zzpb.zza(i, f);
    }

    public final void zza(int i, double d) throws IOException {
        this.zzpb.zza(i, d);
    }

    public final void zzo(int i, int i2) throws IOException {
        this.zzpb.zzd(i, i2);
    }

    public final void zza(int i, long j) throws IOException {
        this.zzpb.zza(i, j);
    }

    public final void zzd(int i, int i2) throws IOException {
        this.zzpb.zzd(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zzpb.zzc(i, j);
    }

    public final void zzg(int i, int i2) throws IOException {
        this.zzpb.zzg(i, i2);
    }

    public final void zzc(int i, boolean z) throws IOException {
        this.zzpb.zzc(i, z);
    }

    public final void zzb(int i, String str) throws IOException {
        this.zzpb.zzb(i, str);
    }

    public final void zza(int i, zzfx zzfx) throws IOException {
        this.zzpb.zza(i, zzfx);
    }

    public final void zze(int i, int i2) throws IOException {
        this.zzpb.zze(i, i2);
    }

    public final void zzf(int i, int i2) throws IOException {
        this.zzpb.zzf(i, i2);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zzpb.zzb(i, j);
    }

    public final void zza(int i, Object obj, zzjf zzjf) throws IOException {
        this.zzpb.zza(i, (zziq) obj, zzjf);
    }

    public final void zzb(int i, Object obj, zzjf zzjf) throws IOException {
        zzgs zzgs = this.zzpb;
        zziq zziq = (zziq) obj;
        zzgs.zzc(i, 3);
        zzjf.zza(zziq, zzgs.zzpw);
        zzgs.zzc(i, 4);
    }

    public final void zzaz(int i) throws IOException {
        this.zzpb.zzc(i, 3);
    }

    public final void zzba(int i) throws IOException {
        this.zzpb.zzc(i, 4);
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzfx) {
            this.zzpb.zzb(i, (zzfx) obj);
        } else {
            this.zzpb.zza(i, (zziq) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzar(((Integer) list.get(i4)).intValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzam(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzd(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzau(((Integer) list.get(i4)).intValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzap(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzg(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzi(((Long) list.get(i4)).longValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzf(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zza(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzj(((Long) list.get(i4)).longValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzf(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zza(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzl(((Long) list.get(i4)).longValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzh(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzc(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzc(((Float) list.get(i4)).floatValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzb(((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zza(i, ((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzd(((Double) list.get(i4)).doubleValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzc(((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zza(i, ((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzaw(((Integer) list.get(i4)).intValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzam(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzd(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zze(((Boolean) list.get(i4)).booleanValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzd(((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzc(i, ((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzhx) {
            zzhx zzhx = (zzhx) list;
            while (i2 < list.size()) {
                Object zzbd = zzhx.zzbd(i2);
                if (zzbd instanceof String) {
                    this.zzpb.zzb(i, (String) zzbd);
                } else {
                    this.zzpb.zza(i, (zzfx) zzbd);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzb(i, (String) list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzfx> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzpb.zza(i, (zzfx) list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzas(((Integer) list.get(i4)).intValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzan(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zze(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzav(((Integer) list.get(i4)).intValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzap(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzg(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzm(((Long) list.get(i4)).longValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzh(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzc(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzat(((Integer) list.get(i4)).intValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzao(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzf(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzpb.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzgs.zzk(((Long) list.get(i4)).longValue());
            }
            this.zzpb.zzan(i3);
            while (i2 < list.size()) {
                this.zzpb.zzg(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzpb.zzb(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzjf zzjf) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzjf);
        }
    }

    public final void zzb(int i, List<?> list, zzjf zzjf) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzjf);
        }
    }

    public final <K, V> void zza(int i, zzih<K, V> zzih, Map<K, V> map) throws IOException {
        for (Entry entry : map.entrySet()) {
            this.zzpb.zzc(i, 2);
            this.zzpb.zzan(zzii.zza(zzih, entry.getKey(), entry.getValue()));
            zzii.zza(this.zzpb, zzih, entry.getKey(), entry.getValue());
        }
    }
}
