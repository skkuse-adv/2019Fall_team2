package kotlin.collections;

import java.util.Iterator;
import kotlin.UInt;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public abstract class UIntIterator implements Iterator<UInt>, KMappedMarker {
    public abstract int nextUInt();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public final UInt next() {
        return UInt.m36boximpl(nextUInt());
    }
}
