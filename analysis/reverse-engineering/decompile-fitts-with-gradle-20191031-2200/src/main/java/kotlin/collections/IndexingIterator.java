package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public final class IndexingIterator<T> implements Iterator<IndexedValue<? extends T>>, KMappedMarker {
    private int index;
    private final Iterator<T> iterator;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public IndexingIterator(@NotNull Iterator<? extends T> it) {
        Intrinsics.checkParameterIsNotNull(it, "iterator");
        this.iterator = it;
    }

    public final boolean hasNext() {
        return this.iterator.hasNext();
    }

    @NotNull
    public final IndexedValue<T> next() {
        int i = this.index;
        this.index = i + 1;
        if (i < 0) {
            CollectionsKt__CollectionsKt.throwIndexOverflow();
        }
        return new IndexedValue<>(i, this.iterator.next());
    }
}
