package com.paginate.recycler;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

class WrapperAdapter extends Adapter<ViewHolder> {
    private boolean displayLoadingRow = true;
    private final LoadingListItemCreator loadingListItemCreator;
    private final Adapter wrappedAdapter;

    public WrapperAdapter(Adapter adapter, LoadingListItemCreator loadingListItemCreator2) {
        this.wrappedAdapter = adapter;
        this.loadingListItemCreator = loadingListItemCreator2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 2147483597) {
            return this.loadingListItemCreator.onCreateViewHolder(viewGroup, i);
        }
        return this.wrappedAdapter.onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (isLoadingRow(i)) {
            this.loadingListItemCreator.onBindViewHolder(viewHolder, i);
        } else {
            this.wrappedAdapter.onBindViewHolder(viewHolder, i);
        }
    }

    public int getItemCount() {
        return this.displayLoadingRow ? this.wrappedAdapter.getItemCount() + 1 : this.wrappedAdapter.getItemCount();
    }

    public int getItemViewType(int i) {
        if (isLoadingRow(i)) {
            return 2147483597;
        }
        return this.wrappedAdapter.getItemViewType(i);
    }

    public long getItemId(int i) {
        if (isLoadingRow(i)) {
            return -1;
        }
        return this.wrappedAdapter.getItemId(i);
    }

    public void setHasStableIds(boolean z) {
        super.setHasStableIds(z);
        this.wrappedAdapter.setHasStableIds(z);
    }

    public Adapter getWrappedAdapter() {
        return this.wrappedAdapter;
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
            return getItemCount() - 1;
        }
        return -1;
    }
}
