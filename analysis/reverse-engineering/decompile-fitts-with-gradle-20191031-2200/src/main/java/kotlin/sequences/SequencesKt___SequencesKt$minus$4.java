package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public final class SequencesKt___SequencesKt$minus$4 implements Sequence<T> {
    final /* synthetic */ Sequence $elements;
    final /* synthetic */ Sequence $this_minus;

    SequencesKt___SequencesKt$minus$4(Sequence<? extends T> sequence, Sequence sequence2) {
        this.$this_minus = sequence;
        this.$elements = sequence2;
    }

    @NotNull
    public Iterator<T> iterator() {
        HashSet hashSet = SequencesKt___SequencesKt.toHashSet(this.$elements);
        if (hashSet.isEmpty()) {
            return this.$this_minus.iterator();
        }
        return SequencesKt___SequencesKt.filterNot(this.$this_minus, new SequencesKt___SequencesKt$minus$4$iterator$1(hashSet)).iterator();
    }
}
