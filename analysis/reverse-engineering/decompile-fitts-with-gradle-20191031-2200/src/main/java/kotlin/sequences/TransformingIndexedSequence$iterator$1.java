package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public final class TransformingIndexedSequence$iterator$1 implements Iterator<R>, KMappedMarker {
    private int index;
    @NotNull
    private final Iterator<T> iterator;
    final /* synthetic */ TransformingIndexedSequence this$0;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    TransformingIndexedSequence$iterator$1(TransformingIndexedSequence transformingIndexedSequence) {
        this.this$0 = transformingIndexedSequence;
        this.iterator = transformingIndexedSequence.sequence.iterator();
    }

    @NotNull
    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public R next() {
        Function2 access$getTransformer$p = this.this$0.transformer;
        int i = this.index;
        this.index = i + 1;
        if (i < 0) {
            CollectionsKt__CollectionsKt.throwIndexOverflow();
        }
        return access$getTransformer$p.invoke(Integer.valueOf(i), this.iterator.next());
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }
}
