package com.beloo.widget.chipslayoutmanager.layouter.criteria;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;
import com.beloo.widget.chipslayoutmanager.layouter.ILayouter;
import com.beloo.widget.chipslayoutmanager.layouter.ILayouterListener;

class CriteriaAdditionalRow extends FinishingCriteriaDecorator implements IFinishingCriteria, ILayouterListener {
    private int additionalRowsCount;
    private int requiredRowsCount;

    CriteriaAdditionalRow(IFinishingCriteria iFinishingCriteria, int i) {
        super(iFinishingCriteria);
        this.requiredRowsCount = i;
    }

    public boolean isFinishedLayouting(AbstractLayouter abstractLayouter) {
        abstractLayouter.addLayouterListener(this);
        return super.isFinishedLayouting(abstractLayouter) && this.additionalRowsCount >= this.requiredRowsCount;
    }

    public void onLayoutRow(ILayouter iLayouter) {
        if (super.isFinishedLayouting((AbstractLayouter) iLayouter)) {
            this.additionalRowsCount++;
        }
    }
}
