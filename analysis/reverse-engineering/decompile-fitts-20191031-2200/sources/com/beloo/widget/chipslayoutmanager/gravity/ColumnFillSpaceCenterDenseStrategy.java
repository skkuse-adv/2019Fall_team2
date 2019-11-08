package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;
import com.beloo.widget.chipslayoutmanager.layouter.Item;
import java.util.List;

class ColumnFillSpaceCenterDenseStrategy implements IRowStrategy {
    ColumnFillSpaceCenterDenseStrategy() {
    }

    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> list) {
        int verticalDifference = GravityUtil.getVerticalDifference(abstractLayouter) / 2;
        for (Item viewRect : list) {
            Rect viewRect2 = viewRect.getViewRect();
            viewRect2.top += verticalDifference;
            viewRect2.bottom += verticalDifference;
        }
    }
}
