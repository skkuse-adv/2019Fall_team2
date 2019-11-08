package com.beloo.widget.chipslayoutmanager.layouter.breaker;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class RTLForwardRowBreaker implements ILayoutRowBreaker {
    RTLForwardRowBreaker() {
    }

    public boolean isRowBroke(AbstractLayouter abstractLayouter) {
        return abstractLayouter.getViewRight() < abstractLayouter.getCanvasRightBorder() && abstractLayouter.getViewRight() - abstractLayouter.getCurrentViewWidth() < abstractLayouter.getCanvasLeftBorder();
    }
}
