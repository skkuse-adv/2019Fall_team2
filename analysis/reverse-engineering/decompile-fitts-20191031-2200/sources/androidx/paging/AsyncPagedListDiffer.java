package androidx.paging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.paging.PagedList.Callback;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncDifferConfig.Builder;
import androidx.recyclerview.widget.DiffUtil.DiffResult;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.concurrent.Executor;

public class AsyncPagedListDiffer<T> {
    final AsyncDifferConfig<T> mConfig;
    private boolean mIsContiguous;
    private int mLastAccessIndex;
    @Nullable
    PagedListListener<T> mListener;
    Executor mMainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
    int mMaxScheduledGeneration;
    private PagedList<T> mPagedList;
    private Callback mPagedListCallback = new Callback() {
        public void onInserted(int i, int i2) {
            AsyncPagedListDiffer.this.mUpdateCallback.onInserted(i, i2);
        }

        public void onRemoved(int i, int i2) {
            AsyncPagedListDiffer.this.mUpdateCallback.onRemoved(i, i2);
        }

        public void onChanged(int i, int i2) {
            AsyncPagedListDiffer.this.mUpdateCallback.onChanged(i, i2, null);
        }
    };
    private PagedList<T> mSnapshot;
    final ListUpdateCallback mUpdateCallback;

    interface PagedListListener<T> {
        void onCurrentListChanged(@Nullable PagedList<T> pagedList);
    }

    public AsyncPagedListDiffer(@NonNull Adapter adapter, @NonNull ItemCallback<T> itemCallback) {
        this.mUpdateCallback = new AdapterListUpdateCallback(adapter);
        this.mConfig = new Builder(itemCallback).build();
    }

    public AsyncPagedListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = asyncDifferConfig;
    }

    @Nullable
    public T getItem(int i) {
        PagedList<T> pagedList = this.mPagedList;
        if (pagedList == null) {
            PagedList<T> pagedList2 = this.mSnapshot;
            if (pagedList2 != null) {
                return pagedList2.get(i);
            }
            throw new IndexOutOfBoundsException("Item count is zero, getItem() call is invalid");
        }
        pagedList.loadAround(i);
        return this.mPagedList.get(i);
    }

    public int getItemCount() {
        PagedList<T> pagedList = this.mPagedList;
        if (pagedList != null) {
            return pagedList.size();
        }
        PagedList<T> pagedList2 = this.mSnapshot;
        return pagedList2 == null ? 0 : pagedList2.size();
    }

    public void submitList(PagedList<T> pagedList) {
        if (pagedList != null) {
            if (this.mPagedList == null && this.mSnapshot == null) {
                this.mIsContiguous = pagedList.isContiguous();
            } else if (pagedList.isContiguous() != this.mIsContiguous) {
                throw new IllegalArgumentException("AsyncPagedListDiffer cannot handle both contiguous and non-contiguous lists.");
            }
        }
        final int i = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = i;
        PagedList<T> pagedList2 = this.mPagedList;
        if (pagedList != pagedList2) {
            if (pagedList == null) {
                int itemCount = getItemCount();
                PagedList<T> pagedList3 = this.mPagedList;
                if (pagedList3 != null) {
                    pagedList3.removeWeakCallback(this.mPagedListCallback);
                    this.mPagedList = null;
                } else if (this.mSnapshot != null) {
                    this.mSnapshot = null;
                }
                this.mUpdateCallback.onRemoved(0, itemCount);
                PagedListListener<T> pagedListListener = this.mListener;
                if (pagedListListener != null) {
                    pagedListListener.onCurrentListChanged(null);
                }
            } else if (pagedList2 == null && this.mSnapshot == null) {
                this.mPagedList = pagedList;
                pagedList.addWeakCallback(null, this.mPagedListCallback);
                this.mUpdateCallback.onInserted(0, pagedList.size());
                PagedListListener<T> pagedListListener2 = this.mListener;
                if (pagedListListener2 != null) {
                    pagedListListener2.onCurrentListChanged(pagedList);
                }
            } else {
                PagedList<T> pagedList4 = this.mPagedList;
                if (pagedList4 != null) {
                    pagedList4.removeWeakCallback(this.mPagedListCallback);
                    this.mSnapshot = (PagedList) this.mPagedList.snapshot();
                    this.mPagedList = null;
                }
                final PagedList<T> pagedList5 = this.mSnapshot;
                if (pagedList5 == null || this.mPagedList != null) {
                    throw new IllegalStateException("must be in snapshot state to diff");
                }
                final PagedList pagedList6 = (PagedList) pagedList.snapshot();
                Executor backgroundThreadExecutor = this.mConfig.getBackgroundThreadExecutor();
                final PagedList<T> pagedList7 = pagedList;
                AnonymousClass2 r1 = new Runnable() {
                    public void run() {
                        final DiffResult computeDiff = PagedStorageDiffHelper.computeDiff(pagedList5.mStorage, pagedList6.mStorage, AsyncPagedListDiffer.this.mConfig.getDiffCallback());
                        AsyncPagedListDiffer.this.mMainThreadExecutor.execute(new Runnable() {
                            public void run() {
                                AnonymousClass2 r0 = AnonymousClass2.this;
                                AsyncPagedListDiffer asyncPagedListDiffer = AsyncPagedListDiffer.this;
                                if (asyncPagedListDiffer.mMaxScheduledGeneration == i) {
                                    asyncPagedListDiffer.latchPagedList(pagedList7, pagedList6, computeDiff, pagedList5.mLastLoad);
                                }
                            }
                        });
                    }
                };
                backgroundThreadExecutor.execute(r1);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void latchPagedList(@NonNull PagedList<T> pagedList, @NonNull PagedList<T> pagedList2, @NonNull DiffResult diffResult, int i) {
        PagedList<T> pagedList3 = this.mSnapshot;
        if (pagedList3 == null || this.mPagedList != null) {
            throw new IllegalStateException("must be in snapshot state to apply diff");
        }
        this.mPagedList = pagedList;
        this.mSnapshot = null;
        PagedStorageDiffHelper.dispatchDiff(this.mUpdateCallback, pagedList3.mStorage, pagedList.mStorage, diffResult);
        pagedList.addWeakCallback(pagedList2, this.mPagedListCallback);
        int transformAnchorIndex = PagedStorageDiffHelper.transformAnchorIndex(diffResult, pagedList3.mStorage, pagedList2.mStorage, i);
        PagedList<T> pagedList4 = this.mPagedList;
        pagedList4.mLastLoad = Math.max(0, Math.min(pagedList4.size(), transformAnchorIndex));
        PagedListListener<T> pagedListListener = this.mListener;
        if (pagedListListener != null) {
            pagedListListener.onCurrentListChanged(this.mPagedList);
        }
    }

    @Nullable
    public PagedList<T> getCurrentList() {
        PagedList<T> pagedList = this.mSnapshot;
        if (pagedList != null) {
            return pagedList;
        }
        return this.mPagedList;
    }
}
