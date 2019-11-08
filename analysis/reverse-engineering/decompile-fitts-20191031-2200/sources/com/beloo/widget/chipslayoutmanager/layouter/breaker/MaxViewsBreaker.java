package com.beloo.widget.chipslayoutmanager.layouter.breaker;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

public class MaxViewsBreaker extends RowBreakerDecorator {
    private int maxViewsInRow;

    MaxViewsBreaker(int i, ILayoutRowBreaker iLayoutRowBreaker) {
        super(iLayoutRowBreaker);
        this.maxViewsInRow = i;
    }

    public boolean isRowBroke(AbstractLayouter abstractLayouter) {
        return super.isRowBroke(abstractLayouter) || abstractLayouter.getRowSize() >= this.maxViewsInRow;
    }
}
