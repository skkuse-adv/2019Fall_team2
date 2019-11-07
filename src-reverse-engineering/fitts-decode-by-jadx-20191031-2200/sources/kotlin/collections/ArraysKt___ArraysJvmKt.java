package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class ArraysKt___ArraysJvmKt extends ArraysKt__ArraysKt {
    @NotNull
    public static final <R> List<R> filterIsInstance(@NotNull Object[] objArr, @NotNull Class<R> cls) {
        Intrinsics.checkParameterIsNotNull(objArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cls, "klass");
        return (List) filterIsInstanceTo(objArr, new ArrayList(), cls);
    }

    @NotNull
    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(@NotNull Object[] objArr, @NotNull C c, @NotNull Class<R> cls) {
        Intrinsics.checkParameterIsNotNull(objArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(cls, "klass");
        for (Object obj : objArr) {
            if (cls.isInstance(obj)) {
                c.add(obj);
            }
        }
        return c;
    }

    @NotNull
    public static <T> List<T> asList(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        List<T> asList = ArraysUtilJVM.asList(tArr);
        Intrinsics.checkExpressionValueIsNotNull(asList, "ArraysUtilJVM.asList(this)");
        return asList;
    }

    @NotNull
    public static final List<Byte> asList(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        return new ArraysKt___ArraysJvmKt$asList$1(bArr);
    }

    @NotNull
    public static final List<Short> asList(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        return new ArraysKt___ArraysJvmKt$asList$2(sArr);
    }

    @NotNull
    public static final List<Integer> asList(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        return new ArraysKt___ArraysJvmKt$asList$3(iArr);
    }

    @NotNull
    public static final List<Long> asList(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        return new ArraysKt___ArraysJvmKt$asList$4(jArr);
    }

    @NotNull
    public static final List<Float> asList(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        return new ArraysKt___ArraysJvmKt$asList$5(fArr);
    }

    @NotNull
    public static final List<Double> asList(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        return new ArraysKt___ArraysJvmKt$asList$6(dArr);
    }

    @NotNull
    public static final List<Boolean> asList(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        return new ArraysKt___ArraysJvmKt$asList$7(zArr);
    }

    @NotNull
    public static final List<Character> asList(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        return new ArraysKt___ArraysJvmKt$asList$8(cArr);
    }

    public static /* synthetic */ int binarySearch$default(Object[] objArr, Object obj, Comparator comparator, int i, int i2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = objArr.length;
        }
        return binarySearch(objArr, obj, comparator, i, i2);
    }

    public static final <T> int binarySearch(@NotNull T[] tArr, T t, @NotNull Comparator<? super T> comparator, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return Arrays.binarySearch(tArr, i, i2, t, comparator);
    }

    public static /* synthetic */ int binarySearch$default(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        return binarySearch((T[]) objArr, (T) obj, i, i2);
    }

    public static final <T> int binarySearch(@NotNull T[] tArr, T t, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        return Arrays.binarySearch(tArr, i, i2, t);
    }

    public static /* synthetic */ int binarySearch$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return binarySearch(bArr, b, i, i2);
    }

    public static final int binarySearch(@NotNull byte[] bArr, byte b, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        return Arrays.binarySearch(bArr, i, i2, b);
    }

    public static /* synthetic */ int binarySearch$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length;
        }
        return binarySearch(sArr, s, i, i2);
    }

    public static final int binarySearch(@NotNull short[] sArr, short s, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        return Arrays.binarySearch(sArr, i, i2, s);
    }

    public static /* synthetic */ int binarySearch$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        return binarySearch(iArr, i, i2, i3);
    }

    public static final int binarySearch(@NotNull int[] iArr, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        return Arrays.binarySearch(iArr, i2, i3, i);
    }

    public static /* synthetic */ int binarySearch$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length;
        }
        return binarySearch(jArr, j, i, i2);
    }

    public static final int binarySearch(@NotNull long[] jArr, long j, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        return Arrays.binarySearch(jArr, i, i2, j);
    }

    public static /* synthetic */ int binarySearch$default(float[] fArr, float f, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length;
        }
        return binarySearch(fArr, f, i, i2);
    }

    public static final int binarySearch(@NotNull float[] fArr, float f, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        return Arrays.binarySearch(fArr, i, i2, f);
    }

    public static /* synthetic */ int binarySearch$default(double[] dArr, double d, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length;
        }
        return binarySearch(dArr, d, i, i2);
    }

    public static final int binarySearch(@NotNull double[] dArr, double d, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        return Arrays.binarySearch(dArr, i, i2, d);
    }

    public static /* synthetic */ int binarySearch$default(char[] cArr, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return binarySearch(cArr, c, i, i2);
    }

    public static final int binarySearch(@NotNull char[] cArr, char c, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        return Arrays.binarySearch(cArr, i, i2, c);
    }

    @NotNull
    public static /* synthetic */ Object[] copyInto$default(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return copyInto((T[]) objArr, (T[]) objArr2, i, i2, i3);
    }

    @NotNull
    public static final <T> T[] copyInto(@NotNull T[] tArr, @NotNull T[] tArr2, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(tArr2, "destination");
        System.arraycopy(tArr, i2, tArr2, i, i3 - i2);
        return tArr2;
    }

    @NotNull
    public static /* synthetic */ byte[] copyInto$default(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return copyInto(bArr, bArr2, i, i2, i3);
    }

    @NotNull
    public static final byte[] copyInto(@NotNull byte[] bArr, @NotNull byte[] bArr2, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(bArr2, "destination");
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
        return bArr2;
    }

    @NotNull
    public static /* synthetic */ short[] copyInto$default(short[] sArr, short[] sArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sArr.length;
        }
        return copyInto(sArr, sArr2, i, i2, i3);
    }

    @NotNull
    public static final short[] copyInto(@NotNull short[] sArr, @NotNull short[] sArr2, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sArr2, "destination");
        System.arraycopy(sArr, i2, sArr2, i, i3 - i2);
        return sArr2;
    }

    @NotNull
    public static /* synthetic */ int[] copyInto$default(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length;
        }
        return copyInto(iArr, iArr2, i, i2, i3);
    }

    @NotNull
    public static final int[] copyInto(@NotNull int[] iArr, @NotNull int[] iArr2, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iArr2, "destination");
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
        return iArr2;
    }

    @NotNull
    public static /* synthetic */ long[] copyInto$default(long[] jArr, long[] jArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = jArr.length;
        }
        return copyInto(jArr, jArr2, i, i2, i3);
    }

    @NotNull
    public static final long[] copyInto(@NotNull long[] jArr, @NotNull long[] jArr2, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(jArr2, "destination");
        System.arraycopy(jArr, i2, jArr2, i, i3 - i2);
        return jArr2;
    }

    @NotNull
    public static /* synthetic */ float[] copyInto$default(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length;
        }
        return copyInto(fArr, fArr2, i, i2, i3);
    }

    @NotNull
    public static final float[] copyInto(@NotNull float[] fArr, @NotNull float[] fArr2, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(fArr2, "destination");
        System.arraycopy(fArr, i2, fArr2, i, i3 - i2);
        return fArr2;
    }

    @NotNull
    public static /* synthetic */ double[] copyInto$default(double[] dArr, double[] dArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = dArr.length;
        }
        return copyInto(dArr, dArr2, i, i2, i3);
    }

    @NotNull
    public static final double[] copyInto(@NotNull double[] dArr, @NotNull double[] dArr2, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(dArr2, "destination");
        System.arraycopy(dArr, i2, dArr2, i, i3 - i2);
        return dArr2;
    }

    @NotNull
    public static /* synthetic */ boolean[] copyInto$default(boolean[] zArr, boolean[] zArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = zArr.length;
        }
        return copyInto(zArr, zArr2, i, i2, i3);
    }

    @NotNull
    public static final boolean[] copyInto(@NotNull boolean[] zArr, @NotNull boolean[] zArr2, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(zArr2, "destination");
        System.arraycopy(zArr, i2, zArr2, i, i3 - i2);
        return zArr2;
    }

    @NotNull
    public static /* synthetic */ char[] copyInto$default(char[] cArr, char[] cArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = cArr.length;
        }
        return copyInto(cArr, cArr2, i, i2, i3);
    }

    @NotNull
    public static final char[] copyInto(@NotNull char[] cArr, @NotNull char[] cArr2, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cArr2, "destination");
        System.arraycopy(cArr, i2, cArr2, i, i3 - i2);
        return cArr2;
    }

    @NotNull
    public static final <T> T[] copyOfRange(@NotNull T[] tArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, tArr.length);
        T[] copyOfRange = Arrays.copyOfRange(tArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @NotNull
    public static final byte[] copyOfRange(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @NotNull
    public static final short[] copyOfRange(@NotNull short[] sArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, sArr.length);
        short[] copyOfRange = Arrays.copyOfRange(sArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @NotNull
    public static final int[] copyOfRange(@NotNull int[] iArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, iArr.length);
        int[] copyOfRange = Arrays.copyOfRange(iArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @NotNull
    public static final long[] copyOfRange(@NotNull long[] jArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, jArr.length);
        long[] copyOfRange = Arrays.copyOfRange(jArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @NotNull
    public static final float[] copyOfRange(@NotNull float[] fArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, fArr.length);
        float[] copyOfRange = Arrays.copyOfRange(fArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @NotNull
    public static final double[] copyOfRange(@NotNull double[] dArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, dArr.length);
        double[] copyOfRange = Arrays.copyOfRange(dArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @NotNull
    public static final boolean[] copyOfRange(@NotNull boolean[] zArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, zArr.length);
        boolean[] copyOfRange = Arrays.copyOfRange(zArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @NotNull
    public static final char[] copyOfRange(@NotNull char[] cArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, cArr.length);
        char[] copyOfRange = Arrays.copyOfRange(cArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static /* synthetic */ void fill$default(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        fill((T[]) objArr, (T) obj, i, i2);
    }

    public static final <T> void fill(@NotNull T[] tArr, T t, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Arrays.fill(tArr, i, i2, t);
    }

    public static /* synthetic */ void fill$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        fill(bArr, b, i, i2);
    }

    public static final void fill(@NotNull byte[] bArr, byte b, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Arrays.fill(bArr, i, i2, b);
    }

    public static /* synthetic */ void fill$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length;
        }
        fill(sArr, s, i, i2);
    }

    public static final void fill(@NotNull short[] sArr, short s, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Arrays.fill(sArr, i, i2, s);
    }

    public static /* synthetic */ void fill$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        fill(iArr, i, i2, i3);
    }

    public static final void fill(@NotNull int[] iArr, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Arrays.fill(iArr, i2, i3, i);
    }

    public static /* synthetic */ void fill$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length;
        }
        fill(jArr, j, i, i2);
    }

    public static final void fill(@NotNull long[] jArr, long j, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Arrays.fill(jArr, i, i2, j);
    }

    public static /* synthetic */ void fill$default(float[] fArr, float f, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length;
        }
        fill(fArr, f, i, i2);
    }

    public static final void fill(@NotNull float[] fArr, float f, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Arrays.fill(fArr, i, i2, f);
    }

    public static /* synthetic */ void fill$default(double[] dArr, double d, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length;
        }
        fill(dArr, d, i, i2);
    }

    public static final void fill(@NotNull double[] dArr, double d, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Arrays.fill(dArr, i, i2, d);
    }

    public static /* synthetic */ void fill$default(boolean[] zArr, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = zArr.length;
        }
        fill(zArr, z, i, i2);
    }

    public static final void fill(@NotNull boolean[] zArr, boolean z, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Arrays.fill(zArr, i, i2, z);
    }

    public static /* synthetic */ void fill$default(char[] cArr, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        fill(cArr, c, i, i2);
    }

    public static final void fill(@NotNull char[] cArr, char c, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Arrays.fill(cArr, i, i2, c);
    }

    @NotNull
    public static final <T> T[] plus(@NotNull T[] tArr, T t) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        int length = tArr.length;
        T[] copyOf = Arrays.copyOf(tArr, length + 1);
        copyOf[length] = t;
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final byte[] plus(@NotNull byte[] bArr, byte b) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        int length = bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + 1);
        copyOf[length] = b;
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final short[] plus(@NotNull short[] sArr, short s) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        int length = sArr.length;
        short[] copyOf = Arrays.copyOf(sArr, length + 1);
        copyOf[length] = s;
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final int[] plus(@NotNull int[] iArr, int i) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, length + 1);
        copyOf[length] = i;
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final long[] plus(@NotNull long[] jArr, long j) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, length + 1);
        copyOf[length] = j;
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final float[] plus(@NotNull float[] fArr, float f) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        int length = fArr.length;
        float[] copyOf = Arrays.copyOf(fArr, length + 1);
        copyOf[length] = f;
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final double[] plus(@NotNull double[] dArr, double d) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        int length = dArr.length;
        double[] copyOf = Arrays.copyOf(dArr, length + 1);
        copyOf[length] = d;
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final boolean[] plus(@NotNull boolean[] zArr, boolean z) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        int length = zArr.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + 1);
        copyOf[length] = z;
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final char[] plus(@NotNull char[] cArr, char c) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        int length = cArr.length;
        char[] copyOf = Arrays.copyOf(cArr, length + 1);
        copyOf[length] = c;
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final <T> T[] plus(@NotNull T[] tArr, @NotNull Collection<? extends T> collection) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, MessengerShareContentUtility.ELEMENTS);
        int length = tArr.length;
        T[] copyOf = Arrays.copyOf(tArr, collection.size() + length);
        for (T t : collection) {
            int i = length + 1;
            copyOf[length] = t;
            length = i;
        }
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final byte[] plus(@NotNull byte[] bArr, @NotNull Collection<Byte> collection) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, MessengerShareContentUtility.ELEMENTS);
        int length = bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, collection.size() + length);
        for (Number byteValue : collection) {
            int i = length + 1;
            copyOf[length] = byteValue.byteValue();
            length = i;
        }
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final short[] plus(@NotNull short[] sArr, @NotNull Collection<Short> collection) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, MessengerShareContentUtility.ELEMENTS);
        int length = sArr.length;
        short[] copyOf = Arrays.copyOf(sArr, collection.size() + length);
        for (Number shortValue : collection) {
            int i = length + 1;
            copyOf[length] = shortValue.shortValue();
            length = i;
        }
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final int[] plus(@NotNull int[] iArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, MessengerShareContentUtility.ELEMENTS);
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, collection.size() + length);
        for (Number intValue : collection) {
            int i = length + 1;
            copyOf[length] = intValue.intValue();
            length = i;
        }
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final long[] plus(@NotNull long[] jArr, @NotNull Collection<Long> collection) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, MessengerShareContentUtility.ELEMENTS);
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, collection.size() + length);
        for (Number longValue : collection) {
            int i = length + 1;
            copyOf[length] = longValue.longValue();
            length = i;
        }
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final float[] plus(@NotNull float[] fArr, @NotNull Collection<Float> collection) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, MessengerShareContentUtility.ELEMENTS);
        int length = fArr.length;
        float[] copyOf = Arrays.copyOf(fArr, collection.size() + length);
        for (Number floatValue : collection) {
            int i = length + 1;
            copyOf[length] = floatValue.floatValue();
            length = i;
        }
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final double[] plus(@NotNull double[] dArr, @NotNull Collection<Double> collection) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, MessengerShareContentUtility.ELEMENTS);
        int length = dArr.length;
        double[] copyOf = Arrays.copyOf(dArr, collection.size() + length);
        for (Number doubleValue : collection) {
            int i = length + 1;
            copyOf[length] = doubleValue.doubleValue();
            length = i;
        }
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final boolean[] plus(@NotNull boolean[] zArr, @NotNull Collection<Boolean> collection) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, MessengerShareContentUtility.ELEMENTS);
        int length = zArr.length;
        boolean[] copyOf = Arrays.copyOf(zArr, collection.size() + length);
        for (Boolean booleanValue : collection) {
            int i = length + 1;
            copyOf[length] = booleanValue.booleanValue();
            length = i;
        }
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final char[] plus(@NotNull char[] cArr, @NotNull Collection<Character> collection) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, MessengerShareContentUtility.ELEMENTS);
        int length = cArr.length;
        char[] copyOf = Arrays.copyOf(cArr, collection.size() + length);
        for (Character charValue : collection) {
            int i = length + 1;
            copyOf[length] = charValue.charValue();
            length = i;
        }
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final <T> T[] plus(@NotNull T[] tArr, @NotNull T[] tArr2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(tArr2, MessengerShareContentUtility.ELEMENTS);
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] copyOf = Arrays.copyOf(tArr, length + length2);
        System.arraycopy(tArr2, 0, copyOf, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final byte[] plus(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(bArr2, MessengerShareContentUtility.ELEMENTS);
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, copyOf, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final short[] plus(@NotNull short[] sArr, @NotNull short[] sArr2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sArr2, MessengerShareContentUtility.ELEMENTS);
        int length = sArr.length;
        int length2 = sArr2.length;
        short[] copyOf = Arrays.copyOf(sArr, length + length2);
        System.arraycopy(sArr2, 0, copyOf, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final int[] plus(@NotNull int[] iArr, @NotNull int[] iArr2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iArr2, MessengerShareContentUtility.ELEMENTS);
        int length = iArr.length;
        int length2 = iArr2.length;
        int[] copyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(iArr2, 0, copyOf, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final long[] plus(@NotNull long[] jArr, @NotNull long[] jArr2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(jArr2, MessengerShareContentUtility.ELEMENTS);
        int length = jArr.length;
        int length2 = jArr2.length;
        long[] copyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(jArr2, 0, copyOf, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final float[] plus(@NotNull float[] fArr, @NotNull float[] fArr2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(fArr2, MessengerShareContentUtility.ELEMENTS);
        int length = fArr.length;
        int length2 = fArr2.length;
        float[] copyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(fArr2, 0, copyOf, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final double[] plus(@NotNull double[] dArr, @NotNull double[] dArr2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(dArr2, MessengerShareContentUtility.ELEMENTS);
        int length = dArr.length;
        int length2 = dArr2.length;
        double[] copyOf = Arrays.copyOf(dArr, length + length2);
        System.arraycopy(dArr2, 0, copyOf, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final boolean[] plus(@NotNull boolean[] zArr, @NotNull boolean[] zArr2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(zArr2, MessengerShareContentUtility.ELEMENTS);
        int length = zArr.length;
        int length2 = zArr2.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(zArr2, 0, copyOf, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    @NotNull
    public static final char[] plus(@NotNull char[] cArr, @NotNull char[] cArr2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cArr2, MessengerShareContentUtility.ELEMENTS);
        int length = cArr.length;
        int length2 = cArr2.length;
        char[] copyOf = Arrays.copyOf(cArr, length + length2);
        System.arraycopy(cArr2, 0, copyOf, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "result");
        return copyOf;
    }

    public static final void sort(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    public static final void sort(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (jArr.length > 1) {
            Arrays.sort(jArr);
        }
    }

    public static final void sort(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (bArr.length > 1) {
            Arrays.sort(bArr);
        }
    }

    public static final void sort(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (sArr.length > 1) {
            Arrays.sort(sArr);
        }
    }

    public static final void sort(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (dArr.length > 1) {
            Arrays.sort(dArr);
        }
    }

    public static final void sort(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (fArr.length > 1) {
            Arrays.sort(fArr);
        }
    }

    public static final void sort(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (cArr.length > 1) {
            Arrays.sort(cArr);
        }
    }

    public static final <T> void sort(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static /* synthetic */ void sort$default(Object[] objArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = objArr.length;
        }
        sort((T[]) objArr, i, i2);
    }

    public static final <T> void sort(@NotNull T[] tArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Arrays.sort(tArr, i, i2);
    }

    public static /* synthetic */ void sort$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        sort(bArr, i, i2);
    }

    public static final void sort(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Arrays.sort(bArr, i, i2);
    }

    public static /* synthetic */ void sort$default(short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = sArr.length;
        }
        sort(sArr, i, i2);
    }

    public static final void sort(@NotNull short[] sArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Arrays.sort(sArr, i, i2);
    }

    public static /* synthetic */ void sort$default(int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = iArr.length;
        }
        sort(iArr, i, i2);
    }

    public static final void sort(@NotNull int[] iArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Arrays.sort(iArr, i, i2);
    }

    public static /* synthetic */ void sort$default(long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = jArr.length;
        }
        sort(jArr, i, i2);
    }

    public static final void sort(@NotNull long[] jArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Arrays.sort(jArr, i, i2);
    }

    public static /* synthetic */ void sort$default(float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = fArr.length;
        }
        sort(fArr, i, i2);
    }

    public static final void sort(@NotNull float[] fArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Arrays.sort(fArr, i, i2);
    }

    public static /* synthetic */ void sort$default(double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = dArr.length;
        }
        sort(dArr, i, i2);
    }

    public static final void sort(@NotNull double[] dArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Arrays.sort(dArr, i, i2);
    }

    public static /* synthetic */ void sort$default(char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = cArr.length;
        }
        sort(cArr, i, i2);
    }

    public static final void sort(@NotNull char[] cArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Arrays.sort(cArr, i, i2);
    }

    public static final <T> void sortWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static /* synthetic */ void sortWith$default(Object[] objArr, Comparator comparator, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        sortWith(objArr, comparator, i, i2);
    }

    public static final <T> void sortWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        Arrays.sort(tArr, i, i2, comparator);
    }

    @NotNull
    public static final Byte[] toTypedArray(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Byte[] bArr2 = new Byte[bArr.length];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    @NotNull
    public static final Short[] toTypedArray(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Short[] shArr = new Short[sArr.length];
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            shArr[i] = Short.valueOf(sArr[i]);
        }
        return shArr;
    }

    @NotNull
    public static final Integer[] toTypedArray(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    @NotNull
    public static final Long[] toTypedArray(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    @NotNull
    public static final Float[] toTypedArray(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    @NotNull
    public static final Double[] toTypedArray(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Double[] dArr2 = new Double[dArr.length];
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    @NotNull
    public static final Boolean[] toTypedArray(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    @NotNull
    public static final Character[] toTypedArray(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            chArr[i] = Character.valueOf(cArr[i]);
        }
        return chArr;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(tArr, new TreeSet());
    }

    @NotNull
    public static final SortedSet<Byte> toSortedSet(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(bArr, new TreeSet());
    }

    @NotNull
    public static final SortedSet<Short> toSortedSet(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(sArr, new TreeSet());
    }

    @NotNull
    public static final SortedSet<Integer> toSortedSet(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(iArr, new TreeSet());
    }

    @NotNull
    public static final SortedSet<Long> toSortedSet(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(jArr, new TreeSet());
    }

    @NotNull
    public static final SortedSet<Float> toSortedSet(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(fArr, new TreeSet());
    }

    @NotNull
    public static final SortedSet<Double> toSortedSet(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(dArr, new TreeSet());
    }

    @NotNull
    public static final SortedSet<Boolean> toSortedSet(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(zArr, new TreeSet());
    }

    @NotNull
    public static final SortedSet<Character> toSortedSet(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(cArr, new TreeSet());
    }

    @NotNull
    public static final <T> SortedSet<T> toSortedSet(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return (SortedSet) ArraysKt___ArraysKt.toCollection(tArr, new TreeSet(comparator));
    }
}
