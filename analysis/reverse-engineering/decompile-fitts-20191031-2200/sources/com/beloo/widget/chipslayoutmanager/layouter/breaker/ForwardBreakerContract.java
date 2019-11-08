package com.beloo.widget.chipslayoutmanager.layouter.breaker;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class ForwardBreakerContract extends RowBreakerDecorator {
    private IRowBreaker breaker;

    ForwardBreakerContract(IRowBreaker iRowBreaker, ILayoutRowBreaker iLayoutRowBreaker) {
        super(iLayoutRowBreaker);
        this.breaker = iRowBreaker;
    }

    public boolean isRowBroke(AbstractLayouter abstractLayouter) {
        if (super.isRowBroke(abstractLayouter)) {
            return true;
        }
        if (abstractLayouter.getCurrentViewPosition() == 0 || !this.breaker.isItemBreakRow(abstractLayouter.getCurrentViewPosition() - 1)) {
            return false;
        }
        return true;
    }
}
