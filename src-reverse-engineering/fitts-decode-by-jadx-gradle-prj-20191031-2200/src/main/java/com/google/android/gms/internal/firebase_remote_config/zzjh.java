package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzjh {
    private static final Class<?> zzwo = zzip();
    private static final zzjx<?, ?> zzwp = zzg(false);
    private static final zzjx<?, ?> zzwq = zzg(true);
    private static final zzjx<?, ?> zzwr = new zzjz();

    public static void zzl(Class<?> cls) {
        if (!zzhi.class.isAssignableFrom(cls)) {
            Class<?> cls2 = zzwo;
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    public static void zza(int i, List<Double> list, zzku zzku, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzku zzku, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzku zzku, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzku zzku, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzku zzku, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzku zzku, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzku zzku, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzku zzku, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzku zzku, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzku zzku, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzku zzku, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzku zzku, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzku zzku, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzku zzku, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzku zzku) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzfx> list, zzku zzku) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzku zzku, zzjf zzjf) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zza(i, list, zzjf);
        }
    }

    public static void zzb(int i, List<?> list, zzku zzku, zzjf zzjf) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzku.zzb(i, list, zzjf);
        }
    }

    static int zzs(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzie) {
            zzie zzie = (zzie) list;
            i = 0;
            while (i2 < size) {
                i += zzgs.zzi(zzie.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgs.zzi(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzs(list) + (list.size() * zzgs.zzaq(i));
    }

    static int zzt(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzie) {
            zzie zzie = (zzie) list;
            i = 0;
            while (i2 < size) {
                i += zzgs.zzj(zzie.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgs.zzj(((Long) list.get(i2)).longValue());
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
        return zzt(list) + (size * zzgs.zzaq(i));
    }

    static int zzu(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzie) {
            zzie zzie = (zzie) list;
            i = 0;
            while (i2 < size) {
                i += zzgs.zzk(zzie.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgs.zzk(((Long) list.get(i2)).longValue());
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
        return zzu(list) + (size * zzgs.zzaq(i));
    }

    static int zzv(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhk) {
            zzhk zzhk = (zzhk) list;
            i = 0;
            while (i2 < size) {
                i += zzgs.zzaw(zzhk.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgs.zzaw(((Integer) list.get(i2)).intValue());
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
        return zzv(list) + (size * zzgs.zzaq(i));
    }

    static int zzw(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhk) {
            zzhk zzhk = (zzhk) list;
            i = 0;
            while (i2 < size) {
                i += zzgs.zzar(zzhk.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgs.zzar(((Integer) list.get(i2)).intValue());
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
        return zzw(list) + (size * zzgs.zzaq(i));
    }

    static int zzx(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhk) {
            zzhk zzhk = (zzhk) list;
            i = 0;
            while (i2 < size) {
                i += zzgs.zzas(zzhk.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgs.zzas(((Integer) list.get(i2)).intValue());
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
        return zzx(list) + (size * zzgs.zzaq(i));
    }

    static int zzy(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhk) {
            zzhk zzhk = (zzhk) list;
            i = 0;
            while (i2 < size) {
                i += zzgs.zzat(zzhk.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgs.zzat(((Integer) list.get(i2)).intValue());
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
        return zzy(list) + (size * zzgs.zzaq(i));
    }

    static int zzz(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzgs.zzk(i, 0);
    }

    static int zzaa(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzgs.zzg(i, 0);
    }

    static int zzab(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzgs.zzd(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzaq = zzgs.zzaq(i) * size;
        if (list instanceof zzhx) {
            zzhx zzhx = (zzhx) list;
            while (i4 < size) {
                Object zzbd = zzhx.zzbd(i4);
                if (zzbd instanceof zzfx) {
                    i3 = zzgs.zzc((zzfx) zzbd);
                } else {
                    i3 = zzgs.zzbl((String) zzbd);
                }
                zzaq += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzfx) {
                    i2 = zzgs.zzc((zzfx) obj);
                } else {
                    i2 = zzgs.zzbl((String) obj);
                }
                zzaq += i2;
                i4++;
            }
        }
        return zzaq;
    }

    static int zzc(int i, Object obj, zzjf zzjf) {
        if (obj instanceof zzhv) {
            return zzgs.zza(i, (zzhv) obj);
        }
        return zzgs.zzb(i, (zziq) obj, zzjf);
    }

    static int zzc(int i, List<?> list, zzjf zzjf) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzaq = zzgs.zzaq(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzhv) {
                i2 = zzgs.zza((zzhv) obj);
            } else {
                i2 = zzgs.zza((zziq) obj, zzjf);
            }
            zzaq += i2;
        }
        return zzaq;
    }

    static int zzd(int i, List<zzfx> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzaq = size * zzgs.zzaq(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzaq += zzgs.zzc((zzfx) list.get(i2));
        }
        return zzaq;
    }

    static int zzd(int i, List<zziq> list, zzjf zzjf) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzgs.zzc(i, (zziq) list.get(i3), zzjf);
        }
        return i2;
    }

    public static zzjx<?, ?> zzim() {
        return zzwp;
    }

    public static zzjx<?, ?> zzin() {
        return zzwq;
    }

    public static zzjx<?, ?> zzio() {
        return zzwr;
    }

    private static zzjx<?, ?> zzg(boolean z) {
        try {
            Class zziq = zziq();
            if (zziq == null) {
                return null;
            }
            return (zzjx) zziq.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzip() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zziq() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzf(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T> void zza(zzij zzij, T t, T t2, long j) {
        zzkd.zza((Object) t, j, zzij.zzd(zzkd.zzp(t, j), zzkd.zzp(t2, j)));
    }

    static <T, FT extends zzhc<FT>> void zza(zzgz<FT> zzgz, T t, T t2) {
        zzha zzk = zzgz.zzk(t2);
        if (!zzk.zzqf.isEmpty()) {
            zzgz.zzl(t).zza(zzk);
        }
    }

    static <T, UT, UB> void zza(zzjx<UT, UB> zzjx, T t, T t2) {
        zzjx.zzg(t, zzjx.zzi(zzjx.zzaa(t), zzjx.zzaa(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzho zzho, UB ub, zzjx<UT, UB> zzjx) {
        UB ub2;
        if (zzho == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    int intValue = ((Integer) it.next()).intValue();
                    if (!zzho.zzbc(intValue)) {
                        ub = zza(i, intValue, ub2, zzjx);
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
                if (zzho.zzbc(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = zza(i, intValue2, ub2, zzjx);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        }
        return ub2;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzjx<UT, UB> zzjx) {
        if (ub == null) {
            ub = zzjx.zziz();
        }
        zzjx.zza(ub, i, (long) i2);
        return ub;
    }
}
