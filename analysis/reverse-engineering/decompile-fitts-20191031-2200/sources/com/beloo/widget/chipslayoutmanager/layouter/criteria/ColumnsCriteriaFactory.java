package com.beloo.widget.chipslayoutmanager.layouter.criteria;

import androidx.annotation.NonNull;

public class ColumnsCriteriaFactory extends AbstractCriteriaFactory {
    @NonNull
    public IFinishingCriteria getBackwardFinishingCriteria() {
        CriteriaLeftLayouterFinished criteriaLeftLayouterFinished = new CriteriaLeftLayouterFinished();
        int i = this.additionalLength;
        return i != 0 ? new CriteriaLeftAdditionalWidth(criteriaLeftLayouterFinished, i) : criteriaLeftLayouterFinished;
    }

    @NonNull
    public IFinishingCriteria getForwardFinishingCriteria() {
        IFinishingCriteria criteriaRightLayouterFinished = new CriteriaRightLayouterFinished();
        int i = this.additionalLength;
        if (i != 0) {
            criteriaRightLayouterFinished = new CriteriaRightAdditionalWidth(criteriaRightLayouterFinished, i);
        }
        int i2 = this.additionalRowCount;
        return i2 != 0 ? new CriteriaAdditionalRow(criteriaRightLayouterFinished, i2) : criteriaRightLayouterFinished;
    }
}
