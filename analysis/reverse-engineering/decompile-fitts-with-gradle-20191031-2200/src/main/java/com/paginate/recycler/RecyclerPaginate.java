package com.paginate.recycler;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.paginate.Paginate;
import com.paginate.Paginate.Callbacks;

public final class RecyclerPaginate extends Paginate {
    private final Callbacks callbacks;
    private final int loadingTriggerThreshold;
    private final AdapterDataObserver mDataObserver = new AdapterDataObserver() {
        public void onChanged() {
            RecyclerPaginate.this.wrapperAdapter.notifyDataSetChanged();
            RecyclerPaginate.this.onAdapterDataChanged();
        }

        public void onItemRangeInserted(int i, int i2) {
            RecyclerPaginate.this.wrapperAdapter.notifyItemRangeInserted(i, i2);
            RecyclerPaginate.this.onAdapterDataChanged();
        }

        public void onItemRangeChanged(int i, int i2) {
            RecyclerPaginate.this.wrapperAdapter.notifyItemRangeChanged(i, i2);
            RecyclerPaginate.this.onAdapterDataChanged();
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerPaginate.this.wrapperAdapter.notifyItemRangeChanged(i, i2, obj);
            RecyclerPaginate.this.onAdapterDataChanged();
        }

        public void onItemRangeRemoved(int i, int i2) {
            RecyclerPaginate.this.wrapperAdapter.notifyItemRangeRemoved(i, i2);
            RecyclerPaginate.this.onAdapterDataChanged();
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerPaginate.this.wrapperAdapter.notifyItemMoved(i, i2);
            RecyclerPaginate.this.onAdapterDataChanged();
        }
    };
    private final OnScrollListener mOnScrollListener = new OnScrollListener() {
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            RecyclerPaginate.this.checkEndOffset();
        }
    };
    private final RecyclerView recyclerView;
    /* access modifiers changed from: private */
    public WrapperAdapter wrapperAdapter;
    private WrapperSpanSizeLookup wrapperSpanSizeLookup;

    public static class Builder {
        private boolean addLoadingListItem = true;
        private final Callbacks callbacks;
        private LoadingListItemCreator loadingListItemCreator;
        private LoadingListItemSpanLookup loadingListItemSpanLookup;
        private int loadingTriggerThreshold = 5;
        private final RecyclerView recyclerView;

        public Builder(RecyclerView recyclerView2, Callbacks callbacks2) {
            this.recyclerView = recyclerView2;
            this.callbacks = callbacks2;
        }

        public Builder setLoadingTriggerThreshold(int i) {
            this.loadingTriggerThreshold = i;
            return this;
        }

        public Builder addLoadingListItem(boolean z) {
            this.addLoadingListItem = z;
            return this;
        }

        public Builder setLoadingListItemCreator(LoadingListItemCreator loadingListItemCreator2) {
            this.loadingListItemCreator = loadingListItemCreator2;
            return this;
        }

        public Builder setLoadingListItemSpanSizeLookup(LoadingListItemSpanLookup loadingListItemSpanLookup2) {
            this.loadingListItemSpanLookup = loadingListItemSpanLookup2;
            return this;
        }

        public Paginate build() {
            if (this.recyclerView.getAdapter() == null) {
                throw new IllegalStateException("Adapter needs to be set!");
            } else if (this.recyclerView.getLayoutManager() != null) {
                if (this.loadingListItemCreator == null) {
                    this.loadingListItemCreator = LoadingListItemCreator.DEFAULT;
                }
                if (this.loadingListItemSpanLookup == null) {
                    this.loadingListItemSpanLookup = new DefaultLoadingListItemSpanLookup(this.recyclerView.getLayoutManager());
                }
                RecyclerPaginate recyclerPaginate = new RecyclerPaginate(this.recyclerView, this.callbacks, this.loadingTriggerThreshold, this.addLoadingListItem, this.loadingListItemCreator, this.loadingListItemSpanLookup);
                return recyclerPaginate;
            } else {
                throw new IllegalStateException("LayoutManager needs to be set on the RecyclerView");
            }
        }
    }

    RecyclerPaginate(RecyclerView recyclerView2, Callbacks callbacks2, int i, boolean z, LoadingListItemCreator loadingListItemCreator, LoadingListItemSpanLookup loadingListItemSpanLookup) {
        this.recyclerView = recyclerView2;
        this.callbacks = callbacks2;
        this.loadingTriggerThreshold = i;
        recyclerView2.addOnScrollListener(this.mOnScrollListener);
        if (z) {
            Adapter adapter = recyclerView2.getAdapter();
            this.wrapperAdapter = new WrapperAdapter(adapter, loadingListItemCreator);
            adapter.registerAdapterDataObserver(this.mDataObserver);
            recyclerView2.setAdapter(this.wrapperAdapter);
            if (recyclerView2.getLayoutManager() instanceof GridLayoutManager) {
                this.wrapperSpanSizeLookup = new WrapperSpanSizeLookup(((GridLayoutManager) recyclerView2.getLayoutManager()).getSpanSizeLookup(), loadingListItemSpanLookup, this.wrapperAdapter);
                ((GridLayoutManager) recyclerView2.getLayoutManager()).setSpanSizeLookup(this.wrapperSpanSizeLookup);
            }
        }
        checkEndOffset();
    }

    public void setHasMoreDataToLoad(boolean z) {
        WrapperAdapter wrapperAdapter2 = this.wrapperAdapter;
        if (wrapperAdapter2 != null) {
            wrapperAdapter2.displayLoadingRow(z);
        }
    }

    public void unbind() {
        this.recyclerView.removeOnScrollListener(this.mOnScrollListener);
        if (this.recyclerView.getAdapter() instanceof WrapperAdapter) {
            Adapter wrappedAdapter = ((WrapperAdapter) this.recyclerView.getAdapter()).getWrappedAdapter();
            wrappedAdapter.unregisterAdapterDataObserver(this.mDataObserver);
            this.recyclerView.setAdapter(wrappedAdapter);
        }
        if (this.recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            WrapperSpanSizeLookup wrapperSpanSizeLookup2 = this.wrapperSpanSizeLookup;
            if (wrapperSpanSizeLookup2 != null) {
                ((GridLayoutManager) this.recyclerView.getLayoutManager()).setSpanSizeLookup(wrapperSpanSizeLookup2.getWrappedSpanSizeLookup());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void checkEndOffset() {
        int childCount = this.recyclerView.getChildCount();
        int itemCount = this.recyclerView.getLayoutManager().getItemCount();
        int i = 0;
        if (this.recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            i = ((LinearLayoutManager) this.recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        } else if (!(this.recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager)) {
            throw new IllegalStateException("LayoutManager needs to subclass LinearLayoutManager or StaggeredGridLayoutManager");
        } else if (this.recyclerView.getLayoutManager().getChildCount() > 0) {
            i = ((StaggeredGridLayoutManager) this.recyclerView.getLayoutManager()).findFirstVisibleItemPositions(null)[0];
        }
        if ((itemCount - childCount <= i + this.loadingTriggerThreshold || itemCount == 0) && !this.callbacks.isLoading() && !this.callbacks.hasLoadedAllItems()) {
            this.callbacks.onLoadMore();
        }
    }

    /* access modifiers changed from: private */
    public void onAdapterDataChanged() {
        this.wrapperAdapter.displayLoadingRow(!this.callbacks.hasLoadedAllItems());
        checkEndOffset();
    }
}
