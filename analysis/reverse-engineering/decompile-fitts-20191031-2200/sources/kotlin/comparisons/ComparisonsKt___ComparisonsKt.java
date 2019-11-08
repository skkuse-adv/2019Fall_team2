package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class ComparisonsKt___ComparisonsKt extends ComparisonsKt___ComparisonsJvmKt {
    public static final <T> T maxOf(T t, T t2, T t3, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return maxOf(t, maxOf(t2, t3, comparator), comparator);
    }

    public static final <T> T maxOf(T t, T t2, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return comparator.compare(t, t2) >= 0 ? t : t2;
    }

    public static final <T> T minOf(T t, T t2, T t3, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return minOf(t, minOf(t2, t3, comparator), comparator);
    }

    public static final <T> T minOf(T t, T t2, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkParameterIsNotNull(comparator, "comparator");
        return comparator.compare(t, t2) <= 0 ? t : t2;
    }
}
