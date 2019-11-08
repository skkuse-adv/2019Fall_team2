package kotlin.collections;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public abstract class FloatIterator implements Iterator<Float>, KMappedMarker {
    public abstract float nextFloat();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public final Float next() {
        return Float.valueOf(nextFloat());
    }
}
