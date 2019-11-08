package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

public final class CollectionsKt__IteratorsJVMKt$iterator$1 implements Iterator<T>, KMappedMarker {
    final /* synthetic */ Enumeration $this_iterator;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    CollectionsKt__IteratorsJVMKt$iterator$1(Enumeration<T> enumeration) {
        this.$this_iterator = enumeration;
    }

    public boolean hasNext() {
        return this.$this_iterator.hasMoreElements();
    }

    public T next() {
        return this.$this_iterator.nextElement();
    }
}
