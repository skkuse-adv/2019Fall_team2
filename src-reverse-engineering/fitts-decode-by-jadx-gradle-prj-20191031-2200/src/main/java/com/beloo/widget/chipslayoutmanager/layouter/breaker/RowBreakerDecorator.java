package com.beloo.widget.chipslayoutmanager.layouter.breaker;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class RowBreakerDecorator implements ILayoutRowBreaker {
    private ILayoutRowBreaker decorate;

    RowBreakerDecorator(ILayoutRowBreaker iLayoutRowBreaker) {
        this.decorate = iLayoutRowBreaker;
    }

    public boolean isRowBroke(AbstractLayouter abstractLayouter) {
        return this.decorate.isRowBroke(abstractLayouter);
    }
}
