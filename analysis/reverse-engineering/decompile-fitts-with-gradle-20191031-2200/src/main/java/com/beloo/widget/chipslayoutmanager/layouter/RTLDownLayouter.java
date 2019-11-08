package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;

class RTLDownLayouter extends AbstractLayouter {
    private boolean isPurged;

    public static final class Builder extends com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter.Builder {
        private Builder() {
        }

        @NonNull
        public RTLDownLayouter createLayouter() {
            return new RTLDownLayouter(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isReverseOrder() {
        return false;
    }

    private RTLDownLayouter(Builder builder) {
        super(builder);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* access modifiers changed from: 0000 */
    public void onPreLayout() {
        if (!this.rowViews.isEmpty()) {
            if (!this.isPurged) {
                this.isPurged = true;
                getCacheStorage().purgeCacheFromPosition(getLayoutManager().getPosition((View) ((Pair) this.rowViews.get(0)).second));
            }
            getCacheStorage().storeRow(this.rowViews);
        }
    }

    /* access modifiers changed from: 0000 */
    public void onAfterLayout() {
        this.viewRight = getCanvasRightBorder();
        this.viewTop = this.viewBottom;
    }

    /* access modifiers changed from: 0000 */
    public boolean isAttachedViewFromNewRow(View view) {
        return this.viewBottom <= getLayoutManager().getDecoratedTop(view) && getLayoutManager().getDecoratedRight(view) > this.viewRight;
    }

    /* access modifiers changed from: 0000 */
    public Rect createViewRect(View view) {
        int currentViewWidth = this.viewRight - getCurrentViewWidth();
        int i = this.viewTop;
        Rect rect = new Rect(currentViewWidth, i, this.viewRight, getCurrentViewHeight() + i);
        this.viewRight = rect.left;
        this.viewBottom = Math.max(this.viewBottom, rect.bottom);
        return rect;
    }

    public void onInterceptAttachView(View view) {
        this.viewTop = getLayoutManager().getDecoratedTop(view);
        this.viewRight = getLayoutManager().getDecoratedLeft(view);
        this.viewBottom = Math.max(this.viewBottom, getLayoutManager().getDecoratedBottom(view));
    }

    public int getStartRowBorder() {
        return getViewTop();
    }

    public int getEndRowBorder() {
        return getViewBottom();
    }

    public int getRowLength() {
        return getCanvasRightBorder() - this.viewRight;
    }
}
