package com.google.android.gms.internal.firebase_remote_config;

import com.kakao.message.template.MessageTemplateProtocol;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzkd {
    private static final Logger logger = Logger.getLogger(zzkd.class.getName());
    private static final Class<?> zzon = zzfu.zzev();
    private static final boolean zzpv = zzjg();
    private static final Unsafe zzvq = zzjf();
    private static final boolean zzxm = zzp(Long.TYPE);
    private static final boolean zzxn = zzp(Integer.TYPE);
    private static final zzd zzxo;
    private static final boolean zzxp = zzjh();
    private static final long zzxq = ((long) zzn(byte[].class));
    static final boolean zzyf = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zzkd.zzyf) {
                return zzkd.zzq(obj, j);
            }
            return zzkd.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzkd.zzyf) {
                zzkd.zza(obj, j, b);
            } else {
                zzkd.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzkd.zzyf) {
                return zzkd.zzs(obj, j);
            }
            return zzkd.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzkd.zzyf) {
                zzkd.zzb(obj, j, z);
            } else {
                zzkd.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzyi.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzyi.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzyi.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzyi.putBoolean(obj, j, z);
        }

        public final float zzn(Object obj, long j) {
            return this.zzyi.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzyi.putFloat(obj, j, f);
        }

        public final double zzo(Object obj, long j) {
            return this.zzyi.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzyi.putDouble(obj, j, d);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zzkd.zzyf) {
                return zzkd.zzq(obj, j);
            }
            return zzkd.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzkd.zzyf) {
                zzkd.zza(obj, j, b);
            } else {
                zzkd.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzkd.zzyf) {
                return zzkd.zzs(obj, j);
            }
            return zzkd.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzkd.zzyf) {
                zzkd.zzb(obj, j, z);
            } else {
                zzkd.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static abstract class zzd {
        Unsafe zzyi;

        zzd(Unsafe unsafe) {
            this.zzyi = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzyi.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzyi.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzyi.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzyi.putLong(obj, j, j2);
        }
    }

    private zzkd() {
    }

    static boolean zzjd() {
        return zzpv;
    }

    static boolean zzje() {
        return zzxp;
    }

    static <T> T zzm(Class<T> cls) {
        try {
            return zzvq.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzn(Class<?> cls) {
        if (zzpv) {
            return zzxo.zzyi.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzo(Class<?> cls) {
        if (zzpv) {
            return zzxo.zzyi.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzxo.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzxo.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzxo.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzxo.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzxo.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzxo.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzxo.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzxo.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzxo.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzxo.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzxo.zzyi.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzxo.zzyi.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzxo.zzy(bArr, zzxq + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzxo.zze(bArr, zzxq + j, b);
    }

    static Unsafe zzjf() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzkf());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzjg() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzvq;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls2.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls2.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls2.getMethod("getInt", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putInt", new Class[]{cls, Long.TYPE, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putLong", new Class[]{cls, Long.TYPE, Long.TYPE});
            cls2.getMethod("getObject", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putObject", new Class[]{cls, Long.TYPE, cls});
            if (zzfu.zzeu()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putByte", new Class[]{cls, Long.TYPE, Byte.TYPE});
            cls2.getMethod("getBoolean", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putBoolean", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("getFloat", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putFloat", new Class[]{cls, Long.TYPE, Float.TYPE});
            cls2.getMethod("getDouble", new Class[]{cls, Long.TYPE});
            cls2.getMethod("putDouble", new Class[]{cls, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzjh() {
        String str = "copyMemory";
        String str2 = "getLong";
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzvq;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls2.getMethod(str2, new Class[]{cls, Long.TYPE});
            if (zzji() == null) {
                return false;
            }
            if (zzfu.zzeu()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{Long.TYPE});
            cls2.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls2.getMethod("getInt", new Class[]{Long.TYPE});
            cls2.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls2.getMethod(str2, new Class[]{Long.TYPE});
            cls2.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls2.getMethod(str, new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls2.getMethod(str, new Class[]{cls, Long.TYPE, cls, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzp(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzfu.zzeu()) {
            return false;
        }
        try {
            Class<?> cls3 = zzon;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field zzji() {
        if (zzfu.zzeu()) {
            Field zzb2 = zzb(Buffer.class, "effectiveDirectAddress");
            if (zzb2 != null) {
                return zzb2;
            }
        }
        Field zzb3 = zzb(Buffer.class, MessageTemplateProtocol.ADDRESS);
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    static {
        Class<Object[]> cls = Object[].class;
        Class<double[]> cls2 = double[].class;
        Class<float[]> cls3 = float[].class;
        Class<long[]> cls4 = long[].class;
        Class<int[]> cls5 = int[].class;
        Class<boolean[]> cls6 = boolean[].class;
        zzd zzd2 = null;
        if (zzvq != null) {
            if (!zzfu.zzeu()) {
                zzd2 = new zzb(zzvq);
            } else if (zzxm) {
                zzd2 = new zzc(zzvq);
            } else if (zzxn) {
                zzd2 = new zza(zzvq);
            }
        }
        zzxo = zzd2;
        zzn(cls6);
        zzo(cls6);
        zzn(cls5);
        zzo(cls5);
        zzn(cls4);
        zzo(cls4);
        zzn(cls3);
        zzo(cls3);
        zzn(cls2);
        zzo(cls2);
        zzn(cls);
        zzo(cls);
        Field zzji = zzji();
        if (zzji != null) {
            zzd zzd3 = zzxo;
            if (zzd3 != null) {
                zzd3.zzyi.objectFieldOffset(zzji);
            }
        }
    }
}
