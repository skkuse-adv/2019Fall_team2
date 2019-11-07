package com.beloo.widget.chipslayoutmanager;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.beloo.widget.chipslayoutmanager.layouter.ICanvas;
import com.beloo.widget.chipslayoutmanager.layouter.IStateFactory;
import java.util.Iterator;
import java.util.List;

class DisappearingViewsManager implements IDisappearingViewsManager {
    private ICanvas canvas;
    private ChildViewsIterable childViews;
    private int deletingItemsOnScreenCount;
    private IStateFactory stateFactory;

    class DisappearingViewsContainer {
        /* access modifiers changed from: private */
        public SparseArray<View> backwardViews = new SparseArray<>();
        /* access modifiers changed from: private */
        public SparseArray<View> forwardViews = new SparseArray<>();

        DisappearingViewsContainer(DisappearingViewsManager disappearingViewsManager) {
        }

        /* access modifiers changed from: 0000 */
        public int size() {
            return this.backwardViews.size() + this.forwardViews.size();
        }

        /* access modifiers changed from: 0000 */
        public SparseArray<View> getBackwardViews() {
            return this.backwardViews;
        }

        /* access modifiers changed from: 0000 */
        public SparseArray<View> getForwardViews() {
            return this.forwardViews;
        }
    }

    DisappearingViewsManager(ICanvas iCanvas, ChildViewsIterable childViewsIterable, IStateFactory iStateFactory) {
        this.canvas = iCanvas;
        this.childViews = childViewsIterable;
        this.stateFactory = iStateFactory;
    }

    public DisappearingViewsContainer getDisappearingViews(Recycler recycler) {
        List<ViewHolder> scrapList = recycler.getScrapList();
        DisappearingViewsContainer disappearingViewsContainer = new DisappearingViewsContainer(this);
        for (ViewHolder viewHolder : scrapList) {
            View view = viewHolder.itemView;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (!layoutParams.isItemRemoved()) {
                if (layoutParams.getViewAdapterPosition() < this.canvas.getMinPositionOnScreen().intValue()) {
                    disappearingViewsContainer.backwardViews.put(layoutParams.getViewAdapterPosition(), view);
                } else if (layoutParams.getViewAdapterPosition() > this.canvas.getMaxPositionOnScreen().intValue()) {
                    disappearingViewsContainer.forwardViews.put(layoutParams.getViewAdapterPosition(), view);
                }
            }
        }
        return disappearingViewsContainer;
    }

    public int calcDisappearingViewsLength(Recycler recycler) {
        Integer valueOf = Integer.valueOf(Integer.MAX_VALUE);
        Integer valueOf2 = Integer.valueOf(Integer.MIN_VALUE);
        Iterator it = this.childViews.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            View view = (View) it.next();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (!layoutParams.isItemRemoved()) {
                int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(layoutParams.getViewLayoutPosition());
                if (convertPreLayoutPositionToPostLayout < this.canvas.getMinPositionOnScreen().intValue() || convertPreLayoutPositionToPostLayout > this.canvas.getMaxPositionOnScreen().intValue()) {
                    z = true;
                }
            }
            if (layoutParams.isItemRemoved() || z) {
                this.deletingItemsOnScreenCount++;
                valueOf = Integer.valueOf(Math.min(valueOf.intValue(), this.stateFactory.getStart(view)));
                valueOf2 = Integer.valueOf(Math.max(valueOf2.intValue(), this.stateFactory.getEnd(view)));
            }
        }
        if (valueOf.intValue() != Integer.MAX_VALUE) {
            return valueOf2.intValue() - valueOf.intValue();
        }
        return 0;
    }

    public int getDeletingItemsOnScreenCount() {
        return this.deletingItemsOnScreenCount;
    }

    public void reset() {
        this.deletingItemsOnScreenCount = 0;
    }
}
