package com.bumptech.glide.integration.recyclerview;

import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

public final class RecyclerToListViewScrollListener extends OnScrollListener {
    public static final int UNKNOWN_SCROLL_STATE = Integer.MIN_VALUE;
    private int lastFirstVisible = -1;
    private int lastItemCount = -1;
    private int lastVisibleCount = -1;
    private final AbsListView.OnScrollListener scrollListener;

    public RecyclerToListViewScrollListener(@NonNull AbsListView.OnScrollListener onScrollListener) {
        this.scrollListener = onScrollListener;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        int i2 = 2;
        if (i == 0) {
            i2 = 0;
        } else if (i == 1) {
            i2 = 1;
        } else if (i != 2) {
            i2 = Integer.MIN_VALUE;
        }
        this.scrollListener.onScrollStateChanged(null, i2);
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int abs = Math.abs(findFirstVisibleItemPosition - linearLayoutManager.findLastVisibleItemPosition());
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (findFirstVisibleItemPosition != this.lastFirstVisible || abs != this.lastVisibleCount || itemCount != this.lastItemCount) {
            this.scrollListener.onScroll(null, findFirstVisibleItemPosition, abs, itemCount);
            this.lastFirstVisible = findFirstVisibleItemPosition;
            this.lastVisibleCount = abs;
            this.lastItemCount = itemCount;
        }
    }
}
