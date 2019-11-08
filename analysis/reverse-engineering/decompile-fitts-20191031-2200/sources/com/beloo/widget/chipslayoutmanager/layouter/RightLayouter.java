package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;

class RightLayouter extends AbstractLayouter {
    private boolean isPurged;

    public static final class Builder extends com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter.Builder {
        private Builder() {
        }

        @NonNull
        public RightLayouter createLayouter() {
            return new RightLayouter(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isReverseOrder() {
        return false;
    }

    private RightLayouter(Builder builder) {
        super(builder);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* access modifiers changed from: 0000 */
    public Rect createViewRect(View view) {
        int i = this.viewLeft;
        Rect rect = new Rect(i, this.viewTop, getCurrentViewWidth() + i, this.viewTop + getCurrentViewHeight());
        this.viewBottom = rect.bottom;
        this.viewTop = this.viewBottom;
        this.viewRight = Math.max(this.viewRight, rect.right);
        return rect;
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
        this.viewLeft = getViewRight();
        this.viewTop = getCanvasTopBorder();
    }

    /* access modifiers changed from: 0000 */
    public boolean isAttachedViewFromNewRow(View view) {
        return this.viewRight <= getLayoutManager().getDecoratedLeft(view) && getLayoutManager().getDecoratedTop(view) < this.viewTop;
    }

    /* access modifiers changed from: 0000 */
    public void onInterceptAttachView(View view) {
        this.viewTop = getLayoutManager().getDecoratedBottom(view);
        this.viewLeft = getLayoutManager().getDecoratedLeft(view);
        this.viewRight = Math.max(this.viewRight, getLayoutManager().getDecoratedRight(view));
    }

    public int getStartRowBorder() {
        return getViewLeft();
    }

    public int getEndRowBorder() {
        return getViewRight();
    }

    public int getRowLength() {
        return this.viewTop - getCanvasTopBorder();
    }
}
