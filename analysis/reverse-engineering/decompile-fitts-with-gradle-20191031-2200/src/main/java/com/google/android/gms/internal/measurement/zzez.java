package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzez {
    static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final byte[] zzair;

    public static int zzbx(long j) {
        return (int) (j ^ (j >>> 32));
    }

    static boolean zzf(zzgi zzgi) {
        return false;
    }

    public static int zzs(boolean z) {
        return z ? 1231 : 1237;
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzh(byte[] bArr) {
        return zzhy.zzh(bArr);
    }

    public static String zzi(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }

    static Object zza(Object obj, Object obj2) {
        return ((zzgi) obj).zzuo().zza((zzgi) obj2).zzuf();
    }

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzair = bArr;
        ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzair;
        zzeb.zza(bArr2, 0, bArr2.length, false);
    }
}
