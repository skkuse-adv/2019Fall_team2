package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public final class TakeSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    @NotNull
    private final Iterator<T> iterator;
    private int left;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    TakeSequence$iterator$1(TakeSequence takeSequence) {
        this.left = takeSequence.count;
        this.iterator = takeSequence.sequence.iterator();
    }

    public final int getLeft() {
        return this.left;
    }

    public final void setLeft(int i) {
        this.left = i;
    }

    @NotNull
    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    public T next() {
        int i = this.left;
        if (i != 0) {
            this.left = i - 1;
            return this.iterator.next();
        }
        throw new NoSuchElementException();
    }

    public boolean hasNext() {
        return this.left > 0 && this.iterator.hasNext();
    }
}
