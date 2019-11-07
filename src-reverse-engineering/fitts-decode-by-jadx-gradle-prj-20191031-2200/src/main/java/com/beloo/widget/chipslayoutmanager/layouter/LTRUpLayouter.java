package com.beloo.widget.chipslayoutmanager.layouter;

import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;

class LTRUpLayouter extends AbstractLayouter implements ILayouter {

    public static final class Builder extends com.beloo.widget.chipslayoutmanager.layouter.AbstractLayouter.Builder {
        private Builder() {
        }

        @NonNull
        public LTRUpLayouter createLayouter() {
            return new LTRUpLayouter(this);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isReverseOrder() {
        return true;
    }

    private LTRUpLayouter(Builder builder) {
        super(builder);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* access modifiers changed from: 0000 */
    public Rect createViewRect(View view) {
        Rect rect = new Rect(this.viewRight - getCurrentViewWidth(), this.viewBottom - getCurrentViewHeight(), this.viewRight, this.viewBottom);
        this.viewRight = rect.left;
        return rect;
    }

    /* access modifiers changed from: 0000 */
    public void onPreLayout() {
        int canvasLeftBorder = this.viewRight - getCanvasLeftBorder();
        this.viewLeft = 0;
        for (Pair pair : this.rowViews) {
            Rect rect = (Rect) pair.first;
            rect.left -= canvasLeftBorder;
            rect.right -= canvasLeftBorder;
            this.viewLeft = Math.max(rect.right, this.viewLeft);
            this.viewTop = Math.min(this.viewTop, rect.top);
            this.viewBottom = Math.max(this.viewBottom, rect.bottom);
        }
    }

    /* access modifiers changed from: 0000 */
    public void onAfterLayout() {
        this.viewRight = getCanvasRightBorder();
        this.viewBottom = this.viewTop;
    }

    /* access modifiers changed from: 0000 */
    public boolean isAttachedViewFromNewRow(View view) {
        return this.viewTop >= getLayoutManager().getDecoratedBottom(view) && getLayoutManager().getDecoratedRight(view) > this.viewRight;
    }

    public void onInterceptAttachView(View view) {
        if (this.viewRight == getCanvasRightBorder() || this.viewRight - getCurrentViewWidth() >= getCanvasLeftBorder()) {
            this.viewRight = getLayoutManager().getDecoratedLeft(view);
        } else {
            this.viewRight = getCanvasRightBorder();
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
        return getCanvasRightBorder() - this.viewRight;
    }
}
