package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;

class LeftLayouter extends AbstractLayouter {

    public static final class Builder extends com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter.Builder {
        private Builder() {
        }

        @NonNull
        public LeftLayouter createLayouter() {
            return new LeftLayouter(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isReverseOrder() {
        return true;
    }

    private LeftLayouter(Builder builder) {
        super(builder);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* access modifiers changed from: 0000 */
    public Rect createViewRect(View view) {
        Rect rect = new Rect(this.viewRight - getCurrentViewWidth(), this.viewBottom - getCurrentViewHeight(), this.viewRight, this.viewBottom);
        this.viewBottom = rect.top;
        return rect;
    }

    /* access modifiers changed from: 0000 */
    public void onPreLayout() {
        int canvasTopBorder = this.viewBottom - getCanvasTopBorder();
        this.viewBottom = 0;
        for (Pair pair : this.rowViews) {
            Rect rect = (Rect) pair.first;
            rect.top -= canvasTopBorder;
            rect.bottom -= canvasTopBorder;
            this.viewBottom = Math.max(this.viewBottom, rect.bottom);
            this.viewLeft = Math.min(this.viewLeft, rect.left);
            this.viewRight = Math.max(this.viewRight, rect.right);
        }
    }

    /* access modifiers changed from: 0000 */
    public void onAfterLayout() {
        this.viewBottom = getCanvasBottomBorder();
        this.viewRight = this.viewLeft;
    }

    /* access modifiers changed from: 0000 */
    public boolean isAttachedViewFromNewRow(View view) {
        return this.viewLeft >= getLayoutManager().getDecoratedRight(view) && getLayoutManager().getDecoratedBottom(view) > this.viewBottom;
    }

    /* access modifiers changed from: 0000 */
    public void onInterceptAttachView(View view) {
        if (this.viewBottom == getCanvasBottomBorder() || this.viewBottom - getCurrentViewHeight() >= getCanvasTopBorder()) {
            this.viewBottom = getLayoutManager().getDecoratedTop(view);
        } else {
            this.viewBottom = getCanvasBottomBorder();
            this.viewRight = this.viewLeft;
        }
        this.viewLeft = Math.min(this.viewLeft, getLayoutManager().getDecoratedLeft(view));
    }

    public int getStartRowBorder() {
        return getViewLeft();
    }

    public int getEndRowBorder() {
        return getViewRight();
    }

    public int getRowLength() {
        return this.viewBottom - getCanvasTopBorder();
    }
}
