package com.beloo.widget.chipslayoutmanager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import java.util.Iterator;

public class ChildViewsIterable implements Iterable<View> {
    /* access modifiers changed from: private */
    public LayoutManager layoutManager;

    public ChildViewsIterable(LayoutManager layoutManager2) {
        this.layoutManager = layoutManager2;
    }

    public Iterator<View> iterator() {
        return new Iterator<View>() {
            int i = 0;

            public boolean hasNext() {
                return this.i < ChildViewsIterable.this.layoutManager.getChildCount();
            }

            public View next() {
                LayoutManager access$000 = ChildViewsIterable.this.layoutManager;
                int i2 = this.i;
                this.i = i2 + 1;
                return access$000.getChildAt(i2);
            }
        };
    }

    public int size() {
        return this.layoutManager.getChildCount();
    }
}
