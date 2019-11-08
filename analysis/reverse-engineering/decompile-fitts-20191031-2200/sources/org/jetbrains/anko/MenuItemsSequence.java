package org.jetbrains.anko;

import android.view.Menu;
import android.view.MenuItem;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

final class MenuItemsSequence implements Sequence<MenuItem> {
    private final Menu menu;

    private static final class MenuItemIterator implements Iterator<MenuItem>, KMappedMarker {
        private final int count = this.menu.size();
        private int index;
        private final Menu menu;

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public MenuItemIterator(@NotNull Menu menu2) {
            Intrinsics.checkParameterIsNotNull(menu2, "menu");
            this.menu = menu2;
        }

        @NotNull
        public MenuItem next() {
            if (hasNext()) {
                Menu menu2 = this.menu;
                int i = this.index;
                this.index = i + 1;
                MenuItem item = menu2.getItem(i);
                Intrinsics.checkExpressionValueIsNotNull(item, "menu.getItem(index++)");
                return item;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.count == this.menu.size()) {
                return this.index < this.count;
            }
            throw new ConcurrentModificationException();
        }
    }

    public MenuItemsSequence(@NotNull Menu menu2) {
        Intrinsics.checkParameterIsNotNull(menu2, "menu");
        this.menu = menu2;
    }

    @NotNull
    public Iterator<MenuItem> iterator() {
        return new MenuItemIterator(this.menu);
    }
}
