package androidx.paging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public abstract class PagedListAdapter<T, VH extends ViewHolder> extends Adapter<VH> {
    private final AsyncPagedListDiffer<T> mDiffer;
    private final PagedListListener<T> mListener = new PagedListListener<T>() {
        public void onCurrentListChanged(@Nullable PagedList<T> pagedList) {
            PagedListAdapter.this.onCurrentListChanged(pagedList);
        }
    };

    public void onCurrentListChanged(@Nullable PagedList<T> pagedList) {
    }

    protected PagedListAdapter(@NonNull ItemCallback<T> itemCallback) {
        this.mDiffer = new AsyncPagedListDiffer<>((Adapter) this, itemCallback);
        this.mDiffer.mListener = this.mListener;
    }

    protected PagedListAdapter(@NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.mDiffer = new AsyncPagedListDiffer<>((ListUpdateCallback) new AdapterListUpdateCallback(this), asyncDifferConfig);
        this.mDiffer.mListener = this.mListener;
    }

    public void submitList(PagedList<T> pagedList) {
        this.mDiffer.submitList(pagedList);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public T getItem(int i) {
        return this.mDiffer.getItem(i);
    }

    public int getItemCount() {
        return this.mDiffer.getItemCount();
    }

    @Nullable
    public PagedList<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }
}
