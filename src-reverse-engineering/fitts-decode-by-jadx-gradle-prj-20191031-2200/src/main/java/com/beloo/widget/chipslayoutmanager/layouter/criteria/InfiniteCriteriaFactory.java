package com.beloo.widget.chipslayoutmanager.layouter.criteria;

import androidx.annotation.NonNull;

public class InfiniteCriteriaFactory extends AbstractCriteriaFactory implements ICriteriaFactory {
    @NonNull
    public IFinishingCriteria getBackwardFinishingCriteria() {
        return new InfiniteCriteria();
    }

    @NonNull
    public IFinishingCriteria getForwardFinishingCriteria() {
        return new InfiniteCriteria();
    }
}
