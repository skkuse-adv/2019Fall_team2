package kotlin.sequences;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public final class SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 implements Sequence<T> {
    final /* synthetic */ Iterator $this_asSequence$inlined;

    public SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(Iterator it) {
        this.$this_asSequence$inlined = it;
    }

    @NotNull
    public Iterator<T> iterator() {
        return this.$this_asSequence$inlined;
    }
}
