package com.beloo.widget.chipslayoutmanager.layouter.criteria;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

abstract class FinishingCriteriaDecorator implements IFinishingCriteria {
    private IFinishingCriteria finishingCriteria;

    FinishingCriteriaDecorator(IFinishingCriteria iFinishingCriteria) {
        this.finishingCriteria = iFinishingCriteria;
    }

    public boolean isFinishedLayouting(AbstractLayouter abstractLayouter) {
        return this.finishingCriteria.isFinishedLayouting(abstractLayouter);
    }
}
