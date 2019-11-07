package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;
import com.beloo.widget.chipslayoutmanager.layouter.Item;
import java.util.List;

class ColumnFillStrategy implements IRowStrategy {
    ColumnFillStrategy() {
    }

    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> list) {
        int verticalDifference = GravityUtil.getVerticalDifference(abstractLayouter) / abstractLayouter.getRowSize();
        int i = verticalDifference;
        for (Item viewRect : list) {
            Rect viewRect2 = viewRect.getViewRect();
            if (viewRect2.top == abstractLayouter.getCanvasTopBorder()) {
                int canvasTopBorder = viewRect2.top - abstractLayouter.getCanvasTopBorder();
                viewRect2.top = abstractLayouter.getCanvasTopBorder();
                viewRect2.bottom -= canvasTopBorder;
                viewRect2.bottom += i;
            } else {
                viewRect2.top += i;
                i += verticalDifference;
                viewRect2.bottom += i;
            }
        }
    }
}
