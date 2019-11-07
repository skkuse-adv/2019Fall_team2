package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.IntProgression.Companion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class RangesKt___RangesKt extends RangesKt__RangesKt {
    public static final byte coerceAtLeast(byte b, byte b2) {
        return b < b2 ? b2 : b;
    }

    public static final double coerceAtLeast(double d, double d2) {
        return d < d2 ? d2 : d;
    }

    public static final float coerceAtLeast(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    public static int coerceAtLeast(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static long coerceAtLeast(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static final short coerceAtLeast(short s, short s2) {
        return s < s2 ? s2 : s;
    }

    public static final byte coerceAtMost(byte b, byte b2) {
        return b > b2 ? b2 : b;
    }

    public static final double coerceAtMost(double d, double d2) {
        return d > d2 ? d2 : d;
    }

    public static final float coerceAtMost(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static int coerceAtMost(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static long coerceAtMost(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static final short coerceAtMost(short s, short s2) {
        return s > s2 ? s2 : s;
    }

    public static final int random(@NotNull IntRange intRange, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(intRange, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        try {
            return RandomKt.nextInt(random, intRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final long random(@NotNull LongRange longRange, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(longRange, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        try {
            return RandomKt.nextLong(random, longRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final char random(@NotNull CharRange charRange, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(charRange, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        try {
            return (char) random.nextInt(charRange.getFirst(), charRange.getLast() + 1);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, byte b) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Integer.valueOf(b));
    }

    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, byte b) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Long.valueOf((long) b));
    }

    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, byte b) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Short.valueOf((short) b));
    }

    public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> closedRange, byte b) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Double.valueOf((double) b));
    }

    public static final boolean floatRangeContains(@NotNull ClosedRange<Float> closedRange, byte b) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Float.valueOf((float) b));
    }

    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, double d) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        Integer intExactOrNull = toIntExactOrNull(d);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, double d) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        Long longExactOrNull = toLongExactOrNull(d);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, double d) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        Byte byteExactOrNull = toByteExactOrNull(d);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, double d) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        Short shortExactOrNull = toShortExactOrNull(d);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final boolean floatRangeContains(@NotNull ClosedRange<Float> closedRange, double d) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Float.valueOf((float) d));
    }

    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, float f) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        Integer intExactOrNull = toIntExactOrNull(f);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, float f) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        Long longExactOrNull = toLongExactOrNull(f);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, float f) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        Byte byteExactOrNull = toByteExactOrNull(f);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, float f) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        Short shortExactOrNull = toShortExactOrNull(f);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> closedRange, float f) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Double.valueOf((double) f));
    }

    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, int i) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Long.valueOf((long) i));
    }

    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, int i) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        Byte byteExactOrNull = toByteExactOrNull(i);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, int i) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        Short shortExactOrNull = toShortExactOrNull(i);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> closedRange, int i) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Double.valueOf((double) i));
    }

    public static final boolean floatRangeContains(@NotNull ClosedRange<Float> closedRange, int i) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Float.valueOf((float) i));
    }

    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, long j) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        Integer intExactOrNull = toIntExactOrNull(j);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, long j) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        Byte byteExactOrNull = toByteExactOrNull(j);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, long j) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        Short shortExactOrNull = toShortExactOrNull(j);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> closedRange, long j) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Double.valueOf((double) j));
    }

    public static final boolean floatRangeContains(@NotNull ClosedRange<Float> closedRange, long j) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Float.valueOf((float) j));
    }

    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, short s) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Integer.valueOf(s));
    }

    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, short s) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Long.valueOf((long) s));
    }

    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, short s) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        Byte byteExactOrNull = toByteExactOrNull(s);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> closedRange, short s) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Double.valueOf((double) s));
    }

    public static final boolean floatRangeContains(@NotNull ClosedRange<Float> closedRange, short s) {
        Intrinsics.checkParameterIsNotNull(closedRange, "receiver$0");
        return closedRange.contains(Float.valueOf((float) s));
    }

    @NotNull
    public static final IntProgression downTo(int i, byte b) {
        return IntProgression.Companion.fromClosedRange(i, b, -1);
    }

    @NotNull
    public static final LongProgression downTo(long j, byte b) {
        return LongProgression.Companion.fromClosedRange(j, (long) b, -1);
    }

    @NotNull
    public static final IntProgression downTo(byte b, byte b2) {
        return IntProgression.Companion.fromClosedRange(b, b2, -1);
    }

    @NotNull
    public static final IntProgression downTo(short s, byte b) {
        return IntProgression.Companion.fromClosedRange(s, b, -1);
    }

    @NotNull
    public static final CharProgression downTo(char c, char c2) {
        return CharProgression.Companion.fromClosedRange(c, c2, -1);
    }

    @NotNull
    public static IntProgression downTo(int i, int i2) {
        return IntProgression.Companion.fromClosedRange(i, i2, -1);
    }

    @NotNull
    public static final LongProgression downTo(long j, int i) {
        return LongProgression.Companion.fromClosedRange(j, (long) i, -1);
    }

    @NotNull
    public static final IntProgression downTo(byte b, int i) {
        return IntProgression.Companion.fromClosedRange(b, i, -1);
    }

    @NotNull
    public static final IntProgression downTo(short s, int i) {
        return IntProgression.Companion.fromClosedRange(s, i, -1);
    }

    @NotNull
    public static final LongProgression downTo(int i, long j) {
        return LongProgression.Companion.fromClosedRange((long) i, j, -1);
    }

    @NotNull
    public static final LongProgression downTo(long j, long j2) {
        return LongProgression.Companion.fromClosedRange(j, j2, -1);
    }

    @NotNull
    public static final LongProgression downTo(byte b, long j) {
        return LongProgression.Companion.fromClosedRange((long) b, j, -1);
    }

    @NotNull
    public static final LongProgression downTo(short s, long j) {
        return LongProgression.Companion.fromClosedRange((long) s, j, -1);
    }

    @NotNull
    public static final IntProgression downTo(int i, short s) {
        return IntProgression.Companion.fromClosedRange(i, s, -1);
    }

    @NotNull
    public static final LongProgression downTo(long j, short s) {
        return LongProgression.Companion.fromClosedRange(j, (long) s, -1);
    }

    @NotNull
    public static final IntProgression downTo(byte b, short s) {
        return IntProgression.Companion.fromClosedRange(b, s, -1);
    }

    @NotNull
    public static final IntProgression downTo(short s, short s2) {
        return IntProgression.Companion.fromClosedRange(s, s2, -1);
    }

    @NotNull
    public static final IntProgression reversed(@NotNull IntProgression intProgression) {
        Intrinsics.checkParameterIsNotNull(intProgression, "receiver$0");
        return IntProgression.Companion.fromClosedRange(intProgression.getLast(), intProgression.getFirst(), -intProgression.getStep());
    }

    @NotNull
    public static final LongProgression reversed(@NotNull LongProgression longProgression) {
        Intrinsics.checkParameterIsNotNull(longProgression, "receiver$0");
        return LongProgression.Companion.fromClosedRange(longProgression.getLast(), longProgression.getFirst(), -longProgression.getStep());
    }

    @NotNull
    public static final CharProgression reversed(@NotNull CharProgression charProgression) {
        Intrinsics.checkParameterIsNotNull(charProgression, "receiver$0");
        return CharProgression.Companion.fromClosedRange(charProgression.getLast(), charProgression.getFirst(), -charProgression.getStep());
    }

    @NotNull
    public static IntProgression step(@NotNull IntProgression intProgression, int i) {
        Intrinsics.checkParameterIsNotNull(intProgression, "receiver$0");
        RangesKt__RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        Companion companion = IntProgression.Companion;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    @NotNull
    public static final LongProgression step(@NotNull LongProgression longProgression, long j) {
        Intrinsics.checkParameterIsNotNull(longProgression, "receiver$0");
        RangesKt__RangesKt.checkStepIsPositive(j > 0, Long.valueOf(j));
        LongProgression.Companion companion = LongProgression.Companion;
        long first = longProgression.getFirst();
        long last = longProgression.getLast();
        if (longProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.fromClosedRange(first, last, j);
    }

    @NotNull
    public static final CharProgression step(@NotNull CharProgression charProgression, int i) {
        Intrinsics.checkParameterIsNotNull(charProgression, "receiver$0");
        RangesKt__RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        CharProgression.Companion companion = CharProgression.Companion;
        char first = charProgression.getFirst();
        char last = charProgression.getLast();
        if (charProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    @Nullable
    public static final Byte toByteExactOrNull(int i) {
        if (-128 <= i && 127 >= i) {
            return Byte.valueOf((byte) i);
        }
        return null;
    }

    @Nullable
    public static final Byte toByteExactOrNull(long j) {
        long j2 = (long) 127;
        if (((long) -128) <= j && j2 >= j) {
            return Byte.valueOf((byte) ((int) j));
        }
        return null;
    }

    @Nullable
    public static final Byte toByteExactOrNull(short s) {
        short s2 = (short) 127;
        if (((short) -128) <= s && s2 >= s) {
            return Byte.valueOf((byte) s);
        }
        return null;
    }

    @Nullable
    public static final Byte toByteExactOrNull(double d) {
        double d2 = (double) 127;
        if (d < ((double) -128) || d > d2) {
            return null;
        }
        return Byte.valueOf((byte) ((int) d));
    }

    @Nullable
    public static final Byte toByteExactOrNull(float f) {
        float f2 = (float) 127;
        if (f < ((float) -128) || f > f2) {
            return null;
        }
        return Byte.valueOf((byte) ((int) f));
    }

    @Nullable
    public static final Integer toIntExactOrNull(long j) {
        long j2 = (long) Integer.MAX_VALUE;
        if (((long) Integer.MIN_VALUE) <= j && j2 >= j) {
            return Integer.valueOf((int) j);
        }
        return null;
    }

    @Nullable
    public static final Integer toIntExactOrNull(double d) {
        double d2 = (double) Integer.MAX_VALUE;
        if (d < ((double) Integer.MIN_VALUE) || d > d2) {
            return null;
        }
        return Integer.valueOf((int) d);
    }

    @Nullable
    public static final Integer toIntExactOrNull(float f) {
        float f2 = (float) Integer.MAX_VALUE;
        if (f < ((float) Integer.MIN_VALUE) || f > f2) {
            return null;
        }
        return Integer.valueOf((int) f);
    }

    @Nullable
    public static final Long toLongExactOrNull(double d) {
        double d2 = (double) Long.MAX_VALUE;
        if (d < ((double) Long.MIN_VALUE) || d > d2) {
            return null;
        }
        return Long.valueOf((long) d);
    }

    @Nullable
    public static final Long toLongExactOrNull(float f) {
        float f2 = (float) Long.MAX_VALUE;
        if (f < ((float) Long.MIN_VALUE) || f > f2) {
            return null;
        }
        return Long.valueOf((long) f);
    }

    @Nullable
    public static final Short toShortExactOrNull(int i) {
        if (-32768 <= i && 32767 >= i) {
            return Short.valueOf((short) i);
        }
        return null;
    }

    @Nullable
    public static final Short toShortExactOrNull(long j) {
        long j2 = (long) 32767;
        if (((long) -32768) <= j && j2 >= j) {
            return Short.valueOf((short) ((int) j));
        }
        return null;
    }

    @Nullable
    public static final Short toShortExactOrNull(double d) {
        double d2 = (double) 32767;
        if (d < ((double) -32768) || d > d2) {
            return null;
        }
        return Short.valueOf((short) ((int) d));
    }

    @Nullable
    public static final Short toShortExactOrNull(float f) {
        float f2 = (float) 32767;
        if (f < ((float) -32768) || f > f2) {
            return null;
        }
        return Short.valueOf((short) ((int) f));
    }

    @NotNull
    public static final IntRange until(int i, byte b) {
        return new IntRange(i, b - 1);
    }

    @NotNull
    public static final LongRange until(long j, byte b) {
        return new LongRange(j, ((long) b) - 1);
    }

    @NotNull
    public static final IntRange until(byte b, byte b2) {
        return new IntRange(b, b2 - 1);
    }

    @NotNull
    public static final IntRange until(short s, byte b) {
        return new IntRange(s, b - 1);
    }

    @NotNull
    public static final CharRange until(char c, char c2) {
        if (c2 <= 0) {
            return CharRange.Companion.getEMPTY();
        }
        return new CharRange(c, (char) (c2 - 1));
    }

    @NotNull
    public static IntRange until(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange(i, i2 - 1);
    }

    @NotNull
    public static final LongRange until(long j, int i) {
        return new LongRange(j, ((long) i) - 1);
    }

    @NotNull
    public static final IntRange until(byte b, int i) {
        if (i <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange(b, i - 1);
    }

    @NotNull
    public static final IntRange until(short s, int i) {
        if (i <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange(s, i - 1);
    }

    @NotNull
    public static final LongRange until(int i, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange((long) i, j - 1);
    }

    @NotNull
    public static final LongRange until(long j, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange(j, j2 - 1);
    }

    @NotNull
    public static final LongRange until(byte b, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange((long) b, j - 1);
    }

    @NotNull
    public static final LongRange until(short s, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange((long) s, j - 1);
    }

    @NotNull
    public static final IntRange until(int i, short s) {
        return new IntRange(i, s - 1);
    }

    @NotNull
    public static final LongRange until(long j, short s) {
        return new LongRange(j, ((long) s) - 1);
    }

    @NotNull
    public static final IntRange until(byte b, short s) {
        return new IntRange(b, s - 1);
    }

    @NotNull
    public static final IntRange until(short s, short s2) {
        return new IntRange(s, s2 - 1);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T coerceAtLeast(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(t2, "minimumValue");
        return t.compareTo(t2) < 0 ? t2 : t;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T coerceAtMost(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(t2, "maximumValue");
        return t.compareTo(t2) > 0 ? t2 : t;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T coerceIn(@NotNull T t, @Nullable T t2, @Nullable T t3) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        if (t2 == null || t3 == null) {
            if (t2 == null || t.compareTo(t2) >= 0) {
                return (t3 == null || t.compareTo(t3) <= 0) ? t : t3;
            }
            return t2;
        } else if (t2.compareTo(t3) > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot coerce value to an empty range: maximum ");
            sb.append(t3);
            sb.append(" is less than minimum ");
            sb.append(t2);
            sb.append('.');
            throw new IllegalArgumentException(sb.toString());
        } else if (t.compareTo(t2) < 0) {
            return t2;
        } else {
            if (t.compareTo(t3) > 0) {
                return t3;
            }
        }
    }

    public static final byte coerceIn(byte b, byte b2, byte b3) {
        if (b2 > b3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot coerce value to an empty range: maximum ");
            sb.append(b3);
            sb.append(" is less than minimum ");
            sb.append(b2);
            sb.append('.');
            throw new IllegalArgumentException(sb.toString());
        } else if (b < b2) {
            return b2;
        } else {
            return b > b3 ? b3 : b;
        }
    }

    public static final short coerceIn(short s, short s2, short s3) {
        if (s2 > s3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot coerce value to an empty range: maximum ");
            sb.append(s3);
            sb.append(" is less than minimum ");
            sb.append(s2);
            sb.append('.');
            throw new IllegalArgumentException(sb.toString());
        } else if (s < s2) {
            return s2;
        } else {
            return s > s3 ? s3 : s;
        }
    }

    public static int coerceIn(int i, int i2, int i3) {
        if (i2 > i3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot coerce value to an empty range: maximum ");
            sb.append(i3);
            sb.append(" is less than minimum ");
            sb.append(i2);
            sb.append('.');
            throw new IllegalArgumentException(sb.toString());
        } else if (i < i2) {
            return i2;
        } else {
            return i > i3 ? i3 : i;
        }
    }

    public static final long coerceIn(long j, long j2, long j3) {
        if (j2 > j3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot coerce value to an empty range: maximum ");
            sb.append(j3);
            sb.append(" is less than minimum ");
            sb.append(j2);
            sb.append('.');
            throw new IllegalArgumentException(sb.toString());
        } else if (j < j2) {
            return j2;
        } else {
            return j > j3 ? j3 : j;
        }
    }

    public static final float coerceIn(float f, float f2, float f3) {
        if (f2 > f3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot coerce value to an empty range: maximum ");
            sb.append(f3);
            sb.append(" is less than minimum ");
            sb.append(f2);
            sb.append('.');
            throw new IllegalArgumentException(sb.toString());
        } else if (f < f2) {
            return f2;
        } else {
            return f > f3 ? f3 : f;
        }
    }

    public static final double coerceIn(double d, double d2, double d3) {
        if (d2 > d3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot coerce value to an empty range: maximum ");
            sb.append(d3);
            sb.append(" is less than minimum ");
            sb.append(d2);
            sb.append('.');
            throw new IllegalArgumentException(sb.toString());
        } else if (d < d2) {
            return d2;
        } else {
            return d > d3 ? d3 : d;
        }
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T coerceIn(@NotNull T t, @NotNull ClosedFloatingPointRange<T> closedFloatingPointRange) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(closedFloatingPointRange, "range");
        if (closedFloatingPointRange.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot coerce value to an empty range: ");
            sb.append(closedFloatingPointRange);
            sb.append('.');
            throw new IllegalArgumentException(sb.toString());
        } else if (!closedFloatingPointRange.lessThanOrEquals(t, closedFloatingPointRange.getStart()) || closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getStart(), t)) {
            return (!closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getEndInclusive(), t) || closedFloatingPointRange.lessThanOrEquals(t, closedFloatingPointRange.getEndInclusive())) ? t : closedFloatingPointRange.getEndInclusive();
        } else {
            return closedFloatingPointRange.getStart();
        }
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T coerceIn(@NotNull T t, @NotNull ClosedRange<T> closedRange) {
        Intrinsics.checkParameterIsNotNull(t, "receiver$0");
        Intrinsics.checkParameterIsNotNull(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return coerceIn(t, (ClosedFloatingPointRange) closedRange);
        }
        if (!closedRange.isEmpty()) {
            if (t.compareTo(closedRange.getStart()) < 0) {
                t = closedRange.getStart();
            } else if (t.compareTo(closedRange.getEndInclusive()) > 0) {
                t = closedRange.getEndInclusive();
            }
            return t;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: ");
        sb.append(closedRange);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    public static final int coerceIn(int i, @NotNull ClosedRange<Integer> closedRange) {
        Intrinsics.checkParameterIsNotNull(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn((T) Integer.valueOf(i), (ClosedFloatingPointRange) closedRange)).intValue();
        }
        if (!closedRange.isEmpty()) {
            if (i < ((Number) closedRange.getStart()).intValue()) {
                i = ((Number) closedRange.getStart()).intValue();
            } else if (i > ((Number) closedRange.getEndInclusive()).intValue()) {
                i = ((Number) closedRange.getEndInclusive()).intValue();
            }
            return i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: ");
        sb.append(closedRange);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    public static final long coerceIn(long j, @NotNull ClosedRange<Long> closedRange) {
        Intrinsics.checkParameterIsNotNull(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn((T) Long.valueOf(j), (ClosedFloatingPointRange) closedRange)).longValue();
        }
        if (!closedRange.isEmpty()) {
            if (j < ((Number) closedRange.getStart()).longValue()) {
                j = ((Number) closedRange.getStart()).longValue();
            } else if (j > ((Number) closedRange.getEndInclusive()).longValue()) {
                j = ((Number) closedRange.getEndInclusive()).longValue();
            }
            return j;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: ");
        sb.append(closedRange);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }
}
