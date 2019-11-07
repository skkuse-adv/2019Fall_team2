package org.jetbrains.anko;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

final class ViewChildrenRecursiveSequence implements Sequence<View> {
    private final View view;

    private static final class RecursiveViewIterator implements Iterator<View>, KMappedMarker {
        private Iterator<? extends View> current;
        private final ArrayList<Sequence<View>> sequences;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public RecursiveViewIterator(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            this.sequences = CollectionsKt__CollectionsKt.arrayListOf(ViewChildrenSequencesKt.childrenSequence(view));
            ArrayList<Sequence<View>> arrayList = this.sequences;
            if (!arrayList.isEmpty()) {
                this.current = ((Sequence) arrayList.remove(arrayList.size() - 1)).iterator();
                return;
            }
            throw new NoSuchElementException();
        }

        @NotNull
        public View next() {
            if (hasNext()) {
                View view = (View) this.current.next();
                if ((view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0) {
                    this.sequences.add(ViewChildrenSequencesKt.childrenSequence(view));
                }
                return view;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (!this.current.hasNext() && (!this.sequences.isEmpty())) {
                ArrayList<Sequence<View>> arrayList = this.sequences;
                if (!arrayList.isEmpty()) {
                    this.current = ((Sequence) arrayList.remove(arrayList.size() - 1)).iterator();
                } else {
                    throw new NoSuchElementException();
                }
            }
            return this.current.hasNext();
        }

        private final <T> T removeLast(@NotNull List<T> list) {
            if (!list.isEmpty()) {
                return list.remove(list.size() - 1);
            }
            throw new NoSuchElementException();
        }
    }

    public ViewChildrenRecursiveSequence(@NotNull View view2) {
        Intrinsics.checkParameterIsNotNull(view2, "view");
        this.view = view2;
    }

    @NotNull
    public Iterator<View> iterator() {
        View view2 = this.view;
        if (!(view2 instanceof ViewGroup)) {
            return CollectionsKt__CollectionsKt.emptyList().iterator();
        }
        return new RecursiveViewIterator(view2);
    }
}
