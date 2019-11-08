package com.google.android.gms.internal.firebase-perf;

import com.kakao.message.template.MessageTemplateProtocol;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzhm {
    private static final Logger logger = Logger.getLogger(zzhm.class.getName());
    private static final Class<?> zzmq = zzdj.zzgd();
    private static final boolean zznh = zzjk();
    private static final Unsafe zzta = zzjj();
    private static final boolean zzux = zzj(Long.TYPE);
    private static final boolean zzuy = zzj(Integer.TYPE);
    private static final zzc zzuz;
    private static final boolean zzva = zzjl();
    private static final long zzvb = ((long) zzh(byte[].class));
    static final boolean zzvq = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    static final class zza extends zzc {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzx(Object obj, long j) {
            if (zzhm.zzvq) {
                return zzhm.zzp(obj, j);
            }
            return zzhm.zzq(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzhm.zzvq) {
                zzhm.zza(obj, j, b);
            } else {
                zzhm.zzb(obj, j, b);
            }
        }

        public final boolean zzl(Object obj, long j) {
            if (zzhm.zzvq) {
                return zzhm.zzr(obj, j);
            }
            return zzhm.zzs(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzhm.zzvq) {
                zzhm.zzb(obj, j, z);
            } else {
                zzhm.zzc(obj, j, z);
            }
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static final class zzb extends zzc {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzx(Object obj, long j) {
            if (zzhm.zzvq) {
                return zzhm.zzp(obj, j);
            }
            return zzhm.zzq(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzhm.zzvq) {
                zzhm.zza(obj, j, b);
            } else {
                zzhm.zzb(obj, j, b);
            }
        }

        public final boolean zzl(Object obj, long j) {
            if (zzhm.zzvq) {
                return zzhm.zzr(obj, j);
            }
            return zzhm.zzs(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzhm.zzvq) {
                zzhm.zzb(obj, j, z);
            } else {
                zzhm.zzc(obj, j, z);
            }
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static abstract class zzc {
        Unsafe zzvr;

        zzc(Unsafe unsafe) {
            this.zzvr = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzl(Object obj, long j);

        public abstract float zzm(Object obj, long j);

        public abstract double zzn(Object obj, long j);

        public abstract byte zzx(Object obj, long j);

        public final int zzj(Object obj, long j) {
            return this.zzvr.getInt(obj, j);
        }

        public final void zza(Object obj, long j, int i) {
            this.zzvr.putInt(obj, j, i);
        }

        public final long zzk(Object obj, long j) {
            return this.zzvr.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzvr.putLong(obj, j, j2);
        }
    }

    static final class zzd extends zzc {
        zzd(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzx(Object obj, long j) {
            return this.zzvr.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzvr.putByte(obj, j, b);
        }

        public final boolean zzl(Object obj, long j) {
            return this.zzvr.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzvr.putBoolean(obj, j, z);
        }

        public final float zzm(Object obj, long j) {
            return this.zzvr.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzvr.putFloat(obj, j, f);
        }

        public final double zzn(Object obj, long j) {
            return this.zzvr.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzvr.putDouble(obj, j, d);
        }
    }

    private zzhm() {
    }

    static boolean zzjh() {
        return zznh;
    }

    static boolean zzji() {
        return zzva;
    }

    static <T> T zzg(Class<T> cls) {
        try {
            return zzta.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzh(Class<?> cls) {
        if (zznh) {
            return zzuz.zzvr.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzi(Class<?> cls) {
        if (zznh) {
            return zzuz.zzvr.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzj(Object obj, long j) {
        return zzuz.zzj(obj, j);
    }

    static void zza(Object obj, long j, int i) {
        zzuz.zza(obj, j, i);
    }

    static long zzk(Object obj, long j) {
        return zzuz.zzk(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzuz.zza(obj, j, j2);
    }

    static boolean zzl(Object obj, long j) {
        return zzuz.zzl(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzuz.zza(obj, j, z);
    }

    static float zzm(Object obj, long j) {
        return zzuz.zzm(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzuz.zza(obj, j, f);
    }

    static double zzn(Object obj, long j) {
        return zzuz.zzn(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzuz.zza(obj, j, d);
    }

    static Object zzo(Object obj, long j) {
        return zzuz.zzvr.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzuz.zzvr.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzuz.zzx(bArr, zzvb + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzuz.zze(bArr, zzvb + j, b);
    }

    static Unsafe zzjj() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhl());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzjk() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzta;
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
            if (zzdj.zzgc()) {
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

    private static boolean zzjl() {
        String str = "copyMemory";
        String str2 = "getLong";
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzta;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls2.getMethod(str2, new Class[]{cls, Long.TYPE});
            if (zzjm() == null) {
                return false;
            }
            if (zzdj.zzgc()) {
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

    private static boolean zzj(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzdj.zzgc()) {
            return false;
        }
        try {
            Class<?> cls3 = zzmq;
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

    private static Field zzjm() {
        if (zzdj.zzgc()) {
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
    public static byte zzp(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static boolean zzr(Object obj, long j) {
        return zzp(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
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
        zzc zzc2 = null;
        if (zzta != null) {
            if (!zzdj.zzgc()) {
                zzc2 = new zzd(zzta);
            } else if (zzux) {
                zzc2 = new zza(zzta);
            } else if (zzuy) {
                zzc2 = new zzb(zzta);
            }
        }
        zzuz = zzc2;
        zzh(cls6);
        zzi(cls6);
        zzh(cls5);
        zzi(cls5);
        zzh(cls4);
        zzi(cls4);
        zzh(cls3);
        zzi(cls3);
        zzh(cls2);
        zzi(cls2);
        zzh(cls);
        zzi(cls);
        Field zzjm = zzjm();
        if (zzjm != null) {
            zzc zzc3 = zzuz;
            if (zzc3 != null) {
                zzc3.zzvr.objectFieldOffset(zzjm);
            }
        }
    }
}
