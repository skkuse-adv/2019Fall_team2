package kotlin.ranges;

import java.lang.Comparable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public interface ClosedRange<T extends Comparable<? super T>> {

    public static final class DefaultImpls {
        public static <T extends Comparable<? super T>> boolean contains(ClosedRange<T> closedRange, @NotNull T t) {
            Intrinsics.checkParameterIsNotNull(t, "value");
            return t.compareTo(closedRange.getStart()) >= 0 && t.compareTo(closedRange.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean isEmpty(ClosedRange<T> closedRange) {
            return closedRange.getStart().compareTo(closedRange.getEndInclusive()) > 0;
        }
    }

    boolean contains(@NotNull T t);

    @NotNull
    T getEndInclusive();

    @NotNull
    T getStart();

    boolean isEmpty();
}
