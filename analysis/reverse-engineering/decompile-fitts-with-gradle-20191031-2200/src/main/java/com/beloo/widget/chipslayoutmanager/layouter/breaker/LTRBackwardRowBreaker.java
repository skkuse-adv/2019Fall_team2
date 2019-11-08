package com.beloo.widget.chipslayoutmanager.layouter.breaker;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class LTRBackwardRowBreaker implements ILayoutRowBreaker {
    LTRBackwardRowBreaker() {
    }

    public boolean isRowBroke(AbstractLayouter abstractLayouter) {
        return abstractLayouter.getViewRight() - abstractLayouter.getCurrentViewWidth() < abstractLayouter.getCanvasLeftBorder() && abstractLayouter.getViewRight() < abstractLayouter.getCanvasRightBorder();
    }
}
