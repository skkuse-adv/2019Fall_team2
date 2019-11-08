package com.beloo.widget.chipslayoutmanager.layouter;

import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.beloo.widget.chipslayoutmanager.gravity.IRowStrategyFactory;
import com.beloo.widget.chipslayoutmanager.gravity.LTRRowStrategyFactory;
import com.beloo.widget.chipslayoutmanager.layouter.breaker.IBreakerFactory;
import com.beloo.widget.chipslayoutmanager.layouter.breaker.LTRRowBreakerFactory;

class LTRRowsOrientationStateFactory implements IOrientationStateFactory {
    LTRRowsOrientationStateFactory() {
    }

    public ILayouterCreator createLayouterCreator(LayoutManager layoutManager) {
        return new LTRRowsCreator(layoutManager);
    }

    public IRowStrategyFactory createRowStrategyFactory() {
        return new LTRRowStrategyFactory();
    }

    public IBreakerFactory createDefaultBreaker() {
        return new LTRRowBreakerFactory();
    }
}
