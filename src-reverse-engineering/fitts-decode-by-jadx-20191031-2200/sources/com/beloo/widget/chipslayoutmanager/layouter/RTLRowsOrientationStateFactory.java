package com.beloo.widget.chipslayoutmanager.layouter;

import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.beloo.widget.chipslayoutmanager.gravity.IRowStrategyFactory;
import com.beloo.widget.chipslayoutmanager.gravity.RTLRowStrategyFactory;
import com.beloo.widget.chipslayoutmanager.layouter.breaker.IBreakerFactory;
import com.beloo.widget.chipslayoutmanager.layouter.breaker.RTLRowBreakerFactory;

class RTLRowsOrientationStateFactory implements IOrientationStateFactory {
    RTLRowsOrientationStateFactory() {
    }

    public ILayouterCreator createLayouterCreator(LayoutManager layoutManager) {
        return new RTLRowsCreator(layoutManager);
    }

    public IRowStrategyFactory createRowStrategyFactory() {
        return new RTLRowStrategyFactory();
    }

    public IBreakerFactory createDefaultBreaker() {
        return new RTLRowBreakerFactory();
    }
}
