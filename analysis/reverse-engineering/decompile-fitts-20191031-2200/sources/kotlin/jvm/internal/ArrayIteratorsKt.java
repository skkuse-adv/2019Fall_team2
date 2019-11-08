package kotlin.jvm.internal;

import kotlin.collections.BooleanIterator;
import kotlin.collections.ByteIterator;
import kotlin.collections.CharIterator;
import kotlin.collections.DoubleIterator;
import kotlin.collections.FloatIterator;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.collections.ShortIterator;
import org.jetbrains.annotations.NotNull;

public final class ArrayIteratorsKt {
    @NotNull
    public static final ByteIterator iterator(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "array");
        return new ArrayByteIterator(bArr);
    }

    @NotNull
    public static final CharIterator iterator(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "array");
        return new ArrayCharIterator(cArr);
    }

    @NotNull
    public static final ShortIterator iterator(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "array");
        return new ArrayShortIterator(sArr);
    }

    @NotNull
    public static final IntIterator iterator(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "array");
        return new ArrayIntIterator(iArr);
    }

    @NotNull
    public static final LongIterator iterator(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "array");
        return new ArrayLongIterator(jArr);
    }

    @NotNull
    public static final FloatIterator iterator(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "array");
        return new ArrayFloatIterator(fArr);
    }

    @NotNull
    public static final DoubleIterator iterator(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "array");
        return new ArrayDoubleIterator(dArr);
    }

    @NotNull
    public static final BooleanIterator iterator(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "array");
        return new ArrayBooleanIterator(zArr);
    }
}
