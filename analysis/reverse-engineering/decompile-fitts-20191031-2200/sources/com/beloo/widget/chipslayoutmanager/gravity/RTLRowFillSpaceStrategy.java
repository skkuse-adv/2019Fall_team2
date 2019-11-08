package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;
import com.beloo.widget.chipslayoutmanager.layouter.Item;
import java.util.List;

class RTLRowFillSpaceStrategy implements IRowStrategy {
    RTLRowFillSpaceStrategy() {
    }

    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> list) {
        if (abstractLayouter.getRowSize() != 1) {
            int horizontalDifference = GravityUtil.getHorizontalDifference(abstractLayouter) / (abstractLayouter.getRowSize() - 1);
            int i = 0;
            for (Item viewRect : list) {
                Rect viewRect2 = viewRect.getViewRect();
                if (viewRect2.right == abstractLayouter.getCanvasRightBorder()) {
                    viewRect2.left += abstractLayouter.getCanvasRightBorder() - viewRect2.right;
                    viewRect2.right = abstractLayouter.getCanvasRightBorder();
                } else {
                    i += horizontalDifference;
                    viewRect2.right -= i;
                    viewRect2.left -= i;
                }
            }
        }
    }
}
