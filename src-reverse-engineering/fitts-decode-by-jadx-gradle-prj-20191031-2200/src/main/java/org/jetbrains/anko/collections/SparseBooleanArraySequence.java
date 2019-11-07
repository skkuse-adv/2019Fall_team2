package org.jetbrains.anko.collections;

import android.util.SparseBooleanArray;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

public final class SparseBooleanArraySequence implements Sequence<Boolean> {
    /* access modifiers changed from: private */
    public final SparseBooleanArray a;

    private final class SparseIntArrayIterator implements Iterator<Boolean>, KMappedMarker {
        private int index;
        private final int size;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public SparseIntArrayIterator() {
            this.size = SparseBooleanArraySequence.this.a.size();
        }

        public boolean hasNext() {
            return this.size > this.index;
        }

        @NotNull
        public Boolean next() {
            if (SparseBooleanArraySequence.this.a.size() == this.size) {
                SparseBooleanArray access$getA$p = SparseBooleanArraySequence.this.a;
                int i = this.index;
                this.index = i + 1;
                return Boolean.valueOf(access$getA$p.get(i));
            }
            throw new ConcurrentModificationException();
        }
    }

    public SparseBooleanArraySequence(@NotNull SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkParameterIsNotNull(sparseBooleanArray, "a");
        this.a = sparseBooleanArray;
    }

    @NotNull
    public Iterator<Boolean> iterator() {
        return new SparseIntArrayIterator();
    }
}
