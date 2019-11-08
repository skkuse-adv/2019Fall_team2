package org.jetbrains.anko.collections;

import android.util.SparseIntArray;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class SparseIntArraySequence implements Sequence<Integer> {
    /* access modifiers changed from: private */
    public final SparseIntArray a;

    private final class SparseIntArrayIterator implements Iterator<Integer>, KMappedMarker {
        private int index;
        private final int size;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public SparseIntArrayIterator() {
            this.size = SparseIntArraySequence.this.a.size();
        }

        public boolean hasNext() {
            return this.size > this.index;
        }

        @NotNull
        public Integer next() {
            if (SparseIntArraySequence.this.a.size() == this.size) {
                SparseIntArray access$getA$p = SparseIntArraySequence.this.a;
                int i = this.index;
                this.index = i + 1;
                return Integer.valueOf(access$getA$p.get(i));
            }
            throw new ConcurrentModificationException();
        }
    }

    public SparseIntArraySequence(@NotNull SparseIntArray sparseIntArray) {
        Intrinsics.checkParameterIsNotNull(sparseIntArray, "a");
        this.a = sparseIntArray;
    }

    @NotNull
    public Iterator<Integer> iterator() {
        return new SparseIntArrayIterator();
    }
}
