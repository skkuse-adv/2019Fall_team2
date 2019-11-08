package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.jetbrains.annotations.NotNull;

public final class SequencesKt___SequencesKt$minus$1 implements Sequence<T> {
    final /* synthetic */ Object $element;
    final /* synthetic */ Sequence $this_minus;

    SequencesKt___SequencesKt$minus$1(Sequence<? extends T> sequence, Object obj) {
        this.$this_minus = sequence;
        this.$element = obj;
    }

    @NotNull
    public Iterator<T> iterator() {
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = false;
        return SequencesKt___SequencesKt.filter(this.$this_minus, new SequencesKt___SequencesKt$minus$1$iterator$1(this, ref$BooleanRef)).iterator();
    }
}
