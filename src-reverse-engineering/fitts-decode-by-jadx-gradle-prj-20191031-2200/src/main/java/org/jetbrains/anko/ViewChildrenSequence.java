package org.jetbrains.anko;

import android.view.View;
import android.view.ViewGroup;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

final class ViewChildrenSequence implements Sequence<View> {
    private final View view;

    private static final class ViewIterator implements Iterator<View>, KMappedMarker {
        private final int count = this.view.getChildCount();
        private int index;
        private final ViewGroup view;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public ViewIterator(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "view");
            this.view = viewGroup;
        }

        @NotNull
        public View next() {
            if (hasNext()) {
                ViewGroup viewGroup = this.view;
                int i = this.index;
                this.index = i + 1;
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "view.getChildAt(index++)");
                return childAt;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            checkCount();
            return this.index < this.count;
        }

        private final void checkCount() {
            if (this.count != this.view.getChildCount()) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public ViewChildrenSequence(@NotNull View view2) {
        Intrinsics.checkParameterIsNotNull(view2, "view");
        this.view = view2;
    }

    @NotNull
    public Iterator<View> iterator() {
        View view2 = this.view;
        if (!(view2 instanceof ViewGroup)) {
            return CollectionsKt__CollectionsKt.emptyList().iterator();
        }
        return new ViewIterator((ViewGroup) view2);
    }
}
