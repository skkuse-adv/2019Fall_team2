package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;
import com.beloo.widget.chipslayoutmanager.layouter.Item;
import java.util.List;

class LTRRowFillSpaceCenterStrategy implements IRowStrategy {
    LTRRowFillSpaceCenterStrategy() {
    }

    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> list) {
        int horizontalDifference = GravityUtil.getHorizontalDifference(abstractLayouter) / (abstractLayouter.getRowSize() + 1);
        int i = 0;
        for (Item viewRect : list) {
            Rect viewRect2 = viewRect.getViewRect();
            i += horizontalDifference;
            viewRect2.left += i;
            viewRect2.right += i;
        }
    }
}
