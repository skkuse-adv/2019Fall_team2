package com.beloo.widget.chipslayoutmanager.layouter.breaker;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class BackwardBreakerContract extends RowBreakerDecorator {
    private IRowBreaker breaker;

    BackwardBreakerContract(IRowBreaker iRowBreaker, ILayoutRowBreaker iLayoutRowBreaker) {
        super(iLayoutRowBreaker);
        this.breaker = iRowBreaker;
    }

    public boolean isRowBroke(AbstractLayouter abstractLayouter) {
        return super.isRowBroke(abstractLayouter) || this.breaker.isItemBreakRow(abstractLayouter.getCurrentViewPosition());
    }
}
