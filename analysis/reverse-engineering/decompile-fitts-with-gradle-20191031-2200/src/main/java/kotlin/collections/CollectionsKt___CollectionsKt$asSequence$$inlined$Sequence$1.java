package kotlin.collections;

import java.util.Iterator;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 implements Sequence<T> {
    final /* synthetic */ Iterable $this_asSequence$inlined;

    public CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1(Iterable iterable) {
        this.$this_asSequence$inlined = iterable;
    }

    @NotNull
    public Iterator<T> iterator() {
        return this.$this_asSequence$inlined.iterator();
    }
}
