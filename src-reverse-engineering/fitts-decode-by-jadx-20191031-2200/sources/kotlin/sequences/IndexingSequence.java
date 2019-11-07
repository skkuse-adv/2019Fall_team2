package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class IndexingSequence<T> implements Sequence<IndexedValue<? extends T>> {
    /* access modifiers changed from: private */
    public final Sequence<T> sequence;

    public IndexingSequence(@NotNull Sequence<? extends T> sequence2) {
        Intrinsics.checkParameterIsNotNull(sequence2, "sequence");
        this.sequence = sequence2;
    }

    @NotNull
    public Iterator<IndexedValue<T>> iterator() {
        return new IndexingSequence$iterator$1(this);
    }
}
