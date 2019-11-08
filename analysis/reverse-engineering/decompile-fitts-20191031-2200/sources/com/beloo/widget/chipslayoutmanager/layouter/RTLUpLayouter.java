package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;

class RTLUpLayouter extends AbstractLayouter implements ILayouter {

    public static final class Builder extends com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter.Builder {
        private Builder() {
        }

        @NonNull
        public RTLUpLayouter createLayouter() {
            return new RTLUpLayouter(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isReverseOrder() {
        return true;
    }

    private RTLUpLayouter(Builder builder) {
        super(builder);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* access modifiers changed from: 0000 */
    public void onPreLayout() {
        int i = -(getCanvasRightBorder() - this.viewLeft);
        this.viewLeft = this.rowViews.size() > 0 ? Integer.MAX_VALUE : 0;
        for (Pair pair : this.rowViews) {
            Rect rect = (Rect) pair.first;
            rect.left -= i;
            rect.right -= i;
            this.viewLeft = Math.min(this.viewLeft, rect.left);
            this.viewTop = Math.min(this.viewTop, rect.top);
            this.viewBottom = Math.max(this.viewBottom, rect.bottom);
        }
    }

    /* access modifiers changed from: 0000 */
    public void onAfterLayout() {
        this.viewLeft = getCanvasLeftBorder();
        this.viewBottom = this.viewTop;
    }

    /* access modifiers changed from: 0000 */
    public boolean isAttachedViewFromNewRow(View view) {
        return this.viewTop >= getLayoutManager().getDecoratedBottom(view) && getLayoutManager().getDecoratedLeft(view) < this.viewLeft;
    }

    /* access modifiers changed from: 0000 */
    public Rect createViewRect(View view) {
        int currentViewHeight = this.viewBottom - getCurrentViewHeight();
        Rect rect = new Rect(this.viewLeft, currentViewHeight, this.viewLeft + getCurrentViewWidth(), this.viewBottom);
        this.viewLeft = rect.right;
        return rect;
    }

    public void onInterceptAttachView(View view) {
        if (this.viewLeft == getCanvasLeftBorder() || this.viewLeft + getCurrentViewWidth() <= getCanvasRightBorder()) {
            this.viewLeft = getLayoutManager().getDecoratedRight(view);
        } else {
            this.viewLeft = getCanvasLeftBorder();
            this.viewBottom = this.viewTop;
        }
        this.viewTop = Math.min(this.viewTop, getLayoutManager().getDecoratedTop(view));
    }

    public int getStartRowBorder() {
        return getViewTop();
    }

    public int getEndRowBorder() {
        return getViewBottom();
    }

    public int getRowLength() {
        return getCanvasRightBorder() - this.viewLeft;
    }
}
