package kotlin.collections;

import java.util.Iterator;
import kotlin.UByte;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public abstract class UByteIterator implements Iterator<UByte>, KMappedMarker {
    public abstract byte nextUByte();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public final UByte next() {
        return UByte.m10boximpl(nextUByte());
    }
}
