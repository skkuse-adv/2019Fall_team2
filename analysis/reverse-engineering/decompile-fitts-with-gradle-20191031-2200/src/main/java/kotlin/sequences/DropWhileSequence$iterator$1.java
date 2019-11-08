package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DropWhileSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    private int dropState = -1;
    @NotNull
    private final Iterator<T> iterator;
    @Nullable
    private T nextItem;
    final /* synthetic */ DropWhileSequence this$0;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    DropWhileSequence$iterator$1(DropWhileSequence dropWhileSequence) {
        this.this$0 = dropWhileSequence;
        this.iterator = dropWhileSequence.sequence.iterator();
    }

    @NotNull
    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    public final int getDropState() {
        return this.dropState;
    }

    public final void setDropState(int i) {
        this.dropState = i;
    }

    @Nullable
    public final T getNextItem() {
        return this.nextItem;
    }

    public final void setNextItem(@Nullable T t) {
        this.nextItem = t;
    }

    private final void drop() {
        while (this.iterator.hasNext()) {
            T next = this.iterator.next();
            if (!((Boolean) this.this$0.predicate.invoke(next)).booleanValue()) {
                this.nextItem = next;
                this.dropState = 1;
                return;
            }
        }
        this.dropState = 0;
    }

    public T next() {
        if (this.dropState == -1) {
            drop();
        }
        if (this.dropState != 1) {
            return this.iterator.next();
        }
        T t = this.nextItem;
        this.nextItem = null;
        this.dropState = 0;
        return t;
    }

    public boolean hasNext() {
        if (this.dropState == -1) {
            drop();
        }
        return this.dropState == 1 || this.iterator.hasNext();
    }
}
