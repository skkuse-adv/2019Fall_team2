package org.jetbrains.anko.collections;

import android.util.SparseArray;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class SparseArraySequence<T> implements Sequence<T> {
    /* access modifiers changed from: private */
    public final SparseArray<T> a;

    private final class SparseArrayIterator implements Iterator<T>, KMappedMarker {
        private int index;
        private final int size;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public SparseArrayIterator() {
            this.size = SparseArraySequence.this.a.size();
        }

        public boolean hasNext() {
            return this.size > this.index;
        }

        public T next() {
            if (SparseArraySequence.this.a.size() == this.size) {
                SparseArray access$getA$p = SparseArraySequence.this.a;
                int i = this.index;
                this.index = i + 1;
                return access$getA$p.valueAt(i);
            }
            throw new ConcurrentModificationException();
        }
    }

    public SparseArraySequence(@NotNull SparseArray<T> sparseArray) {
        Intrinsics.checkParameterIsNotNull(sparseArray, "a");
        this.a = sparseArray;
    }

    @NotNull
    public Iterator<T> iterator() {
        return new SparseArrayIterator();
    }
}
