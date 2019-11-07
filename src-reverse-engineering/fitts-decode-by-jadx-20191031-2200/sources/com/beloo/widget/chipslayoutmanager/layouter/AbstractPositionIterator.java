package com.beloo.widget.chipslayoutmanager.layouter;

import androidx.annotation.IntRange;
import java.util.Iterator;

public abstract class AbstractPositionIterator implements Iterator<Integer> {
    int itemCount;
    int pos;

    AbstractPositionIterator(@IntRange(from = 0) int i) {
        if (i >= 0) {
            this.itemCount = i;
            return;
        }
        throw new IllegalArgumentException("item count couldn't be negative");
    }

    public void move(@IntRange(from = 0) int i) {
        if (i >= this.itemCount) {
            throw new IllegalArgumentException("you can't move above of maxItemCount");
        } else if (i >= 0) {
            this.pos = i;
        } else {
            throw new IllegalArgumentException("can't move to negative position");
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("removing not supported in position iterator");
    }
}
