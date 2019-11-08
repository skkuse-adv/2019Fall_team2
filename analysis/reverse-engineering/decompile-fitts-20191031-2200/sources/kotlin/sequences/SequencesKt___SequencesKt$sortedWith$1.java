package kotlin.sequences;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class SequencesKt___SequencesKt$sortedWith$1 implements Sequence<T> {
    final /* synthetic */ Comparator $comparator;
    final /* synthetic */ Sequence $this_sortedWith;

    SequencesKt___SequencesKt$sortedWith$1(Sequence<? extends T> sequence, Comparator comparator) {
        this.$this_sortedWith = sequence;
        this.$comparator = comparator;
    }

    @NotNull
    public Iterator<T> iterator() {
        List mutableList = SequencesKt___SequencesKt.toMutableList(this.$this_sortedWith);
        CollectionsKt__MutableCollectionsJVMKt.sortWith(mutableList, this.$comparator);
        return mutableList.iterator();
    }
}
