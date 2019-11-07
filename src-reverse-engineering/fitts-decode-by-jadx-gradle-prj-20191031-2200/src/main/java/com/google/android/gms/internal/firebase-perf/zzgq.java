package com.google.android.gms.internal.firebase-perf;

import java.io.IOException;
import java.util.List;

final class zzgq {
    private static final Class<?> zzue = zzja();
    private static final zzhg<?, ?> zzuf = zzg(false);
    private static final zzhg<?, ?> zzug = zzg(true);
    private static final zzhg<?, ?> zzuh = new zzhi();

    public static void zzf(Class<?> cls) {
        if (!zzep.class.isAssignableFrom(cls)) {
            Class<?> cls2 = zzue;
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    public static void zza(int i, List<Double> list, zzia zzia, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzia zzia, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzia zzia, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzia zzia, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzia zzia, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzia zzia, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzia zzia, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzia zzia, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzia zzia, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzia zzia, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzia zzia, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzia zzia, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzia zzia, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzia zzia, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzia zzia) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzdl> list, zzia zzia) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzia zzia, zzgo zzgo) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zza(i, list, zzgo);
        }
    }

    public static void zzb(int i, List<?> list, zzia zzia, zzgo zzgo) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzia.zzb(i, list, zzgo);
        }
    }

    static int zzd(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfl) {
            zzfl zzfl = (zzfl) list;
            i = 0;
            while (i2 < size) {
                i += zzec.zzap(zzfl.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzec.zzap(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzd(list) + (list.size() * zzec.zzy(i));
    }

    static int zze(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfl) {
            zzfl zzfl = (zzfl) list;
            i = 0;
            while (i2 < size) {
                i += zzec.zzaq(zzfl.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzec.zzaq(((Long) list.get(i2)).longValue());
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
        return zze(list) + (size * zzec.zzy(i));
    }

    static int zzf(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfl) {
            zzfl zzfl = (zzfl) list;
            i = 0;
            while (i2 < size) {
                i += zzec.zzar(zzfl.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzec.zzar(((Long) list.get(i2)).longValue());
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
        return zzf(list) + (size * zzec.zzy(i));
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeq) {
            zzeq zzeq = (zzeq) list;
            i = 0;
            while (i2 < size) {
                i += zzec.zzae(zzeq.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzec.zzae(((Integer) list.get(i2)).intValue());
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
        return zzg(list) + (size * zzec.zzy(i));
    }

    static int zzh(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeq) {
            zzeq zzeq = (zzeq) list;
            i = 0;
            while (i2 < size) {
                i += zzec.zzz(zzeq.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzec.zzz(((Integer) list.get(i2)).intValue());
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
        return zzh(list) + (size * zzec.zzy(i));
    }

    static int zzi(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeq) {
            zzeq zzeq = (zzeq) list;
            i = 0;
            while (i2 < size) {
                i += zzec.zzaa(zzeq.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzec.zzaa(((Integer) list.get(i2)).intValue());
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
        return zzi(list) + (size * zzec.zzy(i));
    }

    static int zzj(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeq) {
            zzeq zzeq = (zzeq) list;
            i = 0;
            while (i2 < size) {
                i += zzec.zzab(zzeq.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzec.zzab(((Integer) list.get(i2)).intValue());
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
        return zzj(list) + (size * zzec.zzy(i));
    }

    static int zzk(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzec.zzn(i, 0);
    }

    static int zzl(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzec.zzg(i, 0);
    }

    static int zzm(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzec.zzb(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzy = zzec.zzy(i) * size;
        if (list instanceof zzfi) {
            zzfi zzfi = (zzfi) list;
            while (i4 < size) {
                Object raw = zzfi.getRaw(i4);
                if (raw instanceof zzdl) {
                    i3 = zzec.zzb((zzdl) raw);
                } else {
                    i3 = zzec.zzah((String) raw);
                }
                zzy += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzdl) {
                    i2 = zzec.zzb((zzdl) obj);
                } else {
                    i2 = zzec.zzah((String) obj);
                }
                zzy += i2;
                i4++;
            }
        }
        return zzy;
    }

    static int zzc(int i, Object obj, zzgo zzgo) {
        if (obj instanceof zzfg) {
            return zzec.zza(i, (zzfg) obj);
        }
        return zzec.zzb(i, (zzfx) obj, zzgo);
    }

    static int zzc(int i, List<?> list, zzgo zzgo) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = zzec.zzy(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzfg) {
                i2 = zzec.zza((zzfg) obj);
            } else {
                i2 = zzec.zza((zzfx) obj, zzgo);
            }
            zzy += i2;
        }
        return zzy;
    }

    static int zzd(int i, List<zzdl> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = size * zzec.zzy(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzy += zzec.zzb((zzdl) list.get(i2));
        }
        return zzy;
    }

    static int zzd(int i, List<zzfx> list, zzgo zzgo) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzec.zzc(i, (zzfx) list.get(i3), zzgo);
        }
        return i2;
    }

    public static zzhg<?, ?> zzix() {
        return zzuf;
    }

    public static zzhg<?, ?> zziy() {
        return zzug;
    }

    public static zzhg<?, ?> zziz() {
        return zzuh;
    }

    private static zzhg<?, ?> zzg(boolean z) {
        try {
            Class zzjb = zzjb();
            if (zzjb == null) {
                return null;
            }
            return (zzhg) zzjb.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzja() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzjb() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzf(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T> void zza(zzfu zzfu, T t, T t2, long j) {
        zzhm.zza((Object) t, j, zzfu.zzd(zzhm.zzo(t, j), zzhm.zzo(t2, j)));
    }

    static <T, FT extends zzej<FT>> void zza(zzeg<FT> zzeg, T t, T t2) {
        zzeh zzc = zzeg.zzc(t2);
        if (!zzc.zznp.isEmpty()) {
            zzeg.zzd(t).zza(zzc);
        }
    }

    static <T, UT, UB> void zza(zzhg<UT, UB> zzhg, T t, T t2) {
        zzhg.zzg(t, zzhg.zzh(zzhg.zzo(t), zzhg.zzo(t2)));
    }
}
