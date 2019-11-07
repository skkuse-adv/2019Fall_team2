package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

public final class CollectionsKt___CollectionsKt$groupingBy$1 implements Grouping<T, K> {
    final /* synthetic */ Function1 $keySelector;
    final /* synthetic */ Iterable $this_groupingBy;

    public CollectionsKt___CollectionsKt$groupingBy$1(Iterable<? extends T> iterable, Function1 function1) {
        this.$this_groupingBy = iterable;
        this.$keySelector = function1;
    }

    @NotNull
    public Iterator<T> sourceIterator() {
        return this.$this_groupingBy.iterator();
    }

    public K keyOf(T t) {
        return this.$keySelector.invoke(t);
    }
}
