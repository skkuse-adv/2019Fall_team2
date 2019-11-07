package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class ReversedComparator<T> implements Comparator<T> {
    @NotNull
    private final Comparator<T> comparator;

    public ReversedComparator(@NotNull Comparator<T> comparator2) {
        Intrinsics.checkParameterIsNotNull(comparator2, "comparator");
        this.comparator = comparator2;
    }

    @NotNull
    public final Comparator<T> getComparator() {
        return this.comparator;
    }

    public int compare(T t, T t2) {
        return this.comparator.compare(t2, t);
    }

    @NotNull
    public final Comparator<T> reversed() {
        return this.comparator;
    }
}
