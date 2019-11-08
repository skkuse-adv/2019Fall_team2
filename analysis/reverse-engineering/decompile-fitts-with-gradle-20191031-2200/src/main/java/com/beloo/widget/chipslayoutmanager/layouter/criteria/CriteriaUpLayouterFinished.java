package com.beloo.widget.chipslayoutmanager.layouter.criteria;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class CriteriaUpLayouterFinished implements IFinishingCriteria {
    CriteriaUpLayouterFinished() {
    }

    public boolean isFinishedLayouting(AbstractLayouter abstractLayouter) {
        return abstractLayouter.getViewBottom() <= abstractLayouter.getCanvasTopBorder();
    }
}
