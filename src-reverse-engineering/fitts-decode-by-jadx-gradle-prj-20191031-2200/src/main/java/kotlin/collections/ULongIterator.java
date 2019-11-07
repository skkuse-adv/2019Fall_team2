package kotlin.collections;

import java.util.Iterator;
import kotlin.ULong;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public abstract class ULongIterator implements Iterator<ULong>, KMappedMarker {
    public abstract long nextULong();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public final ULong next() {
        return ULong.m62boximpl(nextULong());
    }
}
