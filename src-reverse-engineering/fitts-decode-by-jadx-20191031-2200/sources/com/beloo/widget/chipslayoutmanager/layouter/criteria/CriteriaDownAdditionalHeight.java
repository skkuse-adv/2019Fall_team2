package com.beloo.widget.chipslayoutmanager.layouter.criteria;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class CriteriaDownAdditionalHeight extends FinishingCriteriaDecorator {
    private int additionalHeight;

    CriteriaDownAdditionalHeight(IFinishingCriteria iFinishingCriteria, int i) {
        super(iFinishingCriteria);
        this.additionalHeight = i;
    }

    public boolean isFinishedLayouting(AbstractLayouter abstractLayouter) {
        return super.isFinishedLayouting(abstractLayouter) && abstractLayouter.getViewTop() > abstractLayouter.getCanvasBottomBorder() + this.additionalHeight;
    }
}
