package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;
import com.beloo.widget.chipslayoutmanager.layouter.Item;
import java.util.List;

class ColumnFillSpaceCenterStrategy implements IRowStrategy {
    ColumnFillSpaceCenterStrategy() {
    }

    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> list) {
        int verticalDifference = GravityUtil.getVerticalDifference(abstractLayouter) / (abstractLayouter.getRowSize() + 1);
        int i = 0;
        for (Item viewRect : list) {
            Rect viewRect2 = viewRect.getViewRect();
            i += verticalDifference;
            viewRect2.top += i;
            viewRect2.bottom += i;
        }
    }
}
