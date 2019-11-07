package kotlin.collections;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public interface Grouping<T, K> {
    K keyOf(T t);

    @NotNull
    Iterator<T> sourceIterator();
}
