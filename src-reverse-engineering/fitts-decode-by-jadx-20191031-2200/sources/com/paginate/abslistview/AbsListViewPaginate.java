package com.paginate.abslistview;

import android.database.DataSetObserver;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.HeaderViewListAdapter;
import com.paginate.Paginate;
import com.paginate.Paginate.Callbacks;
import com.paginate.abslistview.EndScrollListener.Callback;

public final class AbsListViewPaginate extends Paginate implements Callback {
    private final AbsListView absListView;
    /* access modifiers changed from: private */
    public final Callbacks callbacks;
    private final DataSetObserver dataSetObserver = new DataSetObserver() {
        public void onChanged() {
            AbsListViewPaginate.this.wrapperAdapter.displayLoadingRow(!AbsListViewPaginate.this.callbacks.hasLoadedAllItems());
            AbsListViewPaginate.this.wrapperAdapter.notifyDataSetChanged();
        }

        public void onInvalidated() {
            AbsListViewPaginate.this.wrapperAdapter.displayLoadingRow(!AbsListViewPaginate.this.callbacks.hasLoadedAllItems());
            AbsListViewPaginate.this.wrapperAdapter.notifyDataSetInvalidated();
        }
    };
    private EndScrollListener scrollListener;
    /* access modifiers changed from: private */
    public WrapperAdapter wrapperAdapter;

    public static class Builder {
        private final AbsListView absListView;
        private boolean addLoadingListItem = true;
        private final Callbacks callbacks;
        private LoadingListItemCreator loadingListItemCreator;
        private int loadingTriggerThreshold = 5;
        private OnScrollListener onScrollListener;

        public Builder(AbsListView absListView2, Callbacks callbacks2) {
            this.absListView = absListView2;
            this.callbacks = callbacks2;
        }

        public Builder setLoadingTriggerThreshold(int i) {
            this.loadingTriggerThreshold = i;
            return this;
        }

        public Builder setOnScrollListener(OnScrollListener onScrollListener2) {
            this.onScrollListener = onScrollListener2;
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

        public Paginate build() {
            if (this.absListView.getAdapter() != null) {
                if (this.loadingListItemCreator == null) {
                    this.loadingListItemCreator = LoadingListItemCreator.DEFAULT;
                }
                AbsListViewPaginate absListViewPaginate = new AbsListViewPaginate(this.absListView, this.callbacks, this.loadingTriggerThreshold, this.onScrollListener, this.addLoadingListItem, this.loadingListItemCreator);
                return absListViewPaginate;
            }
            throw new IllegalStateException("Adapter needs to be set!");
        }
    }

    AbsListViewPaginate(AbsListView absListView2, Callbacks callbacks2, int i, OnScrollListener onScrollListener, boolean z, LoadingListItemCreator loadingListItemCreator) {
        BaseAdapter baseAdapter;
        this.absListView = absListView2;
        this.callbacks = callbacks2;
        this.scrollListener = new EndScrollListener(this);
        this.scrollListener.setThreshold(i);
        this.scrollListener.setDelegate(onScrollListener);
        absListView2.setOnScrollListener(this.scrollListener);
        if (z) {
            if (absListView2.getAdapter() instanceof BaseAdapter) {
                baseAdapter = (BaseAdapter) absListView2.getAdapter();
            } else if (absListView2.getAdapter() instanceof HeaderViewListAdapter) {
                baseAdapter = (BaseAdapter) ((HeaderViewListAdapter) absListView2.getAdapter()).getWrappedAdapter();
            } else {
                throw new IllegalStateException("Adapter needs to be subclass of BaseAdapter");
            }
            this.wrapperAdapter = new WrapperAdapter(baseAdapter, loadingListItemCreator);
            baseAdapter.registerDataSetObserver(this.dataSetObserver);
            absListView2.setAdapter(this.wrapperAdapter);
        }
    }

    public void setHasMoreDataToLoad(boolean z) {
        WrapperAdapter wrapperAdapter2 = this.wrapperAdapter;
        if (wrapperAdapter2 != null) {
            wrapperAdapter2.displayLoadingRow(z);
        }
    }

    public void onEndReached() {
        if (!this.callbacks.isLoading() && !this.callbacks.hasLoadedAllItems()) {
            this.callbacks.onLoadMore();
        }
    }

    public void unbind() {
        this.absListView.setOnScrollListener(this.scrollListener.getDelegateScrollListener());
        if (this.absListView.getAdapter() instanceof WrapperAdapter) {
            BaseAdapter baseAdapter = (BaseAdapter) ((WrapperAdapter) this.absListView.getAdapter()).getWrappedAdapter();
            baseAdapter.unregisterDataSetObserver(this.dataSetObserver);
            this.absListView.setAdapter(baseAdapter);
        }
    }
}
