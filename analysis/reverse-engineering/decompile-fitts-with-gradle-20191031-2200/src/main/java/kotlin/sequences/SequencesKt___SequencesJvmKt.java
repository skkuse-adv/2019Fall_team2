package kotlin.sequences;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class SequencesKt___SequencesJvmKt extends SequencesKt__SequencesKt {
    @NotNull
    public static final <R> Sequence<R> filterIsInstance(@NotNull Sequence<?> sequence, @NotNull Class<R> cls) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(cls, "klass");
        Sequence<R> filter = SequencesKt___SequencesKt.filter(sequence, new SequencesKt___SequencesJvmKt$filterIsInstance$1(cls));
        if (filter != null) {
            return filter;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    }

    @NotNull
    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(@NotNull Sequence<?> sequence, @NotNull C c, @NotNull Class<R> cls) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(c, "destination");
        Intrinsics.checkParameterIsNotNull(cls, "klass");
        for (Object next : sequence) {
            if (cls.isInstance(next)) {
                c.add(next);
            }
        }
        return c;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        return (SortedSet) SequencesKt___SequencesKt.toCollection(sequence, new TreeSet());
    }

    @NotNull
    public static final <T> SortedSet<T> toSortedSet(@NotNull Sequence<? extends T> sequence, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(sequence, "receiver$0");
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return (SortedSet) SequencesKt___SequencesKt.toCollection(sequence, new TreeSet(comparator));
    }
}
