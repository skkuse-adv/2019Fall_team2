package com.beloo.widget.chipslayoutmanager.layouter;

import androidx.recyclerview.widget.RecyclerView.LayoutManager;

class ColumnSquare extends Square {
    public final int getCanvasLeftBorder() {
        return 0;
    }

    ColumnSquare(LayoutManager layoutManager) {
        super(layoutManager);
    }

    public final int getCanvasRightBorder() {
        return this.lm.getWidth();
    }

    public final int getCanvasBottomBorder() {
        return this.lm.getHeight() - this.lm.getPaddingBottom();
    }

    public final int getCanvasTopBorder() {
        return this.lm.getPaddingTop();
    }
}
