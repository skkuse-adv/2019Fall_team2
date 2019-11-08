package kotlin.collections;

import java.util.Iterator;
import kotlin.UShort;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public abstract class UShortIterator implements Iterator<UShort>, KMappedMarker {
    public abstract short nextUShort();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public final UShort next() {
        return UShort.m88boximpl(nextUShort());
    }
}
