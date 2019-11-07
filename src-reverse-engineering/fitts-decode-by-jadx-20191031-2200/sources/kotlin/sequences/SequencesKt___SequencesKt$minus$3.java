package kotlin.sequences;

import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public final class SequencesKt___SequencesKt$minus$3 implements Sequence<T> {
    final /* synthetic */ Iterable $elements;
    final /* synthetic */ Sequence $this_minus;

    SequencesKt___SequencesKt$minus$3(Sequence<? extends T> sequence, Iterable iterable) {
        this.$this_minus = sequence;
        this.$elements = iterable;
    }

    @NotNull
    public Iterator<T> iterator() {
        Collection convertToSetForSetOperation = CollectionsKt__IterablesKt.convertToSetForSetOperation(this.$elements);
        if (convertToSetForSetOperation.isEmpty()) {
            return this.$this_minus.iterator();
        }
        return SequencesKt___SequencesKt.filterNot(this.$this_minus, new SequencesKt___SequencesKt$minus$3$iterator$1(convertToSetForSetOperation)).iterator();
    }
}
