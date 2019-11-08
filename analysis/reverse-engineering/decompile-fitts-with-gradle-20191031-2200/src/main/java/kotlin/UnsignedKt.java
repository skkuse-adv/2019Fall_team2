package kotlin;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class UnsignedKt {
    public static final int ulongCompare(long j, long j2) {
        return ((j ^ Long.MIN_VALUE) > (j2 ^ Long.MIN_VALUE) ? 1 : ((j ^ Long.MIN_VALUE) == (j2 ^ Long.MIN_VALUE) ? 0 : -1));
    }

    public static final int uintCompare(int i, int i2) {
        return Intrinsics.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    /* renamed from: uintDivide-J1ME1BU reason: not valid java name */
    public static final int m114uintDivideJ1ME1BU(int i, int i2) {
        return UInt.m39constructorimpl((int) ((((long) i) & 4294967295L) / (((long) i2) & 4294967295L)));
    }

    /* renamed from: uintRemainder-J1ME1BU reason: not valid java name */
    public static final int m115uintRemainderJ1ME1BU(int i, int i2) {
        return UInt.m39constructorimpl((int) ((((long) i) & 4294967295L) % (((long) i2) & 4294967295L)));
    }

    /* renamed from: ulongDivide-eb3DHEI reason: not valid java name */
    public static final long m116ulongDivideeb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return ulongCompare(j, j2) < 0 ? ULong.m65constructorimpl(0) : ULong.m65constructorimpl(1);
        } else if (j >= 0) {
            return ULong.m65constructorimpl(j / j2);
        } else {
            int i = 1;
            long j3 = ((j >>> 1) / j2) << 1;
            if (ulongCompare(ULong.m65constructorimpl(j - (j3 * j2)), ULong.m65constructorimpl(j2)) < 0) {
                i = 0;
            }
            return ULong.m65constructorimpl(j3 + ((long) i));
        }
    }

    /* renamed from: ulongRemainder-eb3DHEI reason: not valid java name */
    public static final long m117ulongRemaindereb3DHEI(long j, long j2) {
        if (j2 < 0) {
            if (ulongCompare(j, j2) >= 0) {
                j = ULong.m65constructorimpl(j - j2);
            }
            return j;
        } else if (j >= 0) {
            return ULong.m65constructorimpl(j % j2);
        } else {
            long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
            if (ulongCompare(ULong.m65constructorimpl(j3), ULong.m65constructorimpl(j2)) < 0) {
                j2 = 0;
            }
            return ULong.m65constructorimpl(j3 - j2);
        }
    }

    @NotNull
    public static final String ulongToString(long j) {
        return ulongToString(j, 10);
    }

    @NotNull
    public static final String ulongToString(long j, int i) {
        String str = "java.lang.Long.toString(this, checkRadix(radix))";
        if (j >= 0) {
            String l = Long.toString(j, CharsKt__CharJVMKt.checkRadix(i));
            Intrinsics.checkExpressionValueIsNotNull(l, str);
            return l;
        }
        long j2 = (long) i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String l2 = Long.toString(j3, CharsKt__CharJVMKt.checkRadix(i));
        Intrinsics.checkExpressionValueIsNotNull(l2, str);
        sb.append(l2);
        String l3 = Long.toString(j4, CharsKt__CharJVMKt.checkRadix(i));
        Intrinsics.checkExpressionValueIsNotNull(l3, str);
        sb.append(l3);
        return sb.toString();
    }
}
