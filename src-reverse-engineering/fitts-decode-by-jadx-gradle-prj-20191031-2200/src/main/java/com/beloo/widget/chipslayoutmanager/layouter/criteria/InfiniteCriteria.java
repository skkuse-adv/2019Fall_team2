package com.beloo.widget.chipslayoutmanager.layouter.criteria;

import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;

class InfiniteCriteria implements IFinishingCriteria {
    public boolean isFinishedLayouting(AbstractLayouter abstractLayouter) {
        return false;
    }

    InfiniteCriteria() {
    }
}
