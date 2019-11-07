package org.jetbrains.anko.collections;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class ArraysKt {
    public static final <T> void forEachByIndex(@NotNull T[] tArr, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        int length = tArr.length - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                function1.invoke(tArr[i]);
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final <T> void forEachWithIndex(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        int length = tArr.length - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                function2.invoke(Integer.valueOf(i), tArr[i]);
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final <T> void forEachReversedByIndex(@NotNull T[] tArr, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        for (int length = tArr.length - 1; length >= 0; length--) {
            function1.invoke(tArr[length]);
        }
    }

    public static final <T> void forEachReversedWithIndex(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(tArr, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        for (int length = tArr.length - 1; length >= 0; length--) {
            function2.invoke(Integer.valueOf(length), tArr[length]);
        }
    }

    @NotNull
    public static final <T> Sequence<T> asSequence(@NotNull SparseArray<T> sparseArray) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "receiver$0");
        return new SparseArraySequence(sparseArray);
    }

    @NotNull
    public static final <T> Sequence<Boolean> asSequence(@NotNull SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "receiver$0");
        return new SparseBooleanArraySequence(sparseBooleanArray);
    }

    @NotNull
    public static final <T> Sequence<Integer> asSequence(@NotNull SparseIntArray sparseIntArray) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "receiver$0");
        return new SparseIntArraySequence(sparseIntArray);
    }
}
