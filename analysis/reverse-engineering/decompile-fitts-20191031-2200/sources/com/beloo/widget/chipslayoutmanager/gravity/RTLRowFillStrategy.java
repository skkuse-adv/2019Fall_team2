package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;
import com.beloo.widget.chipslayoutmanager.layouter.Item;
import java.util.List;

class RTLRowFillStrategy implements IRowStrategy {
    RTLRowFillStrategy() {
    }

    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> list) {
        int horizontalDifference = GravityUtil.getHorizontalDifference(abstractLayouter) / abstractLayouter.getRowSize();
        int i = horizontalDifference;
        for (Item viewRect : list) {
            Rect viewRect2 = viewRect.getViewRect();
            if (viewRect2.right == abstractLayouter.getCanvasRightBorder()) {
                viewRect2.left += abstractLayouter.getCanvasRightBorder() - viewRect2.right;
                viewRect2.right = abstractLayouter.getCanvasRightBorder();
                viewRect2.left -= i;
            } else {
                viewRect2.right -= i;
                i += horizontalDifference;
                viewRect2.left -= i;
            }
        }
    }
}
