package com.beloo.widget.chipslayoutmanager.layouter;

import androidx.annotation.CallSuper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorFinishedListener;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

public class MeasureSupporter extends AdapterDataObserver implements IMeasureSupporter {
    private int autoMeasureHeight = 0;
    private int autoMeasureWidth = 0;
    private Integer beforeRemovingHeight = null;
    private Integer beforeRemovingWidth = null;
    /* access modifiers changed from: private */
    public boolean isAfterRemoving;
    private boolean isRegistered;
    /* access modifiers changed from: private */
    public LayoutManager lm;
    private int measuredHeight;
    private int measuredWidth;

    public MeasureSupporter(LayoutManager layoutManager) {
        this.lm = layoutManager;
    }

    public void onSizeChanged() {
        this.autoMeasureWidth = this.lm.getWidth();
        this.autoMeasureHeight = this.lm.getHeight();
    }

    /* access modifiers changed from: 0000 */
    public boolean isAfterRemoving() {
        return this.isAfterRemoving;
    }

    public int getMeasuredWidth() {
        return this.measuredWidth;
    }

    private void setMeasuredWidth(int i) {
        this.measuredWidth = i;
    }

    public int getMeasuredHeight() {
        return this.measuredHeight;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public void setRegistered(boolean z) {
        this.isRegistered = z;
    }

    private void setMeasuredHeight(int i) {
        this.measuredHeight = i;
    }

    @CallSuper
    public void measure(int i, int i2) {
        if (isAfterRemoving()) {
            setMeasuredWidth(Math.max(i, this.beforeRemovingWidth.intValue()));
            setMeasuredHeight(Math.max(i2, this.beforeRemovingHeight.intValue()));
            return;
        }
        setMeasuredWidth(i);
        setMeasuredHeight(i2);
    }

    public void onItemsRemoved(final RecyclerView recyclerView) {
        this.lm.postOnAnimation(new Runnable() {
            /* access modifiers changed from: private */
            public void onFinished() {
                MeasureSupporter.this.isAfterRemoving = false;
                MeasureSupporter.this.lm.requestLayout();
            }

            public void run() {
                if (recyclerView.getItemAnimator() != null) {
                    recyclerView.getItemAnimator().isRunning(new ItemAnimatorFinishedListener() {
                        public void onAnimationsFinished() {
                            AnonymousClass1.this.onFinished();
                        }
                    });
                } else {
                    onFinished();
                }
            }
        });
    }

    @CallSuper
    public void onItemRangeRemoved(int i, int i2) {
        super.onItemRangeRemoved(i, i2);
        this.isAfterRemoving = true;
        this.beforeRemovingWidth = Integer.valueOf(this.autoMeasureWidth);
        this.beforeRemovingHeight = Integer.valueOf(this.autoMeasureHeight);
    }
}
