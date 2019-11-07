package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;

class LTRDownLayouter extends AbstractLayouter {
    private boolean isPurged;

    public static final class Builder extends com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter.Builder {
        private Builder() {
        }

        @NonNull
        public LTRDownLayouter createLayouter() {
            return new LTRDownLayouter(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isReverseOrder() {
        return false;
    }

    private LTRDownLayouter(Builder builder) {
        super(builder);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* access modifiers changed from: 0000 */
    public Rect createViewRect(View view) {
        int i = this.viewLeft;
        Rect rect = new Rect(i, this.viewTop, getCurrentViewWidth() + i, this.viewTop + getCurrentViewHeight());
        this.viewLeft = rect.right;
        this.viewBottom = Math.max(this.viewBottom, rect.bottom);
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
        this.viewLeft = getCanvasLeftBorder();
        this.viewTop = this.viewBottom;
    }

    /* access modifiers changed from: 0000 */
    public boolean isAttachedViewFromNewRow(View view) {
        return this.viewBottom <= getLayoutManager().getDecoratedTop(view) && getLayoutManager().getDecoratedLeft(view) < this.viewLeft;
    }

    public void onInterceptAttachView(View view) {
        this.viewTop = getLayoutManager().getDecoratedTop(view);
        this.viewLeft = getLayoutManager().getDecoratedRight(view);
        this.viewBottom = Math.max(this.viewBottom, getLayoutManager().getDecoratedBottom(view));
    }

    public int getStartRowBorder() {
        return getViewTop();
    }

    public int getEndRowBorder() {
        return getViewBottom();
    }

    public int getRowLength() {
        return this.viewLeft - getCanvasLeftBorder();
    }
}
