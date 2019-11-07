package kotlin.collections;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$2;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ArraysKt___ArraysKt extends ArraysKt___ArraysJvmKt {
    public static final <T> boolean contains(@NotNull T[] tArr, T t) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        return indexOf(tArr, t) >= 0;
    }

    public static boolean contains(@NotNull byte[] bArr, byte b) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        return indexOf(bArr, b) >= 0;
    }

    public static boolean contains(@NotNull short[] sArr, short s) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        return indexOf(sArr, s) >= 0;
    }

    public static boolean contains(@NotNull int[] iArr, int i) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        return indexOf(iArr, i) >= 0;
    }

    public static boolean contains(@NotNull long[] jArr, long j) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        return indexOf(jArr, j) >= 0;
    }

    public static final boolean contains(@NotNull float[] fArr, float f) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        return indexOf(fArr, f) >= 0;
    }

    public static final boolean contains(@NotNull double[] dArr, double d) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        return indexOf(dArr, d) >= 0;
    }

    public static final boolean contains(@NotNull boolean[] zArr, boolean z) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        return indexOf(zArr, z) >= 0;
    }

    public static boolean contains(@NotNull char[] cArr, char c) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        return indexOf(cArr, c) >= 0;
    }

    public static final <T> T first(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (!(tArr.length == 0)) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final byte first(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (!(bArr.length == 0)) {
            return bArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final short first(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (!(sArr.length == 0)) {
            return sArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static int first(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (!(iArr.length == 0)) {
            return iArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final long first(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (!(jArr.length == 0)) {
            return jArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final float first(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (!(fArr.length == 0)) {
            return fArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final double first(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (!(dArr.length == 0)) {
            return dArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final boolean first(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        if (!(zArr.length == 0)) {
            return zArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final char first(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (!(cArr.length == 0)) {
            return cArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> T first(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (T t : tArr) {
            if (((Boolean) function1.invoke(t)).booleanValue()) {
                return t;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final byte first(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (byte b : bArr) {
            if (((Boolean) function1.invoke(Byte.valueOf(b))).booleanValue()) {
                return b;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final short first(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (short s : sArr) {
            if (((Boolean) function1.invoke(Short.valueOf(s))).booleanValue()) {
                return s;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final int first(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int i : iArr) {
            if (((Boolean) function1.invoke(Integer.valueOf(i))).booleanValue()) {
                return i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final long first(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (long j : jArr) {
            if (((Boolean) function1.invoke(Long.valueOf(j))).booleanValue()) {
                return j;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final float first(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (float f : fArr) {
            if (((Boolean) function1.invoke(Float.valueOf(f))).booleanValue()) {
                return f;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final double first(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (double d : dArr) {
            if (((Boolean) function1.invoke(Double.valueOf(d))).booleanValue()) {
                return d;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final boolean first(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (boolean z : zArr) {
            if (((Boolean) function1.invoke(Boolean.valueOf(z))).booleanValue()) {
                return z;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final char first(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (char c : cArr) {
            if (((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                return c;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Nullable
    public static final <T> T firstOrNull(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    @Nullable
    public static final Byte firstOrNull(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[0]);
    }

    @Nullable
    public static final Short firstOrNull(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[0]);
    }

    @Nullable
    public static final Integer firstOrNull(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    @Nullable
    public static final Long firstOrNull(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[0]);
    }

    @Nullable
    public static final Float firstOrNull(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    @Nullable
    public static final Double firstOrNull(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[0]);
    }

    @Nullable
    public static final Boolean firstOrNull(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[0]);
    }

    @Nullable
    public static final Character firstOrNull(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[0]);
    }

    @Nullable
    public static final <T> T firstOrNull(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (T t : tArr) {
            if (((Boolean) function1.invoke(t)).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    @Nullable
    public static final Byte firstOrNull(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (byte b : bArr) {
            if (((Boolean) function1.invoke(Byte.valueOf(b))).booleanValue()) {
                return Byte.valueOf(b);
            }
        }
        return null;
    }

    @Nullable
    public static final Short firstOrNull(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (short s : sArr) {
            if (((Boolean) function1.invoke(Short.valueOf(s))).booleanValue()) {
                return Short.valueOf(s);
            }
        }
        return null;
    }

    @Nullable
    public static final Integer firstOrNull(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int i : iArr) {
            if (((Boolean) function1.invoke(Integer.valueOf(i))).booleanValue()) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    @Nullable
    public static final Long firstOrNull(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (long j : jArr) {
            if (((Boolean) function1.invoke(Long.valueOf(j))).booleanValue()) {
                return Long.valueOf(j);
            }
        }
        return null;
    }

    @Nullable
    public static final Float firstOrNull(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (float f : fArr) {
            if (((Boolean) function1.invoke(Float.valueOf(f))).booleanValue()) {
                return Float.valueOf(f);
            }
        }
        return null;
    }

    @Nullable
    public static final Double firstOrNull(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (double d : dArr) {
            if (((Boolean) function1.invoke(Double.valueOf(d))).booleanValue()) {
                return Double.valueOf(d);
            }
        }
        return null;
    }

    @Nullable
    public static final Boolean firstOrNull(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (boolean z : zArr) {
            if (((Boolean) function1.invoke(Boolean.valueOf(z))).booleanValue()) {
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    @Nullable
    public static final Character firstOrNull(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (char c : cArr) {
            if (((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                return Character.valueOf(c);
            }
        }
        return null;
    }

    @Nullable
    public static final <T> T getOrNull(@NotNull T[] tArr, int i) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (i < 0 || i > getLastIndex(tArr)) {
            return null;
        }
        return tArr[i];
    }

    @Nullable
    public static final Byte getOrNull(@NotNull byte[] bArr, int i) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (i < 0 || i > getLastIndex(bArr)) {
            return null;
        }
        return Byte.valueOf(bArr[i]);
    }

    @Nullable
    public static final Short getOrNull(@NotNull short[] sArr, int i) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (i < 0 || i > getLastIndex(sArr)) {
            return null;
        }
        return Short.valueOf(sArr[i]);
    }

    @Nullable
    public static final Integer getOrNull(@NotNull int[] iArr, int i) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (i < 0 || i > getLastIndex(iArr)) {
            return null;
        }
        return Integer.valueOf(iArr[i]);
    }

    @Nullable
    public static final Long getOrNull(@NotNull long[] jArr, int i) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (i < 0 || i > getLastIndex(jArr)) {
            return null;
        }
        return Long.valueOf(jArr[i]);
    }

    @Nullable
    public static final Float getOrNull(@NotNull float[] fArr, int i) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (i < 0 || i > getLastIndex(fArr)) {
            return null;
        }
        return Float.valueOf(fArr[i]);
    }

    @Nullable
    public static final Double getOrNull(@NotNull double[] dArr, int i) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (i < 0 || i > getLastIndex(dArr)) {
            return null;
        }
        return Double.valueOf(dArr[i]);
    }

    @Nullable
    public static final Boolean getOrNull(@NotNull boolean[] zArr, int i) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        if (i < 0 || i > getLastIndex(zArr)) {
            return null;
        }
        return Boolean.valueOf(zArr[i]);
    }

    @Nullable
    public static final Character getOrNull(@NotNull char[] cArr, int i) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (i < 0 || i > getLastIndex(cArr)) {
            return null;
        }
        return Character.valueOf(cArr[i]);
    }

    public static final <T> int indexOf(@NotNull T[] tArr, T t) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
        } else {
            int length2 = tArr.length;
            while (i < length2) {
                if (Intrinsics.areEqual((Object) t, (Object) tArr[i])) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public static final int indexOf(@NotNull byte[] bArr, byte b) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (b == bArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOf(@NotNull short[] sArr, short s) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            if (s == sArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOf(@NotNull int[] iArr, int i) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOf(@NotNull long[] jArr, long j) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (j == jArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOf(@NotNull float[] fArr, float f) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (f == fArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOf(@NotNull double[] dArr, double d) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (d == dArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOf(@NotNull boolean[] zArr, boolean z) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (z == zArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOf(@NotNull char[] cArr, char c) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            if (c == cArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final <T> int indexOfFirst(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (((Boolean) function1.invoke(tArr[i])).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (((Boolean) function1.invoke(Byte.valueOf(bArr[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            if (((Boolean) function1.invoke(Short.valueOf(sArr[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (((Boolean) function1.invoke(Integer.valueOf(iArr[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (((Boolean) function1.invoke(Long.valueOf(jArr[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (((Boolean) function1.invoke(Float.valueOf(fArr[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (((Boolean) function1.invoke(Double.valueOf(dArr[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (((Boolean) function1.invoke(Boolean.valueOf(zArr[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            if (((Boolean) function1.invoke(Character.valueOf(cArr[i]))).booleanValue()) {
                return i;
            }
        }
        return -1;
    }

    public static final <T> int indexOfLast(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(tArr))) {
            int intValue2 = intValue.intValue();
            if (((Boolean) function1.invoke(tArr[intValue2])).booleanValue()) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(bArr))) {
            int intValue2 = intValue.intValue();
            if (((Boolean) function1.invoke(Byte.valueOf(bArr[intValue2]))).booleanValue()) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(sArr))) {
            int intValue2 = intValue.intValue();
            if (((Boolean) function1.invoke(Short.valueOf(sArr[intValue2]))).booleanValue()) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(iArr))) {
            int intValue2 = intValue.intValue();
            if (((Boolean) function1.invoke(Integer.valueOf(iArr[intValue2]))).booleanValue()) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(jArr))) {
            int intValue2 = intValue.intValue();
            if (((Boolean) function1.invoke(Long.valueOf(jArr[intValue2]))).booleanValue()) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(fArr))) {
            int intValue2 = intValue.intValue();
            if (((Boolean) function1.invoke(Float.valueOf(fArr[intValue2]))).booleanValue()) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(dArr))) {
            int intValue2 = intValue.intValue();
            if (((Boolean) function1.invoke(Double.valueOf(dArr[intValue2]))).booleanValue()) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(zArr))) {
            int intValue2 = intValue.intValue();
            if (((Boolean) function1.invoke(Boolean.valueOf(zArr[intValue2]))).booleanValue()) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(cArr))) {
            int intValue2 = intValue.intValue();
            if (((Boolean) function1.invoke(Character.valueOf(cArr[intValue2]))).booleanValue()) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final <T> T last(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (!(tArr.length == 0)) {
            return tArr[getLastIndex(tArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final byte last(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (!(bArr.length == 0)) {
            return bArr[getLastIndex(bArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final short last(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (!(sArr.length == 0)) {
            return sArr[getLastIndex(sArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int last(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (!(iArr.length == 0)) {
            return iArr[getLastIndex(iArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final long last(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (!(jArr.length == 0)) {
            return jArr[getLastIndex(jArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final float last(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (!(fArr.length == 0)) {
            return fArr[getLastIndex(fArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final double last(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (!(dArr.length == 0)) {
            return dArr[getLastIndex(dArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final boolean last(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        if (!(zArr.length == 0)) {
            return zArr[getLastIndex(zArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final char last(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (!(cArr.length == 0)) {
            return cArr[getLastIndex(cArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> T last(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(tArr))) {
            T t = tArr[intValue.intValue()];
            if (((Boolean) function1.invoke(t)).booleanValue()) {
                return t;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final byte last(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(bArr))) {
            byte b = bArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Byte.valueOf(b))).booleanValue()) {
                return b;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final short last(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(sArr))) {
            short s = sArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Short.valueOf(s))).booleanValue()) {
                return s;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final int last(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(iArr))) {
            int i = iArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Integer.valueOf(i))).booleanValue()) {
                return i;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final long last(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(jArr))) {
            long j = jArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Long.valueOf(j))).booleanValue()) {
                return j;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final float last(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(fArr))) {
            float f = fArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Float.valueOf(f))).booleanValue()) {
                return f;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final double last(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(dArr))) {
            double d = dArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Double.valueOf(d))).booleanValue()) {
                return d;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final boolean last(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(zArr))) {
            boolean z = zArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Boolean.valueOf(z))).booleanValue()) {
                return z;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final char last(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(cArr))) {
            char c = cArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                return c;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final <T> int lastIndexOf(@NotNull T[] tArr, T t) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (t == null) {
            for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(tArr))) {
                int intValue2 = intValue.intValue();
                if (tArr[intValue2] == null) {
                    return intValue2;
                }
            }
        } else {
            for (Number intValue3 : CollectionsKt___CollectionsKt.reversed(getIndices(tArr))) {
                int intValue4 = intValue3.intValue();
                if (Intrinsics.areEqual((Object) t, (Object) tArr[intValue4])) {
                    return intValue4;
                }
            }
        }
        return -1;
    }

    public static final int lastIndexOf(@NotNull byte[] bArr, byte b) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(bArr))) {
            int intValue2 = intValue.intValue();
            if (b == bArr[intValue2]) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final int lastIndexOf(@NotNull short[] sArr, short s) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(sArr))) {
            int intValue2 = intValue.intValue();
            if (s == sArr[intValue2]) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final int lastIndexOf(@NotNull int[] iArr, int i) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(iArr))) {
            int intValue2 = intValue.intValue();
            if (i == iArr[intValue2]) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final int lastIndexOf(@NotNull long[] jArr, long j) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(jArr))) {
            int intValue2 = intValue.intValue();
            if (j == jArr[intValue2]) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final int lastIndexOf(@NotNull float[] fArr, float f) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(fArr))) {
            int intValue2 = intValue.intValue();
            if (f == fArr[intValue2]) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final int lastIndexOf(@NotNull double[] dArr, double d) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(dArr))) {
            int intValue2 = intValue.intValue();
            if (d == dArr[intValue2]) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final int lastIndexOf(@NotNull boolean[] zArr, boolean z) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(zArr))) {
            int intValue2 = intValue.intValue();
            if (z == zArr[intValue2]) {
                return intValue2;
            }
        }
        return -1;
    }

    public static final int lastIndexOf(@NotNull char[] cArr, char c) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(cArr))) {
            int intValue2 = intValue.intValue();
            if (c == cArr[intValue2]) {
                return intValue2;
            }
        }
        return -1;
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    @Nullable
    public static final Byte lastOrNull(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[bArr.length - 1]);
    }

    @Nullable
    public static final Short lastOrNull(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[sArr.length - 1]);
    }

    @Nullable
    public static final Integer lastOrNull(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[iArr.length - 1]);
    }

    @Nullable
    public static final Long lastOrNull(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[jArr.length - 1]);
    }

    @Nullable
    public static final Float lastOrNull(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[fArr.length - 1]);
    }

    @Nullable
    public static final Double lastOrNull(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[dArr.length - 1]);
    }

    @Nullable
    public static final Boolean lastOrNull(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[zArr.length - 1]);
    }

    @Nullable
    public static final Character lastOrNull(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[cArr.length - 1]);
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(tArr))) {
            T t = tArr[intValue.intValue()];
            if (((Boolean) function1.invoke(t)).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    @Nullable
    public static final Byte lastOrNull(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(bArr))) {
            byte b = bArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Byte.valueOf(b))).booleanValue()) {
                return Byte.valueOf(b);
            }
        }
        return null;
    }

    @Nullable
    public static final Short lastOrNull(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(sArr))) {
            short s = sArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Short.valueOf(s))).booleanValue()) {
                return Short.valueOf(s);
            }
        }
        return null;
    }

    @Nullable
    public static final Integer lastOrNull(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(iArr))) {
            int i = iArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Integer.valueOf(i))).booleanValue()) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    @Nullable
    public static final Long lastOrNull(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(jArr))) {
            long j = jArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Long.valueOf(j))).booleanValue()) {
                return Long.valueOf(j);
            }
        }
        return null;
    }

    @Nullable
    public static final Float lastOrNull(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(fArr))) {
            float f = fArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Float.valueOf(f))).booleanValue()) {
                return Float.valueOf(f);
            }
        }
        return null;
    }

    @Nullable
    public static final Double lastOrNull(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(dArr))) {
            double d = dArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Double.valueOf(d))).booleanValue()) {
                return Double.valueOf(d);
            }
        }
        return null;
    }

    @Nullable
    public static final Boolean lastOrNull(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(zArr))) {
            boolean z = zArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Boolean.valueOf(z))).booleanValue()) {
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    @Nullable
    public static final Character lastOrNull(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (Number intValue : CollectionsKt___CollectionsKt.reversed(getIndices(cArr))) {
            char c = cArr[intValue.intValue()];
            if (((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                return Character.valueOf(c);
            }
        }
        return null;
    }

    public static final <T> T random(@NotNull T[] tArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!(tArr.length == 0)) {
            return tArr[random.nextInt(tArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final byte random(@NotNull byte[] bArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!(bArr.length == 0)) {
            return bArr[random.nextInt(bArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final short random(@NotNull short[] sArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!(sArr.length == 0)) {
            return sArr[random.nextInt(sArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int random(@NotNull int[] iArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!(iArr.length == 0)) {
            return iArr[random.nextInt(iArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final long random(@NotNull long[] jArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!(jArr.length == 0)) {
            return jArr[random.nextInt(jArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final float random(@NotNull float[] fArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!(fArr.length == 0)) {
            return fArr[random.nextInt(fArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final double random(@NotNull double[] dArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!(dArr.length == 0)) {
            return dArr[random.nextInt(dArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final boolean random(@NotNull boolean[] zArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!(zArr.length == 0)) {
            return zArr[random.nextInt(zArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final char random(@NotNull char[] cArr, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        if (!(cArr.length == 0)) {
            return cArr[random.nextInt(cArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> T single(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return tArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final byte single(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        int length = bArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return bArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final short single(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        int length = sArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return sArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final int single(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        int length = iArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return iArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final long single(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        int length = jArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return jArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final float single(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        int length = fArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return fArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final double single(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        int length = dArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return dArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final boolean single(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        int length = zArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return zArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static char single(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final <T> T single(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : tArr) {
            if (((Boolean) function1.invoke(t2)).booleanValue()) {
                if (!z) {
                    z = true;
                    t = t2;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final byte single(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Byte b = null;
        boolean z = false;
        for (byte b2 : bArr) {
            if (((Boolean) function1.invoke(Byte.valueOf(b2))).booleanValue()) {
                if (!z) {
                    b = Byte.valueOf(b2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } else if (b != null) {
            return b.byteValue();
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Byte");
        }
    }

    public static final short single(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Short sh = null;
        boolean z = false;
        for (short s : sArr) {
            if (((Boolean) function1.invoke(Short.valueOf(s))).booleanValue()) {
                if (!z) {
                    sh = Short.valueOf(s);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } else if (sh != null) {
            return sh.shortValue();
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Short");
        }
    }

    public static final int single(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Integer num = null;
        boolean z = false;
        for (int i : iArr) {
            if (((Boolean) function1.invoke(Integer.valueOf(i))).booleanValue()) {
                if (!z) {
                    num = Integer.valueOf(i);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } else if (num != null) {
            return num.intValue();
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final long single(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Long l = null;
        boolean z = false;
        for (long j : jArr) {
            if (((Boolean) function1.invoke(Long.valueOf(j))).booleanValue()) {
                if (!z) {
                    l = Long.valueOf(j);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } else if (l != null) {
            return l.longValue();
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
        }
    }

    public static final float single(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Float f = null;
        boolean z = false;
        for (float f2 : fArr) {
            if (((Boolean) function1.invoke(Float.valueOf(f2))).booleanValue()) {
                if (!z) {
                    f = Float.valueOf(f2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } else if (f != null) {
            return f.floatValue();
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final double single(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Double d = null;
        boolean z = false;
        for (double d2 : dArr) {
            if (((Boolean) function1.invoke(Double.valueOf(d2))).booleanValue()) {
                if (!z) {
                    d = Double.valueOf(d2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } else if (d != null) {
            return d.doubleValue();
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
        }
    }

    public static final boolean single(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Boolean bool = null;
        boolean z = false;
        for (boolean z2 : zArr) {
            if (((Boolean) function1.invoke(Boolean.valueOf(z2))).booleanValue()) {
                if (!z) {
                    bool = Boolean.valueOf(z2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } else if (bool != null) {
            return bool.booleanValue();
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
        }
    }

    public static final char single(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Character ch = null;
        boolean z = false;
        for (char c : cArr) {
            if (((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                if (!z) {
                    ch = Character.valueOf(c);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } else if (ch != null) {
            return ch.charValue();
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Char");
        }
    }

    @Nullable
    public static final <T> T singleOrNull(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    @Nullable
    public static final Byte singleOrNull(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (bArr.length == 1) {
            return Byte.valueOf(bArr[0]);
        }
        return null;
    }

    @Nullable
    public static final Short singleOrNull(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (sArr.length == 1) {
            return Short.valueOf(sArr[0]);
        }
        return null;
    }

    @Nullable
    public static final Integer singleOrNull(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (iArr.length == 1) {
            return Integer.valueOf(iArr[0]);
        }
        return null;
    }

    @Nullable
    public static final Long singleOrNull(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (jArr.length == 1) {
            return Long.valueOf(jArr[0]);
        }
        return null;
    }

    @Nullable
    public static final Float singleOrNull(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (fArr.length == 1) {
            return Float.valueOf(fArr[0]);
        }
        return null;
    }

    @Nullable
    public static final Double singleOrNull(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (dArr.length == 1) {
            return Double.valueOf(dArr[0]);
        }
        return null;
    }

    @Nullable
    public static final Boolean singleOrNull(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        if (zArr.length == 1) {
            return Boolean.valueOf(zArr[0]);
        }
        return null;
    }

    @Nullable
    public static final Character singleOrNull(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (cArr.length == 1) {
            return Character.valueOf(cArr[0]);
        }
        return null;
    }

    @Nullable
    public static final <T> T singleOrNull(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : tArr) {
            if (((Boolean) function1.invoke(t2)).booleanValue()) {
                if (z) {
                    return null;
                }
                z = true;
                t = t2;
            }
        }
        if (!z) {
            return null;
        }
        return t;
    }

    @Nullable
    public static final Byte singleOrNull(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Byte b = null;
        boolean z = false;
        for (byte b2 : bArr) {
            if (((Boolean) function1.invoke(Byte.valueOf(b2))).booleanValue()) {
                if (z) {
                    return null;
                }
                b = Byte.valueOf(b2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return b;
    }

    @Nullable
    public static final Short singleOrNull(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Short sh = null;
        boolean z = false;
        for (short s : sArr) {
            if (((Boolean) function1.invoke(Short.valueOf(s))).booleanValue()) {
                if (z) {
                    return null;
                }
                sh = Short.valueOf(s);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return sh;
    }

    @Nullable
    public static final Integer singleOrNull(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Integer num = null;
        boolean z = false;
        for (int i : iArr) {
            if (((Boolean) function1.invoke(Integer.valueOf(i))).booleanValue()) {
                if (z) {
                    return null;
                }
                num = Integer.valueOf(i);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return num;
    }

    @Nullable
    public static final Long singleOrNull(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Long l = null;
        boolean z = false;
        for (long j : jArr) {
            if (((Boolean) function1.invoke(Long.valueOf(j))).booleanValue()) {
                if (z) {
                    return null;
                }
                l = Long.valueOf(j);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return l;
    }

    @Nullable
    public static final Float singleOrNull(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Float f = null;
        boolean z = false;
        for (float f2 : fArr) {
            if (((Boolean) function1.invoke(Float.valueOf(f2))).booleanValue()) {
                if (z) {
                    return null;
                }
                f = Float.valueOf(f2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return f;
    }

    @Nullable
    public static final Double singleOrNull(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Double d = null;
        boolean z = false;
        for (double d2 : dArr) {
            if (((Boolean) function1.invoke(Double.valueOf(d2))).booleanValue()) {
                if (z) {
                    return null;
                }
                d = Double.valueOf(d2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return d;
    }

    @Nullable
    public static final Boolean singleOrNull(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Boolean bool = null;
        boolean z = false;
        for (boolean z2 : zArr) {
            if (((Boolean) function1.invoke(Boolean.valueOf(z2))).booleanValue()) {
                if (z) {
                    return null;
                }
                bool = Boolean.valueOf(z2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return bool;
    }

    @Nullable
    public static final Character singleOrNull(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        Character ch = null;
        boolean z = false;
        for (char c : cArr) {
            if (((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                if (z) {
                    return null;
                }
                ch = Character.valueOf(c);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return ch;
    }

    @NotNull
    public static final <T> List<T> drop(@NotNull T[] tArr, int i) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (i >= 0) {
            return takeLast(tArr, RangesKt___RangesKt.coerceAtLeast(tArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Byte> drop(@NotNull byte[] bArr, int i) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (i >= 0) {
            return takeLast(bArr, RangesKt___RangesKt.coerceAtLeast(bArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Short> drop(@NotNull short[] sArr, int i) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (i >= 0) {
            return takeLast(sArr, RangesKt___RangesKt.coerceAtLeast(sArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Integer> drop(@NotNull int[] iArr, int i) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (i >= 0) {
            return takeLast(iArr, RangesKt___RangesKt.coerceAtLeast(iArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Long> drop(@NotNull long[] jArr, int i) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (i >= 0) {
            return takeLast(jArr, RangesKt___RangesKt.coerceAtLeast(jArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Float> drop(@NotNull float[] fArr, int i) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (i >= 0) {
            return takeLast(fArr, RangesKt___RangesKt.coerceAtLeast(fArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Double> drop(@NotNull double[] dArr, int i) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (i >= 0) {
            return takeLast(dArr, RangesKt___RangesKt.coerceAtLeast(dArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Boolean> drop(@NotNull boolean[] zArr, int i) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        if (i >= 0) {
            return takeLast(zArr, RangesKt___RangesKt.coerceAtLeast(zArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Character> drop(@NotNull char[] cArr, int i) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (i >= 0) {
            return takeLast(cArr, RangesKt___RangesKt.coerceAtLeast(cArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final <T> List<T> dropLast(@NotNull T[] tArr, int i) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (i >= 0) {
            return take(tArr, RangesKt___RangesKt.coerceAtLeast(tArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Byte> dropLast(@NotNull byte[] bArr, int i) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (i >= 0) {
            return take(bArr, RangesKt___RangesKt.coerceAtLeast(bArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Short> dropLast(@NotNull short[] sArr, int i) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (i >= 0) {
            return take(sArr, RangesKt___RangesKt.coerceAtLeast(sArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Integer> dropLast(@NotNull int[] iArr, int i) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (i >= 0) {
            return take(iArr, RangesKt___RangesKt.coerceAtLeast(iArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Long> dropLast(@NotNull long[] jArr, int i) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (i >= 0) {
            return take(jArr, RangesKt___RangesKt.coerceAtLeast(jArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Float> dropLast(@NotNull float[] fArr, int i) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (i >= 0) {
            return take(fArr, RangesKt___RangesKt.coerceAtLeast(fArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Double> dropLast(@NotNull double[] dArr, int i) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (i >= 0) {
            return take(dArr, RangesKt___RangesKt.coerceAtLeast(dArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Boolean> dropLast(@NotNull boolean[] zArr, int i) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        if (i >= 0) {
            return take(zArr, RangesKt___RangesKt.coerceAtLeast(zArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final List<Character> dropLast(@NotNull char[] cArr, int i) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (i >= 0) {
            return take(cArr, RangesKt___RangesKt.coerceAtLeast(cArr.length - i, 0));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Requested element count ");
        sb.append(i);
        sb.append(" is less than zero.");
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public static final <T> List<T> dropLastWhile(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(tArr[lastIndex])).booleanValue()) {
                return take(tArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Byte> dropLastWhile(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Byte.valueOf(bArr[lastIndex]))).booleanValue()) {
                return take(bArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Short> dropLastWhile(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Short.valueOf(sArr[lastIndex]))).booleanValue()) {
                return take(sArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Integer> dropLastWhile(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Integer.valueOf(iArr[lastIndex]))).booleanValue()) {
                return take(iArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Long> dropLastWhile(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Long.valueOf(jArr[lastIndex]))).booleanValue()) {
                return take(jArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Float> dropLastWhile(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Float.valueOf(fArr[lastIndex]))).booleanValue()) {
                return take(fArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Double> dropLastWhile(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Double.valueOf(dArr[lastIndex]))).booleanValue()) {
                return take(dArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Boolean> dropLastWhile(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Boolean.valueOf(zArr[lastIndex]))).booleanValue()) {
                return take(zArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Character> dropLastWhile(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Character.valueOf(cArr[lastIndex]))).booleanValue()) {
                return take(cArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final <T> List<T> dropWhile(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (T t : tArr) {
            if (z) {
                arrayList.add(t);
            } else if (!((Boolean) function1.invoke(t)).booleanValue()) {
                arrayList.add(t);
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Byte> dropWhile(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (byte b : bArr) {
            if (z) {
                arrayList.add(Byte.valueOf(b));
            } else if (!((Boolean) function1.invoke(Byte.valueOf(b))).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Short> dropWhile(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (short s : sArr) {
            if (z) {
                arrayList.add(Short.valueOf(s));
            } else if (!((Boolean) function1.invoke(Short.valueOf(s))).booleanValue()) {
                arrayList.add(Short.valueOf(s));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> dropWhile(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i : iArr) {
            if (z) {
                arrayList.add(Integer.valueOf(i));
            } else if (!((Boolean) function1.invoke(Integer.valueOf(i))).booleanValue()) {
                arrayList.add(Integer.valueOf(i));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> dropWhile(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (long j : jArr) {
            if (z) {
                arrayList.add(Long.valueOf(j));
            } else if (!((Boolean) function1.invoke(Long.valueOf(j))).booleanValue()) {
                arrayList.add(Long.valueOf(j));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> dropWhile(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (float f : fArr) {
            if (z) {
                arrayList.add(Float.valueOf(f));
            } else if (!((Boolean) function1.invoke(Float.valueOf(f))).booleanValue()) {
                arrayList.add(Float.valueOf(f));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> dropWhile(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (double d : dArr) {
            if (z) {
                arrayList.add(Double.valueOf(d));
            } else if (!((Boolean) function1.invoke(Double.valueOf(d))).booleanValue()) {
                arrayList.add(Double.valueOf(d));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> dropWhile(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (boolean z2 : zArr) {
            if (z) {
                arrayList.add(Boolean.valueOf(z2));
            } else if (!((Boolean) function1.invoke(Boolean.valueOf(z2))).booleanValue()) {
                arrayList.add(Boolean.valueOf(z2));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Character> dropWhile(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (char c : cArr) {
            if (z) {
                arrayList.add(Character.valueOf(c));
            } else if (!((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                arrayList.add(Character.valueOf(c));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filter(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (((Boolean) function1.invoke(t)).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Byte> filter(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (((Boolean) function1.invoke(Byte.valueOf(b))).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Short> filter(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (((Boolean) function1.invoke(Short.valueOf(s))).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> filter(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (((Boolean) function1.invoke(Integer.valueOf(i))).booleanValue()) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> filter(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (((Boolean) function1.invoke(Long.valueOf(j))).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> filter(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f : fArr) {
            if (((Boolean) function1.invoke(Float.valueOf(f))).booleanValue()) {
                arrayList.add(Float.valueOf(f));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> filter(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (((Boolean) function1.invoke(Double.valueOf(d))).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> filter(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (((Boolean) function1.invoke(Boolean.valueOf(z))).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Character> filter(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filterIndexed(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            T t = tArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), t)).booleanValue()) {
                arrayList.add(t);
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Byte> filterIndexed(@NotNull byte[] bArr, @NotNull Function2<? super Integer, ? super Byte, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Byte.valueOf(b))).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Short> filterIndexed(@NotNull short[] sArr, @NotNull Function2<? super Integer, ? super Short, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            short s = sArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Short.valueOf(s))).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> filterIndexed(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue()) {
                arrayList.add(Integer.valueOf(i3));
            }
            i++;
            i2 = i4;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> filterIndexed(@NotNull long[] jArr, @NotNull Function2<? super Integer, ? super Long, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            long j = jArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Long.valueOf(j))).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> filterIndexed(@NotNull float[] fArr, @NotNull Function2<? super Integer, ? super Float, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            float f = fArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Float.valueOf(f))).booleanValue()) {
                arrayList.add(Float.valueOf(f));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> filterIndexed(@NotNull double[] dArr, @NotNull Function2<? super Integer, ? super Double, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            double d = dArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Double.valueOf(d))).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> filterIndexed(@NotNull boolean[] zArr, @NotNull Function2<? super Integer, ? super Boolean, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            boolean z = zArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Character> filterIndexed(@NotNull char[] cArr, @NotNull Function2<? super Integer, ? super Character, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char c = cArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Character.valueOf(c))).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filterNot(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (!((Boolean) function1.invoke(t)).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Byte> filterNot(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (!((Boolean) function1.invoke(Byte.valueOf(b))).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Short> filterNot(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (!((Boolean) function1.invoke(Short.valueOf(s))).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> filterNot(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (!((Boolean) function1.invoke(Integer.valueOf(i))).booleanValue()) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> filterNot(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (!((Boolean) function1.invoke(Long.valueOf(j))).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> filterNot(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f : fArr) {
            if (!((Boolean) function1.invoke(Float.valueOf(f))).booleanValue()) {
                arrayList.add(Float.valueOf(f));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> filterNot(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (!((Boolean) function1.invoke(Double.valueOf(d))).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> filterNot(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (!((Boolean) function1.invoke(Boolean.valueOf(z))).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Character> filterNot(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (!((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filterNotNull(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        return (List) filterNotNullTo(tArr, new ArrayList());
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C filterNotNullTo(@NotNull T[] tArr, @NotNull C c) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        for (T t : tArr) {
            if (t != null) {
                c.add(t);
            }
        }
        return c;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterNotTo(@NotNull T[] tArr, @NotNull C c, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (T t : tArr) {
            if (!((Boolean) function1.invoke(t)).booleanValue()) {
                c.add(t);
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C filterNotTo(@NotNull byte[] bArr, @NotNull C c, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (byte b : bArr) {
            if (!((Boolean) function1.invoke(Byte.valueOf(b))).booleanValue()) {
                c.add(Byte.valueOf(b));
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C filterNotTo(@NotNull short[] sArr, @NotNull C c, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (short s : sArr) {
            if (!((Boolean) function1.invoke(Short.valueOf(s))).booleanValue()) {
                c.add(Short.valueOf(s));
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C filterNotTo(@NotNull int[] iArr, @NotNull C c, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int i : iArr) {
            if (!((Boolean) function1.invoke(Integer.valueOf(i))).booleanValue()) {
                c.add(Integer.valueOf(i));
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C filterNotTo(@NotNull long[] jArr, @NotNull C c, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (long j : jArr) {
            if (!((Boolean) function1.invoke(Long.valueOf(j))).booleanValue()) {
                c.add(Long.valueOf(j));
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C filterNotTo(@NotNull float[] fArr, @NotNull C c, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (float f : fArr) {
            if (!((Boolean) function1.invoke(Float.valueOf(f))).booleanValue()) {
                c.add(Float.valueOf(f));
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C filterNotTo(@NotNull double[] dArr, @NotNull C c, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (double d : dArr) {
            if (!((Boolean) function1.invoke(Double.valueOf(d))).booleanValue()) {
                c.add(Double.valueOf(d));
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C filterNotTo(@NotNull boolean[] zArr, @NotNull C c, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (boolean z : zArr) {
            if (!((Boolean) function1.invoke(Boolean.valueOf(z))).booleanValue()) {
                c.add(Boolean.valueOf(z));
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C filterNotTo(@NotNull char[] cArr, @NotNull C c, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (char c2 : cArr) {
            if (!((Boolean) function1.invoke(Character.valueOf(c2))).booleanValue()) {
                c.add(Character.valueOf(c2));
            }
        }
        return c;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterTo(@NotNull T[] tArr, @NotNull C c, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (T t : tArr) {
            if (((Boolean) function1.invoke(t)).booleanValue()) {
                c.add(t);
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C filterTo(@NotNull byte[] bArr, @NotNull C c, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (byte b : bArr) {
            if (((Boolean) function1.invoke(Byte.valueOf(b))).booleanValue()) {
                c.add(Byte.valueOf(b));
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C filterTo(@NotNull short[] sArr, @NotNull C c, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (short s : sArr) {
            if (((Boolean) function1.invoke(Short.valueOf(s))).booleanValue()) {
                c.add(Short.valueOf(s));
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C filterTo(@NotNull int[] iArr, @NotNull C c, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int i : iArr) {
            if (((Boolean) function1.invoke(Integer.valueOf(i))).booleanValue()) {
                c.add(Integer.valueOf(i));
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C filterTo(@NotNull long[] jArr, @NotNull C c, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (long j : jArr) {
            if (((Boolean) function1.invoke(Long.valueOf(j))).booleanValue()) {
                c.add(Long.valueOf(j));
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C filterTo(@NotNull float[] fArr, @NotNull C c, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (float f : fArr) {
            if (((Boolean) function1.invoke(Float.valueOf(f))).booleanValue()) {
                c.add(Float.valueOf(f));
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C filterTo(@NotNull double[] dArr, @NotNull C c, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (double d : dArr) {
            if (((Boolean) function1.invoke(Double.valueOf(d))).booleanValue()) {
                c.add(Double.valueOf(d));
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C filterTo(@NotNull boolean[] zArr, @NotNull C c, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (boolean z : zArr) {
            if (((Boolean) function1.invoke(Boolean.valueOf(z))).booleanValue()) {
                c.add(Boolean.valueOf(z));
            }
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C filterTo(@NotNull char[] cArr, @NotNull C c, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (char c2 : cArr) {
            if (((Boolean) function1.invoke(Character.valueOf(c2))).booleanValue()) {
                c.add(Character.valueOf(c2));
            }
        }
        return c;
    }

    @NotNull
    public static final <T> List<T> slice(@NotNull T[] tArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList((T[]) ArraysKt___ArraysJvmKt.copyOfRange(tArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final List<Byte> slice(@NotNull byte[] bArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(bArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final List<Short> slice(@NotNull short[] sArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(sArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final List<Integer> slice(@NotNull int[] iArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(iArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final List<Long> slice(@NotNull long[] jArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(jArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final List<Float> slice(@NotNull float[] fArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(fArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final List<Double> slice(@NotNull double[] dArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(dArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final List<Boolean> slice(@NotNull boolean[] zArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(zArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final List<Character> slice(@NotNull char[] cArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(cArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final <T> List<T> slice(@NotNull T[] tArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Number intValue : iterable) {
            arrayList.add(tArr[intValue.intValue()]);
        }
        return arrayList;
    }

    @NotNull
    public static final List<Byte> slice(@NotNull byte[] bArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Number intValue : iterable) {
            arrayList.add(Byte.valueOf(bArr[intValue.intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Short> slice(@NotNull short[] sArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Number intValue : iterable) {
            arrayList.add(Short.valueOf(sArr[intValue.intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> slice(@NotNull int[] iArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Number intValue : iterable) {
            arrayList.add(Integer.valueOf(iArr[intValue.intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> slice(@NotNull long[] jArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Number intValue : iterable) {
            arrayList.add(Long.valueOf(jArr[intValue.intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> slice(@NotNull float[] fArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Number intValue : iterable) {
            arrayList.add(Float.valueOf(fArr[intValue.intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> slice(@NotNull double[] dArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Number intValue : iterable) {
            arrayList.add(Double.valueOf(dArr[intValue.intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> slice(@NotNull boolean[] zArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Number intValue : iterable) {
            arrayList.add(Boolean.valueOf(zArr[intValue.intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Character> slice(@NotNull char[] cArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Number intValue : iterable) {
            arrayList.add(Character.valueOf(cArr[intValue.intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final <T> T[] sliceArray(@NotNull T[] tArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, "indices");
        T[] arrayOfNulls = ArraysKt__ArraysJVMKt.arrayOfNulls(tArr, collection.size());
        int i = 0;
        for (Number intValue : collection) {
            int i2 = i + 1;
            arrayOfNulls[i] = tArr[intValue.intValue()];
            i = i2;
        }
        return arrayOfNulls;
    }

    @NotNull
    public static final byte[] sliceArray(@NotNull byte[] bArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, "indices");
        byte[] bArr2 = new byte[collection.size()];
        int i = 0;
        for (Number intValue : collection) {
            int i2 = i + 1;
            bArr2[i] = bArr[intValue.intValue()];
            i = i2;
        }
        return bArr2;
    }

    @NotNull
    public static final short[] sliceArray(@NotNull short[] sArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, "indices");
        short[] sArr2 = new short[collection.size()];
        int i = 0;
        for (Number intValue : collection) {
            int i2 = i + 1;
            sArr2[i] = sArr[intValue.intValue()];
            i = i2;
        }
        return sArr2;
    }

    @NotNull
    public static final int[] sliceArray(@NotNull int[] iArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, "indices");
        int[] iArr2 = new int[collection.size()];
        int i = 0;
        for (Number intValue : collection) {
            int i2 = i + 1;
            iArr2[i] = iArr[intValue.intValue()];
            i = i2;
        }
        return iArr2;
    }

    @NotNull
    public static final long[] sliceArray(@NotNull long[] jArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, "indices");
        long[] jArr2 = new long[collection.size()];
        int i = 0;
        for (Number intValue : collection) {
            int i2 = i + 1;
            jArr2[i] = jArr[intValue.intValue()];
            i = i2;
        }
        return jArr2;
    }

    @NotNull
    public static final float[] sliceArray(@NotNull float[] fArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, "indices");
        float[] fArr2 = new float[collection.size()];
        int i = 0;
        for (Number intValue : collection) {
            int i2 = i + 1;
            fArr2[i] = fArr[intValue.intValue()];
            i = i2;
        }
        return fArr2;
    }

    @NotNull
    public static final double[] sliceArray(@NotNull double[] dArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, "indices");
        double[] dArr2 = new double[collection.size()];
        int i = 0;
        for (Number intValue : collection) {
            int i2 = i + 1;
            dArr2[i] = dArr[intValue.intValue()];
            i = i2;
        }
        return dArr2;
    }

    @NotNull
    public static final boolean[] sliceArray(@NotNull boolean[] zArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, "indices");
        boolean[] zArr2 = new boolean[collection.size()];
        int i = 0;
        for (Number intValue : collection) {
            int i2 = i + 1;
            zArr2[i] = zArr[intValue.intValue()];
            i = i2;
        }
        return zArr2;
    }

    @NotNull
    public static final char[] sliceArray(@NotNull char[] cArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(collection, "indices");
        char[] cArr2 = new char[collection.size()];
        int i = 0;
        for (Number intValue : collection) {
            int i2 = i + 1;
            cArr2[i] = cArr[intValue.intValue()];
            i = i2;
        }
        return cArr2;
    }

    @NotNull
    public static final <T> T[] sliceArray(@NotNull T[] tArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return ArraysKt___ArraysJvmKt.copyOfRange(tArr, 0, 0);
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(tArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final byte[] sliceArray(@NotNull byte[] bArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return new byte[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(bArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final short[] sliceArray(@NotNull short[] sArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return new short[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(sArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final int[] sliceArray(@NotNull int[] iArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return new int[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(iArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final long[] sliceArray(@NotNull long[] jArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return new long[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(jArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final float[] sliceArray(@NotNull float[] fArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return new float[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(fArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final double[] sliceArray(@NotNull double[] dArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return new double[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(dArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final boolean[] sliceArray(@NotNull boolean[] zArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return new boolean[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(zArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final char[] sliceArray(@NotNull char[] cArr, @NotNull IntRange intRange) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(intRange, "indices");
        if (intRange.isEmpty()) {
            return new char[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(cArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final <T> List<T> take(@NotNull T[] tArr, int i) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        int i2 = 0;
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i >= tArr.length) {
                return toList(tArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(tArr[0]);
            }
            ArrayList arrayList = new ArrayList(i);
            int length = tArr.length;
            int i3 = 0;
            while (i2 < length) {
                T t = tArr[i2];
                int i4 = i3 + 1;
                if (i3 == i) {
                    break;
                }
                arrayList.add(t);
                i2++;
                i3 = i4;
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Byte> take(@NotNull byte[] bArr, int i) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        int i2 = 0;
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i >= bArr.length) {
                return toList(bArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Byte.valueOf(bArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int length = bArr.length;
            int i3 = 0;
            while (i2 < length) {
                byte b = bArr[i2];
                int i4 = i3 + 1;
                if (i3 == i) {
                    break;
                }
                arrayList.add(Byte.valueOf(b));
                i2++;
                i3 = i4;
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Short> take(@NotNull short[] sArr, int i) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        int i2 = 0;
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i >= sArr.length) {
                return toList(sArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Short.valueOf(sArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int length = sArr.length;
            int i3 = 0;
            while (i2 < length) {
                short s = sArr[i2];
                int i4 = i3 + 1;
                if (i3 == i) {
                    break;
                }
                arrayList.add(Short.valueOf(s));
                i2++;
                i3 = i4;
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Integer> take(@NotNull int[] iArr, int i) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        int i2 = 0;
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i >= iArr.length) {
                return toList(iArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(iArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int length = iArr.length;
            int i3 = 0;
            while (i2 < length) {
                int i4 = iArr[i2];
                int i5 = i3 + 1;
                if (i3 == i) {
                    break;
                }
                arrayList.add(Integer.valueOf(i4));
                i2++;
                i3 = i5;
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Long> take(@NotNull long[] jArr, int i) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        int i2 = 0;
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i >= jArr.length) {
                return toList(jArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(jArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int length = jArr.length;
            int i3 = 0;
            while (i2 < length) {
                long j = jArr[i2];
                int i4 = i3 + 1;
                if (i3 == i) {
                    break;
                }
                arrayList.add(Long.valueOf(j));
                i2++;
                i3 = i4;
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Float> take(@NotNull float[] fArr, int i) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        int i2 = 0;
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i >= fArr.length) {
                return toList(fArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Float.valueOf(fArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int length = fArr.length;
            int i3 = 0;
            while (i2 < length) {
                float f = fArr[i2];
                int i4 = i3 + 1;
                if (i3 == i) {
                    break;
                }
                arrayList.add(Float.valueOf(f));
                i2++;
                i3 = i4;
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Double> take(@NotNull double[] dArr, int i) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        int i2 = 0;
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i >= dArr.length) {
                return toList(dArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Double.valueOf(dArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int length = dArr.length;
            int i3 = 0;
            while (i2 < length) {
                double d = dArr[i2];
                int i4 = i3 + 1;
                if (i3 == i) {
                    break;
                }
                arrayList.add(Double.valueOf(d));
                i2++;
                i3 = i4;
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Boolean> take(@NotNull boolean[] zArr, int i) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        int i2 = 0;
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i >= zArr.length) {
                return toList(zArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Boolean.valueOf(zArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int length = zArr.length;
            int i3 = 0;
            while (i2 < length) {
                boolean z = zArr[i2];
                int i4 = i3 + 1;
                if (i3 == i) {
                    break;
                }
                arrayList.add(Boolean.valueOf(z));
                i2++;
                i3 = i4;
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Character> take(@NotNull char[] cArr, int i) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        int i2 = 0;
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i >= cArr.length) {
                return toList(cArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Character.valueOf(cArr[0]));
            }
            ArrayList arrayList = new ArrayList(i);
            int length = cArr.length;
            int i3 = 0;
            while (i2 < length) {
                char c = cArr[i2];
                int i4 = i3 + 1;
                if (i3 == i) {
                    break;
                }
                arrayList.add(Character.valueOf(c));
                i2++;
                i3 = i4;
            }
            return arrayList;
        }
    }

    @NotNull
    public static final <T> List<T> takeLast(@NotNull T[] tArr, int i) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = tArr.length;
            if (i >= length) {
                return toList(tArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(tArr[length - 1]);
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(tArr[i2]);
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Byte> takeLast(@NotNull byte[] bArr, int i) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = bArr.length;
            if (i >= length) {
                return toList(bArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Byte.valueOf(bArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Byte.valueOf(bArr[i2]));
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Short> takeLast(@NotNull short[] sArr, int i) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = sArr.length;
            if (i >= length) {
                return toList(sArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Short.valueOf(sArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Short.valueOf(sArr[i2]));
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Integer> takeLast(@NotNull int[] iArr, int i) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = iArr.length;
            if (i >= length) {
                return toList(iArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(iArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Integer.valueOf(iArr[i2]));
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Long> takeLast(@NotNull long[] jArr, int i) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = jArr.length;
            if (i >= length) {
                return toList(jArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(jArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Long.valueOf(jArr[i2]));
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Float> takeLast(@NotNull float[] fArr, int i) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = fArr.length;
            if (i >= length) {
                return toList(fArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Float.valueOf(fArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Float.valueOf(fArr[i2]));
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Double> takeLast(@NotNull double[] dArr, int i) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = dArr.length;
            if (i >= length) {
                return toList(dArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Double.valueOf(dArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Double.valueOf(dArr[i2]));
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Boolean> takeLast(@NotNull boolean[] zArr, int i) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = zArr.length;
            if (i >= length) {
                return toList(zArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Boolean.valueOf(zArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Boolean.valueOf(zArr[i2]));
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Character> takeLast(@NotNull char[] cArr, int i) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested element count ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = cArr.length;
            if (i >= length) {
                return toList(cArr);
            }
            if (i == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Character.valueOf(cArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = length - i; i2 < length; i2++) {
                arrayList.add(Character.valueOf(cArr[i2]));
            }
            return arrayList;
        }
    }

    @NotNull
    public static final <T> List<T> takeLastWhile(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(tArr[lastIndex])).booleanValue()) {
                return drop(tArr, lastIndex + 1);
            }
        }
        return toList(tArr);
    }

    @NotNull
    public static final List<Byte> takeLastWhile(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Byte.valueOf(bArr[lastIndex]))).booleanValue()) {
                return drop(bArr, lastIndex + 1);
            }
        }
        return toList(bArr);
    }

    @NotNull
    public static final List<Short> takeLastWhile(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Short.valueOf(sArr[lastIndex]))).booleanValue()) {
                return drop(sArr, lastIndex + 1);
            }
        }
        return toList(sArr);
    }

    @NotNull
    public static final List<Integer> takeLastWhile(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Integer.valueOf(iArr[lastIndex]))).booleanValue()) {
                return drop(iArr, lastIndex + 1);
            }
        }
        return toList(iArr);
    }

    @NotNull
    public static final List<Long> takeLastWhile(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Long.valueOf(jArr[lastIndex]))).booleanValue()) {
                return drop(jArr, lastIndex + 1);
            }
        }
        return toList(jArr);
    }

    @NotNull
    public static final List<Float> takeLastWhile(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Float.valueOf(fArr[lastIndex]))).booleanValue()) {
                return drop(fArr, lastIndex + 1);
            }
        }
        return toList(fArr);
    }

    @NotNull
    public static final List<Double> takeLastWhile(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Double.valueOf(dArr[lastIndex]))).booleanValue()) {
                return drop(dArr, lastIndex + 1);
            }
        }
        return toList(dArr);
    }

    @NotNull
    public static final List<Boolean> takeLastWhile(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Boolean.valueOf(zArr[lastIndex]))).booleanValue()) {
                return drop(zArr, lastIndex + 1);
            }
        }
        return toList(zArr);
    }

    @NotNull
    public static final List<Character> takeLastWhile(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            if (!((Boolean) function1.invoke(Character.valueOf(cArr[lastIndex]))).booleanValue()) {
                return drop(cArr, lastIndex + 1);
            }
        }
        return toList(cArr);
    }

    @NotNull
    public static final <T> List<T> takeWhile(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (!((Boolean) function1.invoke(t)).booleanValue()) {
                break;
            }
            arrayList.add(t);
        }
        return arrayList;
    }

    @NotNull
    public static final List<Byte> takeWhile(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (!((Boolean) function1.invoke(Byte.valueOf(b))).booleanValue()) {
                break;
            }
            arrayList.add(Byte.valueOf(b));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Short> takeWhile(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (!((Boolean) function1.invoke(Short.valueOf(s))).booleanValue()) {
                break;
            }
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> takeWhile(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (!((Boolean) function1.invoke(Integer.valueOf(i))).booleanValue()) {
                break;
            }
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> takeWhile(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (!((Boolean) function1.invoke(Long.valueOf(j))).booleanValue()) {
                break;
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> takeWhile(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f : fArr) {
            if (!((Boolean) function1.invoke(Float.valueOf(f))).booleanValue()) {
                break;
            }
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> takeWhile(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (!((Boolean) function1.invoke(Double.valueOf(d))).booleanValue()) {
                break;
            }
            arrayList.add(Double.valueOf(d));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> takeWhile(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (!((Boolean) function1.invoke(Boolean.valueOf(z))).booleanValue()) {
                break;
            }
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Character> takeWhile(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (!((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                break;
            }
            arrayList.add(Character.valueOf(c));
        }
        return arrayList;
    }

    public static final <T> void reverse(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        int length = (tArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(tArr);
            int i = 0;
            if (length >= 0) {
                while (true) {
                    T t = tArr[i];
                    tArr[i] = tArr[lastIndex];
                    tArr[lastIndex] = t;
                    lastIndex--;
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
    }

    public static final void reverse(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        int length = (bArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(bArr);
            int i = 0;
            if (length >= 0) {
                while (true) {
                    byte b = bArr[i];
                    bArr[i] = bArr[lastIndex];
                    bArr[lastIndex] = b;
                    lastIndex--;
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
    }

    public static final void reverse(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        int length = (sArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(sArr);
            int i = 0;
            if (length >= 0) {
                while (true) {
                    short s = sArr[i];
                    sArr[i] = sArr[lastIndex];
                    sArr[lastIndex] = s;
                    lastIndex--;
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
    }

    public static final void reverse(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        int length = (iArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(iArr);
            int i = 0;
            if (length >= 0) {
                while (true) {
                    int i2 = iArr[i];
                    iArr[i] = iArr[lastIndex];
                    iArr[lastIndex] = i2;
                    lastIndex--;
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
    }

    public static final void reverse(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        int length = (jArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(jArr);
            int i = 0;
            if (length >= 0) {
                while (true) {
                    long j = jArr[i];
                    jArr[i] = jArr[lastIndex];
                    jArr[lastIndex] = j;
                    lastIndex--;
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
    }

    public static final void reverse(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        int length = (fArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(fArr);
            int i = 0;
            if (length >= 0) {
                while (true) {
                    float f = fArr[i];
                    fArr[i] = fArr[lastIndex];
                    fArr[lastIndex] = f;
                    lastIndex--;
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
    }

    public static final void reverse(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        int length = (dArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(dArr);
            int i = 0;
            if (length >= 0) {
                while (true) {
                    double d = dArr[i];
                    dArr[i] = dArr[lastIndex];
                    dArr[lastIndex] = d;
                    lastIndex--;
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
    }

    public static final void reverse(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        int length = (zArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(zArr);
            int i = 0;
            if (length >= 0) {
                while (true) {
                    boolean z = zArr[i];
                    zArr[i] = zArr[lastIndex];
                    zArr[lastIndex] = z;
                    lastIndex--;
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
    }

    public static final void reverse(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        int length = (cArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(cArr);
            int i = 0;
            if (length >= 0) {
                while (true) {
                    char c = cArr[i];
                    cArr[i] = cArr[lastIndex];
                    cArr[lastIndex] = c;
                    lastIndex--;
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
    }

    @NotNull
    public static final <T> List<T> reversed(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<T> mutableList = toMutableList(tArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final List<Byte> reversed(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Byte> mutableList = toMutableList(bArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final List<Short> reversed(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Short> mutableList = toMutableList(sArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final List<Integer> reversed(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Integer> mutableList = toMutableList(iArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final List<Long> reversed(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Long> mutableList = toMutableList(jArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final List<Float> reversed(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Float> mutableList = toMutableList(fArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final List<Double> reversed(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Double> mutableList = toMutableList(dArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final List<Boolean> reversed(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Boolean> mutableList = toMutableList(zArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final List<Character> reversed(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Character> mutableList = toMutableList(cArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final <T> T[] reversedArray(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        int i = 0;
        if (tArr.length == 0) {
            return tArr;
        }
        T[] arrayOfNulls = ArraysKt__ArraysJVMKt.arrayOfNulls(tArr, tArr.length);
        int lastIndex = getLastIndex(tArr);
        if (lastIndex >= 0) {
            while (true) {
                arrayOfNulls[lastIndex - i] = tArr[i];
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return arrayOfNulls;
    }

    @NotNull
    public static final byte[] reversedArray(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        int i = 0;
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            while (true) {
                bArr2[lastIndex - i] = bArr[i];
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return bArr2;
    }

    @NotNull
    public static final short[] reversedArray(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        int i = 0;
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArr2 = new short[sArr.length];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            while (true) {
                sArr2[lastIndex - i] = sArr[i];
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return sArr2;
    }

    @NotNull
    public static final int[] reversedArray(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        int i = 0;
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArr2 = new int[iArr.length];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            while (true) {
                iArr2[lastIndex - i] = iArr[i];
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return iArr2;
    }

    @NotNull
    public static final long[] reversedArray(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        int i = 0;
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArr2 = new long[jArr.length];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            while (true) {
                jArr2[lastIndex - i] = jArr[i];
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return jArr2;
    }

    @NotNull
    public static final float[] reversedArray(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        int i = 0;
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArr2 = new float[fArr.length];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            while (true) {
                fArr2[lastIndex - i] = fArr[i];
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return fArr2;
    }

    @NotNull
    public static final double[] reversedArray(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        int i = 0;
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArr2 = new double[dArr.length];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            while (true) {
                dArr2[lastIndex - i] = dArr[i];
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return dArr2;
    }

    @NotNull
    public static final boolean[] reversedArray(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        int i = 0;
        if (zArr.length == 0) {
            return zArr;
        }
        boolean[] zArr2 = new boolean[zArr.length];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            while (true) {
                zArr2[lastIndex - i] = zArr[i];
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return zArr2;
    }

    @NotNull
    public static final char[] reversedArray(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        int i = 0;
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArr2 = new char[cArr.length];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            while (true) {
                cArr2[lastIndex - i] = cArr[i];
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return cArr2;
    }

    public static final <T, R extends Comparable<? super R>> void sortBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        if (tArr.length > 1) {
            ArraysKt___ArraysJvmKt.sortWith(tArr, new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
        }
    }

    public static final <T, R extends Comparable<? super R>> void sortByDescending(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        if (tArr.length > 1) {
            ArraysKt___ArraysJvmKt.sortWith(tArr, new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
        }
    }

    public static final <T extends Comparable<? super T>> void sortDescending(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        ArraysKt___ArraysJvmKt.sortWith(tArr, ComparisonsKt__ComparisonsKt.reverseOrder());
    }

    public static final void sortDescending(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (bArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(bArr);
            reverse(bArr);
        }
    }

    public static final void sortDescending(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (sArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(sArr);
            reverse(sArr);
        }
    }

    public static final void sortDescending(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (iArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(iArr);
            reverse(iArr);
        }
    }

    public static final void sortDescending(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (jArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(jArr);
            reverse(jArr);
        }
    }

    public static final void sortDescending(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (fArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(fArr);
            reverse(fArr);
        }
    }

    public static final void sortDescending(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (dArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(dArr);
            reverse(dArr);
        }
    }

    public static final void sortDescending(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (cArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(cArr);
            reverse(cArr);
        }
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> sorted(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        return ArraysKt___ArraysJvmKt.asList((T[]) sortedArray(tArr));
    }

    @NotNull
    public static final List<Byte> sorted(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Byte[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(bArr);
        if (typedArray != null) {
            ArraysKt___ArraysJvmKt.sort((T[]) typedArray);
            return ArraysKt___ArraysJvmKt.asList((T[]) typedArray);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    @NotNull
    public static final List<Short> sorted(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Short[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(sArr);
        if (typedArray != null) {
            ArraysKt___ArraysJvmKt.sort((T[]) typedArray);
            return ArraysKt___ArraysJvmKt.asList((T[]) typedArray);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    @NotNull
    public static final List<Integer> sorted(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Integer[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(iArr);
        if (typedArray != null) {
            ArraysKt___ArraysJvmKt.sort((T[]) typedArray);
            return ArraysKt___ArraysJvmKt.asList((T[]) typedArray);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    @NotNull
    public static final List<Long> sorted(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Long[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(jArr);
        if (typedArray != null) {
            ArraysKt___ArraysJvmKt.sort((T[]) typedArray);
            return ArraysKt___ArraysJvmKt.asList((T[]) typedArray);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    @NotNull
    public static final List<Float> sorted(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Float[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(fArr);
        if (typedArray != null) {
            ArraysKt___ArraysJvmKt.sort((T[]) typedArray);
            return ArraysKt___ArraysJvmKt.asList((T[]) typedArray);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    @NotNull
    public static final List<Double> sorted(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Double[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(dArr);
        if (typedArray != null) {
            ArraysKt___ArraysJvmKt.sort((T[]) typedArray);
            return ArraysKt___ArraysJvmKt.asList((T[]) typedArray);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    @NotNull
    public static final List<Character> sorted(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Character[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(cArr);
        if (typedArray != null) {
            ArraysKt___ArraysJvmKt.sort((T[]) typedArray);
            return ArraysKt___ArraysJvmKt.asList((T[]) typedArray);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T[] sortedArray(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] copyOf = Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        T[] tArr2 = (Comparable[]) copyOf;
        if (tArr2 != null) {
            ArraysKt___ArraysJvmKt.sort(tArr2);
            return tArr2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }

    @NotNull
    public static final byte[] sortedArray(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final short[] sortedArray(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final int[] sortedArray(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final long[] sortedArray(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final float[] sortedArray(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final double[] sortedArray(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final char[] sortedArray(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T[] sortedArrayDescending(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] copyOf = Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        T[] tArr2 = (Comparable[]) copyOf;
        ArraysKt___ArraysJvmKt.sortWith(tArr2, ComparisonsKt__ComparisonsKt.reverseOrder());
        return tArr2;
    }

    @NotNull
    public static final byte[] sortedArrayDescending(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final short[] sortedArrayDescending(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final int[] sortedArrayDescending(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final long[] sortedArrayDescending(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final float[] sortedArrayDescending(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final double[] sortedArrayDescending(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final char[] sortedArrayDescending(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final <T> T[] sortedArrayWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] copyOf = Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sortWith(copyOf, comparator);
        return copyOf;
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> sortedBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(tArr, (Comparator<? super T>) new ComparisonsKt__ComparisonsKt$compareBy$2<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Byte> sortedBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(bArr, (Comparator<? super Byte>) new ComparisonsKt__ComparisonsKt$compareBy$2<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Short> sortedBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(sArr, (Comparator<? super Short>) new ComparisonsKt__ComparisonsKt$compareBy$2<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Integer> sortedBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(iArr, (Comparator<? super Integer>) new ComparisonsKt__ComparisonsKt$compareBy$2<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Long> sortedBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(jArr, (Comparator<? super Long>) new ComparisonsKt__ComparisonsKt$compareBy$2<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Float> sortedBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(fArr, (Comparator<? super Float>) new ComparisonsKt__ComparisonsKt$compareBy$2<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Double> sortedBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(dArr, (Comparator<? super Double>) new ComparisonsKt__ComparisonsKt$compareBy$2<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Boolean> sortedBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(zArr, (Comparator<? super Boolean>) new ComparisonsKt__ComparisonsKt$compareBy$2<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Character> sortedBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(cArr, (Comparator<? super Character>) new ComparisonsKt__ComparisonsKt$compareBy$2<Object>(function1));
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(tArr, (Comparator<? super T>) new ComparisonsKt__ComparisonsKt$compareByDescending$1<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Byte> sortedByDescending(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(bArr, (Comparator<? super Byte>) new ComparisonsKt__ComparisonsKt$compareByDescending$1<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Short> sortedByDescending(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(sArr, (Comparator<? super Short>) new ComparisonsKt__ComparisonsKt$compareByDescending$1<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Integer> sortedByDescending(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(iArr, (Comparator<? super Integer>) new ComparisonsKt__ComparisonsKt$compareByDescending$1<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Long> sortedByDescending(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(jArr, (Comparator<? super Long>) new ComparisonsKt__ComparisonsKt$compareByDescending$1<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Float> sortedByDescending(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(fArr, (Comparator<? super Float>) new ComparisonsKt__ComparisonsKt$compareByDescending$1<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Double> sortedByDescending(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(dArr, (Comparator<? super Double>) new ComparisonsKt__ComparisonsKt$compareByDescending$1<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Boolean> sortedByDescending(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(zArr, (Comparator<? super Boolean>) new ComparisonsKt__ComparisonsKt$compareByDescending$1<Object>(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Character> sortedByDescending(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        return sortedWith(cArr, (Comparator<? super Character>) new ComparisonsKt__ComparisonsKt$compareByDescending$1<Object>(function1));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> sortedDescending(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        return sortedWith(tArr, ComparisonsKt__ComparisonsKt.reverseOrder());
    }

    @NotNull
    public static final List<Byte> sortedDescending(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Short> sortedDescending(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Integer> sortedDescending(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Long> sortedDescending(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Float> sortedDescending(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Double> sortedDescending(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Character> sortedDescending(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final <T> List<T> sortedWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return ArraysKt___ArraysJvmKt.asList((T[]) sortedArrayWith(tArr, comparator));
    }

    @NotNull
    public static final List<Byte> sortedWith(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        Byte[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(bArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList((T[]) typedArray);
    }

    @NotNull
    public static final List<Short> sortedWith(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        Short[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(sArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList((T[]) typedArray);
    }

    @NotNull
    public static final List<Integer> sortedWith(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        Integer[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(iArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList((T[]) typedArray);
    }

    @NotNull
    public static final List<Long> sortedWith(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        Long[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(jArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList((T[]) typedArray);
    }

    @NotNull
    public static final List<Float> sortedWith(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        Float[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(fArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList((T[]) typedArray);
    }

    @NotNull
    public static final List<Double> sortedWith(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        Double[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(dArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList((T[]) typedArray);
    }

    @NotNull
    public static final List<Boolean> sortedWith(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        Boolean[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(zArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList((T[]) typedArray);
    }

    @NotNull
    public static final List<Character> sortedWith(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        Character[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(cArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList((T[]) typedArray);
    }

    @NotNull
    public static final <T> IntRange getIndices(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        return new IntRange(0, getLastIndex(tArr));
    }

    @NotNull
    public static final IntRange getIndices(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        return new IntRange(0, getLastIndex(bArr));
    }

    @NotNull
    public static final IntRange getIndices(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        return new IntRange(0, getLastIndex(sArr));
    }

    @NotNull
    public static final IntRange getIndices(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        return new IntRange(0, getLastIndex(iArr));
    }

    @NotNull
    public static final IntRange getIndices(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        return new IntRange(0, getLastIndex(jArr));
    }

    @NotNull
    public static final IntRange getIndices(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        return new IntRange(0, getLastIndex(fArr));
    }

    @NotNull
    public static final IntRange getIndices(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        return new IntRange(0, getLastIndex(dArr));
    }

    @NotNull
    public static final IntRange getIndices(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        return new IntRange(0, getLastIndex(zArr));
    }

    @NotNull
    public static final IntRange getIndices(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        return new IntRange(0, getLastIndex(cArr));
    }

    public static final <T> int getLastIndex(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        return tArr.length - 1;
    }

    public static final int getLastIndex(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        return bArr.length - 1;
    }

    public static final int getLastIndex(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        return sArr.length - 1;
    }

    public static final int getLastIndex(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        return iArr.length - 1;
    }

    public static final int getLastIndex(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        return jArr.length - 1;
    }

    public static final int getLastIndex(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        return fArr.length - 1;
    }

    public static final int getLastIndex(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        return dArr.length - 1;
    }

    public static final int getLastIndex(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        return zArr.length - 1;
    }

    public static final int getLastIndex(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        return cArr.length - 1;
    }

    @NotNull
    public static final boolean[] toBooleanArray(@NotNull Boolean[] boolArr) {
        Intrinsics.checkParameterIsNotNull(boolArr, "receiver$0");
        boolean[] zArr = new boolean[boolArr.length];
        int length = boolArr.length;
        for (int i = 0; i < length; i++) {
            zArr[i] = boolArr[i].booleanValue();
        }
        return zArr;
    }

    @NotNull
    public static final byte[] toByteArray(@NotNull Byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        byte[] bArr2 = new byte[bArr.length];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        return bArr2;
    }

    @NotNull
    public static final char[] toCharArray(@NotNull Character[] chArr) {
        Intrinsics.checkParameterIsNotNull(chArr, "receiver$0");
        char[] cArr = new char[chArr.length];
        int length = chArr.length;
        for (int i = 0; i < length; i++) {
            cArr[i] = chArr[i].charValue();
        }
        return cArr;
    }

    @NotNull
    public static final double[] toDoubleArray(@NotNull Double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        double[] dArr2 = new double[dArr.length];
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            dArr2[i] = dArr[i].doubleValue();
        }
        return dArr2;
    }

    @NotNull
    public static final float[] toFloatArray(@NotNull Float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        float[] fArr2 = new float[fArr.length];
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            fArr2[i] = fArr[i].floatValue();
        }
        return fArr2;
    }

    @NotNull
    public static final int[] toIntArray(@NotNull Integer[] numArr) {
        Intrinsics.checkParameterIsNotNull(numArr, "receiver$0");
        int[] iArr = new int[numArr.length];
        int length = numArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    @NotNull
    public static final long[] toLongArray(@NotNull Long[] lArr) {
        Intrinsics.checkParameterIsNotNull(lArr, "receiver$0");
        long[] jArr = new long[lArr.length];
        int length = lArr.length;
        for (int i = 0; i < length; i++) {
            jArr[i] = lArr[i].longValue();
        }
        return jArr;
    }

    @NotNull
    public static final short[] toShortArray(@NotNull Short[] shArr) {
        Intrinsics.checkParameterIsNotNull(shArr, "receiver$0");
        short[] sArr = new short[shArr.length];
        int length = shArr.length;
        for (int i = 0; i < length; i++) {
            sArr[i] = shArr[i].shortValue();
        }
        return sArr;
    }

    @NotNull
    public static final <T, K, V> Map<K, V> associate(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(tArr.length), 16));
        for (T invoke : tArr) {
            Pair pair = (Pair) function1.invoke(invoke);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(bArr.length), 16));
        for (byte valueOf : bArr) {
            Pair pair = (Pair) function1.invoke(Byte.valueOf(valueOf));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(sArr.length), 16));
        for (short valueOf : sArr) {
            Pair pair = (Pair) function1.invoke(Short.valueOf(valueOf));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(iArr.length), 16));
        for (int valueOf : iArr) {
            Pair pair = (Pair) function1.invoke(Integer.valueOf(valueOf));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(jArr.length), 16));
        for (long valueOf : jArr) {
            Pair pair = (Pair) function1.invoke(Long.valueOf(valueOf));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(fArr.length), 16));
        for (float valueOf : fArr) {
            Pair pair = (Pair) function1.invoke(Float.valueOf(valueOf));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(dArr.length), 16));
        for (double valueOf : dArr) {
            Pair pair = (Pair) function1.invoke(Double.valueOf(valueOf));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(zArr.length), 16));
        for (boolean valueOf : zArr) {
            Pair pair = (Pair) function1.invoke(Boolean.valueOf(valueOf));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(cArr.length), 16));
        for (char valueOf : cArr) {
            Pair pair = (Pair) function1.invoke(Character.valueOf(valueOf));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K> Map<K, T> associateBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(tArr.length), 16));
        for (T t : tArr) {
            linkedHashMap.put(function1.invoke(t), t);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Byte> associateBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(bArr.length), 16));
        for (byte b : bArr) {
            linkedHashMap.put(function1.invoke(Byte.valueOf(b)), Byte.valueOf(b));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Short> associateBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(sArr.length), 16));
        for (short s : sArr) {
            linkedHashMap.put(function1.invoke(Short.valueOf(s)), Short.valueOf(s));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Integer> associateBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(iArr.length), 16));
        for (int i : iArr) {
            linkedHashMap.put(function1.invoke(Integer.valueOf(i)), Integer.valueOf(i));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Long> associateBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(jArr.length), 16));
        for (long j : jArr) {
            linkedHashMap.put(function1.invoke(Long.valueOf(j)), Long.valueOf(j));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Float> associateBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(fArr.length), 16));
        for (float f : fArr) {
            linkedHashMap.put(function1.invoke(Float.valueOf(f)), Float.valueOf(f));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Double> associateBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(dArr.length), 16));
        for (double d : dArr) {
            linkedHashMap.put(function1.invoke(Double.valueOf(d)), Double.valueOf(d));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Boolean> associateBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(zArr.length), 16));
        for (boolean z : zArr) {
            linkedHashMap.put(function1.invoke(Boolean.valueOf(z)), Boolean.valueOf(z));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, Character> associateBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(cArr.length), 16));
        for (char c : cArr) {
            linkedHashMap.put(function1.invoke(Character.valueOf(c)), Character.valueOf(c));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, V> Map<K, V> associateBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(tArr.length), 16));
        for (T t : tArr) {
            linkedHashMap.put(function1.invoke(t), function12.invoke(t));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> function1, @NotNull Function1<? super Byte, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(bArr.length), 16));
        for (byte b : bArr) {
            linkedHashMap.put(function1.invoke(Byte.valueOf(b)), function12.invoke(Byte.valueOf(b)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> function1, @NotNull Function1<? super Short, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(sArr.length), 16));
        for (short s : sArr) {
            linkedHashMap.put(function1.invoke(Short.valueOf(s)), function12.invoke(Short.valueOf(s)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> function1, @NotNull Function1<? super Integer, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(iArr.length), 16));
        for (int i : iArr) {
            linkedHashMap.put(function1.invoke(Integer.valueOf(i)), function12.invoke(Integer.valueOf(i)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> function1, @NotNull Function1<? super Long, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(jArr.length), 16));
        for (long j : jArr) {
            linkedHashMap.put(function1.invoke(Long.valueOf(j)), function12.invoke(Long.valueOf(j)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> function1, @NotNull Function1<? super Float, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(fArr.length), 16));
        for (float f : fArr) {
            linkedHashMap.put(function1.invoke(Float.valueOf(f)), function12.invoke(Float.valueOf(f)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> function1, @NotNull Function1<? super Double, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(dArr.length), 16));
        for (double d : dArr) {
            linkedHashMap.put(function1.invoke(Double.valueOf(d)), function12.invoke(Double.valueOf(d)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> function1, @NotNull Function1<? super Boolean, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(zArr.length), 16));
        for (boolean z : zArr) {
            linkedHashMap.put(function1.invoke(Boolean.valueOf(z)), function12.invoke(Boolean.valueOf(z)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> function1, @NotNull Function1<? super Character, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsKt.mapCapacity(cArr.length), 16));
        for (char c : cArr) {
            linkedHashMap.put(function1.invoke(Character.valueOf(c)), function12.invoke(Character.valueOf(c)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(@NotNull T[] tArr, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (T t : tArr) {
            m.put(function1.invoke(t), t);
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Byte>> M associateByTo(@NotNull byte[] bArr, @NotNull M m, @NotNull Function1<? super Byte, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (byte b : bArr) {
            m.put(function1.invoke(Byte.valueOf(b)), Byte.valueOf(b));
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Short>> M associateByTo(@NotNull short[] sArr, @NotNull M m, @NotNull Function1<? super Short, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (short s : sArr) {
            m.put(function1.invoke(Short.valueOf(s)), Short.valueOf(s));
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Integer>> M associateByTo(@NotNull int[] iArr, @NotNull M m, @NotNull Function1<? super Integer, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (int i : iArr) {
            m.put(function1.invoke(Integer.valueOf(i)), Integer.valueOf(i));
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Long>> M associateByTo(@NotNull long[] jArr, @NotNull M m, @NotNull Function1<? super Long, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (long j : jArr) {
            m.put(function1.invoke(Long.valueOf(j)), Long.valueOf(j));
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Float>> M associateByTo(@NotNull float[] fArr, @NotNull M m, @NotNull Function1<? super Float, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (float f : fArr) {
            m.put(function1.invoke(Float.valueOf(f)), Float.valueOf(f));
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Double>> M associateByTo(@NotNull double[] dArr, @NotNull M m, @NotNull Function1<? super Double, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (double d : dArr) {
            m.put(function1.invoke(Double.valueOf(d)), Double.valueOf(d));
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Boolean>> M associateByTo(@NotNull boolean[] zArr, @NotNull M m, @NotNull Function1<? super Boolean, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (boolean z : zArr) {
            m.put(function1.invoke(Boolean.valueOf(z)), Boolean.valueOf(z));
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(@NotNull char[] cArr, @NotNull M m, @NotNull Function1<? super Character, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (char c : cArr) {
            m.put(function1.invoke(Character.valueOf(c)), Character.valueOf(c));
        }
        return m;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull T[] tArr, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (T t : tArr) {
            m.put(function1.invoke(t), function12.invoke(t));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull byte[] bArr, @NotNull M m, @NotNull Function1<? super Byte, ? extends K> function1, @NotNull Function1<? super Byte, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (byte b : bArr) {
            m.put(function1.invoke(Byte.valueOf(b)), function12.invoke(Byte.valueOf(b)));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull short[] sArr, @NotNull M m, @NotNull Function1<? super Short, ? extends K> function1, @NotNull Function1<? super Short, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (short s : sArr) {
            m.put(function1.invoke(Short.valueOf(s)), function12.invoke(Short.valueOf(s)));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull int[] iArr, @NotNull M m, @NotNull Function1<? super Integer, ? extends K> function1, @NotNull Function1<? super Integer, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (int i : iArr) {
            m.put(function1.invoke(Integer.valueOf(i)), function12.invoke(Integer.valueOf(i)));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull long[] jArr, @NotNull M m, @NotNull Function1<? super Long, ? extends K> function1, @NotNull Function1<? super Long, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (long j : jArr) {
            m.put(function1.invoke(Long.valueOf(j)), function12.invoke(Long.valueOf(j)));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull float[] fArr, @NotNull M m, @NotNull Function1<? super Float, ? extends K> function1, @NotNull Function1<? super Float, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (float f : fArr) {
            m.put(function1.invoke(Float.valueOf(f)), function12.invoke(Float.valueOf(f)));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull double[] dArr, @NotNull M m, @NotNull Function1<? super Double, ? extends K> function1, @NotNull Function1<? super Double, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (double d : dArr) {
            m.put(function1.invoke(Double.valueOf(d)), function12.invoke(Double.valueOf(d)));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull boolean[] zArr, @NotNull M m, @NotNull Function1<? super Boolean, ? extends K> function1, @NotNull Function1<? super Boolean, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (boolean z : zArr) {
            m.put(function1.invoke(Boolean.valueOf(z)), function12.invoke(Boolean.valueOf(z)));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull char[] cArr, @NotNull M m, @NotNull Function1<? super Character, ? extends K> function1, @NotNull Function1<? super Character, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (char c : cArr) {
            m.put(function1.invoke(Character.valueOf(c)), function12.invoke(Character.valueOf(c)));
        }
        return m;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull T[] tArr, @NotNull M m, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (T invoke : tArr) {
            Pair pair = (Pair) function1.invoke(invoke);
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull byte[] bArr, @NotNull M m, @NotNull Function1<? super Byte, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (byte valueOf : bArr) {
            Pair pair = (Pair) function1.invoke(Byte.valueOf(valueOf));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull short[] sArr, @NotNull M m, @NotNull Function1<? super Short, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (short valueOf : sArr) {
            Pair pair = (Pair) function1.invoke(Short.valueOf(valueOf));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull int[] iArr, @NotNull M m, @NotNull Function1<? super Integer, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (int valueOf : iArr) {
            Pair pair = (Pair) function1.invoke(Integer.valueOf(valueOf));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull long[] jArr, @NotNull M m, @NotNull Function1<? super Long, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (long valueOf : jArr) {
            Pair pair = (Pair) function1.invoke(Long.valueOf(valueOf));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull float[] fArr, @NotNull M m, @NotNull Function1<? super Float, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (float valueOf : fArr) {
            Pair pair = (Pair) function1.invoke(Float.valueOf(valueOf));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull double[] dArr, @NotNull M m, @NotNull Function1<? super Double, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (double valueOf : dArr) {
            Pair pair = (Pair) function1.invoke(Double.valueOf(valueOf));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull boolean[] zArr, @NotNull M m, @NotNull Function1<? super Boolean, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (boolean valueOf : zArr) {
            Pair pair = (Pair) function1.invoke(Boolean.valueOf(valueOf));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull char[] cArr, @NotNull M m, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (char valueOf : cArr) {
            Pair pair = (Pair) function1.invoke(Character.valueOf(valueOf));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C toCollection(@NotNull T[] tArr, @NotNull C c) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        for (T add : tArr) {
            c.add(add);
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C toCollection(@NotNull byte[] bArr, @NotNull C c) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        for (byte valueOf : bArr) {
            c.add(Byte.valueOf(valueOf));
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C toCollection(@NotNull short[] sArr, @NotNull C c) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        for (short valueOf : sArr) {
            c.add(Short.valueOf(valueOf));
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C toCollection(@NotNull int[] iArr, @NotNull C c) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        for (int valueOf : iArr) {
            c.add(Integer.valueOf(valueOf));
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C toCollection(@NotNull long[] jArr, @NotNull C c) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        for (long valueOf : jArr) {
            c.add(Long.valueOf(valueOf));
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C toCollection(@NotNull float[] fArr, @NotNull C c) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        for (float valueOf : fArr) {
            c.add(Float.valueOf(valueOf));
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C toCollection(@NotNull double[] dArr, @NotNull C c) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        for (double valueOf : dArr) {
            c.add(Double.valueOf(valueOf));
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C toCollection(@NotNull boolean[] zArr, @NotNull C c) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        for (boolean valueOf : zArr) {
            c.add(Boolean.valueOf(valueOf));
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C toCollection(@NotNull char[] cArr, @NotNull C c) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        for (char valueOf : cArr) {
            c.add(Character.valueOf(valueOf));
        }
        return c;
    }

    @NotNull
    public static <T> HashSet<T> toHashSet(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        return (HashSet) toCollection(tArr, (C) new HashSet(MapsKt__MapsKt.mapCapacity(tArr.length)));
    }

    @NotNull
    public static final HashSet<Byte> toHashSet(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        return (HashSet) toCollection(bArr, (C) new HashSet(MapsKt__MapsKt.mapCapacity(bArr.length)));
    }

    @NotNull
    public static final HashSet<Short> toHashSet(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        return (HashSet) toCollection(sArr, (C) new HashSet(MapsKt__MapsKt.mapCapacity(sArr.length)));
    }

    @NotNull
    public static final HashSet<Integer> toHashSet(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        return (HashSet) toCollection(iArr, (C) new HashSet(MapsKt__MapsKt.mapCapacity(iArr.length)));
    }

    @NotNull
    public static final HashSet<Long> toHashSet(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        return (HashSet) toCollection(jArr, (C) new HashSet(MapsKt__MapsKt.mapCapacity(jArr.length)));
    }

    @NotNull
    public static final HashSet<Float> toHashSet(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        return (HashSet) toCollection(fArr, (C) new HashSet(MapsKt__MapsKt.mapCapacity(fArr.length)));
    }

    @NotNull
    public static final HashSet<Double> toHashSet(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        return (HashSet) toCollection(dArr, (C) new HashSet(MapsKt__MapsKt.mapCapacity(dArr.length)));
    }

    @NotNull
    public static final HashSet<Boolean> toHashSet(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        return (HashSet) toCollection(zArr, (C) new HashSet(MapsKt__MapsKt.mapCapacity(zArr.length)));
    }

    @NotNull
    public static final HashSet<Character> toHashSet(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        return (HashSet) toCollection(cArr, (C) new HashSet(MapsKt__MapsKt.mapCapacity(cArr.length)));
    }

    @NotNull
    public static <T> List<T> toList(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        int length = tArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(tArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(tArr[0]);
    }

    @NotNull
    public static final List<Byte> toList(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        int length = bArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(bArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Byte.valueOf(bArr[0]));
    }

    @NotNull
    public static final List<Short> toList(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        int length = sArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(sArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Short.valueOf(sArr[0]));
    }

    @NotNull
    public static final List<Integer> toList(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        int length = iArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(iArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(iArr[0]));
    }

    @NotNull
    public static final List<Long> toList(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        int length = jArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(jArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(jArr[0]));
    }

    @NotNull
    public static final List<Float> toList(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        int length = fArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(fArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Float.valueOf(fArr[0]));
    }

    @NotNull
    public static final List<Double> toList(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        int length = dArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(dArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Double.valueOf(dArr[0]));
    }

    @NotNull
    public static final List<Boolean> toList(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        int length = zArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(zArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Boolean.valueOf(zArr[0]));
    }

    @NotNull
    public static final List<Character> toList(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        int length = cArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(cArr);
        }
        return CollectionsKt__CollectionsJVMKt.listOf(Character.valueOf(cArr[0]));
    }

    @NotNull
    public static final <T> List<T> toMutableList(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        return new ArrayList(CollectionsKt__CollectionsKt.asCollection(tArr));
    }

    @NotNull
    public static final List<Byte> toMutableList(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte valueOf : bArr) {
            arrayList.add(Byte.valueOf(valueOf));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Short> toMutableList(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short valueOf : sArr) {
            arrayList.add(Short.valueOf(valueOf));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> toMutableList(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> toMutableList(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long valueOf : jArr) {
            arrayList.add(Long.valueOf(valueOf));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> toMutableList(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf : fArr) {
            arrayList.add(Float.valueOf(valueOf));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> toMutableList(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double valueOf : dArr) {
            arrayList.add(Double.valueOf(valueOf));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> toMutableList(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean valueOf : zArr) {
            arrayList.add(Boolean.valueOf(valueOf));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Character> toMutableList(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char valueOf : cArr) {
            arrayList.add(Character.valueOf(valueOf));
        }
        return arrayList;
    }

    @NotNull
    public static final <T> Set<T> toSet(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        int length = tArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(tArr, (C) new LinkedHashSet(MapsKt__MapsKt.mapCapacity(tArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(tArr[0]);
    }

    @NotNull
    public static final Set<Byte> toSet(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        int length = bArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(bArr, (C) new LinkedHashSet(MapsKt__MapsKt.mapCapacity(bArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(Byte.valueOf(bArr[0]));
    }

    @NotNull
    public static final Set<Short> toSet(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        int length = sArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(sArr, (C) new LinkedHashSet(MapsKt__MapsKt.mapCapacity(sArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(Short.valueOf(sArr[0]));
    }

    @NotNull
    public static final Set<Integer> toSet(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        int length = iArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(iArr, (C) new LinkedHashSet(MapsKt__MapsKt.mapCapacity(iArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(Integer.valueOf(iArr[0]));
    }

    @NotNull
    public static final Set<Long> toSet(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        int length = jArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(jArr, (C) new LinkedHashSet(MapsKt__MapsKt.mapCapacity(jArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(Long.valueOf(jArr[0]));
    }

    @NotNull
    public static final Set<Float> toSet(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        int length = fArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(fArr, (C) new LinkedHashSet(MapsKt__MapsKt.mapCapacity(fArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(Float.valueOf(fArr[0]));
    }

    @NotNull
    public static final Set<Double> toSet(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        int length = dArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(dArr, (C) new LinkedHashSet(MapsKt__MapsKt.mapCapacity(dArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(Double.valueOf(dArr[0]));
    }

    @NotNull
    public static final Set<Boolean> toSet(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        int length = zArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(zArr, (C) new LinkedHashSet(MapsKt__MapsKt.mapCapacity(zArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(Boolean.valueOf(zArr[0]));
    }

    @NotNull
    public static final Set<Character> toSet(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        int length = cArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(cArr, (C) new LinkedHashSet(MapsKt__MapsKt.mapCapacity(cArr.length)));
        }
        return SetsKt__SetsJVMKt.setOf(Character.valueOf(cArr[0]));
    }

    @NotNull
    public static final <T, R> List<R> flatMap(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (T invoke : tArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, (Iterable) function1.invoke(invoke));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (byte valueOf : bArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, (Iterable) function1.invoke(Byte.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (short valueOf : sArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, (Iterable) function1.invoke(Short.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (int valueOf : iArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, (Iterable) function1.invoke(Integer.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (long valueOf : jArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, (Iterable) function1.invoke(Long.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (float valueOf : fArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, (Iterable) function1.invoke(Float.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (double valueOf : dArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, (Iterable) function1.invoke(Double.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (boolean valueOf : zArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, (Iterable) function1.invoke(Boolean.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (char valueOf : cArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) arrayList, (Iterable) function1.invoke(Character.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C flatMapTo(@NotNull T[] tArr, @NotNull C c, @NotNull Function1<? super T, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (T invoke : tArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) c, (Iterable) function1.invoke(invoke));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull byte[] bArr, @NotNull C c, @NotNull Function1<? super Byte, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (byte valueOf : bArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) c, (Iterable) function1.invoke(Byte.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull short[] sArr, @NotNull C c, @NotNull Function1<? super Short, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (short valueOf : sArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) c, (Iterable) function1.invoke(Short.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull int[] iArr, @NotNull C c, @NotNull Function1<? super Integer, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (int valueOf : iArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) c, (Iterable) function1.invoke(Integer.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull long[] jArr, @NotNull C c, @NotNull Function1<? super Long, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (long valueOf : jArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) c, (Iterable) function1.invoke(Long.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull float[] fArr, @NotNull C c, @NotNull Function1<? super Float, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (float valueOf : fArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) c, (Iterable) function1.invoke(Float.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull double[] dArr, @NotNull C c, @NotNull Function1<? super Double, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (double valueOf : dArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) c, (Iterable) function1.invoke(Double.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull boolean[] zArr, @NotNull C c, @NotNull Function1<? super Boolean, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (boolean valueOf : zArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) c, (Iterable) function1.invoke(Boolean.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull char[] cArr, @NotNull C c, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (char valueOf : cArr) {
            CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) c, (Iterable) function1.invoke(Character.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <T, K> Map<K, List<T>> groupBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : tArr) {
            Object invoke = function1.invoke(t);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(t);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, List<Byte>> groupBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b : bArr) {
            Object invoke = function1.invoke(Byte.valueOf(b));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Byte.valueOf(b));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, List<Short>> groupBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s : sArr) {
            Object invoke = function1.invoke(Short.valueOf(s));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Short.valueOf(s));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, List<Integer>> groupBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i : iArr) {
            Object invoke = function1.invoke(Integer.valueOf(i));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Integer.valueOf(i));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, List<Long>> groupBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j : jArr) {
            Object invoke = function1.invoke(Long.valueOf(j));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Long.valueOf(j));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, List<Float>> groupBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f : fArr) {
            Object invoke = function1.invoke(Float.valueOf(f));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Float.valueOf(f));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, List<Double>> groupBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d : dArr) {
            Object invoke = function1.invoke(Double.valueOf(d));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Double.valueOf(d));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, List<Boolean>> groupBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z : zArr) {
            Object invoke = function1.invoke(Boolean.valueOf(z));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Boolean.valueOf(z));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> Map<K, List<Character>> groupBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c : cArr) {
            Object invoke = function1.invoke(Character.valueOf(c));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(c));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, V> Map<K, List<V>> groupBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : tArr) {
            Object invoke = function1.invoke(t);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(t));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> function1, @NotNull Function1<? super Byte, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b : bArr) {
            Object invoke = function1.invoke(Byte.valueOf(b));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Byte.valueOf(b)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> function1, @NotNull Function1<? super Short, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s : sArr) {
            Object invoke = function1.invoke(Short.valueOf(s));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Short.valueOf(s)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> function1, @NotNull Function1<? super Integer, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i : iArr) {
            Object invoke = function1.invoke(Integer.valueOf(i));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Integer.valueOf(i)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> function1, @NotNull Function1<? super Long, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j : jArr) {
            Object invoke = function1.invoke(Long.valueOf(j));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Long.valueOf(j)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> function1, @NotNull Function1<? super Float, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f : fArr) {
            Object invoke = function1.invoke(Float.valueOf(f));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Float.valueOf(f)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> function1, @NotNull Function1<? super Double, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d : dArr) {
            Object invoke = function1.invoke(Double.valueOf(d));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Double.valueOf(d)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> function1, @NotNull Function1<? super Boolean, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z : zArr) {
            Object invoke = function1.invoke(Boolean.valueOf(z));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Boolean.valueOf(z)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> function1, @NotNull Function1<? super Character, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c : cArr) {
            Object invoke = function1.invoke(Character.valueOf(c));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Character.valueOf(c)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(@NotNull T[] tArr, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (T t : tArr) {
            Object invoke = function1.invoke(t);
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(t);
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Byte>>> M groupByTo(@NotNull byte[] bArr, @NotNull M m, @NotNull Function1<? super Byte, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (byte b : bArr) {
            Object invoke = function1.invoke(Byte.valueOf(b));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(Byte.valueOf(b));
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Short>>> M groupByTo(@NotNull short[] sArr, @NotNull M m, @NotNull Function1<? super Short, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (short s : sArr) {
            Object invoke = function1.invoke(Short.valueOf(s));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(Short.valueOf(s));
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Integer>>> M groupByTo(@NotNull int[] iArr, @NotNull M m, @NotNull Function1<? super Integer, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (int i : iArr) {
            Object invoke = function1.invoke(Integer.valueOf(i));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(Integer.valueOf(i));
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Long>>> M groupByTo(@NotNull long[] jArr, @NotNull M m, @NotNull Function1<? super Long, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (long j : jArr) {
            Object invoke = function1.invoke(Long.valueOf(j));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(Long.valueOf(j));
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Float>>> M groupByTo(@NotNull float[] fArr, @NotNull M m, @NotNull Function1<? super Float, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (float f : fArr) {
            Object invoke = function1.invoke(Float.valueOf(f));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(Float.valueOf(f));
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Double>>> M groupByTo(@NotNull double[] dArr, @NotNull M m, @NotNull Function1<? super Double, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (double d : dArr) {
            Object invoke = function1.invoke(Double.valueOf(d));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(Double.valueOf(d));
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Boolean>>> M groupByTo(@NotNull boolean[] zArr, @NotNull M m, @NotNull Function1<? super Boolean, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (boolean z : zArr) {
            Object invoke = function1.invoke(Boolean.valueOf(z));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(Boolean.valueOf(z));
        }
        return m;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(@NotNull char[] cArr, @NotNull M m, @NotNull Function1<? super Character, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        for (char c : cArr) {
            Object invoke = function1.invoke(Character.valueOf(c));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(c));
        }
        return m;
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull T[] tArr, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (T t : tArr) {
            Object invoke = function1.invoke(t);
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(t));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull byte[] bArr, @NotNull M m, @NotNull Function1<? super Byte, ? extends K> function1, @NotNull Function1<? super Byte, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (byte b : bArr) {
            Object invoke = function1.invoke(Byte.valueOf(b));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Byte.valueOf(b)));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull short[] sArr, @NotNull M m, @NotNull Function1<? super Short, ? extends K> function1, @NotNull Function1<? super Short, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (short s : sArr) {
            Object invoke = function1.invoke(Short.valueOf(s));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Short.valueOf(s)));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull int[] iArr, @NotNull M m, @NotNull Function1<? super Integer, ? extends K> function1, @NotNull Function1<? super Integer, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (int i : iArr) {
            Object invoke = function1.invoke(Integer.valueOf(i));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Integer.valueOf(i)));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull long[] jArr, @NotNull M m, @NotNull Function1<? super Long, ? extends K> function1, @NotNull Function1<? super Long, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (long j : jArr) {
            Object invoke = function1.invoke(Long.valueOf(j));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Long.valueOf(j)));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull float[] fArr, @NotNull M m, @NotNull Function1<? super Float, ? extends K> function1, @NotNull Function1<? super Float, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (float f : fArr) {
            Object invoke = function1.invoke(Float.valueOf(f));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Float.valueOf(f)));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull double[] dArr, @NotNull M m, @NotNull Function1<? super Double, ? extends K> function1, @NotNull Function1<? super Double, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (double d : dArr) {
            Object invoke = function1.invoke(Double.valueOf(d));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Double.valueOf(d)));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull boolean[] zArr, @NotNull M m, @NotNull Function1<? super Boolean, ? extends K> function1, @NotNull Function1<? super Boolean, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (boolean z : zArr) {
            Object invoke = function1.invoke(Boolean.valueOf(z));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Boolean.valueOf(z)));
        }
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull char[] cArr, @NotNull M m, @NotNull Function1<? super Character, ? extends K> function1, @NotNull Function1<? super Character, ? extends V> function12) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(m, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        Intrinsics.checkParameterIsNotNull(function12, "valueTransform");
        for (char c : cArr) {
            Object invoke = function1.invoke(Character.valueOf(c));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                m.put(invoke, obj);
            }
            ((List) obj).add(function12.invoke(Character.valueOf(c)));
        }
        return m;
    }

    @NotNull
    public static final <T, K> Grouping<T, K> groupingBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "keySelector");
        return new ArraysKt___ArraysKt$groupingBy$1(tArr, function1);
    }

    @NotNull
    public static final <T, R> List<R> map(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T invoke : tArr) {
            arrayList.add(function1.invoke(invoke));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> map(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte valueOf : bArr) {
            arrayList.add(function1.invoke(Byte.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> map(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short valueOf : sArr) {
            arrayList.add(function1.invoke(Short.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> map(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(function1.invoke(Integer.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> map(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long valueOf : jArr) {
            arrayList.add(function1.invoke(Long.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> map(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf : fArr) {
            arrayList.add(function1.invoke(Float.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> map(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double valueOf : dArr) {
            arrayList.add(function1.invoke(Double.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> map(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean valueOf : zArr) {
            arrayList.add(function1.invoke(Boolean.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> map(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char valueOf : cArr) {
            arrayList.add(function1.invoke(Character.valueOf(valueOf)));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> mapIndexed(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        int i = 0;
        for (T t : tArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            arrayList.add(function2.invoke(valueOf, t));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull byte[] bArr, @NotNull Function2<? super Integer, ? super Byte, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        int i = 0;
        for (byte b : bArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            arrayList.add(function2.invoke(valueOf, Byte.valueOf(b)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull short[] sArr, @NotNull Function2<? super Integer, ? super Short, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        int i = 0;
        for (short s : sArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            arrayList.add(function2.invoke(valueOf, Short.valueOf(s)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        int i = 0;
        for (int i2 : iArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            arrayList.add(function2.invoke(valueOf, Integer.valueOf(i2)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull long[] jArr, @NotNull Function2<? super Integer, ? super Long, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        int i = 0;
        for (long j : jArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            arrayList.add(function2.invoke(valueOf, Long.valueOf(j)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull float[] fArr, @NotNull Function2<? super Integer, ? super Float, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        int i = 0;
        for (float f : fArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            arrayList.add(function2.invoke(valueOf, Float.valueOf(f)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull double[] dArr, @NotNull Function2<? super Integer, ? super Double, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        int i = 0;
        for (double d : dArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            arrayList.add(function2.invoke(valueOf, Double.valueOf(d)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull boolean[] zArr, @NotNull Function2<? super Integer, ? super Boolean, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        int i = 0;
        for (boolean z : zArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            arrayList.add(function2.invoke(valueOf, Boolean.valueOf(z)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull char[] cArr, @NotNull Function2<? super Integer, ? super Character, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        int i = 0;
        for (char c : cArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            arrayList.add(function2.invoke(valueOf, Character.valueOf(c)));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> mapIndexedNotNull(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            Object invoke = function2.invoke(Integer.valueOf(i2), tArr[i]);
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(@NotNull T[] tArr, @NotNull C c, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int i = 0;
        for (T t : tArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            c.add(function2.invoke(valueOf, t));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull byte[] bArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Byte, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int i = 0;
        for (byte b : bArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            c.add(function2.invoke(valueOf, Byte.valueOf(b)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull short[] sArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Short, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int i = 0;
        for (short s : sArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            c.add(function2.invoke(valueOf, Short.valueOf(s)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull int[] iArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Integer, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int i = 0;
        for (int i2 : iArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            c.add(function2.invoke(valueOf, Integer.valueOf(i2)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull long[] jArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Long, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int i = 0;
        for (long j : jArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            c.add(function2.invoke(valueOf, Long.valueOf(j)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull float[] fArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Float, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int i = 0;
        for (float f : fArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            c.add(function2.invoke(valueOf, Float.valueOf(f)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull double[] dArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Double, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int i = 0;
        for (double d : dArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            c.add(function2.invoke(valueOf, Double.valueOf(d)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull boolean[] zArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Boolean, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int i = 0;
        for (boolean z : zArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            c.add(function2.invoke(valueOf, Boolean.valueOf(z)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull char[] cArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Character, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int i = 0;
        for (char c2 : cArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            c.add(function2.invoke(valueOf, Character.valueOf(c2)));
        }
        return c;
    }

    @NotNull
    public static final <T, R> List<R> mapNotNull(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (T invoke : tArr) {
            Object invoke2 = function1.invoke(invoke);
            if (invoke2 != null) {
                arrayList.add(invoke2);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapTo(@NotNull T[] tArr, @NotNull C c, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (T invoke : tArr) {
            c.add(function1.invoke(invoke));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull byte[] bArr, @NotNull C c, @NotNull Function1<? super Byte, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (byte valueOf : bArr) {
            c.add(function1.invoke(Byte.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull short[] sArr, @NotNull C c, @NotNull Function1<? super Short, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (short valueOf : sArr) {
            c.add(function1.invoke(Short.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull int[] iArr, @NotNull C c, @NotNull Function1<? super Integer, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (int valueOf : iArr) {
            c.add(function1.invoke(Integer.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull long[] jArr, @NotNull C c, @NotNull Function1<? super Long, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (long valueOf : jArr) {
            c.add(function1.invoke(Long.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull float[] fArr, @NotNull C c, @NotNull Function1<? super Float, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (float valueOf : fArr) {
            c.add(function1.invoke(Float.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull double[] dArr, @NotNull C c, @NotNull Function1<? super Double, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (double valueOf : dArr) {
            c.add(function1.invoke(Double.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull boolean[] zArr, @NotNull C c, @NotNull Function1<? super Boolean, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (boolean valueOf : zArr) {
            c.add(function1.invoke(Boolean.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull char[] cArr, @NotNull C c, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (char valueOf : cArr) {
            c.add(function1.invoke(Character.valueOf(valueOf)));
        }
        return c;
    }

    @NotNull
    public static final <T> Iterable<IndexedValue<T>> withIndex(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        return new IndexingIterable(new ArraysKt___ArraysKt$withIndex$1(tArr));
    }

    @NotNull
    public static final Iterable<IndexedValue<Byte>> withIndex(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        return new IndexingIterable(new ArraysKt___ArraysKt$withIndex$2(bArr));
    }

    @NotNull
    public static final Iterable<IndexedValue<Short>> withIndex(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        return new IndexingIterable(new ArraysKt___ArraysKt$withIndex$3(sArr));
    }

    @NotNull
    public static final Iterable<IndexedValue<Integer>> withIndex(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        return new IndexingIterable(new ArraysKt___ArraysKt$withIndex$4(iArr));
    }

    @NotNull
    public static final Iterable<IndexedValue<Long>> withIndex(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        return new IndexingIterable(new ArraysKt___ArraysKt$withIndex$5(jArr));
    }

    @NotNull
    public static final Iterable<IndexedValue<Float>> withIndex(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        return new IndexingIterable(new ArraysKt___ArraysKt$withIndex$6(fArr));
    }

    @NotNull
    public static final Iterable<IndexedValue<Double>> withIndex(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        return new IndexingIterable(new ArraysKt___ArraysKt$withIndex$7(dArr));
    }

    @NotNull
    public static final Iterable<IndexedValue<Boolean>> withIndex(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        return new IndexingIterable(new ArraysKt___ArraysKt$withIndex$8(zArr));
    }

    @NotNull
    public static final Iterable<IndexedValue<Character>> withIndex(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        return new IndexingIterable(new ArraysKt___ArraysKt$withIndex$9(cArr));
    }

    @NotNull
    public static final <T> List<T> distinct(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(tArr));
    }

    @NotNull
    public static final List<Byte> distinct(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(bArr));
    }

    @NotNull
    public static final List<Short> distinct(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(sArr));
    }

    @NotNull
    public static final List<Integer> distinct(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(iArr));
    }

    @NotNull
    public static final List<Long> distinct(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(jArr));
    }

    @NotNull
    public static final List<Float> distinct(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(fArr));
    }

    @NotNull
    public static final List<Double> distinct(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(dArr));
    }

    @NotNull
    public static final List<Boolean> distinct(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(zArr));
    }

    @NotNull
    public static final List<Character> distinct(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(cArr));
    }

    @NotNull
    public static final <T, K> List<T> distinctBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (hashSet.add(function1.invoke(t))) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K> List<Byte> distinctBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            if (hashSet.add(function1.invoke(Byte.valueOf(b)))) {
                arrayList.add(Byte.valueOf(b));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K> List<Short> distinctBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (hashSet.add(function1.invoke(Short.valueOf(s)))) {
                arrayList.add(Short.valueOf(s));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K> List<Integer> distinctBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (hashSet.add(function1.invoke(Integer.valueOf(i)))) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K> List<Long> distinctBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (hashSet.add(function1.invoke(Long.valueOf(j)))) {
                arrayList.add(Long.valueOf(j));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K> List<Float> distinctBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (float f : fArr) {
            if (hashSet.add(function1.invoke(Float.valueOf(f)))) {
                arrayList.add(Float.valueOf(f));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K> List<Double> distinctBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (double d : dArr) {
            if (hashSet.add(function1.invoke(Double.valueOf(d)))) {
                arrayList.add(Double.valueOf(d));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K> List<Boolean> distinctBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (hashSet.add(function1.invoke(Boolean.valueOf(z)))) {
                arrayList.add(Boolean.valueOf(z));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K> List<Character> distinctBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (char c : cArr) {
            if (hashSet.add(function1.invoke(Character.valueOf(c)))) {
                arrayList.add(Character.valueOf(c));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> Set<T> intersect(@NotNull T[] tArr, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<T> mutableSet = toMutableSet(tArr);
        CollectionsKt__MutableCollectionsKt.retainAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Byte> intersect(@NotNull byte[] bArr, @NotNull Iterable<Byte> iterable) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Byte> mutableSet = toMutableSet(bArr);
        CollectionsKt__MutableCollectionsKt.retainAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Short> intersect(@NotNull short[] sArr, @NotNull Iterable<Short> iterable) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Short> mutableSet = toMutableSet(sArr);
        CollectionsKt__MutableCollectionsKt.retainAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Integer> intersect(@NotNull int[] iArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Integer> mutableSet = toMutableSet(iArr);
        CollectionsKt__MutableCollectionsKt.retainAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Long> intersect(@NotNull long[] jArr, @NotNull Iterable<Long> iterable) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Long> mutableSet = toMutableSet(jArr);
        CollectionsKt__MutableCollectionsKt.retainAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Float> intersect(@NotNull float[] fArr, @NotNull Iterable<Float> iterable) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Float> mutableSet = toMutableSet(fArr);
        CollectionsKt__MutableCollectionsKt.retainAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Double> intersect(@NotNull double[] dArr, @NotNull Iterable<Double> iterable) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Double> mutableSet = toMutableSet(dArr);
        CollectionsKt__MutableCollectionsKt.retainAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Boolean> intersect(@NotNull boolean[] zArr, @NotNull Iterable<Boolean> iterable) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Boolean> mutableSet = toMutableSet(zArr);
        CollectionsKt__MutableCollectionsKt.retainAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Character> intersect(@NotNull char[] cArr, @NotNull Iterable<Character> iterable) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Character> mutableSet = toMutableSet(cArr);
        CollectionsKt__MutableCollectionsKt.retainAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final <T> Set<T> subtract(@NotNull T[] tArr, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<T> mutableSet = toMutableSet(tArr);
        CollectionsKt__MutableCollectionsKt.removeAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Byte> subtract(@NotNull byte[] bArr, @NotNull Iterable<Byte> iterable) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Byte> mutableSet = toMutableSet(bArr);
        CollectionsKt__MutableCollectionsKt.removeAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Short> subtract(@NotNull short[] sArr, @NotNull Iterable<Short> iterable) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Short> mutableSet = toMutableSet(sArr);
        CollectionsKt__MutableCollectionsKt.removeAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Integer> subtract(@NotNull int[] iArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Integer> mutableSet = toMutableSet(iArr);
        CollectionsKt__MutableCollectionsKt.removeAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Long> subtract(@NotNull long[] jArr, @NotNull Iterable<Long> iterable) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Long> mutableSet = toMutableSet(jArr);
        CollectionsKt__MutableCollectionsKt.removeAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Float> subtract(@NotNull float[] fArr, @NotNull Iterable<Float> iterable) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Float> mutableSet = toMutableSet(fArr);
        CollectionsKt__MutableCollectionsKt.removeAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Double> subtract(@NotNull double[] dArr, @NotNull Iterable<Double> iterable) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Double> mutableSet = toMutableSet(dArr);
        CollectionsKt__MutableCollectionsKt.removeAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Boolean> subtract(@NotNull boolean[] zArr, @NotNull Iterable<Boolean> iterable) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Boolean> mutableSet = toMutableSet(zArr);
        CollectionsKt__MutableCollectionsKt.removeAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Character> subtract(@NotNull char[] cArr, @NotNull Iterable<Character> iterable) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Character> mutableSet = toMutableSet(cArr);
        CollectionsKt__MutableCollectionsKt.removeAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final <T> Set<T> toMutableSet(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(tArr.length));
        for (T add : tArr) {
            linkedHashSet.add(add);
        }
        return linkedHashSet;
    }

    @NotNull
    public static final Set<Byte> toMutableSet(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(bArr.length));
        for (byte valueOf : bArr) {
            linkedHashSet.add(Byte.valueOf(valueOf));
        }
        return linkedHashSet;
    }

    @NotNull
    public static final Set<Short> toMutableSet(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(sArr.length));
        for (short valueOf : sArr) {
            linkedHashSet.add(Short.valueOf(valueOf));
        }
        return linkedHashSet;
    }

    @NotNull
    public static final Set<Integer> toMutableSet(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(iArr.length));
        for (int valueOf : iArr) {
            linkedHashSet.add(Integer.valueOf(valueOf));
        }
        return linkedHashSet;
    }

    @NotNull
    public static final Set<Long> toMutableSet(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(jArr.length));
        for (long valueOf : jArr) {
            linkedHashSet.add(Long.valueOf(valueOf));
        }
        return linkedHashSet;
    }

    @NotNull
    public static final Set<Float> toMutableSet(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(fArr.length));
        for (float valueOf : fArr) {
            linkedHashSet.add(Float.valueOf(valueOf));
        }
        return linkedHashSet;
    }

    @NotNull
    public static final Set<Double> toMutableSet(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(dArr.length));
        for (double valueOf : dArr) {
            linkedHashSet.add(Double.valueOf(valueOf));
        }
        return linkedHashSet;
    }

    @NotNull
    public static final Set<Boolean> toMutableSet(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(zArr.length));
        for (boolean valueOf : zArr) {
            linkedHashSet.add(Boolean.valueOf(valueOf));
        }
        return linkedHashSet;
    }

    @NotNull
    public static final Set<Character> toMutableSet(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(cArr.length));
        for (char valueOf : cArr) {
            linkedHashSet.add(Character.valueOf(valueOf));
        }
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> union(@NotNull T[] tArr, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<T> mutableSet = toMutableSet(tArr);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Byte> union(@NotNull byte[] bArr, @NotNull Iterable<Byte> iterable) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Byte> mutableSet = toMutableSet(bArr);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Short> union(@NotNull short[] sArr, @NotNull Iterable<Short> iterable) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Short> mutableSet = toMutableSet(sArr);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Integer> union(@NotNull int[] iArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Integer> mutableSet = toMutableSet(iArr);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Long> union(@NotNull long[] jArr, @NotNull Iterable<Long> iterable) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Long> mutableSet = toMutableSet(jArr);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Float> union(@NotNull float[] fArr, @NotNull Iterable<Float> iterable) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Float> mutableSet = toMutableSet(fArr);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Double> union(@NotNull double[] dArr, @NotNull Iterable<Double> iterable) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Double> mutableSet = toMutableSet(dArr);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Boolean> union(@NotNull boolean[] zArr, @NotNull Iterable<Boolean> iterable) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Boolean> mutableSet = toMutableSet(zArr);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Set<Character> union(@NotNull char[] cArr, @NotNull Iterable<Character> iterable) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Set<Character> mutableSet = toMutableSet(cArr);
        CollectionsKt__MutableCollectionsKt.addAll((Collection<? super T>) mutableSet, iterable);
        return mutableSet;
    }

    public static final <T> boolean all(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (T invoke : tArr) {
            if (!((Boolean) function1.invoke(invoke)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean all(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (byte valueOf : bArr) {
            if (!((Boolean) function1.invoke(Byte.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean all(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (short valueOf : sArr) {
            if (!((Boolean) function1.invoke(Short.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean all(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int valueOf : iArr) {
            if (!((Boolean) function1.invoke(Integer.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean all(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (long valueOf : jArr) {
            if (!((Boolean) function1.invoke(Long.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean all(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (float valueOf : fArr) {
            if (!((Boolean) function1.invoke(Float.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean all(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (double valueOf : dArr) {
            if (!((Boolean) function1.invoke(Double.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean all(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (boolean valueOf : zArr) {
            if (!((Boolean) function1.invoke(Boolean.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean all(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (char valueOf : cArr) {
            if (!((Boolean) function1.invoke(Character.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        return !(tArr.length == 0);
    }

    public static final boolean any(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        return !(bArr.length == 0);
    }

    public static final boolean any(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        return !(sArr.length == 0);
    }

    public static final boolean any(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        return !(iArr.length == 0);
    }

    public static final boolean any(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        return !(jArr.length == 0);
    }

    public static final boolean any(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        return !(fArr.length == 0);
    }

    public static final boolean any(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        return !(dArr.length == 0);
    }

    public static final boolean any(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        return !(zArr.length == 0);
    }

    public static final boolean any(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        return !(cArr.length == 0);
    }

    public static final <T> boolean any(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (T invoke : tArr) {
            if (((Boolean) function1.invoke(invoke)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean any(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (byte valueOf : bArr) {
            if (((Boolean) function1.invoke(Byte.valueOf(valueOf))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean any(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (short valueOf : sArr) {
            if (((Boolean) function1.invoke(Short.valueOf(valueOf))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean any(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int valueOf : iArr) {
            if (((Boolean) function1.invoke(Integer.valueOf(valueOf))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean any(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (long valueOf : jArr) {
            if (((Boolean) function1.invoke(Long.valueOf(valueOf))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean any(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (float valueOf : fArr) {
            if (((Boolean) function1.invoke(Float.valueOf(valueOf))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean any(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (double valueOf : dArr) {
            if (((Boolean) function1.invoke(Double.valueOf(valueOf))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean any(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (boolean valueOf : zArr) {
            if (((Boolean) function1.invoke(Boolean.valueOf(valueOf))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean any(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (char valueOf : cArr) {
            if (((Boolean) function1.invoke(Character.valueOf(valueOf))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <T> int count(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        for (T invoke : tArr) {
            if (((Boolean) function1.invoke(invoke)).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public static final int count(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        for (byte valueOf : bArr) {
            if (((Boolean) function1.invoke(Byte.valueOf(valueOf))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public static final int count(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        for (short valueOf : sArr) {
            if (((Boolean) function1.invoke(Short.valueOf(valueOf))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public static final int count(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        for (int valueOf : iArr) {
            if (((Boolean) function1.invoke(Integer.valueOf(valueOf))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public static final int count(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        for (long valueOf : jArr) {
            if (((Boolean) function1.invoke(Long.valueOf(valueOf))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public static final int count(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        for (float valueOf : fArr) {
            if (((Boolean) function1.invoke(Float.valueOf(valueOf))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public static final int count(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        for (double valueOf : dArr) {
            if (((Boolean) function1.invoke(Double.valueOf(valueOf))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public static final int count(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        for (boolean valueOf : zArr) {
            if (((Boolean) function1.invoke(Boolean.valueOf(valueOf))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public static final int count(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int i = 0;
        for (char valueOf : cArr) {
            if (((Boolean) function1.invoke(Character.valueOf(valueOf))).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public static final <T, R> R fold(@NotNull T[] tArr, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        for (T invoke : tArr) {
            r = function2.invoke(r, invoke);
        }
        return r;
    }

    public static final <R> R fold(@NotNull byte[] bArr, R r, @NotNull Function2<? super R, ? super Byte, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        for (byte valueOf : bArr) {
            r = function2.invoke(r, Byte.valueOf(valueOf));
        }
        return r;
    }

    public static final <R> R fold(@NotNull short[] sArr, R r, @NotNull Function2<? super R, ? super Short, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        for (short valueOf : sArr) {
            r = function2.invoke(r, Short.valueOf(valueOf));
        }
        return r;
    }

    public static final <R> R fold(@NotNull int[] iArr, R r, @NotNull Function2<? super R, ? super Integer, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        for (int valueOf : iArr) {
            r = function2.invoke(r, Integer.valueOf(valueOf));
        }
        return r;
    }

    public static final <R> R fold(@NotNull long[] jArr, R r, @NotNull Function2<? super R, ? super Long, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        for (long valueOf : jArr) {
            r = function2.invoke(r, Long.valueOf(valueOf));
        }
        return r;
    }

    public static final <R> R fold(@NotNull float[] fArr, R r, @NotNull Function2<? super R, ? super Float, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        for (float valueOf : fArr) {
            r = function2.invoke(r, Float.valueOf(valueOf));
        }
        return r;
    }

    public static final <R> R fold(@NotNull double[] dArr, R r, @NotNull Function2<? super R, ? super Double, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        for (double valueOf : dArr) {
            r = function2.invoke(r, Double.valueOf(valueOf));
        }
        return r;
    }

    public static final <R> R fold(@NotNull boolean[] zArr, R r, @NotNull Function2<? super R, ? super Boolean, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        for (boolean valueOf : zArr) {
            r = function2.invoke(r, Boolean.valueOf(valueOf));
        }
        return r;
    }

    public static final <R> R fold(@NotNull char[] cArr, R r, @NotNull Function2<? super R, ? super Character, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        for (char valueOf : cArr) {
            r = function2.invoke(r, Character.valueOf(valueOf));
        }
        return r;
    }

    public static final <T, R> R foldIndexed(@NotNull T[] tArr, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 0;
        for (T t : tArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            r = function3.invoke(valueOf, r, t);
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull byte[] bArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Byte, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 0;
        for (byte b : bArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            r = function3.invoke(valueOf, r, Byte.valueOf(b));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull short[] sArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Short, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 0;
        for (short s : sArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            r = function3.invoke(valueOf, r, Short.valueOf(s));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull int[] iArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Integer, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 0;
        for (int i2 : iArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            r = function3.invoke(valueOf, r, Integer.valueOf(i2));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull long[] jArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Long, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 0;
        for (long j : jArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            r = function3.invoke(valueOf, r, Long.valueOf(j));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull float[] fArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Float, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 0;
        for (float f : fArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            r = function3.invoke(valueOf, r, Float.valueOf(f));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull double[] dArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Double, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 0;
        for (double d : dArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            r = function3.invoke(valueOf, r, Double.valueOf(d));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull boolean[] zArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Boolean, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 0;
        for (boolean z : zArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            r = function3.invoke(valueOf, r, Boolean.valueOf(z));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull char[] cArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Character, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 0;
        for (char c : cArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            r = function3.invoke(valueOf, r, Character.valueOf(c));
        }
        return r;
    }

    public static final <T, R> R foldRight(@NotNull T[] tArr, R r, @NotNull Function2<? super T, ? super R, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(tArr);
        while (lastIndex >= 0) {
            int i = lastIndex - 1;
            r = function2.invoke(tArr[lastIndex], r);
            lastIndex = i;
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull byte[] bArr, R r, @NotNull Function2<? super Byte, ? super R, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(bArr);
        while (lastIndex >= 0) {
            int i = lastIndex - 1;
            r = function2.invoke(Byte.valueOf(bArr[lastIndex]), r);
            lastIndex = i;
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull short[] sArr, R r, @NotNull Function2<? super Short, ? super R, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(sArr);
        while (lastIndex >= 0) {
            int i = lastIndex - 1;
            r = function2.invoke(Short.valueOf(sArr[lastIndex]), r);
            lastIndex = i;
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull int[] iArr, R r, @NotNull Function2<? super Integer, ? super R, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(iArr);
        while (lastIndex >= 0) {
            int i = lastIndex - 1;
            r = function2.invoke(Integer.valueOf(iArr[lastIndex]), r);
            lastIndex = i;
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull long[] jArr, R r, @NotNull Function2<? super Long, ? super R, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(jArr);
        while (lastIndex >= 0) {
            int i = lastIndex - 1;
            r = function2.invoke(Long.valueOf(jArr[lastIndex]), r);
            lastIndex = i;
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull float[] fArr, R r, @NotNull Function2<? super Float, ? super R, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(fArr);
        while (lastIndex >= 0) {
            int i = lastIndex - 1;
            r = function2.invoke(Float.valueOf(fArr[lastIndex]), r);
            lastIndex = i;
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull double[] dArr, R r, @NotNull Function2<? super Double, ? super R, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(dArr);
        while (lastIndex >= 0) {
            int i = lastIndex - 1;
            r = function2.invoke(Double.valueOf(dArr[lastIndex]), r);
            lastIndex = i;
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull boolean[] zArr, R r, @NotNull Function2<? super Boolean, ? super R, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(zArr);
        while (lastIndex >= 0) {
            int i = lastIndex - 1;
            r = function2.invoke(Boolean.valueOf(zArr[lastIndex]), r);
            lastIndex = i;
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull char[] cArr, R r, @NotNull Function2<? super Character, ? super R, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(cArr);
        while (lastIndex >= 0) {
            int i = lastIndex - 1;
            r = function2.invoke(Character.valueOf(cArr[lastIndex]), r);
            lastIndex = i;
        }
        return r;
    }

    public static final <T, R> R foldRightIndexed(@NotNull T[] tArr, R r, @NotNull Function3<? super Integer, ? super T, ? super R, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            r = function3.invoke(Integer.valueOf(lastIndex), tArr[lastIndex], r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull byte[] bArr, R r, @NotNull Function3<? super Integer, ? super Byte, ? super R, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            r = function3.invoke(Integer.valueOf(lastIndex), Byte.valueOf(bArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull short[] sArr, R r, @NotNull Function3<? super Integer, ? super Short, ? super R, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            r = function3.invoke(Integer.valueOf(lastIndex), Short.valueOf(sArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull int[] iArr, R r, @NotNull Function3<? super Integer, ? super Integer, ? super R, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            r = function3.invoke(Integer.valueOf(lastIndex), Integer.valueOf(iArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull long[] jArr, R r, @NotNull Function3<? super Integer, ? super Long, ? super R, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            r = function3.invoke(Integer.valueOf(lastIndex), Long.valueOf(jArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull float[] fArr, R r, @NotNull Function3<? super Integer, ? super Float, ? super R, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            r = function3.invoke(Integer.valueOf(lastIndex), Float.valueOf(fArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull double[] dArr, R r, @NotNull Function3<? super Integer, ? super Double, ? super R, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            r = function3.invoke(Integer.valueOf(lastIndex), Double.valueOf(dArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull boolean[] zArr, R r, @NotNull Function3<? super Integer, ? super Boolean, ? super R, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            r = function3.invoke(Integer.valueOf(lastIndex), Boolean.valueOf(zArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull char[] cArr, R r, @NotNull Function3<? super Integer, ? super Character, ? super R, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            r = function3.invoke(Integer.valueOf(lastIndex), Character.valueOf(cArr[lastIndex]), r);
        }
        return r;
    }

    public static final <T> void forEach(@NotNull T[] tArr, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        for (T invoke : tArr) {
            function1.invoke(invoke);
        }
    }

    public static final void forEach(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        for (byte valueOf : bArr) {
            function1.invoke(Byte.valueOf(valueOf));
        }
    }

    public static final void forEach(@NotNull short[] sArr, @NotNull Function1<? super Short, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        for (short valueOf : sArr) {
            function1.invoke(Short.valueOf(valueOf));
        }
    }

    public static final void forEach(@NotNull int[] iArr, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        for (int valueOf : iArr) {
            function1.invoke(Integer.valueOf(valueOf));
        }
    }

    public static final void forEach(@NotNull long[] jArr, @NotNull Function1<? super Long, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        for (long valueOf : jArr) {
            function1.invoke(Long.valueOf(valueOf));
        }
    }

    public static final void forEach(@NotNull float[] fArr, @NotNull Function1<? super Float, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        for (float valueOf : fArr) {
            function1.invoke(Float.valueOf(valueOf));
        }
    }

    public static final void forEach(@NotNull double[] dArr, @NotNull Function1<? super Double, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        for (double valueOf : dArr) {
            function1.invoke(Double.valueOf(valueOf));
        }
    }

    public static final void forEach(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        for (boolean valueOf : zArr) {
            function1.invoke(Boolean.valueOf(valueOf));
        }
    }

    public static final void forEach(@NotNull char[] cArr, @NotNull Function1<? super Character, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        for (char valueOf : cArr) {
            function1.invoke(Character.valueOf(valueOf));
        }
    }

    public static final <T> void forEachIndexed(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int i = 0;
        for (T t : tArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            function2.invoke(valueOf, t);
        }
    }

    public static final void forEachIndexed(@NotNull byte[] bArr, @NotNull Function2<? super Integer, ? super Byte, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int i = 0;
        for (byte b : bArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            function2.invoke(valueOf, Byte.valueOf(b));
        }
    }

    public static final void forEachIndexed(@NotNull short[] sArr, @NotNull Function2<? super Integer, ? super Short, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int i = 0;
        for (short s : sArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            function2.invoke(valueOf, Short.valueOf(s));
        }
    }

    public static final void forEachIndexed(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int i = 0;
        for (int i2 : iArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            function2.invoke(valueOf, Integer.valueOf(i2));
        }
    }

    public static final void forEachIndexed(@NotNull long[] jArr, @NotNull Function2<? super Integer, ? super Long, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int i = 0;
        for (long j : jArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            function2.invoke(valueOf, Long.valueOf(j));
        }
    }

    public static final void forEachIndexed(@NotNull float[] fArr, @NotNull Function2<? super Integer, ? super Float, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int i = 0;
        for (float f : fArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            function2.invoke(valueOf, Float.valueOf(f));
        }
    }

    public static final void forEachIndexed(@NotNull double[] dArr, @NotNull Function2<? super Integer, ? super Double, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int i = 0;
        for (double d : dArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            function2.invoke(valueOf, Double.valueOf(d));
        }
    }

    public static final void forEachIndexed(@NotNull boolean[] zArr, @NotNull Function2<? super Integer, ? super Boolean, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int i = 0;
        for (boolean z : zArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            function2.invoke(valueOf, Boolean.valueOf(z));
        }
    }

    public static final void forEachIndexed(@NotNull char[] cArr, @NotNull Function2<? super Integer, ? super Character, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int i = 0;
        for (char c : cArr) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            function2.invoke(valueOf, Character.valueOf(c));
        }
    }

    @Nullable
    public static final Double max(@NotNull Double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        int i = 1;
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = dArr[0].doubleValue();
        if (Double.isNaN(doubleValue)) {
            return Double.valueOf(doubleValue);
        }
        int lastIndex = getLastIndex((T[]) dArr);
        if (1 <= lastIndex) {
            while (true) {
                double doubleValue2 = dArr[i].doubleValue();
                if (!Double.isNaN(doubleValue2)) {
                    if (doubleValue < doubleValue2) {
                        doubleValue = doubleValue2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                } else {
                    return Double.valueOf(doubleValue2);
                }
            }
        }
        return Double.valueOf(doubleValue);
    }

    @Nullable
    public static final Float max(@NotNull Float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        int i = 1;
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = fArr[0].floatValue();
        if (Float.isNaN(floatValue)) {
            return Float.valueOf(floatValue);
        }
        int lastIndex = getLastIndex((T[]) fArr);
        if (1 <= lastIndex) {
            while (true) {
                float floatValue2 = fArr[i].floatValue();
                if (!Float.isNaN(floatValue2)) {
                    if (floatValue < floatValue2) {
                        floatValue = floatValue2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                } else {
                    return Float.valueOf(floatValue2);
                }
            }
        }
        return Float.valueOf(floatValue);
    }

    @Nullable
    public static final <T extends Comparable<? super T>> T max(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        int i = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i];
                if (t.compareTo(t2) < 0) {
                    t = t2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return t;
    }

    @Nullable
    public static final Byte max(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        int i = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b2 = bArr[i];
                if (b < b2) {
                    b = b2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Byte.valueOf(b);
    }

    @Nullable
    public static final Short max(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        int i = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s2 = sArr[i];
                if (s < s2) {
                    s = s2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Short.valueOf(s);
    }

    @Nullable
    public static final Integer max(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        int i = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i2 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i3 = iArr[i];
                if (i2 < i3) {
                    i2 = i3;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Integer.valueOf(i2);
    }

    @Nullable
    public static final Long max(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        int i = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j2 = jArr[i];
                if (j < j2) {
                    j = j2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Long.valueOf(j);
    }

    @Nullable
    public static final Float max(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        int i = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        if (Float.isNaN(f)) {
            return Float.valueOf(f);
        }
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                float f2 = fArr[i];
                if (!Float.isNaN(f2)) {
                    if (f < f2) {
                        f = f2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                } else {
                    return Float.valueOf(f2);
                }
            }
        }
        return Float.valueOf(f);
    }

    @Nullable
    public static final Double max(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        int i = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        if (Double.isNaN(d)) {
            return Double.valueOf(d);
        }
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                double d2 = dArr[i];
                if (!Double.isNaN(d2)) {
                    if (d < d2) {
                        d = d2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                } else {
                    return Double.valueOf(d2);
                }
            }
        }
        return Double.valueOf(d);
    }

    @Nullable
    public static final Character max(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        int i = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c2 = cArr[i];
                if (c < c2) {
                    c = c2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(c);
    }

    @Nullable
    public static final <T, R extends Comparable<? super R>> T maxBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        Comparable comparable = (Comparable) function1.invoke(t);
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(t2);
                if (comparable.compareTo(comparable2) < 0) {
                    t = t2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return t;
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Byte maxBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        Comparable comparable = (Comparable) function1.invoke(Byte.valueOf(b));
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b2 = bArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Byte.valueOf(b2));
                if (comparable.compareTo(comparable2) < 0) {
                    b = b2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Byte.valueOf(b);
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Short maxBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        Comparable comparable = (Comparable) function1.invoke(Short.valueOf(s));
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s2 = sArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Short.valueOf(s2));
                if (comparable.compareTo(comparable2) < 0) {
                    s = s2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Short.valueOf(s);
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Integer maxBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i2 = iArr[0];
        Comparable comparable = (Comparable) function1.invoke(Integer.valueOf(i2));
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i3 = iArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Integer.valueOf(i3));
                if (comparable.compareTo(comparable2) < 0) {
                    i2 = i3;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Integer.valueOf(i2);
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Long maxBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        Comparable comparable = (Comparable) function1.invoke(Long.valueOf(j));
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j2 = jArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Long.valueOf(j2));
                if (comparable.compareTo(comparable2) < 0) {
                    j = j2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Long.valueOf(j);
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Float maxBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        Comparable comparable = (Comparable) function1.invoke(Float.valueOf(f));
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                float f2 = fArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Float.valueOf(f2));
                if (comparable.compareTo(comparable2) < 0) {
                    f = f2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Float.valueOf(f);
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Double maxBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        Comparable comparable = (Comparable) function1.invoke(Double.valueOf(d));
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                double d2 = dArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Double.valueOf(d2));
                if (comparable.compareTo(comparable2) < 0) {
                    d = d2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Double.valueOf(d);
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Boolean maxBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        Comparable comparable = (Comparable) function1.invoke(Boolean.valueOf(z));
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                boolean z2 = zArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Boolean.valueOf(z2));
                if (comparable.compareTo(comparable2) < 0) {
                    z = z2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Boolean.valueOf(z);
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Character maxBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        Comparable comparable = (Comparable) function1.invoke(Character.valueOf(c));
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c2 = cArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Character.valueOf(c2));
                if (comparable.compareTo(comparable2) < 0) {
                    c = c2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(c);
    }

    @Nullable
    public static final <T> T maxWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i];
                if (comparator.compare(t, t2) < 0) {
                    t = t2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return t;
    }

    @Nullable
    public static final Byte maxWith(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b2 = bArr[i];
                if (comparator.compare(Byte.valueOf(b), Byte.valueOf(b2)) < 0) {
                    b = b2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Byte.valueOf(b);
    }

    @Nullable
    public static final Short maxWith(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s2 = sArr[i];
                if (comparator.compare(Short.valueOf(s), Short.valueOf(s2)) < 0) {
                    s = s2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Short.valueOf(s);
    }

    @Nullable
    public static final Integer maxWith(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i2 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i3 = iArr[i];
                if (comparator.compare(Integer.valueOf(i2), Integer.valueOf(i3)) < 0) {
                    i2 = i3;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Integer.valueOf(i2);
    }

    @Nullable
    public static final Long maxWith(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j2 = jArr[i];
                if (comparator.compare(Long.valueOf(j), Long.valueOf(j2)) < 0) {
                    j = j2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Long.valueOf(j);
    }

    @Nullable
    public static final Float maxWith(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                float f2 = fArr[i];
                if (comparator.compare(Float.valueOf(f), Float.valueOf(f2)) < 0) {
                    f = f2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Float.valueOf(f);
    }

    @Nullable
    public static final Double maxWith(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                double d2 = dArr[i];
                if (comparator.compare(Double.valueOf(d), Double.valueOf(d2)) < 0) {
                    d = d2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Double.valueOf(d);
    }

    @Nullable
    public static final Boolean maxWith(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                boolean z2 = zArr[i];
                if (comparator.compare(Boolean.valueOf(z), Boolean.valueOf(z2)) < 0) {
                    z = z2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Boolean.valueOf(z);
    }

    @Nullable
    public static final Character maxWith(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c2 = cArr[i];
                if (comparator.compare(Character.valueOf(c), Character.valueOf(c2)) < 0) {
                    c = c2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(c);
    }

    @Nullable
    public static final Double min(@NotNull Double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        int i = 1;
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = dArr[0].doubleValue();
        if (Double.isNaN(doubleValue)) {
            return Double.valueOf(doubleValue);
        }
        int lastIndex = getLastIndex((T[]) dArr);
        if (1 <= lastIndex) {
            while (true) {
                double doubleValue2 = dArr[i].doubleValue();
                if (!Double.isNaN(doubleValue2)) {
                    if (doubleValue > doubleValue2) {
                        doubleValue = doubleValue2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                } else {
                    return Double.valueOf(doubleValue2);
                }
            }
        }
        return Double.valueOf(doubleValue);
    }

    @Nullable
    public static final Float min(@NotNull Float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        int i = 1;
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = fArr[0].floatValue();
        if (Float.isNaN(floatValue)) {
            return Float.valueOf(floatValue);
        }
        int lastIndex = getLastIndex((T[]) fArr);
        if (1 <= lastIndex) {
            while (true) {
                float floatValue2 = fArr[i].floatValue();
                if (!Float.isNaN(floatValue2)) {
                    if (floatValue > floatValue2) {
                        floatValue = floatValue2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                } else {
                    return Float.valueOf(floatValue2);
                }
            }
        }
        return Float.valueOf(floatValue);
    }

    @Nullable
    public static final <T extends Comparable<? super T>> T min(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        int i = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i];
                if (t.compareTo(t2) > 0) {
                    t = t2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return t;
    }

    @Nullable
    public static final Byte min(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        int i = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b2 = bArr[i];
                if (b > b2) {
                    b = b2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Byte.valueOf(b);
    }

    @Nullable
    public static final Short min(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        int i = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s2 = sArr[i];
                if (s > s2) {
                    s = s2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Short.valueOf(s);
    }

    @Nullable
    public static final Integer min(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        int i = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i2 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i3 = iArr[i];
                if (i2 > i3) {
                    i2 = i3;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Integer.valueOf(i2);
    }

    @Nullable
    public static final Long min(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        int i = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j2 = jArr[i];
                if (j > j2) {
                    j = j2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Long.valueOf(j);
    }

    @Nullable
    public static final Float min(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        int i = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        if (Float.isNaN(f)) {
            return Float.valueOf(f);
        }
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                float f2 = fArr[i];
                if (!Float.isNaN(f2)) {
                    if (f > f2) {
                        f = f2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                } else {
                    return Float.valueOf(f2);
                }
            }
        }
        return Float.valueOf(f);
    }

    @Nullable
    public static final Double min(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        int i = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        if (Double.isNaN(d)) {
            return Double.valueOf(d);
        }
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                double d2 = dArr[i];
                if (!Double.isNaN(d2)) {
                    if (d > d2) {
                        d = d2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                } else {
                    return Double.valueOf(d2);
                }
            }
        }
        return Double.valueOf(d);
    }

    @Nullable
    public static final Character min(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        int i = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c2 = cArr[i];
                if (c > c2) {
                    c = c2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(c);
    }

    @Nullable
    public static final <T, R extends Comparable<? super R>> T minBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        Comparable comparable = (Comparable) function1.invoke(t);
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(t2);
                if (comparable.compareTo(comparable2) > 0) {
                    t = t2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return t;
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Byte minBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        Comparable comparable = (Comparable) function1.invoke(Byte.valueOf(b));
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b2 = bArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Byte.valueOf(b2));
                if (comparable.compareTo(comparable2) > 0) {
                    b = b2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Byte.valueOf(b);
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Short minBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        Comparable comparable = (Comparable) function1.invoke(Short.valueOf(s));
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s2 = sArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Short.valueOf(s2));
                if (comparable.compareTo(comparable2) > 0) {
                    s = s2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Short.valueOf(s);
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Integer minBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i2 = iArr[0];
        Comparable comparable = (Comparable) function1.invoke(Integer.valueOf(i2));
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i3 = iArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Integer.valueOf(i3));
                if (comparable.compareTo(comparable2) > 0) {
                    i2 = i3;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Integer.valueOf(i2);
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Long minBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        Comparable comparable = (Comparable) function1.invoke(Long.valueOf(j));
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j2 = jArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Long.valueOf(j2));
                if (comparable.compareTo(comparable2) > 0) {
                    j = j2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Long.valueOf(j);
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Float minBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        Comparable comparable = (Comparable) function1.invoke(Float.valueOf(f));
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                float f2 = fArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Float.valueOf(f2));
                if (comparable.compareTo(comparable2) > 0) {
                    f = f2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Float.valueOf(f);
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Double minBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        Comparable comparable = (Comparable) function1.invoke(Double.valueOf(d));
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                double d2 = dArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Double.valueOf(d2));
                if (comparable.compareTo(comparable2) > 0) {
                    d = d2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Double.valueOf(d);
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Boolean minBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        Comparable comparable = (Comparable) function1.invoke(Boolean.valueOf(z));
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                boolean z2 = zArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Boolean.valueOf(z2));
                if (comparable.compareTo(comparable2) > 0) {
                    z = z2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Boolean.valueOf(z);
    }

    @Nullable
    public static final <R extends Comparable<? super R>> Character minBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        Comparable comparable = (Comparable) function1.invoke(Character.valueOf(c));
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c2 = cArr[i];
                Comparable comparable2 = (Comparable) function1.invoke(Character.valueOf(c2));
                if (comparable.compareTo(comparable2) > 0) {
                    c = c2;
                    comparable = comparable2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(c);
    }

    @Nullable
    public static final <T> T minWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i];
                if (comparator.compare(t, t2) > 0) {
                    t = t2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return t;
    }

    @Nullable
    public static final Byte minWith(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b2 = bArr[i];
                if (comparator.compare(Byte.valueOf(b), Byte.valueOf(b2)) > 0) {
                    b = b2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Byte.valueOf(b);
    }

    @Nullable
    public static final Short minWith(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s2 = sArr[i];
                if (comparator.compare(Short.valueOf(s), Short.valueOf(s2)) > 0) {
                    s = s2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Short.valueOf(s);
    }

    @Nullable
    public static final Integer minWith(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i2 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i3 = iArr[i];
                if (comparator.compare(Integer.valueOf(i2), Integer.valueOf(i3)) > 0) {
                    i2 = i3;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Integer.valueOf(i2);
    }

    @Nullable
    public static final Long minWith(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j2 = jArr[i];
                if (comparator.compare(Long.valueOf(j), Long.valueOf(j2)) > 0) {
                    j = j2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Long.valueOf(j);
    }

    @Nullable
    public static final Float minWith(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                float f2 = fArr[i];
                if (comparator.compare(Float.valueOf(f), Float.valueOf(f2)) > 0) {
                    f = f2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Float.valueOf(f);
    }

    @Nullable
    public static final Double minWith(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                double d2 = dArr[i];
                if (comparator.compare(Double.valueOf(d), Double.valueOf(d2)) > 0) {
                    d = d2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Double.valueOf(d);
    }

    @Nullable
    public static final Boolean minWith(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                boolean z2 = zArr[i];
                if (comparator.compare(Boolean.valueOf(z), Boolean.valueOf(z2)) > 0) {
                    z = z2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Boolean.valueOf(z);
    }

    @Nullable
    public static final Character minWith(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        int i = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c2 = cArr[i];
                if (comparator.compare(Character.valueOf(c), Character.valueOf(c2)) > 0) {
                    c = c2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return Character.valueOf(c);
    }

    public static final <T> boolean none(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        return tArr.length == 0;
    }

    public static final boolean none(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        return bArr.length == 0;
    }

    public static final boolean none(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        return sArr.length == 0;
    }

    public static final boolean none(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        return iArr.length == 0;
    }

    public static final boolean none(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        return jArr.length == 0;
    }

    public static final boolean none(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        return fArr.length == 0;
    }

    public static final boolean none(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        return dArr.length == 0;
    }

    public static final boolean none(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        return zArr.length == 0;
    }

    public static final boolean none(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        return cArr.length == 0;
    }

    public static final <T> boolean none(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (T invoke : tArr) {
            if (((Boolean) function1.invoke(invoke)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean none(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (byte valueOf : bArr) {
            if (((Boolean) function1.invoke(Byte.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean none(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (short valueOf : sArr) {
            if (((Boolean) function1.invoke(Short.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean none(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (int valueOf : iArr) {
            if (((Boolean) function1.invoke(Integer.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean none(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (long valueOf : jArr) {
            if (((Boolean) function1.invoke(Long.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean none(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (float valueOf : fArr) {
            if (((Boolean) function1.invoke(Float.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean none(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (double valueOf : dArr) {
            if (((Boolean) function1.invoke(Double.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean none(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (boolean valueOf : zArr) {
            if (((Boolean) function1.invoke(Boolean.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean none(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        for (char valueOf : cArr) {
            if (((Boolean) function1.invoke(Character.valueOf(valueOf))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=T[], code=java.lang.Object[], for r4v0, types: [T[], java.lang.Object[], java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S, T extends S> S reduce(@org.jetbrains.annotations.NotNull java.lang.Object[] r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super S, ? super T, ? extends S> r5) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            int r0 = r4.length
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x0028
            r0 = r4[r1]
            int r1 = getLastIndex((T[]) r4)
            if (r2 > r1) goto L_0x0027
        L_0x001c:
            r3 = r4[r2]
            java.lang.Object r0 = r5.invoke(r0, r3)
            if (r2 == r1) goto L_0x0027
            int r2 = r2 + 1
            goto L_0x001c
        L_0x0027:
            return r0
        L_0x0028:
            java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
            java.lang.String r5 = "Empty array can't be reduced."
            r4.<init>(r5)
            goto L_0x0031
        L_0x0030:
            throw r4
        L_0x0031:
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArraysKt___ArraysKt.reduce(java.lang.Object[], kotlin.jvm.functions.Function2):java.lang.Object");
    }

    public static final byte reduce(@NotNull byte[] bArr, @NotNull Function2<? super Byte, ? super Byte, Byte> function2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int i = 1;
        if (!(bArr.length == 0)) {
            byte b = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    b = ((Number) function2.invoke(Byte.valueOf(b), Byte.valueOf(bArr[i]))).byteValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return b;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final short reduce(@NotNull short[] sArr, @NotNull Function2<? super Short, ? super Short, Short> function2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int i = 1;
        if (!(sArr.length == 0)) {
            short s = sArr[0];
            int lastIndex = getLastIndex(sArr);
            if (1 <= lastIndex) {
                while (true) {
                    s = ((Number) function2.invoke(Short.valueOf(s), Short.valueOf(sArr[i]))).shortValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int reduce(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Integer> function2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int i = 1;
        if (!(iArr.length == 0)) {
            int i2 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (1 <= lastIndex) {
                while (true) {
                    i2 = ((Number) function2.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i]))).intValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return i2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long reduce(@NotNull long[] jArr, @NotNull Function2<? super Long, ? super Long, Long> function2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int i = 1;
        if (!(jArr.length == 0)) {
            long j = jArr[0];
            int lastIndex = getLastIndex(jArr);
            if (1 <= lastIndex) {
                while (true) {
                    j = ((Number) function2.invoke(Long.valueOf(j), Long.valueOf(jArr[i]))).longValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduce(@NotNull float[] fArr, @NotNull Function2<? super Float, ? super Float, Float> function2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int i = 1;
        if (!(fArr.length == 0)) {
            float f = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    f = ((Number) function2.invoke(Float.valueOf(f), Float.valueOf(fArr[i]))).floatValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return f;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final double reduce(@NotNull double[] dArr, @NotNull Function2<? super Double, ? super Double, Double> function2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int i = 1;
        if (!(dArr.length == 0)) {
            double d = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    d = ((Number) function2.invoke(Double.valueOf(d), Double.valueOf(dArr[i]))).doubleValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return d;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean reduce(@NotNull boolean[] zArr, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int i = 1;
        if (!(zArr.length == 0)) {
            boolean z = zArr[0];
            int lastIndex = getLastIndex(zArr);
            if (1 <= lastIndex) {
                while (true) {
                    z = ((Boolean) function2.invoke(Boolean.valueOf(z), Boolean.valueOf(zArr[i]))).booleanValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char reduce(@NotNull char[] cArr, @NotNull Function2<? super Character, ? super Character, Character> function2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int i = 1;
        if (!(cArr.length == 0)) {
            char c = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    c = ((Character) function2.invoke(Character.valueOf(c), Character.valueOf(cArr[i]))).charValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return c;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=T[], code=java.lang.Object[], for r5v0, types: [T[], java.lang.Object[], java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S, T extends S> S reduceIndexed(@org.jetbrains.annotations.NotNull java.lang.Object[] r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super S, ? super T, ? extends S> r6) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            int r0 = r5.length
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x002c
            r0 = r5[r1]
            int r1 = getLastIndex((T[]) r5)
            if (r2 > r1) goto L_0x002b
        L_0x001c:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r4 = r5[r2]
            java.lang.Object r0 = r6.invoke(r3, r0, r4)
            if (r2 == r1) goto L_0x002b
            int r2 = r2 + 1
            goto L_0x001c
        L_0x002b:
            return r0
        L_0x002c:
            java.lang.UnsupportedOperationException r5 = new java.lang.UnsupportedOperationException
            java.lang.String r6 = "Empty array can't be reduced."
            r5.<init>(r6)
            goto L_0x0035
        L_0x0034:
            throw r5
        L_0x0035:
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArraysKt___ArraysKt.reduceIndexed(java.lang.Object[], kotlin.jvm.functions.Function3):java.lang.Object");
    }

    public static final byte reduceIndexed(@NotNull byte[] bArr, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> function3) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 1;
        if (!(bArr.length == 0)) {
            byte b = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    b = ((Number) function3.invoke(Integer.valueOf(i), Byte.valueOf(b), Byte.valueOf(bArr[i]))).byteValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return b;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final short reduceIndexed(@NotNull short[] sArr, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> function3) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 1;
        if (!(sArr.length == 0)) {
            short s = sArr[0];
            int lastIndex = getLastIndex(sArr);
            if (1 <= lastIndex) {
                while (true) {
                    s = ((Number) function3.invoke(Integer.valueOf(i), Short.valueOf(s), Short.valueOf(sArr[i]))).shortValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int reduceIndexed(@NotNull int[] iArr, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> function3) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 1;
        if (!(iArr.length == 0)) {
            int i2 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (1 <= lastIndex) {
                while (true) {
                    i2 = ((Number) function3.invoke(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(iArr[i]))).intValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return i2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long reduceIndexed(@NotNull long[] jArr, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> function3) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 1;
        if (!(jArr.length == 0)) {
            long j = jArr[0];
            int lastIndex = getLastIndex(jArr);
            if (1 <= lastIndex) {
                while (true) {
                    j = ((Number) function3.invoke(Integer.valueOf(i), Long.valueOf(j), Long.valueOf(jArr[i]))).longValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceIndexed(@NotNull float[] fArr, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> function3) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 1;
        if (!(fArr.length == 0)) {
            float f = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    f = ((Number) function3.invoke(Integer.valueOf(i), Float.valueOf(f), Float.valueOf(fArr[i]))).floatValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return f;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final double reduceIndexed(@NotNull double[] dArr, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> function3) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 1;
        if (!(dArr.length == 0)) {
            double d = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    d = ((Number) function3.invoke(Integer.valueOf(i), Double.valueOf(d), Double.valueOf(dArr[i]))).doubleValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return d;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean reduceIndexed(@NotNull boolean[] zArr, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> function3) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 1;
        if (!(zArr.length == 0)) {
            boolean z = zArr[0];
            int lastIndex = getLastIndex(zArr);
            if (1 <= lastIndex) {
                while (true) {
                    z = ((Boolean) function3.invoke(Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(zArr[i]))).booleanValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char reduceIndexed(@NotNull char[] cArr, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> function3) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int i = 1;
        if (!(cArr.length == 0)) {
            char c = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    c = ((Character) function3.invoke(Integer.valueOf(i), Character.valueOf(c), Character.valueOf(cArr[i]))).charValue();
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return c;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=T[], code=java.lang.Object[], for r3v0, types: [T[], java.lang.Object[], java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S, T extends S> S reduceRight(@org.jetbrains.annotations.NotNull java.lang.Object[] r3, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super S, ? extends S> r4) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            int r0 = getLastIndex((T[]) r3)
            if (r0 < 0) goto L_0x0021
            int r1 = r0 + -1
            r0 = r3[r0]
        L_0x0014:
            if (r1 < 0) goto L_0x0020
            int r2 = r1 + -1
            r1 = r3[r1]
            java.lang.Object r0 = r4.invoke(r1, r0)
            r1 = r2
            goto L_0x0014
        L_0x0020:
            return r0
        L_0x0021:
            java.lang.UnsupportedOperationException r3 = new java.lang.UnsupportedOperationException
            java.lang.String r4 = "Empty array can't be reduced."
            r3.<init>(r4)
            goto L_0x002a
        L_0x0029:
            throw r3
        L_0x002a:
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArraysKt___ArraysKt.reduceRight(java.lang.Object[], kotlin.jvm.functions.Function2):java.lang.Object");
    }

    public static final byte reduceRight(@NotNull byte[] bArr, @NotNull Function2<? super Byte, ? super Byte, Byte> function2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            int i = lastIndex - 1;
            byte b = bArr[lastIndex];
            while (i >= 0) {
                int i2 = i - 1;
                b = ((Number) function2.invoke(Byte.valueOf(bArr[i]), Byte.valueOf(b))).byteValue();
                i = i2;
            }
            return b;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final short reduceRight(@NotNull short[] sArr, @NotNull Function2<? super Short, ? super Short, Short> function2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            int i = lastIndex - 1;
            short s = sArr[lastIndex];
            while (i >= 0) {
                int i2 = i - 1;
                s = ((Number) function2.invoke(Short.valueOf(sArr[i]), Short.valueOf(s))).shortValue();
                i = i2;
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int reduceRight(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Integer> function2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int i = lastIndex - 1;
            int i2 = iArr[lastIndex];
            while (i >= 0) {
                int i3 = i - 1;
                i2 = ((Number) function2.invoke(Integer.valueOf(iArr[i]), Integer.valueOf(i2))).intValue();
                i = i3;
            }
            return i2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long reduceRight(@NotNull long[] jArr, @NotNull Function2<? super Long, ? super Long, Long> function2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            int i = lastIndex - 1;
            long j = jArr[lastIndex];
            while (i >= 0) {
                int i2 = i - 1;
                j = ((Number) function2.invoke(Long.valueOf(jArr[i]), Long.valueOf(j))).longValue();
                i = i2;
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceRight(@NotNull float[] fArr, @NotNull Function2<? super Float, ? super Float, Float> function2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            int i = lastIndex - 1;
            float f = fArr[lastIndex];
            while (i >= 0) {
                int i2 = i - 1;
                f = ((Number) function2.invoke(Float.valueOf(fArr[i]), Float.valueOf(f))).floatValue();
                i = i2;
            }
            return f;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final double reduceRight(@NotNull double[] dArr, @NotNull Function2<? super Double, ? super Double, Double> function2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            int i = lastIndex - 1;
            double d = dArr[lastIndex];
            while (i >= 0) {
                int i2 = i - 1;
                d = ((Number) function2.invoke(Double.valueOf(dArr[i]), Double.valueOf(d))).doubleValue();
                i = i2;
            }
            return d;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean reduceRight(@NotNull boolean[] zArr, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            int i = lastIndex - 1;
            boolean z = zArr[lastIndex];
            while (i >= 0) {
                int i2 = i - 1;
                z = ((Boolean) function2.invoke(Boolean.valueOf(zArr[i]), Boolean.valueOf(z))).booleanValue();
                i = i2;
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char reduceRight(@NotNull char[] cArr, @NotNull Function2<? super Character, ? super Character, Character> function2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            int i = lastIndex - 1;
            char c = cArr[lastIndex];
            while (i >= 0) {
                int i2 = i - 1;
                c = ((Character) function2.invoke(Character.valueOf(cArr[i]), Character.valueOf(c))).charValue();
                i = i2;
            }
            return c;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=T[], code=java.lang.Object[], for r4v0, types: [T[], java.lang.Object[], java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S, T extends S> S reduceRightIndexed(@org.jetbrains.annotations.NotNull java.lang.Object[] r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super T, ? super S, ? extends S> r5) {
        /*
            java.lang.String r0 = "receiver$0"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            int r0 = getLastIndex((T[]) r4)
            if (r0 < 0) goto L_0x0024
            int r1 = r0 + -1
            r0 = r4[r0]
        L_0x0014:
            if (r1 < 0) goto L_0x0023
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            r3 = r4[r1]
            java.lang.Object r0 = r5.invoke(r2, r3, r0)
            int r1 = r1 + -1
            goto L_0x0014
        L_0x0023:
            return r0
        L_0x0024:
            java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
            java.lang.String r5 = "Empty array can't be reduced."
            r4.<init>(r5)
            goto L_0x002d
        L_0x002c:
            throw r4
        L_0x002d:
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArraysKt___ArraysKt.reduceRightIndexed(java.lang.Object[], kotlin.jvm.functions.Function3):java.lang.Object");
    }

    public static final byte reduceRightIndexed(@NotNull byte[] bArr, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> function3) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            byte b = bArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                b = ((Number) function3.invoke(Integer.valueOf(i), Byte.valueOf(bArr[i]), Byte.valueOf(b))).byteValue();
            }
            return b;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final short reduceRightIndexed(@NotNull short[] sArr, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> function3) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            short s = sArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                s = ((Number) function3.invoke(Integer.valueOf(i), Short.valueOf(sArr[i]), Short.valueOf(s))).shortValue();
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int reduceRightIndexed(@NotNull int[] iArr, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> function3) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int i = iArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                i = ((Number) function3.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i2]), Integer.valueOf(i))).intValue();
            }
            return i;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long reduceRightIndexed(@NotNull long[] jArr, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> function3) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            long j = jArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                j = ((Number) function3.invoke(Integer.valueOf(i), Long.valueOf(jArr[i]), Long.valueOf(j))).longValue();
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceRightIndexed(@NotNull float[] fArr, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> function3) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            float f = fArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                f = ((Number) function3.invoke(Integer.valueOf(i), Float.valueOf(fArr[i]), Float.valueOf(f))).floatValue();
            }
            return f;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final double reduceRightIndexed(@NotNull double[] dArr, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> function3) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            double d = dArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                d = ((Number) function3.invoke(Integer.valueOf(i), Double.valueOf(dArr[i]), Double.valueOf(d))).doubleValue();
            }
            return d;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean reduceRightIndexed(@NotNull boolean[] zArr, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> function3) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            boolean z = zArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                z = ((Boolean) function3.invoke(Integer.valueOf(i), Boolean.valueOf(zArr[i]), Boolean.valueOf(z))).booleanValue();
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char reduceRightIndexed(@NotNull char[] cArr, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> function3) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function3, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            char c = cArr[lastIndex];
            for (int i = lastIndex - 1; i >= 0; i--) {
                c = ((Character) function3.invoke(Integer.valueOf(i), Character.valueOf(cArr[i]), Character.valueOf(c))).charValue();
            }
            return c;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final <T> int sumBy(@NotNull T[] tArr, @NotNull Function1<? super T, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 0;
        for (T invoke : tArr) {
            i += ((Number) function1.invoke(invoke)).intValue();
        }
        return i;
    }

    public static final int sumBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 0;
        for (byte valueOf : bArr) {
            i += ((Number) function1.invoke(Byte.valueOf(valueOf))).intValue();
        }
        return i;
    }

    public static final int sumBy(@NotNull short[] sArr, @NotNull Function1<? super Short, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 0;
        for (short valueOf : sArr) {
            i += ((Number) function1.invoke(Short.valueOf(valueOf))).intValue();
        }
        return i;
    }

    public static final int sumBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 0;
        for (int valueOf : iArr) {
            i += ((Number) function1.invoke(Integer.valueOf(valueOf))).intValue();
        }
        return i;
    }

    public static final int sumBy(@NotNull long[] jArr, @NotNull Function1<? super Long, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 0;
        for (long valueOf : jArr) {
            i += ((Number) function1.invoke(Long.valueOf(valueOf))).intValue();
        }
        return i;
    }

    public static final int sumBy(@NotNull float[] fArr, @NotNull Function1<? super Float, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 0;
        for (float valueOf : fArr) {
            i += ((Number) function1.invoke(Float.valueOf(valueOf))).intValue();
        }
        return i;
    }

    public static final int sumBy(@NotNull double[] dArr, @NotNull Function1<? super Double, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 0;
        for (double valueOf : dArr) {
            i += ((Number) function1.invoke(Double.valueOf(valueOf))).intValue();
        }
        return i;
    }

    public static final int sumBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 0;
        for (boolean valueOf : zArr) {
            i += ((Number) function1.invoke(Boolean.valueOf(valueOf))).intValue();
        }
        return i;
    }

    public static final int sumBy(@NotNull char[] cArr, @NotNull Function1<? super Character, Integer> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int i = 0;
        for (char valueOf : cArr) {
            i += ((Number) function1.invoke(Character.valueOf(valueOf))).intValue();
        }
        return i;
    }

    public static final <T> double sumByDouble(@NotNull T[] tArr, @NotNull Function1<? super T, Double> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (T invoke : tArr) {
            d += ((Number) function1.invoke(invoke)).doubleValue();
        }
        return d;
    }

    public static final double sumByDouble(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Double> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (byte valueOf : bArr) {
            d += ((Number) function1.invoke(Byte.valueOf(valueOf))).doubleValue();
        }
        return d;
    }

    public static final double sumByDouble(@NotNull short[] sArr, @NotNull Function1<? super Short, Double> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (short valueOf : sArr) {
            d += ((Number) function1.invoke(Short.valueOf(valueOf))).doubleValue();
        }
        return d;
    }

    public static final double sumByDouble(@NotNull int[] iArr, @NotNull Function1<? super Integer, Double> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int valueOf : iArr) {
            d += ((Number) function1.invoke(Integer.valueOf(valueOf))).doubleValue();
        }
        return d;
    }

    public static final double sumByDouble(@NotNull long[] jArr, @NotNull Function1<? super Long, Double> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (long valueOf : jArr) {
            d += ((Number) function1.invoke(Long.valueOf(valueOf))).doubleValue();
        }
        return d;
    }

    public static final double sumByDouble(@NotNull float[] fArr, @NotNull Function1<? super Float, Double> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (float valueOf : fArr) {
            d += ((Number) function1.invoke(Float.valueOf(valueOf))).doubleValue();
        }
        return d;
    }

    public static final double sumByDouble(@NotNull double[] dArr, @NotNull Function1<? super Double, Double> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (double valueOf : dArr) {
            d += ((Number) function1.invoke(Double.valueOf(valueOf))).doubleValue();
        }
        return d;
    }

    public static final double sumByDouble(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Double> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (boolean valueOf : zArr) {
            d += ((Number) function1.invoke(Boolean.valueOf(valueOf))).doubleValue();
        }
        return d;
    }

    public static final double sumByDouble(@NotNull char[] cArr, @NotNull Function1<? super Character, Double> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (char valueOf : cArr) {
            d += ((Number) function1.invoke(Character.valueOf(valueOf))).doubleValue();
        }
        return d;
    }

    @NotNull
    public static final <T> T[] requireNoNulls(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        int length = tArr.length;
        int i = 0;
        while (i < length) {
            if (tArr[i] != null) {
                i++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("null element found in ");
                sb.append(tArr);
                sb.append('.');
                throw new IllegalArgumentException(sb.toString());
            }
        }
        return tArr;
    }

    @NotNull
    public static final <T> Pair<List<T>, List<T>> partition(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : tArr) {
            if (((Boolean) function1.invoke(t)).booleanValue()) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final Pair<List<Byte>, List<Byte>> partition(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (byte b : bArr) {
            if (((Boolean) function1.invoke(Byte.valueOf(b))).booleanValue()) {
                arrayList.add(Byte.valueOf(b));
            } else {
                arrayList2.add(Byte.valueOf(b));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final Pair<List<Short>, List<Short>> partition(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (short s : sArr) {
            if (((Boolean) function1.invoke(Short.valueOf(s))).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            } else {
                arrayList2.add(Short.valueOf(s));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final Pair<List<Integer>, List<Integer>> partition(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i : iArr) {
            if (((Boolean) function1.invoke(Integer.valueOf(i))).booleanValue()) {
                arrayList.add(Integer.valueOf(i));
            } else {
                arrayList2.add(Integer.valueOf(i));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final Pair<List<Long>, List<Long>> partition(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (long j : jArr) {
            if (((Boolean) function1.invoke(Long.valueOf(j))).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            } else {
                arrayList2.add(Long.valueOf(j));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final Pair<List<Float>, List<Float>> partition(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (float f : fArr) {
            if (((Boolean) function1.invoke(Float.valueOf(f))).booleanValue()) {
                arrayList.add(Float.valueOf(f));
            } else {
                arrayList2.add(Float.valueOf(f));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final Pair<List<Double>, List<Double>> partition(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (double d : dArr) {
            if (((Boolean) function1.invoke(Double.valueOf(d))).booleanValue()) {
                arrayList.add(Double.valueOf(d));
            } else {
                arrayList2.add(Double.valueOf(d));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final Pair<List<Boolean>, List<Boolean>> partition(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (boolean z : zArr) {
            if (((Boolean) function1.invoke(Boolean.valueOf(z))).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            } else {
                arrayList2.add(Boolean.valueOf(z));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final Pair<List<Character>, List<Character>> partition(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (char c : cArr) {
            if (((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                arrayList.add(Character.valueOf(c));
            } else {
                arrayList2.add(Character.valueOf(c));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final <T, R, V> List<V> zip(@NotNull T[] tArr, @NotNull R[] rArr, @NotNull Function2<? super T, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(tArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(tArr[i], rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull byte[] bArr, @NotNull R[] rArr, @NotNull Function2<? super Byte, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(bArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Byte.valueOf(bArr[i]), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull short[] sArr, @NotNull R[] rArr, @NotNull Function2<? super Short, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(sArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Short.valueOf(sArr[i]), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull int[] iArr, @NotNull R[] rArr, @NotNull Function2<? super Integer, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(iArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Integer.valueOf(iArr[i]), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull long[] jArr, @NotNull R[] rArr, @NotNull Function2<? super Long, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(jArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Long.valueOf(jArr[i]), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull float[] fArr, @NotNull R[] rArr, @NotNull Function2<? super Float, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(fArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Float.valueOf(fArr[i]), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull double[] dArr, @NotNull R[] rArr, @NotNull Function2<? super Double, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(dArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Double.valueOf(dArr[i]), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull boolean[] zArr, @NotNull R[] rArr, @NotNull Function2<? super Boolean, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(zArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Boolean.valueOf(zArr[i]), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull char[] cArr, @NotNull R[] rArr, @NotNull Function2<? super Character, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(cArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Character.valueOf(cArr[i]), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, V> List<V> zip(@NotNull T[] tArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super T, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(function2.invoke(tArr[i], next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull byte[] bArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Byte, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(function2.invoke(Byte.valueOf(bArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull short[] sArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Short, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(function2.invoke(Short.valueOf(sArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull int[] iArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Integer, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(function2.invoke(Integer.valueOf(iArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull long[] jArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Long, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(function2.invoke(Long.valueOf(jArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull float[] fArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Float, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(function2.invoke(Float.valueOf(fArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull double[] dArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Double, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(function2.invoke(Double.valueOf(dArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull boolean[] zArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Boolean, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(function2.invoke(Boolean.valueOf(zArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull char[] cArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Character, ? super R, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(function2.invoke(Character.valueOf(cArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull byte[] bArr, @NotNull byte[] bArr2, @NotNull Function2<? super Byte, ? super Byte, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(bArr2, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(bArr.length, bArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Byte.valueOf(bArr[i]), Byte.valueOf(bArr2[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull short[] sArr, @NotNull short[] sArr2, @NotNull Function2<? super Short, ? super Short, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sArr2, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(sArr.length, sArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Short.valueOf(sArr[i]), Short.valueOf(sArr2[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull int[] iArr, @NotNull int[] iArr2, @NotNull Function2<? super Integer, ? super Integer, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iArr2, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(iArr.length, iArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Integer.valueOf(iArr[i]), Integer.valueOf(iArr2[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull long[] jArr, @NotNull long[] jArr2, @NotNull Function2<? super Long, ? super Long, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(jArr2, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(jArr.length, jArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Long.valueOf(jArr[i]), Long.valueOf(jArr2[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull float[] fArr, @NotNull float[] fArr2, @NotNull Function2<? super Float, ? super Float, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(fArr2, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(fArr.length, fArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Float.valueOf(fArr[i]), Float.valueOf(fArr2[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull double[] dArr, @NotNull double[] dArr2, @NotNull Function2<? super Double, ? super Double, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(dArr2, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(dArr.length, dArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Double.valueOf(dArr[i]), Double.valueOf(dArr2[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull boolean[] zArr, @NotNull boolean[] zArr2, @NotNull Function2<? super Boolean, ? super Boolean, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(zArr2, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(zArr.length, zArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Boolean.valueOf(zArr[i]), Boolean.valueOf(zArr2[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull char[] cArr, @NotNull char[] cArr2, @NotNull Function2<? super Character, ? super Character, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cArr2, FacebookRequestErrorClassification.KEY_OTHER);
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int min = Math.min(cArr.length, cArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(function2.invoke(Character.valueOf(cArr[i]), Character.valueOf(cArr2[i])));
        }
        return arrayList;
    }

    @NotNull
    public static /* synthetic */ Appendable joinTo$default(Object[] objArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        CharSequence charSequence5 = (i2 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence6 = "";
        CharSequence charSequence7 = (i2 & 4) != 0 ? charSequence6 : charSequence2;
        if ((i2 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return joinTo((T[]) objArr, (A) appendable, charSequence5, charSequence7, charSequence6, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final <T, A extends Appendable> A joinTo(@NotNull T[] tArr, @NotNull A a, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(a, "buffer");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (T t : tArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            StringsKt__StringBuilderKt.appendElement(a, t, function1);
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    @NotNull
    public static /* synthetic */ Appendable joinTo$default(byte[] bArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        CharSequence charSequence5 = (i2 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence6 = "";
        CharSequence charSequence7 = (i2 & 4) != 0 ? charSequence6 : charSequence2;
        if ((i2 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return joinTo(bArr, (A) appendable, charSequence5, charSequence7, charSequence6, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull byte[] bArr, @NotNull A a, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(a, "buffer");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (byte b : bArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                a.append((CharSequence) function1.invoke(Byte.valueOf(b)));
            } else {
                a.append(String.valueOf(b));
            }
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    @NotNull
    public static /* synthetic */ Appendable joinTo$default(short[] sArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        CharSequence charSequence5 = (i2 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence6 = "";
        CharSequence charSequence7 = (i2 & 4) != 0 ? charSequence6 : charSequence2;
        if ((i2 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return joinTo(sArr, (A) appendable, charSequence5, charSequence7, charSequence6, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull short[] sArr, @NotNull A a, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Short, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(a, "buffer");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (short s : sArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                a.append((CharSequence) function1.invoke(Short.valueOf(s)));
            } else {
                a.append(String.valueOf(s));
            }
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    @NotNull
    public static /* synthetic */ Appendable joinTo$default(int[] iArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        CharSequence charSequence5 = (i2 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence6 = "";
        CharSequence charSequence7 = (i2 & 4) != 0 ? charSequence6 : charSequence2;
        if ((i2 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return joinTo(iArr, (A) appendable, charSequence5, charSequence7, charSequence6, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull int[] iArr, @NotNull A a, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Integer, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(a, "buffer");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (int i3 : iArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                a.append((CharSequence) function1.invoke(Integer.valueOf(i3)));
            } else {
                a.append(String.valueOf(i3));
            }
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    @NotNull
    public static /* synthetic */ Appendable joinTo$default(long[] jArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        CharSequence charSequence5 = (i2 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence6 = "";
        CharSequence charSequence7 = (i2 & 4) != 0 ? charSequence6 : charSequence2;
        if ((i2 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return joinTo(jArr, (A) appendable, charSequence5, charSequence7, charSequence6, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull long[] jArr, @NotNull A a, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(a, "buffer");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (long j : jArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                a.append((CharSequence) function1.invoke(Long.valueOf(j)));
            } else {
                a.append(String.valueOf(j));
            }
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    @NotNull
    public static /* synthetic */ Appendable joinTo$default(float[] fArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        CharSequence charSequence5 = (i2 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence6 = "";
        CharSequence charSequence7 = (i2 & 4) != 0 ? charSequence6 : charSequence2;
        if ((i2 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return joinTo(fArr, (A) appendable, charSequence5, charSequence7, charSequence6, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull float[] fArr, @NotNull A a, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Float, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(a, "buffer");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (float f : fArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                a.append((CharSequence) function1.invoke(Float.valueOf(f)));
            } else {
                a.append(String.valueOf(f));
            }
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    @NotNull
    public static /* synthetic */ Appendable joinTo$default(double[] dArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        CharSequence charSequence5 = (i2 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence6 = "";
        CharSequence charSequence7 = (i2 & 4) != 0 ? charSequence6 : charSequence2;
        if ((i2 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return joinTo(dArr, (A) appendable, charSequence5, charSequence7, charSequence6, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull double[] dArr, @NotNull A a, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Double, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(a, "buffer");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (double d : dArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                a.append((CharSequence) function1.invoke(Double.valueOf(d)));
            } else {
                a.append(String.valueOf(d));
            }
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    @NotNull
    public static /* synthetic */ Appendable joinTo$default(boolean[] zArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        CharSequence charSequence5 = (i2 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence6 = "";
        CharSequence charSequence7 = (i2 & 4) != 0 ? charSequence6 : charSequence2;
        if ((i2 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return joinTo(zArr, (A) appendable, charSequence5, charSequence7, charSequence6, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull boolean[] zArr, @NotNull A a, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Boolean, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(a, "buffer");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (boolean z : zArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                a.append((CharSequence) function1.invoke(Boolean.valueOf(z)));
            } else {
                a.append(String.valueOf(z));
            }
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    @NotNull
    public static /* synthetic */ Appendable joinTo$default(char[] cArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        CharSequence charSequence5 = (i2 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence6 = "";
        CharSequence charSequence7 = (i2 & 4) != 0 ? charSequence6 : charSequence2;
        if ((i2 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return joinTo(cArr, (A) appendable, charSequence5, charSequence7, charSequence6, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull char[] cArr, @NotNull A a, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Character, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(a, "buffer");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (char c : cArr) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (function1 != null) {
                a.append((CharSequence) function1.invoke(Character.valueOf(c)));
            } else {
                a.append(c);
            }
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    @NotNull
    public static /* synthetic */ String joinToString$default(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString((T[]) objArr, charSequence, charSequence6, charSequence5, i3, charSequence7, function1);
    }

    @NotNull
    public static final <T> String joinToString(@NotNull T[] tArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(tArr, (A) new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    @NotNull
    public static /* synthetic */ String joinToString$default(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(bArr, charSequence, charSequence6, charSequence5, i3, charSequence7, function1);
    }

    @NotNull
    public static final String joinToString(@NotNull byte[] bArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(bArr, (A) new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    @NotNull
    public static /* synthetic */ String joinToString$default(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(sArr, charSequence, charSequence6, charSequence5, i3, charSequence7, function1);
    }

    @NotNull
    public static final String joinToString(@NotNull short[] sArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Short, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(sArr, (A) new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    @NotNull
    public static /* synthetic */ String joinToString$default(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(iArr, charSequence, charSequence6, charSequence5, i3, charSequence7, function1);
    }

    @NotNull
    public static final String joinToString(@NotNull int[] iArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Integer, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(iArr, (A) new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    @NotNull
    public static /* synthetic */ String joinToString$default(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(jArr, charSequence, charSequence6, charSequence5, i3, charSequence7, function1);
    }

    @NotNull
    public static final String joinToString(@NotNull long[] jArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(jArr, (A) new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    @NotNull
    public static /* synthetic */ String joinToString$default(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(fArr, charSequence, charSequence6, charSequence5, i3, charSequence7, function1);
    }

    @NotNull
    public static final String joinToString(@NotNull float[] fArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Float, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(fArr, (A) new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    @NotNull
    public static /* synthetic */ String joinToString$default(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(dArr, charSequence, charSequence6, charSequence5, i3, charSequence7, function1);
    }

    @NotNull
    public static final String joinToString(@NotNull double[] dArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Double, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(dArr, (A) new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    @NotNull
    public static /* synthetic */ String joinToString$default(boolean[] zArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(zArr, charSequence, charSequence6, charSequence5, i3, charSequence7, function1);
    }

    @NotNull
    public static final String joinToString(@NotNull boolean[] zArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Boolean, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(zArr, (A) new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    @NotNull
    public static /* synthetic */ String joinToString$default(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(cArr, charSequence, charSequence6, charSequence5, i3, charSequence7, function1);
    }

    @NotNull
    public static final String joinToString(@NotNull char[] cArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super Character, ? extends CharSequence> function1) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(charSequence, "separator");
        Intrinsics.checkParameterIsNotNull(charSequence2, "prefix");
        Intrinsics.checkParameterIsNotNull(charSequence3, "postfix");
        Intrinsics.checkParameterIsNotNull(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(cArr, (A) new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    @NotNull
    public static final <T> Iterable<T> asIterable(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1(tArr);
    }

    @NotNull
    public static final Iterable<Byte> asIterable(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$2(bArr);
    }

    @NotNull
    public static final Iterable<Short> asIterable(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$3(sArr);
    }

    @NotNull
    public static final Iterable<Integer> asIterable(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$4(iArr);
    }

    @NotNull
    public static final Iterable<Long> asIterable(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$5(jArr);
    }

    @NotNull
    public static final Iterable<Float> asIterable(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$6(fArr);
    }

    @NotNull
    public static final Iterable<Double> asIterable(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$7(dArr);
    }

    @NotNull
    public static final Iterable<Boolean> asIterable(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$8(zArr);
    }

    @NotNull
    public static final Iterable<Character> asIterable(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$9(cArr);
    }

    @NotNull
    public static <T> Sequence<T> asSequence(@NotNull T[] tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        if (tArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1(tArr);
    }

    @NotNull
    public static final Sequence<Byte> asSequence(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        if (bArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new ArraysKt___ArraysKt$asSequence$$inlined$Sequence$2(bArr);
    }

    @NotNull
    public static final Sequence<Short> asSequence(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        if (sArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new ArraysKt___ArraysKt$asSequence$$inlined$Sequence$3(sArr);
    }

    @NotNull
    public static final Sequence<Integer> asSequence(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        if (iArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new ArraysKt___ArraysKt$asSequence$$inlined$Sequence$4(iArr);
    }

    @NotNull
    public static final Sequence<Long> asSequence(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        if (jArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new ArraysKt___ArraysKt$asSequence$$inlined$Sequence$5(jArr);
    }

    @NotNull
    public static final Sequence<Float> asSequence(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        if (fArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new ArraysKt___ArraysKt$asSequence$$inlined$Sequence$6(fArr);
    }

    @NotNull
    public static final Sequence<Double> asSequence(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        if (dArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new ArraysKt___ArraysKt$asSequence$$inlined$Sequence$7(dArr);
    }

    @NotNull
    public static final Sequence<Boolean> asSequence(@NotNull boolean[] zArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        if (zArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new ArraysKt___ArraysKt$asSequence$$inlined$Sequence$8(zArr);
    }

    @NotNull
    public static final Sequence<Character> asSequence(@NotNull char[] cArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        if (cArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new ArraysKt___ArraysKt$asSequence$$inlined$Sequence$9(cArr);
    }

    public static final double averageOfByte(@NotNull Byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        double d = 0.0d;
        int i = 0;
        for (Byte byteValue : bArr) {
            double byteValue2 = (double) byteValue.byteValue();
            Double.isNaN(byteValue2);
            d += byteValue2;
            i++;
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d2 = (double) i;
        Double.isNaN(d2);
        return d / d2;
    }

    public static final double averageOfShort(@NotNull Short[] shArr) {
        Intrinsics.checkParameterIsNotNull(shArr, "receiver$0");
        double d = 0.0d;
        int i = 0;
        for (Short shortValue : shArr) {
            double shortValue2 = (double) shortValue.shortValue();
            Double.isNaN(shortValue2);
            d += shortValue2;
            i++;
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d2 = (double) i;
        Double.isNaN(d2);
        return d / d2;
    }

    public static final double averageOfInt(@NotNull Integer[] numArr) {
        Intrinsics.checkParameterIsNotNull(numArr, "receiver$0");
        double d = 0.0d;
        int i = 0;
        for (Integer intValue : numArr) {
            double intValue2 = (double) intValue.intValue();
            Double.isNaN(intValue2);
            d += intValue2;
            i++;
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d2 = (double) i;
        Double.isNaN(d2);
        return d / d2;
    }

    public static final double averageOfLong(@NotNull Long[] lArr) {
        Intrinsics.checkParameterIsNotNull(lArr, "receiver$0");
        double d = 0.0d;
        int i = 0;
        for (Long longValue : lArr) {
            double longValue2 = (double) longValue.longValue();
            Double.isNaN(longValue2);
            d += longValue2;
            i++;
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d2 = (double) i;
        Double.isNaN(d2);
        return d / d2;
    }

    public static final double averageOfFloat(@NotNull Float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        double d = 0.0d;
        int i = 0;
        for (Float floatValue : fArr) {
            double floatValue2 = (double) floatValue.floatValue();
            Double.isNaN(floatValue2);
            d += floatValue2;
            i++;
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d2 = (double) i;
        Double.isNaN(d2);
        return d / d2;
    }

    public static final double averageOfDouble(@NotNull Double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        double d = 0.0d;
        int i = 0;
        for (Double doubleValue : dArr) {
            d += doubleValue.doubleValue();
            i++;
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d2 = (double) i;
        Double.isNaN(d2);
        return d / d2;
    }

    public static final double average(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        double d = 0.0d;
        int i = 0;
        for (byte b : bArr) {
            double d2 = (double) b;
            Double.isNaN(d2);
            d += d2;
            i++;
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d3 = (double) i;
        Double.isNaN(d3);
        return d / d3;
    }

    public static final double average(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        double d = 0.0d;
        int i = 0;
        for (short s : sArr) {
            double d2 = (double) s;
            Double.isNaN(d2);
            d += d2;
            i++;
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d3 = (double) i;
        Double.isNaN(d3);
        return d / d3;
    }

    public static final double average(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        double d = 0.0d;
        int i = 0;
        for (int i2 : iArr) {
            double d2 = (double) i2;
            Double.isNaN(d2);
            d += d2;
            i++;
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d3 = (double) i;
        Double.isNaN(d3);
        return d / d3;
    }

    public static final double average(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        double d = 0.0d;
        int i = 0;
        for (long j : jArr) {
            double d2 = (double) j;
            Double.isNaN(d2);
            d += d2;
            i++;
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d3 = (double) i;
        Double.isNaN(d3);
        return d / d3;
    }

    public static final double average(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        double d = 0.0d;
        int i = 0;
        for (float f : fArr) {
            double d2 = (double) f;
            Double.isNaN(d2);
            d += d2;
            i++;
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d3 = (double) i;
        Double.isNaN(d3);
        return d / d3;
    }

    public static final double average(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        double d = 0.0d;
        int i = 0;
        for (double d2 : dArr) {
            d += d2;
            i++;
        }
        if (i == 0) {
            return DoubleCompanionObject.INSTANCE.getNaN();
        }
        double d3 = (double) i;
        Double.isNaN(d3);
        return d / d3;
    }

    public static final int sumOfByte(@NotNull Byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        int i = 0;
        for (Byte byteValue : bArr) {
            i += byteValue.byteValue();
        }
        return i;
    }

    public static final int sumOfShort(@NotNull Short[] shArr) {
        Intrinsics.checkParameterIsNotNull(shArr, "receiver$0");
        int i = 0;
        for (Short shortValue : shArr) {
            i += shortValue.shortValue();
        }
        return i;
    }

    public static final int sumOfInt(@NotNull Integer[] numArr) {
        Intrinsics.checkParameterIsNotNull(numArr, "receiver$0");
        int i = 0;
        for (Integer intValue : numArr) {
            i += intValue.intValue();
        }
        return i;
    }

    public static final long sumOfLong(@NotNull Long[] lArr) {
        Intrinsics.checkParameterIsNotNull(lArr, "receiver$0");
        long j = 0;
        for (Long longValue : lArr) {
            j += longValue.longValue();
        }
        return j;
    }

    public static final float sumOfFloat(@NotNull Float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        float f = 0.0f;
        for (Float floatValue : fArr) {
            f += floatValue.floatValue();
        }
        return f;
    }

    public static final double sumOfDouble(@NotNull Double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (Double doubleValue : dArr) {
            d += doubleValue.doubleValue();
        }
        return d;
    }

    public static final int sum(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        int i = 0;
        for (byte b : bArr) {
            i += b;
        }
        return i;
    }

    public static final int sum(@NotNull short[] sArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        int i = 0;
        for (short s : sArr) {
            i += s;
        }
        return i;
    }

    public static final int sum(@NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    public static final long sum(@NotNull long[] jArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        return j;
    }

    public static final float sum(@NotNull float[] fArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        float f = 0.0f;
        for (float f2 : fArr) {
            f += f2;
        }
        return f;
    }

    public static final double sum(@NotNull double[] dArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (double d2 : dArr) {
            d += d2;
        }
        return d;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterIndexedTo(@NotNull T[] tArr, @NotNull C c, @NotNull Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            T t = tArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), t)).booleanValue()) {
                c.add(t);
            }
            i++;
            i2 = i3;
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C filterIndexedTo(@NotNull byte[] bArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Byte, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Byte.valueOf(b))).booleanValue()) {
                c.add(Byte.valueOf(b));
            }
            i++;
            i2 = i3;
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C filterIndexedTo(@NotNull short[] sArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Short, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        int length = sArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            short s = sArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Short.valueOf(s))).booleanValue()) {
                c.add(Short.valueOf(s));
            }
            i++;
            i2 = i3;
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C filterIndexedTo(@NotNull int[] iArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Integer, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue()) {
                c.add(Integer.valueOf(i3));
            }
            i++;
            i2 = i4;
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C filterIndexedTo(@NotNull long[] jArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Long, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        int length = jArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            long j = jArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Long.valueOf(j))).booleanValue()) {
                c.add(Long.valueOf(j));
            }
            i++;
            i2 = i3;
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C filterIndexedTo(@NotNull float[] fArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Float, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        int length = fArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            float f = fArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Float.valueOf(f))).booleanValue()) {
                c.add(Float.valueOf(f));
            }
            i++;
            i2 = i3;
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C filterIndexedTo(@NotNull double[] dArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Double, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        int length = dArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            double d = dArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Double.valueOf(d))).booleanValue()) {
                c.add(Double.valueOf(d));
            }
            i++;
            i2 = i3;
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C filterIndexedTo(@NotNull boolean[] zArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Boolean, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        int length = zArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            boolean z = zArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue()) {
                c.add(Boolean.valueOf(z));
            }
            i++;
            i2 = i3;
        }
        return c;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C filterIndexedTo(@NotNull char[] cArr, @NotNull C c, @NotNull Function2<? super Integer, ? super Character, Boolean> function2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "predicate");
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char c2 = cArr[i];
            int i3 = i2 + 1;
            if (((Boolean) function2.invoke(Integer.valueOf(i2), Character.valueOf(c2))).booleanValue()) {
                c.add(Character.valueOf(c2));
            }
            i++;
            i2 = i3;
        }
        return c;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(@NotNull T[] tArr, @NotNull C c, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function2, "transform");
        int length = tArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            Object invoke = function2.invoke(Integer.valueOf(i2), tArr[i]);
            if (invoke != null) {
                c.add(invoke);
            }
            i++;
            i2 = i3;
        }
        return c;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull T[] tArr, @NotNull C c, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(function1, "transform");
        for (T invoke : tArr) {
            Object invoke2 = function1.invoke(invoke);
            if (invoke2 != null) {
                c.add(invoke2);
            }
        }
        return c;
    }

    @NotNull
    public static final <T, R> List<Pair<T, R>> zip(@NotNull T[] tArr, @NotNull R[] rArr) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(tArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.to(tArr[i], rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Byte, R>> zip(@NotNull byte[] bArr, @NotNull R[] rArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(bArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            byte b = bArr[i];
            arrayList.add(TuplesKt.to(Byte.valueOf(b), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Short, R>> zip(@NotNull short[] sArr, @NotNull R[] rArr) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(sArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            short s = sArr[i];
            arrayList.add(TuplesKt.to(Short.valueOf(s), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Integer, R>> zip(@NotNull int[] iArr, @NotNull R[] rArr) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(iArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            int i2 = iArr[i];
            arrayList.add(TuplesKt.to(Integer.valueOf(i2), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Long, R>> zip(@NotNull long[] jArr, @NotNull R[] rArr) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(jArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            long j = jArr[i];
            arrayList.add(TuplesKt.to(Long.valueOf(j), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Float, R>> zip(@NotNull float[] fArr, @NotNull R[] rArr) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(fArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            float f = fArr[i];
            arrayList.add(TuplesKt.to(Float.valueOf(f), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Double, R>> zip(@NotNull double[] dArr, @NotNull R[] rArr) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(dArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            double d = dArr[i];
            arrayList.add(TuplesKt.to(Double.valueOf(d), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Boolean, R>> zip(@NotNull boolean[] zArr, @NotNull R[] rArr) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(zArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            boolean z = zArr[i];
            arrayList.add(TuplesKt.to(Boolean.valueOf(z), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Character, R>> zip(@NotNull char[] cArr, @NotNull R[] rArr) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(rArr, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(cArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            char c = cArr[i];
            arrayList.add(TuplesKt.to(Character.valueOf(c), rArr[i]));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<Pair<T, R>> zip(@NotNull T[] tArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(TuplesKt.to(tArr[i], next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Byte, R>> zip(@NotNull byte[] bArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(TuplesKt.to(Byte.valueOf(bArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Short, R>> zip(@NotNull short[] sArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(TuplesKt.to(Short.valueOf(sArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Integer, R>> zip(@NotNull int[] iArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(TuplesKt.to(Integer.valueOf(iArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Long, R>> zip(@NotNull long[] jArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(TuplesKt.to(Long.valueOf(jArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Float, R>> zip(@NotNull float[] fArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(TuplesKt.to(Float.valueOf(fArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Double, R>> zip(@NotNull double[] dArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(TuplesKt.to(Double.valueOf(dArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Boolean, R>> zip(@NotNull boolean[] zArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(TuplesKt.to(Boolean.valueOf(zArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Character, R>> zip(@NotNull char[] cArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iterable, FacebookRequestErrorClassification.KEY_OTHER);
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object next : iterable) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            arrayList.add(TuplesKt.to(Character.valueOf(cArr[i]), next));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Byte, Byte>> zip(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkParameterIsNotNull(bArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(bArr2, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(bArr.length, bArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.to(Byte.valueOf(bArr[i]), Byte.valueOf(bArr2[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Short, Short>> zip(@NotNull short[] sArr, @NotNull short[] sArr2) {
        Intrinsics.checkParameterIsNotNull(sArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sArr2, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(sArr.length, sArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.to(Short.valueOf(sArr[i]), Short.valueOf(sArr2[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Integer, Integer>> zip(@NotNull int[] iArr, @NotNull int[] iArr2) {
        Intrinsics.checkParameterIsNotNull(iArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(iArr2, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(iArr.length, iArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.to(Integer.valueOf(iArr[i]), Integer.valueOf(iArr2[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Long, Long>> zip(@NotNull long[] jArr, @NotNull long[] jArr2) {
        Intrinsics.checkParameterIsNotNull(jArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(jArr2, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(jArr.length, jArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.to(Long.valueOf(jArr[i]), Long.valueOf(jArr2[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Float, Float>> zip(@NotNull float[] fArr, @NotNull float[] fArr2) {
        Intrinsics.checkParameterIsNotNull(fArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(fArr2, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(fArr.length, fArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.to(Float.valueOf(fArr[i]), Float.valueOf(fArr2[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Double, Double>> zip(@NotNull double[] dArr, @NotNull double[] dArr2) {
        Intrinsics.checkParameterIsNotNull(dArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(dArr2, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(dArr.length, dArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.to(Double.valueOf(dArr[i]), Double.valueOf(dArr2[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Boolean, Boolean>> zip(@NotNull boolean[] zArr, @NotNull boolean[] zArr2) {
        Intrinsics.checkParameterIsNotNull(zArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(zArr2, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(zArr.length, zArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.to(Boolean.valueOf(zArr[i]), Boolean.valueOf(zArr2[i])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Character, Character>> zip(@NotNull char[] cArr, @NotNull char[] cArr2) {
        Intrinsics.checkParameterIsNotNull(cArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cArr2, FacebookRequestErrorClassification.KEY_OTHER);
        int min = Math.min(cArr.length, cArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i = 0; i < min; i++) {
            arrayList.add(TuplesKt.to(Character.valueOf(cArr[i]), Character.valueOf(cArr2[i])));
        }
        return arrayList;
    }
}
