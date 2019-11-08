package com.google.android.gms.internal.measurement;

import com.kakao.message.template.MessageTemplateProtocol;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzhv {
    private static final Logger logger = Logger.getLogger(zzhv.class.getName());
    private static final Class<?> zzacx = zzdi.zzrw();
    private static final boolean zzaec = zzww();
    private static final Unsafe zzaki = zzwv();
    private static final boolean zzame = zzk(Long.TYPE);
    private static final boolean zzamf = zzk(Integer.TYPE);
    private static final zzd zzamg;
    private static final boolean zzamh = zzwx();
    static final long zzami = ((long) zzi(byte[].class));
    private static final long zzamv;
    static final boolean zzamx = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte((int) (j & -1), b);
        }

        public final byte zzy(Object obj, long j) {
            if (zzhv.zzamx) {
                return zzhv.zzq(obj, j);
            }
            return zzhv.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzhv.zzamx) {
                zzhv.zza(obj, j, b);
            } else {
                zzhv.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzhv.zzamx) {
                return zzhv.zzs(obj, j);
            }
            return zzhv.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzhv.zzamx) {
                zzhv.zzb(obj, j, z);
            } else {
                zzhv.zzc(obj, j, z);
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

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & -1), bArr, (int) j, (int) j3);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            this.zzana.putByte(j, b);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzana.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzana.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzana.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzana.putBoolean(obj, j, z);
        }

        public final float zzn(Object obj, long j) {
            return this.zzana.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzana.putFloat(obj, j, f);
        }

        public final double zzo(Object obj, long j) {
            return this.zzana.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzana.putDouble(obj, j, d);
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            this.zzana.copyMemory(bArr, zzhv.zzami + j, null, j2, j3);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        public final byte zzy(Object obj, long j) {
            if (zzhv.zzamx) {
                return zzhv.zzq(obj, j);
            }
            return zzhv.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzhv.zzamx) {
                zzhv.zza(obj, j, b);
            } else {
                zzhv.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zzhv.zzamx) {
                return zzhv.zzs(obj, j);
            }
            return zzhv.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzhv.zzamx) {
                zzhv.zzb(obj, j, z);
            } else {
                zzhv.zzc(obj, j, z);
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

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }
    }

    static abstract class zzd {
        Unsafe zzana;

        zzd(Unsafe unsafe) {
            this.zzana = unsafe;
        }

        public abstract void zza(long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zza(byte[] bArr, long j, long j2, long j3);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzana.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzana.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzana.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzana.putLong(obj, j, j2);
        }
    }

    private zzhv() {
    }

    static boolean zzwt() {
        return zzaec;
    }

    static boolean zzwu() {
        return zzamh;
    }

    static <T> T zzh(Class<T> cls) {
        try {
            return zzaki.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzi(Class<?> cls) {
        if (zzaec) {
            return zzamg.zzana.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzj(Class<?> cls) {
        if (zzaec) {
            return zzamg.zzana.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzamg.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzamg.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzamg.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzamg.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzamg.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzamg.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzamg.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzamg.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzamg.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzamg.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzamg.zzana.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzamg.zzana.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzamg.zzy(bArr, zzami + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzamg.zze(bArr, zzami + j, b);
    }

    static void zza(byte[] bArr, long j, long j2, long j3) {
        zzamg.zza(bArr, j, j2, j3);
    }

    static void zza(long j, byte b) {
        zzamg.zza(j, b);
    }

    static long zzb(ByteBuffer byteBuffer) {
        return zzamg.zzl(byteBuffer, zzamv);
    }

    static Unsafe zzwv() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhx());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzww() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzaki;
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
            if (zzdi.zzrv()) {
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

    private static boolean zzwx() {
        String str = "copyMemory";
        String str2 = "getLong";
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzaki;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls2.getMethod(str2, new Class[]{cls, Long.TYPE});
            if (zzwy() == null) {
                return false;
            }
            if (zzdi.zzrv()) {
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

    private static boolean zzk(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzdi.zzrv()) {
            return false;
        }
        try {
            Class<?> cls3 = zzacx;
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

    private static Field zzwy() {
        if (zzdi.zzrv()) {
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

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ba  */
    static {
        /*
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            java.lang.Class<double[]> r1 = double[].class
            java.lang.Class<float[]> r2 = float[].class
            java.lang.Class<long[]> r3 = long[].class
            java.lang.Class<int[]> r4 = int[].class
            java.lang.Class<boolean[]> r5 = boolean[].class
            java.lang.Class<com.google.android.gms.internal.measurement.zzhv> r6 = com.google.android.gms.internal.measurement.zzhv.class
            java.lang.String r6 = r6.getName()
            java.util.logging.Logger r6 = java.util.logging.Logger.getLogger(r6)
            logger = r6
            sun.misc.Unsafe r6 = zzwv()
            zzaki = r6
            java.lang.Class r6 = com.google.android.gms.internal.measurement.zzdi.zzrw()
            zzacx = r6
            java.lang.Class r6 = java.lang.Long.TYPE
            boolean r6 = zzk(r6)
            zzame = r6
            java.lang.Class r6 = java.lang.Integer.TYPE
            boolean r6 = zzk(r6)
            zzamf = r6
            sun.misc.Unsafe r6 = zzaki
            r7 = 0
            if (r6 != 0) goto L_0x003a
            goto L_0x005f
        L_0x003a:
            boolean r6 = com.google.android.gms.internal.measurement.zzdi.zzrv()
            if (r6 == 0) goto L_0x0058
            boolean r6 = zzame
            if (r6 == 0) goto L_0x004c
            com.google.android.gms.internal.measurement.zzhv$zzc r7 = new com.google.android.gms.internal.measurement.zzhv$zzc
            sun.misc.Unsafe r6 = zzaki
            r7.<init>(r6)
            goto L_0x005f
        L_0x004c:
            boolean r6 = zzamf
            if (r6 == 0) goto L_0x005f
            com.google.android.gms.internal.measurement.zzhv$zza r7 = new com.google.android.gms.internal.measurement.zzhv$zza
            sun.misc.Unsafe r6 = zzaki
            r7.<init>(r6)
            goto L_0x005f
        L_0x0058:
            com.google.android.gms.internal.measurement.zzhv$zzb r7 = new com.google.android.gms.internal.measurement.zzhv$zzb
            sun.misc.Unsafe r6 = zzaki
            r7.<init>(r6)
        L_0x005f:
            zzamg = r7
            boolean r6 = zzwx()
            zzamh = r6
            boolean r6 = zzww()
            zzaec = r6
            java.lang.Class<byte[]> r6 = byte[].class
            int r6 = zzi(r6)
            long r6 = (long) r6
            zzami = r6
            zzi(r5)
            zzj(r5)
            zzi(r4)
            zzj(r4)
            zzi(r3)
            zzj(r3)
            zzi(r2)
            zzj(r2)
            zzi(r1)
            zzj(r1)
            zzi(r0)
            zzj(r0)
            java.lang.reflect.Field r0 = zzwy()
            if (r0 == 0) goto L_0x00ac
            com.google.android.gms.internal.measurement.zzhv$zzd r1 = zzamg
            if (r1 != 0) goto L_0x00a5
            goto L_0x00ac
        L_0x00a5:
            sun.misc.Unsafe r1 = r1.zzana
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00ae
        L_0x00ac:
            r0 = -1
        L_0x00ae:
            zzamv = r0
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00ba
            r0 = 1
            goto L_0x00bb
        L_0x00ba:
            r0 = 0
        L_0x00bb:
            zzamx = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhv.<clinit>():void");
    }
}
