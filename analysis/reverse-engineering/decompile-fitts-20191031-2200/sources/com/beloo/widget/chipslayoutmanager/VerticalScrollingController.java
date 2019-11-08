package com.beloo.widget.chipslayoutmanager;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.Action;
import androidx.recyclerview.widget.RecyclerView.State;
import com.beloo.widget.chipslayoutmanager.anchor.AnchorViewState;
import com.beloo.widget.chipslayoutmanager.layouter.IStateFactory;

class VerticalScrollingController extends ScrollingController implements IScrollingController {
    /* access modifiers changed from: private */
    public ChipsLayoutManager lm;

    public boolean canScrollHorizontally() {
        return false;
    }

    VerticalScrollingController(ChipsLayoutManager chipsLayoutManager, IStateFactory iStateFactory, IScrollerListener iScrollerListener) {
        super(chipsLayoutManager, iStateFactory, iScrollerListener);
        this.lm = chipsLayoutManager;
    }

    public SmoothScroller createSmoothScroller(@NonNull Context context, int i, int i2, AnchorViewState anchorViewState) {
        final AnchorViewState anchorViewState2 = anchorViewState;
        final int i3 = i;
        final int i4 = i2;
        AnonymousClass1 r0 = new LinearSmoothScroller(context) {
            public PointF computeScrollVectorForPosition(int i) {
                return new PointF(0.0f, i3 > anchorViewState2.getPosition().intValue() ? 1.0f : -1.0f);
            }

            /* access modifiers changed from: protected */
            public void onTargetFound(View view, State state, Action action) {
                super.onTargetFound(view, state, action);
                action.update(0, VerticalScrollingController.this.lm.getDecoratedTop(view) - VerticalScrollingController.this.lm.getPaddingTop(), i4, new LinearInterpolator());
            }
        };
        return r0;
    }

    public boolean canScrollVertically() {
        this.canvas.findBorderViews();
        if (this.lm.getChildCount() <= 0) {
            return false;
        }
        int decoratedTop = this.lm.getDecoratedTop(this.canvas.getTopView());
        int decoratedBottom = this.lm.getDecoratedBottom(this.canvas.getBottomView());
        if (this.canvas.getMinPositionOnScreen().intValue() != 0 || this.canvas.getMaxPositionOnScreen().intValue() != this.lm.getItemCount() - 1 || decoratedTop < this.lm.getPaddingTop() || decoratedBottom > this.lm.getHeight() - this.lm.getPaddingBottom()) {
            return this.lm.isScrollingEnabledContract();
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void offsetChildren(int i) {
        this.lm.offsetChildrenVertical(i);
    }
}
