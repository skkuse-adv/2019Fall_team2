package com.beloo.widget.chipslayoutmanager.layouter.criteria;

import androidx.annotation.IntRange;

public abstract class AbstractCriteriaFactory implements ICriteriaFactory {
    int additionalLength;
    int additionalRowCount;

    public void setAdditionalLength(@IntRange(from = 0) int i) {
        if (i >= 0) {
            this.additionalLength = i;
            return;
        }
        throw new IllegalArgumentException("additional height can't be negative");
    }

    public void setAdditionalRowsCount(int i) {
        this.additionalRowCount = i;
    }
}
