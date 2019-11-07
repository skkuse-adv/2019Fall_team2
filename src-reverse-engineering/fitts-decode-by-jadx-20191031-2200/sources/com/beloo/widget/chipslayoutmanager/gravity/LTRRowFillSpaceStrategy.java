package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;
import com.beloo.widget.chipslayoutmanager.layouter.Item;
import java.util.List;

class LTRRowFillSpaceStrategy implements IRowStrategy {
    LTRRowFillSpaceStrategy() {
    }

    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> list) {
        if (abstractLayouter.getRowSize() != 1) {
            int horizontalDifference = GravityUtil.getHorizontalDifference(abstractLayouter) / (abstractLayouter.getRowSize() - 1);
            int i = 0;
            for (Item viewRect : list) {
                Rect viewRect2 = viewRect.getViewRect();
                if (viewRect2.left == abstractLayouter.getCanvasLeftBorder()) {
                    int canvasLeftBorder = viewRect2.left - abstractLayouter.getCanvasLeftBorder();
                    viewRect2.left = abstractLayouter.getCanvasLeftBorder();
                    viewRect2.right -= canvasLeftBorder;
                } else {
                    i += horizontalDifference;
                    viewRect2.left += i;
                    viewRect2.right += i;
                }
            }
        }
    }
}
