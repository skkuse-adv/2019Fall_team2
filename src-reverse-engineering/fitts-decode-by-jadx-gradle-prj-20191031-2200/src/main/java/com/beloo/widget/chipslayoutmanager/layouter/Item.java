package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;

public class Item {
    private int viewPosition;
    private Rect viewRect;

    public Item(Rect rect, int i) {
        this.viewRect = rect;
        this.viewPosition = i;
    }

    public Rect getViewRect() {
        return this.viewRect;
    }

    public int getViewPosition() {
        return this.viewPosition;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || Item.class != obj.getClass()) {
            return false;
        }
        if (this.viewPosition != ((Item) obj).viewPosition) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.viewPosition;
    }
}
