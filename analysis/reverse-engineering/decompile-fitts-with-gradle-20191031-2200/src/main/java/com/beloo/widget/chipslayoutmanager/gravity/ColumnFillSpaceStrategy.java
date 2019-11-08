package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;
import com.beloo.widget.chipslayoutmanager.layouter.Item;
import java.util.List;

class ColumnFillSpaceStrategy implements IRowStrategy {
    ColumnFillSpaceStrategy() {
    }

    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> list) {
        if (abstractLayouter.getRowSize() != 1) {
            int verticalDifference = GravityUtil.getVerticalDifference(abstractLayouter) / (abstractLayouter.getRowSize() - 1);
            int i = 0;
            for (Item viewRect : list) {
                Rect viewRect2 = viewRect.getViewRect();
                if (viewRect2.top == abstractLayouter.getCanvasTopBorder()) {
                    int canvasTopBorder = viewRect2.top - abstractLayouter.getCanvasTopBorder();
                    viewRect2.top = abstractLayouter.getCanvasTopBorder();
                    viewRect2.bottom -= canvasTopBorder;
                } else {
                    i += verticalDifference;
                    viewRect2.top += i;
                    viewRect2.bottom += i;
                }
            }
        }
    }
}
