package com.beloo.widget.chipslayoutmanager;

import androidx.annotation.IntRange;
import com.beloo.widget.chipslayoutmanager.layouter.breaker.IRowBreaker;

interface IChipsLayoutManagerContract extends IPositionsContract, IScrollingContract {
    Integer getMaxViewsInRow();

    IRowBreaker getRowBreaker();

    int getRowStrategyType();

    boolean isScrollingEnabledContract();

    int layoutOrientation();

    void setMaxViewsInRow(@IntRange(from = 1) Integer num);

    void setScrollingEnabledContract(boolean z);
}
