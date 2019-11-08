package com.beloo.widget.chipslayoutmanager.layouter.criteria;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class CriteriaLeftLayouterFinished implements IFinishingCriteria {
    CriteriaLeftLayouterFinished() {
    }

    public boolean isFinishedLayouting(AbstractLayouter abstractLayouter) {
        return abstractLayouter.getViewRight() <= abstractLayouter.getCanvasLeftBorder();
    }
}
