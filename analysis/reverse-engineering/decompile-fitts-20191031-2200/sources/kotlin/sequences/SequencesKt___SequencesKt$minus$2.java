package kotlin.sequences;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public final class SequencesKt___SequencesKt$minus$2 implements Sequence<T> {
    final /* synthetic */ Object[] $elements;
    final /* synthetic */ Sequence $this_minus;

    SequencesKt___SequencesKt$minus$2(Sequence<? extends T> sequence, Object[] objArr) {
        this.$this_minus = sequence;
        this.$elements = objArr;
    }

    @NotNull
    public Iterator<T> iterator() {
        return SequencesKt___SequencesKt.filterNot(this.$this_minus, new SequencesKt___SequencesKt$minus$2$iterator$1(ArraysKt___ArraysKt.toHashSet((T[]) this.$elements))).iterator();
    }
}
