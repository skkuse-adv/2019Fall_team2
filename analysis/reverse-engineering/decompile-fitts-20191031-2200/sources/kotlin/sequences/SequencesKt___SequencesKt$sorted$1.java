package kotlin.sequences;

import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class SequencesKt___SequencesKt$sorted$1 implements Sequence<T> {
    final /* synthetic */ Sequence $this_sorted;

    SequencesKt___SequencesKt$sorted$1(Sequence<? extends T> sequence) {
        this.$this_sorted = sequence;
    }

    @NotNull
    public Iterator<T> iterator() {
        List mutableList = SequencesKt___SequencesKt.toMutableList(this.$this_sorted);
        CollectionsKt__MutableCollectionsJVMKt.sort(mutableList);
        return mutableList.iterator();
    }
}
