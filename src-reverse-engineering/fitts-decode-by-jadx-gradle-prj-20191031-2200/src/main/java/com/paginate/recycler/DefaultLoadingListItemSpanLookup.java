package com.paginate.recycler;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

class DefaultLoadingListItemSpanLookup implements LoadingListItemSpanLookup {
    private final int loadingListItemSpan;

    public DefaultLoadingListItemSpanLookup(LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            this.loadingListItemSpan = ((GridLayoutManager) layoutManager).getSpanCount();
        } else {
            this.loadingListItemSpan = 1;
        }
    }

    public int getSpanSize() {
        return this.loadingListItemSpan;
    }
}
