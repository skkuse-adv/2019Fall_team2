package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class CollectionsKt___CollectionsJvmKt extends CollectionsKt__ReversedViewsKt {
    @NotNull
    public static final <R> List<R> filterIsInstance(@NotNull Iterable<?> iterable, @NotNull Class<R> cls) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cls, "klass");
        return (List) filterIsInstanceTo(iterable, new ArrayList(), cls);
    }

    @NotNull
    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(@NotNull Iterable<?> iterable, @NotNull C c, @NotNull Class<R> cls) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(cls, "klass");
        for (Object next : iterable) {
            if (cls.isInstance(next)) {
                c.add(next);
            }
        }
        return c;
    }

    public static <T> void reverse(@NotNull List<T> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        Collections.reverse(list);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        return (SortedSet) CollectionsKt___CollectionsKt.toCollection(iterable, new TreeSet());
    }

    @NotNull
    public static final <T> SortedSet<T> toSortedSet(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(iterable, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return (SortedSet) CollectionsKt___CollectionsKt.toCollection(iterable, new TreeSet(comparator));
    }
}
