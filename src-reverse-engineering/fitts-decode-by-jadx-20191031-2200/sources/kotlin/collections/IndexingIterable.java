package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public final class IndexingIterable<T> implements Iterable<IndexedValue<? extends T>>, KMappedMarker {
    private final Function0<Iterator<T>> iteratorFactory;

    public IndexingIterable(@NotNull Function0<? extends Iterator<? extends T>> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "iteratorFactory");
        this.iteratorFactory = function0;
    }

    @NotNull
    public Iterator<IndexedValue<T>> iterator() {
        return new IndexingIterator((Iterator) this.iteratorFactory.invoke());
    }
}
