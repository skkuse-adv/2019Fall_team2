package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;
import com.beloo.widget.chipslayoutmanager.layouter.Item;
import java.util.List;

class LTRRowFillStrategy implements IRowStrategy {
    LTRRowFillStrategy() {
    }

    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> list) {
        int horizontalDifference = GravityUtil.getHorizontalDifference(abstractLayouter) / abstractLayouter.getRowSize();
        int i = horizontalDifference;
        for (Item viewRect : list) {
            Rect viewRect2 = viewRect.getViewRect();
            if (viewRect2.left == abstractLayouter.getCanvasLeftBorder()) {
                int canvasLeftBorder = viewRect2.left - abstractLayouter.getCanvasLeftBorder();
                viewRect2.left = abstractLayouter.getCanvasLeftBorder();
                viewRect2.right -= canvasLeftBorder;
                viewRect2.right += i;
            } else {
                viewRect2.left += i;
                i += horizontalDifference;
                viewRect2.right += i;
            }
        }
    }
}
