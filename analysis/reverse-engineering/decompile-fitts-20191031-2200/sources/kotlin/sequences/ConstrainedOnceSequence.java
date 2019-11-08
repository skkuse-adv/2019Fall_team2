package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ConstrainedOnceSequence<T> implements Sequence<T> {
    private final AtomicReference<Sequence<T>> sequenceRef;

    public ConstrainedOnceSequence(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkParameterIsNotNull(sequence, "sequence");
        this.sequenceRef = new AtomicReference<>(sequence);
    }

    @NotNull
    public Iterator<T> iterator() {
        Sequence sequence = (Sequence) this.sequenceRef.getAndSet(null);
        if (sequence != null) {
            return sequence.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
