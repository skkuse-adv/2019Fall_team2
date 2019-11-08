package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.beloo.widget.chipslayoutmanager.anchor.AnchorViewState;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter.Builder;

class RTLRowsCreator implements ILayouterCreator {
    private LayoutManager layoutManager;

    RTLRowsCreator(LayoutManager layoutManager2) {
        this.layoutManager = layoutManager2;
    }

    public Rect createOffsetRectForBackwardLayouter(AnchorViewState anchorViewState) {
        Rect anchorViewRect = anchorViewState.getAnchorViewRect();
        return new Rect(anchorViewRect == null ? 0 : anchorViewRect.right, anchorViewRect == null ? 0 : anchorViewRect.top, 0, anchorViewRect == null ? 0 : anchorViewRect.bottom);
    }

    public Builder createBackwardBuilder() {
        return RTLUpLayouter.newBuilder();
    }

    public Builder createForwardBuilder() {
        return RTLDownLayouter.newBuilder();
    }

    public Rect createOffsetRectForForwardLayouter(AnchorViewState anchorViewState) {
        Rect anchorViewRect = anchorViewState.getAnchorViewRect();
        int i = anchorViewRect == null ? anchorViewState.getPosition().intValue() == 0 ? this.layoutManager.getPaddingTop() : 0 : anchorViewRect.top;
        int paddingRight = anchorViewRect == null ? this.layoutManager.getPaddingRight() : anchorViewRect.right;
        int i2 = anchorViewRect == null ? anchorViewState.getPosition().intValue() == 0 ? this.layoutManager.getPaddingBottom() : 0 : anchorViewRect.bottom;
        return new Rect(0, i, paddingRight, i2);
    }
}
