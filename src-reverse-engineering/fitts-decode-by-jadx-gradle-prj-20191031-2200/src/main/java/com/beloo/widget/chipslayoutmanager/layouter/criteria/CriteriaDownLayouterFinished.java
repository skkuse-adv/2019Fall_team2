package com.beloo.widget.chipslayoutmanager.layouter.criteria;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class CriteriaDownLayouterFinished implements IFinishingCriteria {
    private boolean isFinished;

    CriteriaDownLayouterFinished() {
    }

    public boolean isFinishedLayouting(AbstractLayouter abstractLayouter) {
        this.isFinished = this.isFinished || abstractLayouter.getViewTop() >= abstractLayouter.getCanvasBottomBorder();
        return this.isFinished;
    }
}
