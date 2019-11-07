package com.beloo.widget.chipslayoutmanager;

import androidx.recyclerview.widget.RecyclerView.Recycler;

interface IDisappearingViewsManager {
    int calcDisappearingViewsLength(Recycler recycler);

    int getDeletingItemsOnScreenCount();

    DisappearingViewsContainer getDisappearingViews(Recycler recycler);

    void reset();
}
