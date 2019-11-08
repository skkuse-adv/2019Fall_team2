package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public final class SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 implements Iterable<T>, KMappedMarker {
    final /* synthetic */ Sequence $this_asIterable$inlined;

    public SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(Sequence sequence) {
        this.$this_asIterable$inlined = sequence;
    }

    @NotNull
    public Iterator<T> iterator() {
        return this.$this_asIterable$inlined.iterator();
    }
}
