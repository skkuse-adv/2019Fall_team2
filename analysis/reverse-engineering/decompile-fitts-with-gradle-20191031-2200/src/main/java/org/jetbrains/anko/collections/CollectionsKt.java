package org.jetbrains.anko.collections;

import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class CollectionsKt {
    public static final <T> void forEachByIndex(@NotNull List<? extends T> list, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        int size = list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                function1.invoke(list.get(i));
                if (i != size) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final <T> void forEachWithIndex(@NotNull List<? extends T> list, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        int size = list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                function2.invoke(Integer.valueOf(i), list.get(i));
                if (i != size) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final <T> void forEachReversedByIndex(@NotNull List<? extends T> list, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "f");
        for (int size = list.size() - 1; size >= 0; size--) {
            function1.invoke(list.get(size));
        }
    }

    public static final <T> void forEachReversedWithIndex(@NotNull List<? extends T> list, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "f");
        for (int size = list.size() - 1; size >= 0; size--) {
            function2.invoke(Integer.valueOf(size), list.get(size));
        }
    }

    @NotNull
    public static final <F, S> Pair<F, S> toKotlinPair(@NotNull android.util.Pair<F, S> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "receiver$0");
        return TuplesKt.to(pair.first, pair.second);
    }

    @NotNull
    public static final <F, S> android.util.Pair<F, S> toAndroidPair(@NotNull Pair<? extends F, ? extends S> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "receiver$0");
        return new android.util.Pair<>(pair.getFirst(), pair.getSecond());
    }
}
