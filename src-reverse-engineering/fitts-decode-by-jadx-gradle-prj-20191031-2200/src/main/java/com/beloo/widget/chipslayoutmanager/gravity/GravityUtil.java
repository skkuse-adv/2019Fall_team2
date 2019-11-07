package com.beloo.widget.chipslayoutmanager.gravity;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

abstract class GravityUtil {
    static int getHorizontalDifference(AbstractLayouter abstractLayouter) {
        return (abstractLayouter.getCanvasRightBorder() - abstractLayouter.getCanvasLeftBorder()) - abstractLayouter.getRowLength();
    }

    static int getVerticalDifference(AbstractLayouter abstractLayouter) {
        return (abstractLayouter.getCanvasBottomBorder() - abstractLayouter.getCanvasTopBorder()) - abstractLayouter.getRowLength();
    }
}
