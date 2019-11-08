package com.paginate.abslistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;

class WrapperAdapter extends BaseAdapter implements WrapperListAdapter {
    private boolean displayLoadingRow = true;
    private final LoadingListItemCreator loadingListItemCreator;
    private final BaseAdapter wrappedAdapter;

    public WrapperAdapter(BaseAdapter baseAdapter, LoadingListItemCreator loadingListItemCreator2) {
        this.wrappedAdapter = baseAdapter;
        this.loadingListItemCreator = loadingListItemCreator2;
    }

    public ListAdapter getWrappedAdapter() {
        return this.wrappedAdapter;
    }

    public int getCount() {
        return this.displayLoadingRow ? this.wrappedAdapter.getCount() + 1 : this.wrappedAdapter.getCount();
    }

    public Object getItem(int i) {
        if (isLoadingRow(i)) {
            return null;
        }
        return this.wrappedAdapter.getItem(i);
    }

    public long getItemId(int i) {
        if (isLoadingRow(i)) {
            return -1;
        }
        return this.wrappedAdapter.getItemId(i);
    }

    public int getViewTypeCount() {
        return this.displayLoadingRow ? this.wrappedAdapter.getViewTypeCount() + 1 : this.wrappedAdapter.getViewTypeCount();
    }

    public int getItemViewType(int i) {
        return isLoadingRow(i) ? getViewTypeCount() - 1 : this.wrappedAdapter.getItemViewType(i);
    }

    public boolean isEnabled(int i) {
        return !isLoadingRow(i) && this.wrappedAdapter.isEnabled(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!isLoadingRow(i)) {
            return this.wrappedAdapter.getView(i, view, viewGroup);
        }
        if (view == null) {
            view = this.loadingListItemCreator.newView(i, viewGroup);
        }
        this.loadingListItemCreator.bindView(i, view);
        return view;
    }

    /* access modifiers changed from: 0000 */
    public void displayLoadingRow(boolean z) {
        if (this.displayLoadingRow != z) {
            this.displayLoadingRow = z;
            notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isLoadingRow(int i) {
        return this.displayLoadingRow && i == getLoadingRowPosition();
    }

    private int getLoadingRowPosition() {
        if (this.displayLoadingRow) {
            return getCount() - 1;
        }
        return -1;
    }
}
