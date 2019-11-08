package com.beloo.widget.chipslayoutmanager.layouter.criteria;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class CriteriaUpAdditionalHeight extends FinishingCriteriaDecorator {
    private int additionalHeight;

    CriteriaUpAdditionalHeight(IFinishingCriteria iFinishingCriteria, int i) {
        super(iFinishingCriteria);
        this.additionalHeight = i;
    }

    public boolean isFinishedLayouting(AbstractLayouter abstractLayouter) {
        return super.isFinishedLayouting(abstractLayouter) && abstractLayouter.getViewBottom() < abstractLayouter.getCanvasTopBorder() - this.additionalHeight;
    }
}
