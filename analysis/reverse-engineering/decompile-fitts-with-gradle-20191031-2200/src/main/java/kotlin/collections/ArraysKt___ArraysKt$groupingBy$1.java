package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import org.jetbrains.annotations.NotNull;

public final class ArraysKt___ArraysKt$groupingBy$1 implements Grouping<T, K> {
    final /* synthetic */ Function1 $keySelector;
    final /* synthetic */ Object[] $this_groupingBy;

    public ArraysKt___ArraysKt$groupingBy$1(T[] tArr, Function1 function1) {
        this.$this_groupingBy = tArr;
        this.$keySelector = function1;
    }

    @NotNull
    public Iterator<T> sourceIterator() {
        return ArrayIteratorKt.iterator(this.$this_groupingBy);
    }

    public K keyOf(T t) {
        return this.$keySelector.invoke(t);
    }
}
