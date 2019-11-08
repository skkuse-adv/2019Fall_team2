package kotlin.random;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import org.jetbrains.annotations.NotNull;

public final class RandomKt {
    public static final int takeUpperBits(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }

    @NotNull
    public static final Random Random(int i) {
        return new XorWowRandom(i, i >> 31);
    }

    @NotNull
    public static final Random Random(long j) {
        return new XorWowRandom((int) j, (int) (j >> 32));
    }

    public static final int nextInt(@NotNull Random random, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(random, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "range");
        if (intRange.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot get random in empty range: ");
            sb.append(intRange);
            throw new IllegalArgumentException(sb.toString());
        } else if (intRange.getLast() < Integer.MAX_VALUE) {
            return random.nextInt(intRange.getFirst(), intRange.getLast() + 1);
        } else {
            if (intRange.getFirst() > Integer.MIN_VALUE) {
                return random.nextInt(intRange.getFirst() - 1, intRange.getLast()) + 1;
            }
            return random.nextInt();
        }
    }

    public static final long nextLong(@NotNull Random random, @NotNull LongRange longRange) {
        Intrinsics.checkParameterIsNotNull(random, "receiver$0");
        Intrinsics.checkParameterIsNotNull(longRange, "range");
        if (longRange.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot get random in empty range: ");
            sb.append(longRange);
            throw new IllegalArgumentException(sb.toString());
        } else if (longRange.getLast() < Long.MAX_VALUE) {
            return random.nextLong(longRange.getStart().longValue(), longRange.getEndInclusive().longValue() + 1);
        } else {
            if (longRange.getStart().longValue() > Long.MIN_VALUE) {
                return random.nextLong(longRange.getStart().longValue() - 1, longRange.getEndInclusive().longValue()) + 1;
            }
            return random.nextLong();
        }
    }

    public static final void checkRangeBounds(int i, int i2) {
        if (!(i2 > i)) {
            throw new IllegalArgumentException(boundsErrorMessage(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final void checkRangeBounds(long j, long j2) {
        if (!(j2 > j)) {
            throw new IllegalArgumentException(boundsErrorMessage(Long.valueOf(j), Long.valueOf(j2)).toString());
        }
    }

    public static final void checkRangeBounds(double d, double d2) {
        if (!(d2 > d)) {
            throw new IllegalArgumentException(boundsErrorMessage(Double.valueOf(d), Double.valueOf(d2)).toString());
        }
    }

    @NotNull
    public static final String boundsErrorMessage(@NotNull Object obj, @NotNull Object obj2) {
        Intrinsics.checkParameterIsNotNull(obj, "from");
        Intrinsics.checkParameterIsNotNull(obj2, "until");
        StringBuilder sb = new StringBuilder();
        sb.append("Random range is empty: [");
        sb.append(obj);
        sb.append(", ");
        sb.append(obj2);
        sb.append(").");
        return sb.toString();
    }
}
