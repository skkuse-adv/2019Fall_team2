package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public final class DropSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    @NotNull
    private final Iterator<T> iterator;
    private int left;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    DropSequence$iterator$1(DropSequence dropSequence) {
        this.iterator = dropSequence.sequence.iterator();
        this.left = dropSequence.count;
    }

    @NotNull
    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    public final int getLeft() {
        return this.left;
    }

    public final void setLeft(int i) {
        this.left = i;
    }

    private final void drop() {
        while (this.left > 0 && this.iterator.hasNext()) {
            this.iterator.next();
            this.left--;
        }
    }

    public T next() {
        drop();
        return this.iterator.next();
    }

    public boolean hasNext() {
        drop();
        return this.iterator.hasNext();
    }
}
