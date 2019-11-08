package com.beloo.widget.chipslayoutmanager.gravity;

import androidx.annotation.NonNull;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;
import com.beloo.widget.chipslayoutmanager.layouter.Item;
import java.util.List;

class StrategyDecorator implements IRowStrategy {
    @NonNull
    private IRowStrategy rowStrategy;

    StrategyDecorator(@NonNull IRowStrategy iRowStrategy) {
        this.rowStrategy = iRowStrategy;
    }

    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> list) {
        this.rowStrategy.applyStrategy(abstractLayouter, list);
    }
}
