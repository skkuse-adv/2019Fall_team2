package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzgz {
    private static final Class<?> zzalg = zzwf();
    private static final zzhp<?, ?> zzalh = zzt(false);
    private static final zzhp<?, ?> zzali = zzt(true);
    private static final zzhp<?, ?> zzalj = new zzhr();

    public static void zzg(Class<?> cls) {
        if (!zzey.class.isAssignableFrom(cls)) {
            Class<?> cls2 = zzalg;
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    public static void zza(int i, List<Double> list, zzim zzim, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzim zzim, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzim zzim, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzim zzim, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzim zzim, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzim zzim, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzim zzim, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzim zzim, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzim zzim, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzim zzim, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzim zzim, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzim zzim, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzim zzim, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzim zzim, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzim zzim) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzdp> list, zzim zzim) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzim zzim, zzgx zzgx) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zza(i, list, zzgx);
        }
    }

    public static void zzb(int i, List<?> list, zzim zzim, zzgx zzgx) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzim.zzb(i, list, zzgx);
        }
    }

    static int zzu(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfw) {
            zzfw zzfw = (zzfw) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzbq(zzfw.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzee.zzbq(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzu(list) + (list.size() * zzee.zzbi(i));
    }

    static int zzv(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfw) {
            zzfw zzfw = (zzfw) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzbr(zzfw.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzee.zzbr(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzee.zzbi(i));
    }

    static int zzw(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfw) {
            zzfw zzfw = (zzfw) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzbs(zzfw.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzee.zzbs(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzee.zzbi(i));
    }

    static int zzx(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfa) {
            zzfa zzfa = (zzfa) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzbo(zzfa.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzee.zzbo(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzx(list) + (size * zzee.zzbi(i));
    }

    static int zzy(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfa) {
            zzfa zzfa = (zzfa) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzbj(zzfa.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzee.zzbj(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzee.zzbi(i));
    }

    static int zzz(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfa) {
            zzfa zzfa = (zzfa) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzbk(zzfa.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzee.zzbk(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzz(list) + (size * zzee.zzbi(i));
    }

    static int zzaa(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfa) {
            zzfa zzfa = (zzfa) list;
            i = 0;
            while (i2 < size) {
                i += zzee.zzbl(zzfa.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzee.zzbl(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzaa(list) + (size * zzee.zzbi(i));
    }

    static int zzab(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzee.zzj(i, 0);
    }

    static int zzac(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzee.zzg(i, 0);
    }

    static int zzad(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzee.zzc(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzbi = zzee.zzbi(i) * size;
        if (list instanceof zzfp) {
            zzfp zzfp = (zzfp) list;
            while (i4 < size) {
                Object zzbw = zzfp.zzbw(i4);
                if (zzbw instanceof zzdp) {
                    i3 = zzee.zzb((zzdp) zzbw);
                } else {
                    i3 = zzee.zzds((String) zzbw);
                }
                zzbi += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzdp) {
                    i2 = zzee.zzb((zzdp) obj);
                } else {
                    i2 = zzee.zzds((String) obj);
                }
                zzbi += i2;
                i4++;
            }
        }
        return zzbi;
    }

    static int zzc(int i, Object obj, zzgx zzgx) {
        if (obj instanceof zzfn) {
            return zzee.zza(i, (zzfn) obj);
        }
        return zzee.zzb(i, (zzgi) obj, zzgx);
    }

    static int zzc(int i, List<?> list, zzgx zzgx) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbi = zzee.zzbi(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzfn) {
                i2 = zzee.zza((zzfn) obj);
            } else {
                i2 = zzee.zzb((zzgi) obj, zzgx);
            }
            zzbi += i2;
        }
        return zzbi;
    }

    static int zzd(int i, List<zzdp> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbi = size * zzee.zzbi(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzbi += zzee.zzb((zzdp) list.get(i2));
        }
        return zzbi;
    }

    static int zzd(int i, List<zzgi> list, zzgx zzgx) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzee.zzc(i, (zzgi) list.get(i3), zzgx);
        }
        return i2;
    }

    public static zzhp<?, ?> zzwc() {
        return zzalh;
    }

    public static zzhp<?, ?> zzwd() {
        return zzali;
    }

    public static zzhp<?, ?> zzwe() {
        return zzalj;
    }

    private static zzhp<?, ?> zzt(boolean z) {
        try {
            Class zzwg = zzwg();
            if (zzwg == null) {
                return null;
            }
            return (zzhp) zzwg.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzwf() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzwg() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzd(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T> void zza(zzgb zzgb, T t, T t2, long j) {
        zzhv.zza((Object) t, j, zzgb.zzb(zzhv.zzp(t, j), zzhv.zzp(t2, j)));
    }

    static <T, FT extends zzeq<FT>> void zza(zzen<FT> zzen, T t, T t2) {
        zzeo zzh = zzen.zzh(t2);
        if (!zzh.zzaex.isEmpty()) {
            zzen.zzi(t).zza(zzh);
        }
    }

    static <T, UT, UB> void zza(zzhp<UT, UB> zzhp, T t, T t2) {
        zzhp.zze(t, zzhp.zzg(zzhp.zzx(t), zzhp.zzx(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzfe zzfe, UB ub, zzhp<UT, UB> zzhp) {
        UB ub2;
        if (zzfe == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    if (!zzfe.zzg(intValue)) {
                        ub = zza(i, intValue, ub2, zzhp);
                        it.remove();
                    }
                }
                break loop1;
            }
        } else {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue2 = ((Integer) list.get(i3)).intValue();
                if (zzfe.zzg(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = zza(i, intValue2, ub2, zzhp);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        }
        return ub2;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzhp<UT, UB> zzhp) {
        if (ub == null) {
            ub = zzhp.zzwp();
        }
        zzhp.zza(ub, i, (long) i2);
        return ub;
    }
}
