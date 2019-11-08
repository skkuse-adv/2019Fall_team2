package com.beloo.widget.chipslayoutmanager;

import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.State;
import com.beloo.widget.chipslayoutmanager.anchor.AnchorViewState;
import com.beloo.widget.chipslayoutmanager.layouter.ICanvas;
import com.beloo.widget.chipslayoutmanager.layouter.IStateFactory;

abstract class ScrollingController implements IScrollingController {
    ICanvas canvas;
    private ChipsLayoutManager lm;
    private IScrollerListener scrollerListener;
    private IStateFactory stateFactory;

    interface IScrollerListener {
        void onScrolled(IScrollingController iScrollingController, Recycler recycler, State state);
    }

    /* access modifiers changed from: 0000 */
    public abstract void offsetChildren(int i);

    ScrollingController(ChipsLayoutManager chipsLayoutManager, IStateFactory iStateFactory, IScrollerListener iScrollerListener) {
        this.lm = chipsLayoutManager;
        this.scrollerListener = iScrollerListener;
        this.stateFactory = iStateFactory;
        this.canvas = chipsLayoutManager.getCanvas();
    }

    /* access modifiers changed from: 0000 */
    public final int calculateEndGap() {
        if (this.lm.getChildCount() == 0 || this.lm.getCompletelyVisibleViewsCount() == this.lm.getItemCount()) {
            return 0;
        }
        int endAfterPadding = this.stateFactory.getEndAfterPadding() - this.stateFactory.getEndViewBound();
        if (endAfterPadding < 0) {
            return 0;
        }
        return endAfterPadding;
    }

    /* access modifiers changed from: 0000 */
    public final int calculateStartGap() {
        if (this.lm.getChildCount() == 0) {
            return 0;
        }
        int startViewBound = this.stateFactory.getStartViewBound() - this.stateFactory.getStartAfterPadding();
        if (startViewBound < 0) {
            return 0;
        }
        return startViewBound;
    }

    public final boolean normalizeGaps(Recycler recycler, State state) {
        int calculateStartGap = calculateStartGap();
        if (calculateStartGap > 0) {
            offsetChildren(-calculateStartGap);
            return true;
        }
        int calculateEndGap = calculateEndGap();
        if (calculateEndGap <= 0) {
            return false;
        }
        scrollBy(-calculateEndGap, recycler, state);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public final int calcOffset(int i) {
        int i2 = 0;
        if (this.lm.getChildCount() == 0) {
            return 0;
        }
        if (i < 0) {
            i2 = onContentScrolledBackward(i);
        } else if (i > 0) {
            i2 = onContentScrolledForward(i);
        }
        return i2;
    }

    /* access modifiers changed from: 0000 */
    public final int onContentScrolledBackward(int i) {
        AnchorViewState anchor = this.lm.getAnchor();
        if (anchor.getAnchorViewRect() == null) {
            return 0;
        }
        if (anchor.getPosition().intValue() == 0) {
            int start = this.stateFactory.getStart(anchor) - this.stateFactory.getStartAfterPadding();
            if (start >= 0) {
                i = start;
            } else {
                i = Math.max(start, i);
            }
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    public final int onContentScrolledForward(int i) {
        return this.lm.getPosition(this.lm.getChildAt(this.lm.getChildCount() + -1)) < this.lm.getItemCount() + -1 ? i : Math.min(this.stateFactory.getEndViewBound() - this.stateFactory.getEndAfterPadding(), i);
    }

    public final int scrollHorizontallyBy(int i, Recycler recycler, State state) {
        if (canScrollHorizontally()) {
            return scrollBy(i, recycler, state);
        }
        return 0;
    }

    public final int scrollVerticallyBy(int i, Recycler recycler, State state) {
        if (canScrollVertically()) {
            return scrollBy(i, recycler, state);
        }
        return 0;
    }

    private int scrollBy(int i, Recycler recycler, State state) {
        int calcOffset = calcOffset(i);
        offsetChildren(-calcOffset);
        this.scrollerListener.onScrolled(this, recycler, state);
        return calcOffset;
    }

    private int getLaidOutArea() {
        return this.stateFactory.getEndViewBound() - this.stateFactory.getStartViewBound();
    }

    private int computeScrollOffset(State state) {
        if (this.lm.getChildCount() == 0 || state.getItemCount() == 0) {
            return 0;
        }
        int findFirstVisibleItemPosition = this.lm.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.lm.findLastVisibleItemPosition();
        int max = Math.max(0, findFirstVisibleItemPosition);
        if (!this.lm.isSmoothScrollbarEnabled()) {
            return max;
        }
        return Math.round((((float) max) * (((float) getLaidOutArea()) / ((float) (Math.abs(findFirstVisibleItemPosition - findLastVisibleItemPosition) + 1)))) + ((float) (this.stateFactory.getStartAfterPadding() - this.stateFactory.getStartViewBound())));
    }

    private int computeScrollExtent(State state) {
        if (this.lm.getChildCount() == 0 || state.getItemCount() == 0) {
            return 0;
        }
        int findFirstVisibleItemPosition = this.lm.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.lm.findLastVisibleItemPosition();
        if (!this.lm.isSmoothScrollbarEnabled()) {
            return Math.abs(findLastVisibleItemPosition - findFirstVisibleItemPosition) + 1;
        }
        return Math.min(this.stateFactory.getTotalSpace(), getLaidOutArea());
    }

    private int computeScrollRange(State state) {
        if (this.lm.getChildCount() == 0 || state.getItemCount() == 0) {
            return 0;
        }
        if (!this.lm.isSmoothScrollbarEnabled()) {
            return state.getItemCount();
        }
        return (int) ((((float) getLaidOutArea()) / ((float) (Math.abs(this.lm.findFirstVisibleItemPosition() - this.lm.findLastVisibleItemPosition()) + 1))) * ((float) state.getItemCount()));
    }

    public final int computeVerticalScrollExtent(State state) {
        if (canScrollVertically()) {
            return computeScrollExtent(state);
        }
        return 0;
    }

    public final int computeVerticalScrollRange(State state) {
        if (canScrollVertically()) {
            return computeScrollRange(state);
        }
        return 0;
    }

    public final int computeVerticalScrollOffset(State state) {
        if (canScrollVertically()) {
            return computeScrollOffset(state);
        }
        return 0;
    }

    public final int computeHorizontalScrollRange(State state) {
        if (canScrollHorizontally()) {
            return computeScrollRange(state);
        }
        return 0;
    }

    public final int computeHorizontalScrollOffset(State state) {
        if (canScrollHorizontally()) {
            return computeScrollOffset(state);
        }
        return 0;
    }

    public final int computeHorizontalScrollExtent(State state) {
        if (canScrollHorizontally()) {
            return computeScrollExtent(state);
        }
        return 0;
    }
}
