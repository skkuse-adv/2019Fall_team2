package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.Grouping;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

public final class SequencesKt___SequencesKt$groupingBy$1 implements Grouping<T, K> {
    final /* synthetic */ Function1 $keySelector;
    final /* synthetic */ Sequence $this_groupingBy;

    public SequencesKt___SequencesKt$groupingBy$1(Sequence<? extends T> sequence, Function1 function1) {
        this.$this_groupingBy = sequence;
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
