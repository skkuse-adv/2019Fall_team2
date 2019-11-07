package com.paginate;

import android.widget.AbsListView;
import androidx.recyclerview.widget.RecyclerView;
import com.paginate.abslistview.AbsListViewPaginate;
import com.paginate.recycler.RecyclerPaginate.Builder;

public abstract class Paginate {

    public interface Callbacks {
        boolean hasLoadedAllItems();

        boolean isLoading();

        void onLoadMore();
    }

    public abstract void setHasMoreDataToLoad(boolean z);

    public abstract void unbind();

    public static Builder with(RecyclerView recyclerView, Callbacks callbacks) {
        return new Builder(recyclerView, callbacks);
    }

    public static AbsListViewPaginate.Builder with(AbsListView absListView, Callbacks callbacks) {
        return new AbsListViewPaginate.Builder(absListView, callbacks);
    }
}
