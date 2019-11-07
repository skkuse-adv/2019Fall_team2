package com.beloo.widget.chipslayoutmanager.layouter.criteria;

import androidx.annotation.NonNull;

public class RowsCriteriaFactory extends AbstractCriteriaFactory implements ICriteriaFactory {
    @NonNull
    public IFinishingCriteria getBackwardFinishingCriteria() {
        CriteriaUpLayouterFinished criteriaUpLayouterFinished = new CriteriaUpLayouterFinished();
        int i = this.additionalLength;
        return i != 0 ? new CriteriaUpAdditionalHeight(criteriaUpLayouterFinished, i) : criteriaUpLayouterFinished;
    }

    @NonNull
    public IFinishingCriteria getForwardFinishingCriteria() {
        IFinishingCriteria criteriaDownLayouterFinished = new CriteriaDownLayouterFinished();
        int i = this.additionalLength;
        if (i != 0) {
            criteriaDownLayouterFinished = new CriteriaDownAdditionalHeight(criteriaDownLayouterFinished, i);
        }
        int i2 = this.additionalRowCount;
        return i2 != 0 ? new CriteriaAdditionalRow(criteriaDownLayouterFinished, i2) : criteriaDownLayouterFinished;
    }
}
