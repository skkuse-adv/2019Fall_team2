package com.beloo.widget.chipslayoutmanager.layouter.criteria;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class CriteriaRightAdditionalWidth extends FinishingCriteriaDecorator {
    private int additionalWidth;

    CriteriaRightAdditionalWidth(IFinishingCriteria iFinishingCriteria, int i) {
        super(iFinishingCriteria);
        this.additionalWidth = i;
    }

    public boolean isFinishedLayouting(AbstractLayouter abstractLayouter) {
        return super.isFinishedLayouting(abstractLayouter) && abstractLayouter.getViewLeft() > abstractLayouter.getCanvasRightBorder() + this.additionalWidth;
    }
}
