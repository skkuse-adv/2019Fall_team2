package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class CollectionsKt__MutableCollectionsJVMKt extends CollectionsKt__IteratorsKt {
    public static <T extends Comparable<? super T>> void sort(@NotNull List<T> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static <T> void sortWith(@NotNull List<T> list, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    @NotNull
    public static final <T> List<T> shuffled(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        List<T> mutableList = CollectionsKt___CollectionsKt.toMutableList(iterable);
        Collections.shuffle(mutableList);
        return mutableList;
    }

    @NotNull
    public static final <T> List<T> shuffled(@NotNull Iterable<? extends T> iterable, @NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(random, "random");
        List<T> mutableList = CollectionsKt___CollectionsKt.toMutableList(iterable);
        Collections.shuffle(mutableList, random);
        return mutableList;
    }
}
