package com.beloo.widget.chipslayoutmanager.layouter;

import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.beloo.widget.chipslayoutmanager.gravity.IRowStrategyFactory;
import com.beloo.widget.chipslayoutmanager.layouter.breaker.IBreakerFactory;

interface IOrientationStateFactory {
    IBreakerFactory createDefaultBreaker();

    ILayouterCreator createLayouterCreator(LayoutManager layoutManager);

    IRowStrategyFactory createRowStrategyFactory();
}
