package com.beloo.widget.chipslayoutmanager.layouter.breaker;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class RTLBackwardRowBreaker implements ILayoutRowBreaker {
    RTLBackwardRowBreaker() {
    }

    public boolean isRowBroke(AbstractLayouter abstractLayouter) {
        return abstractLayouter.getViewLeft() + abstractLayouter.getCurrentViewWidth() > abstractLayouter.getCanvasRightBorder() && abstractLayouter.getViewLeft() > abstractLayouter.getCanvasLeftBorder();
    }
}
