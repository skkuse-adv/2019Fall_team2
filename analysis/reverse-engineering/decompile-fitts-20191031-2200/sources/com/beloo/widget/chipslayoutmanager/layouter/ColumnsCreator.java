package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.beloo.widget.chipslayoutmanager.anchor.AnchorViewState;
import com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter.Builder;

class ColumnsCreator implements ILayouterCreator {
    private LayoutManager layoutManager;

    ColumnsCreator(LayoutManager layoutManager2) {
        this.layoutManager = layoutManager2;
    }

    public Builder createBackwardBuilder() {
        return LeftLayouter.newBuilder();
    }

    public Builder createForwardBuilder() {
        return RightLayouter.newBuilder();
    }

    public Rect createOffsetRectForBackwardLayouter(@NonNull AnchorViewState anchorViewState) {
        Rect anchorViewRect = anchorViewState.getAnchorViewRect();
        return new Rect(anchorViewRect == null ? 0 : anchorViewRect.left, 0, anchorViewRect == null ? 0 : anchorViewRect.right, anchorViewRect == null ? 0 : anchorViewRect.top);
    }

    public Rect createOffsetRectForForwardLayouter(@NonNull AnchorViewState anchorViewState) {
        Rect anchorViewRect = anchorViewState.getAnchorViewRect();
        int i = anchorViewRect == null ? anchorViewState.getPosition().intValue() == 0 ? this.layoutManager.getPaddingLeft() : 0 : anchorViewRect.left;
        int paddingTop = anchorViewRect == null ? this.layoutManager.getPaddingTop() : anchorViewRect.top;
        int i2 = anchorViewRect == null ? anchorViewState.getPosition().intValue() == 0 ? this.layoutManager.getPaddingRight() : 0 : anchorViewRect.right;
        return new Rect(i, paddingTop, i2, 0);
    }
}
