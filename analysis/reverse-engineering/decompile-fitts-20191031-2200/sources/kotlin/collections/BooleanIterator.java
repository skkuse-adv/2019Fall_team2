package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public abstract class BooleanIterator implements Iterator<Boolean>, KMappedMarker {
    public abstract boolean nextBoolean();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public final Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }
}
