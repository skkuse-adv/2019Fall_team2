package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class ReverseOrderComparator implements Comparator<Comparable<? super Object>> {
    public static final ReverseOrderComparator INSTANCE = new ReverseOrderComparator();

    private ReverseOrderComparator() {
    }

    public int compare(@NotNull Comparable<Object> comparable, @NotNull Comparable<Object> comparable2) {
        Intrinsics.checkParameterIsNotNull(comparable, "a");
        Intrinsics.checkParameterIsNotNull(comparable2, "b");
        return comparable2.compareTo(comparable);
    }

    @NotNull
    public final Comparator<Comparable<Object>> reversed() {
        return NaturalOrderComparator.INSTANCE;
    }
}
