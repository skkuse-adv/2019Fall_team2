package org.jetbrains.anko.collections;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.facebook.internal.NativeProtocol;
import java.util.ConcurrentModificationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SparseArraysKt {
    public static final <E> void forEach(@NotNull SparseArray<E> sparseArray, @NotNull Function2<? super Integer, ? super E, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int size = sparseArray.size();
        int i = size - 1;
        if (i >= 0) {
            int i2 = 0;
            while (size == sparseArray.size()) {
                function2.invoke(Integer.valueOf(sparseArray.keyAt(i2)), sparseArray.valueAt(i2));
                if (i2 != i) {
                    i2++;
                } else {
                    return;
                }
            }
            throw new ConcurrentModificationException();
        }
    }

    public static final void forEach(@NotNull SparseBooleanArray sparseBooleanArray, @NotNull Function2<? super Integer, ? super Boolean, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int size = sparseBooleanArray.size();
        int i = size - 1;
        if (i >= 0) {
            int i2 = 0;
            while (size == sparseBooleanArray.size()) {
                function2.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i2)), Boolean.valueOf(sparseBooleanArray.valueAt(i2)));
                if (i2 != i) {
                    i2++;
                } else {
                    return;
                }
            }
            throw new ConcurrentModificationException();
        }
    }

    public static final void forEach(@NotNull SparseIntArray sparseIntArray, @NotNull Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int size = sparseIntArray.size();
        int i = size - 1;
        if (i >= 0) {
            int i2 = 0;
            while (size == sparseIntArray.size()) {
                function2.invoke(Integer.valueOf(sparseIntArray.keyAt(i2)), Integer.valueOf(sparseIntArray.valueAt(i2)));
                if (i2 != i) {
                    i2++;
                } else {
                    return;
                }
            }
            throw new ConcurrentModificationException();
        }
    }
}
