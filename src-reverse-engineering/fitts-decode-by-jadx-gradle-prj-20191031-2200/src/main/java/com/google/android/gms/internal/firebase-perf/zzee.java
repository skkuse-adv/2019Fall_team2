package com.google.android.gms.internal.firebase-perf;

import com.google.android.gms.internal.firebase-perf.zzep.zzd;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class zzee implements zzia {
    private final zzec zzmz;

    public static zzee zza(zzec zzec) {
        zzee zzee = zzec.zzni;
        if (zzee != null) {
            return zzee;
        }
        return new zzee(zzec);
    }

    private zzee(zzec zzec) {
        zzes.zza(zzec, "output");
        this.zzmz = zzec;
    }

    public final int zzgt() {
        return zzd.zzrg;
    }

    public final void zzq(int i, int i2) throws IOException {
        this.zzmz.zzj(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzmz.zza(i, j);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zzmz.zzc(i, j);
    }

    public final void zza(int i, float f) throws IOException {
        this.zzmz.zza(i, f);
    }

    public final void zza(int i, double d) throws IOException {
        this.zzmz.zza(i, d);
    }

    public final void zzr(int i, int i2) throws IOException {
        this.zzmz.zzg(i, i2);
    }

    public final void zza(int i, long j) throws IOException {
        this.zzmz.zza(i, j);
    }

    public final void zzg(int i, int i2) throws IOException {
        this.zzmz.zzg(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zzmz.zzc(i, j);
    }

    public final void zzj(int i, int i2) throws IOException {
        this.zzmz.zzj(i, i2);
    }

    public final void zza(int i, boolean z) throws IOException {
        this.zzmz.zza(i, z);
    }

    public final void zzb(int i, String str) throws IOException {
        this.zzmz.zzb(i, str);
    }

    public final void zza(int i, zzdl zzdl) throws IOException {
        this.zzmz.zza(i, zzdl);
    }

    public final void zzh(int i, int i2) throws IOException {
        this.zzmz.zzh(i, i2);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zzmz.zzi(i, i2);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zzmz.zzb(i, j);
    }

    public final void zza(int i, Object obj, zzgo zzgo) throws IOException {
        this.zzmz.zza(i, (zzfx) obj, zzgo);
    }

    public final void zzb(int i, Object obj, zzgo zzgo) throws IOException {
        zzec zzec = this.zzmz;
        zzfx zzfx = (zzfx) obj;
        zzec.zzf(i, 3);
        zzgo.zza(zzfx, zzec.zzni);
        zzec.zzf(i, 4);
    }

    public final void zzai(int i) throws IOException {
        this.zzmz.zzf(i, 3);
    }

    public final void zzaj(int i) throws IOException {
        this.zzmz.zzf(i, 4);
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzdl) {
            this.zzmz.zzb(i, (zzdl) obj);
        } else {
            this.zzmz.zza(i, (zzfx) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzz(((Integer) list.get(i4)).intValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzg(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzac(((Integer) list.get(i4)).intValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzx(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzj(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzap(((Long) list.get(i4)).longValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzam(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zza(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzaq(((Long) list.get(i4)).longValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzam(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zza(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzas(((Long) list.get(i4)).longValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzao(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzc(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzb(((Float) list.get(i4)).floatValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zza(((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zza(i, ((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzb(((Double) list.get(i4)).doubleValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zza(((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zza(i, ((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzae(((Integer) list.get(i4)).intValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzu(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzg(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zze(((Boolean) list.get(i4)).booleanValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzd(((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zza(i, ((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzfi) {
            zzfi zzfi = (zzfi) list;
            while (i2 < list.size()) {
                Object raw = zzfi.getRaw(i2);
                if (raw instanceof String) {
                    this.zzmz.zzb(i, (String) raw);
                } else {
                    this.zzmz.zza(i, (zzdl) raw);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzb(i, (String) list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzdl> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzmz.zza(i, (zzdl) list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzaa(((Integer) list.get(i4)).intValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzv(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzh(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzad(((Integer) list.get(i4)).intValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzx(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzj(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzat(((Long) list.get(i4)).longValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzao(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzc(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzab(((Integer) list.get(i4)).intValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzw(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzi(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmz.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzec.zzar(((Long) list.get(i4)).longValue());
            }
            this.zzmz.zzv(i3);
            while (i2 < list.size()) {
                this.zzmz.zzan(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmz.zzb(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzgo zzgo) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzgo);
        }
    }

    public final void zzb(int i, List<?> list, zzgo zzgo) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzgo);
        }
    }

    public final <K, V> void zza(int i, zzfs<K, V> zzfs, Map<K, V> map) throws IOException {
        for (Entry entry : map.entrySet()) {
            this.zzmz.zzf(i, 2);
            this.zzmz.zzv(zzfp.zza(zzfs, entry.getKey(), entry.getValue()));
            zzec zzec = this.zzmz;
            Object key = entry.getKey();
            Object value = entry.getValue();
            zzeh.zza(zzec, zzfs.zzst, 1, key);
            zzeh.zza(zzec, zzfs.zzsv, 2, value);
        }
    }
}
