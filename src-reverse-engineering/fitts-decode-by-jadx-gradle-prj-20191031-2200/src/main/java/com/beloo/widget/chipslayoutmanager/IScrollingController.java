package com.beloo.widget.chipslayoutmanager;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller;
import androidx.recyclerview.widget.RecyclerView.State;
import com.beloo.widget.chipslayoutmanager.anchor.AnchorViewState;

public interface IScrollingController {
    boolean canScrollHorizontally();

    boolean canScrollVertically();

    int computeHorizontalScrollExtent(State state);

    int computeHorizontalScrollOffset(State state);

    int computeHorizontalScrollRange(State state);

    int computeVerticalScrollExtent(State state);

    int computeVerticalScrollOffset(State state);

    int computeVerticalScrollRange(State state);

    SmoothScroller createSmoothScroller(@NonNull Context context, int i, int i2, AnchorViewState anchorViewState);

    boolean normalizeGaps(Recycler recycler, State state);

    int scrollHorizontallyBy(int i, Recycler recycler, State state);

    int scrollVerticallyBy(int i, Recycler recycler, State state);
}
