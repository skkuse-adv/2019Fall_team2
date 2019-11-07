package com.beloo.widget.chipslayoutmanager.layouter.breaker;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

public class LTRForwardColumnBreaker implements ILayoutRowBreaker {
    public boolean isRowBroke(AbstractLayouter abstractLayouter) {
        return abstractLayouter.getViewTop() > abstractLayouter.getCanvasTopBorder() && abstractLayouter.getViewTop() + abstractLayouter.getCurrentViewHeight() > abstractLayouter.getCanvasBottomBorder();
    }
}
