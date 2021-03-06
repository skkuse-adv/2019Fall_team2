package com.beloo.widget.chipslayoutmanager.layouter;

import androidx.annotation.IntRange;

class IncrementalPositionIterator extends AbstractPositionIterator {
    IncrementalPositionIterator(@IntRange(from = 0) int i) {
        super(i);
    }

    public boolean hasNext() {
        return this.pos < this.itemCount;
    }

    public Integer next() {
        if (hasNext()) {
            int i = this.pos;
            this.pos = i + 1;
            return Integer.valueOf(i);
        }
        throw new IllegalStateException("position out of bounds reached");
    }
}
