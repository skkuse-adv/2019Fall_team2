package com.paginate.recycler;

import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;

class WrapperSpanSizeLookup extends SpanSizeLookup {
    private final LoadingListItemSpanLookup loadingListItemSpanLookup;
    private final SpanSizeLookup wrappedSpanSizeLookup;
    private final WrapperAdapter wrapperAdapter;

    public WrapperSpanSizeLookup(SpanSizeLookup spanSizeLookup, LoadingListItemSpanLookup loadingListItemSpanLookup2, WrapperAdapter wrapperAdapter2) {
        this.wrappedSpanSizeLookup = spanSizeLookup;
        this.loadingListItemSpanLookup = loadingListItemSpanLookup2;
        this.wrapperAdapter = wrapperAdapter2;
    }

    public int getSpanSize(int i) {
        if (this.wrapperAdapter.isLoadingRow(i)) {
            return this.loadingListItemSpanLookup.getSpanSize();
        }
        return this.wrappedSpanSizeLookup.getSpanSize(i);
    }

    public SpanSizeLookup getWrappedSpanSizeLookup() {
        return this.wrappedSpanSizeLookup;
    }
}
