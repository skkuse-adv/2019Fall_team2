package com.beloo.widget.chipslayoutmanager.layouter.breaker;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

public class LTRBackwardColumnBreaker implements ILayoutRowBreaker {
    public boolean isRowBroke(AbstractLayouter abstractLayouter) {
        return abstractLayouter.getViewBottom() - abstractLayouter.getCurrentViewHeight() < abstractLayouter.getCanvasTopBorder() && abstractLayouter.getViewBottom() < abstractLayouter.getCanvasBottomBorder();
    }
}
