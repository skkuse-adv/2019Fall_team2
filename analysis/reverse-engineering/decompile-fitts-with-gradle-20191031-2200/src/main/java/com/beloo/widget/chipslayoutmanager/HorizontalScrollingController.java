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

class HorizontalScrollingController extends ScrollingController implements IScrollingController {
    /* access modifiers changed from: private */
    public ChipsLayoutManager layoutManager;

    public boolean canScrollVertically() {
        return false;
    }

    HorizontalScrollingController(ChipsLayoutManager chipsLayoutManager, IStateFactory iStateFactory, IScrollerListener iScrollerListener) {
        super(chipsLayoutManager, iStateFactory, iScrollerListener);
        this.layoutManager = chipsLayoutManager;
    }

    public SmoothScroller createSmoothScroller(@NonNull Context context, int i, int i2, AnchorViewState anchorViewState) {
        final AnchorViewState anchorViewState2 = anchorViewState;
        final int i3 = i;
        final int i4 = i2;
        AnonymousClass1 r0 = new LinearSmoothScroller(context) {
            public PointF computeScrollVectorForPosition(int i) {
                return new PointF(i3 > anchorViewState2.getPosition().intValue() ? 1.0f : -1.0f, 0.0f);
            }

            /* access modifiers changed from: protected */
            public void onTargetFound(View view, State state, Action action) {
                super.onTargetFound(view, state, action);
                action.update(HorizontalScrollingController.this.layoutManager.getDecoratedLeft(view) - HorizontalScrollingController.this.layoutManager.getPaddingLeft(), 0, i4, new LinearInterpolator());
            }
        };
        return r0;
    }

    public boolean canScrollHorizontally() {
        this.canvas.findBorderViews();
        if (this.layoutManager.getChildCount() <= 0) {
            return false;
        }
        int decoratedLeft = this.layoutManager.getDecoratedLeft(this.canvas.getLeftView());
        int decoratedRight = this.layoutManager.getDecoratedRight(this.canvas.getRightView());
        if (this.canvas.getMinPositionOnScreen().intValue() != 0 || this.canvas.getMaxPositionOnScreen().intValue() != this.layoutManager.getItemCount() - 1 || decoratedLeft < this.layoutManager.getPaddingLeft() || decoratedRight > this.layoutManager.getWidth() - this.layoutManager.getPaddingRight()) {
            return this.layoutManager.isScrollingEnabledContract();
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void offsetChildren(int i) {
        this.layoutManager.offsetChildrenHorizontal(i);
    }
}
