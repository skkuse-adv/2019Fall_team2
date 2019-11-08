package com.beloo.widget.chipslayoutmanager.layouter;

import androidx.recyclerview.widget.RecyclerView.LayoutManager;

class RowSquare extends Square {
    public final int getCanvasTopBorder() {
        return 0;
    }

    RowSquare(LayoutManager layoutManager) {
        super(layoutManager);
    }

    public final int getCanvasRightBorder() {
        return this.lm.getWidth() - this.lm.getPaddingRight();
    }

    public final int getCanvasBottomBorder() {
        return this.lm.getHeight();
    }

    public final int getCanvasLeftBorder() {
        return this.lm.getPaddingLeft();
    }
}
