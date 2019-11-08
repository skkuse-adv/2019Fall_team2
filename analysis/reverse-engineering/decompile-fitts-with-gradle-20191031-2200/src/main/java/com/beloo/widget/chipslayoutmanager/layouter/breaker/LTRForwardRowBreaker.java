package com.beloo.widget.chipslayoutmanager.layouter.breaker;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class LTRForwardRowBreaker implements ILayoutRowBreaker {
    LTRForwardRowBreaker() {
    }

    public boolean isRowBroke(AbstractLayouter abstractLayouter) {
        return abstractLayouter.getViewLeft() > abstractLayouter.getCanvasLeftBorder() && abstractLayouter.getViewLeft() + abstractLayouter.getCurrentViewWidth() > abstractLayouter.getCanvasRightBorder();
    }
}
