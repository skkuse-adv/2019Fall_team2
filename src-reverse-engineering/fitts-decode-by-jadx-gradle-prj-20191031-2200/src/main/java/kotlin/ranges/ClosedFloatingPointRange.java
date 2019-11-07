package kotlin.ranges;

import java.lang.Comparable;
import org.jetbrains.annotations.NotNull;

public interface ClosedFloatingPointRange<T extends Comparable<? super T>> extends ClosedRange<T> {
    boolean contains(@NotNull T t);

    boolean isEmpty();

    boolean lessThanOrEquals(@NotNull T t, @NotNull T t2);
}
