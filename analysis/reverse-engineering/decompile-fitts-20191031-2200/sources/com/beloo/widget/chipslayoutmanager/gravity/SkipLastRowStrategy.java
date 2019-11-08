package com.beloo.widget.chipslayoutmanager.gravity;

import androidx.annotation.NonNull;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;
import com.beloo.widget.chipslayoutmanager.layouter.Item;
import java.util.List;

public class SkipLastRowStrategy extends StrategyDecorator {
    private boolean skipLastRow;

    public SkipLastRowStrategy(@NonNull IRowStrategy iRowStrategy, boolean z) {
        super(iRowStrategy);
        this.skipLastRow = z;
    }

    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> list) {
        if (!this.skipLastRow || abstractLayouter.isRowCompleted()) {
            super.applyStrategy(abstractLayouter, list);
        }
    }
}
