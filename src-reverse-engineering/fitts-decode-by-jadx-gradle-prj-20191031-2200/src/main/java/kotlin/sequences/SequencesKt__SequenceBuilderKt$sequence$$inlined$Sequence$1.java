package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

public final class SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1 implements Sequence<T> {
    final /* synthetic */ Function2 $block$inlined;

    public SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(Function2 function2) {
        this.$block$inlined = function2;
    }

    @NotNull
    public Iterator<T> iterator() {
        return SequencesKt__SequenceBuilderKt.iterator(this.$block$inlined);
    }
}
