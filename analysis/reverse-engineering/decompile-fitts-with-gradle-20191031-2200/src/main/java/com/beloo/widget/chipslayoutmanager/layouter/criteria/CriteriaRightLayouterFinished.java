package com.beloo.widget.chipslayoutmanager.layouter.criteria;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class CriteriaRightLayouterFinished implements IFinishingCriteria {
    CriteriaRightLayouterFinished() {
    }

    public boolean isFinishedLayouting(AbstractLayouter abstractLayouter) {
        return abstractLayouter.getViewLeft() >= abstractLayouter.getCanvasRightBorder();
    }
}
