package com.beloo.widget.chipslayoutmanager.gravity;

import android.graphics.Rect;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter;
import com.beloo.widget.chipslayoutmanager.layouter.Item;
import java.util.List;

class LTRRowFillSpaceCenterDenseStrategy implements IRowStrategy {
    LTRRowFillSpaceCenterDenseStrategy() {
    }

    public void applyStrategy(AbstractLayouter abstractLayouter, List<Item> list) {
        int horizontalDifference = GravityUtil.getHorizontalDifference(abstractLayouter) / 2;
        for (Item viewRect : list) {
            Rect viewRect2 = viewRect.getViewRect();
            viewRect2.left += horizontalDifference;
            viewRect2.right += horizontalDifference;
        }
    }
}
