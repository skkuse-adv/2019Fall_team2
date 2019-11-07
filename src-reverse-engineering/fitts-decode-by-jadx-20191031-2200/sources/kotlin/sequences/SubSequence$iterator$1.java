package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public final class SubSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    @NotNull
    private final Iterator<T> iterator;
    private int position;
    final /* synthetic */ SubSequence this$0;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    SubSequence$iterator$1(SubSequence subSequence) {
        this.this$0 = subSequence;
        this.iterator = subSequence.sequence.iterator();
    }

    @NotNull
    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    private final void drop() {
        while (this.position < this.this$0.startIndex && this.iterator.hasNext()) {
            this.iterator.next();
            this.position++;
        }
    }

    public boolean hasNext() {
        drop();
        return this.position < this.this$0.endIndex && this.iterator.hasNext();
    }

    public T next() {
        drop();
        if (this.position < this.this$0.endIndex) {
            this.position++;
            return this.iterator.next();
        }
        throw new NoSuchElementException();
    }
}
