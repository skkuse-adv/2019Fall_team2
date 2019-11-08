package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.beloo.widget.chipslayoutmanager.anchor.AnchorViewState;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter.Builder;

class LTRRowsCreator implements ILayouterCreator {
    private LayoutManager layoutManager;

    LTRRowsCreator(LayoutManager layoutManager2) {
        this.layoutManager = layoutManager2;
    }

    public Rect createOffsetRectForBackwardLayouter(AnchorViewState anchorViewState) {
        Rect anchorViewRect = anchorViewState.getAnchorViewRect();
        return new Rect(0, anchorViewRect == null ? 0 : anchorViewRect.top, anchorViewRect == null ? 0 : anchorViewRect.left, anchorViewRect == null ? 0 : anchorViewRect.bottom);
    }

    public Rect createOffsetRectForForwardLayouter(AnchorViewState anchorViewState) {
        Rect anchorViewRect = anchorViewState.getAnchorViewRect();
        int paddingLeft = anchorViewRect == null ? this.layoutManager.getPaddingLeft() : anchorViewRect.left;
        int i = anchorViewRect == null ? anchorViewState.getPosition().intValue() == 0 ? this.layoutManager.getPaddingTop() : 0 : anchorViewRect.top;
        int i2 = anchorViewRect == null ? anchorViewState.getPosition().intValue() == 0 ? this.layoutManager.getPaddingBottom() : 0 : anchorViewRect.bottom;
        return new Rect(paddingLeft, i, 0, i2);
    }

    public Builder createBackwardBuilder() {
        return LTRUpLayouter.newBuilder();
    }

    public Builder createForwardBuilder() {
        return LTRDownLayouter.newBuilder();
    }
}
