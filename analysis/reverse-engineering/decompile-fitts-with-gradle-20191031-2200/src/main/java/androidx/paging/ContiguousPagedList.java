package androidx.paging;

import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagedList.BoundaryCallback;
import androidx.paging.PagedList.Callback;
import androidx.paging.PagedList.Config;
import java.util.List;
import java.util.concurrent.Executor;

class ContiguousPagedList<K, V> extends PagedList<V> implements Callback {
    static final int LAST_LOAD_UNSPECIFIED = -1;
    private int mAppendItemsRequested = 0;
    private boolean mAppendWorkerRunning = false;
    /* access modifiers changed from: private */
    public final ContiguousDataSource<K, V> mDataSource;
    private int mPrependItemsRequested = 0;
    private boolean mPrependWorkerRunning = false;
    /* access modifiers changed from: private */
    public Receiver<V> mReceiver = new Receiver<V>() {
        @AnyThread
        public void onPageResult(int i, @NonNull PageResult<V> pageResult) {
            if (pageResult.isInvalid()) {
                ContiguousPagedList.this.detach();
            } else if (!ContiguousPagedList.this.isDetached()) {
                List<T> list = pageResult.page;
                if (i == 0) {
                    ContiguousPagedList contiguousPagedList = ContiguousPagedList.this;
                    contiguousPagedList.mStorage.init(pageResult.leadingNulls, list, pageResult.trailingNulls, pageResult.positionOffset, contiguousPagedList);
                    ContiguousPagedList contiguousPagedList2 = ContiguousPagedList.this;
                    if (contiguousPagedList2.mLastLoad == -1) {
                        contiguousPagedList2.mLastLoad = pageResult.leadingNulls + pageResult.positionOffset + (list.size() / 2);
                    }
                } else if (i == 1) {
                    ContiguousPagedList contiguousPagedList3 = ContiguousPagedList.this;
                    contiguousPagedList3.mStorage.appendPage(list, contiguousPagedList3);
                } else if (i == 2) {
                    ContiguousPagedList contiguousPagedList4 = ContiguousPagedList.this;
                    contiguousPagedList4.mStorage.prependPage(list, contiguousPagedList4);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unexpected resultType ");
                    sb.append(i);
                    throw new IllegalArgumentException(sb.toString());
                }
                ContiguousPagedList contiguousPagedList5 = ContiguousPagedList.this;
                if (contiguousPagedList5.mBoundaryCallback != null) {
                    boolean z = false;
                    boolean z2 = contiguousPagedList5.mStorage.size() == 0;
                    boolean z3 = !z2 && i == 2 && pageResult.page.size() == 0;
                    if (!z2 && i == 1 && pageResult.page.size() == 0) {
                        z = true;
                    }
                    ContiguousPagedList.this.deferBoundaryCallbacks(z2, z3, z);
                }
            }
        }
    };

    /* access modifiers changed from: 0000 */
    public boolean isContiguous() {
        return true;
    }

    ContiguousPagedList(@NonNull ContiguousDataSource<K, V> contiguousDataSource, @NonNull Executor executor, @NonNull Executor executor2, @Nullable BoundaryCallback<V> boundaryCallback, @NonNull Config config, @Nullable K k, int i) {
        super(new PagedStorage(), executor, executor2, boundaryCallback, config);
        this.mDataSource = contiguousDataSource;
        this.mLastLoad = i;
        if (this.mDataSource.isInvalid()) {
            detach();
            return;
        }
        ContiguousDataSource<K, V> contiguousDataSource2 = this.mDataSource;
        Config config2 = this.mConfig;
        contiguousDataSource2.dispatchLoadInitial(k, config2.initialLoadSizeHint, config2.pageSize, config2.enablePlaceholders, this.mMainThreadExecutor, this.mReceiver);
    }

    /* access modifiers changed from: 0000 */
    @MainThread
    public void dispatchUpdatesSinceSnapshot(@NonNull PagedList<V> pagedList, @NonNull Callback callback) {
        PagedStorage<T> pagedStorage = pagedList.mStorage;
        int numberAppended = this.mStorage.getNumberAppended() - pagedStorage.getNumberAppended();
        int numberPrepended = this.mStorage.getNumberPrepended() - pagedStorage.getNumberPrepended();
        int trailingNullCount = pagedStorage.getTrailingNullCount();
        int leadingNullCount = pagedStorage.getLeadingNullCount();
        if (pagedStorage.isEmpty() || numberAppended < 0 || numberPrepended < 0 || this.mStorage.getTrailingNullCount() != Math.max(trailingNullCount - numberAppended, 0) || this.mStorage.getLeadingNullCount() != Math.max(leadingNullCount - numberPrepended, 0) || this.mStorage.getStorageCount() != pagedStorage.getStorageCount() + numberAppended + numberPrepended) {
            throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
        }
        if (numberAppended != 0) {
            int min = Math.min(trailingNullCount, numberAppended);
            int i = numberAppended - min;
            int leadingNullCount2 = pagedStorage.getLeadingNullCount() + pagedStorage.getStorageCount();
            if (min != 0) {
                callback.onChanged(leadingNullCount2, min);
            }
            if (i != 0) {
                callback.onInserted(leadingNullCount2 + min, i);
            }
        }
        if (numberPrepended != 0) {
            int min2 = Math.min(leadingNullCount, numberPrepended);
            int i2 = numberPrepended - min2;
            if (min2 != 0) {
                callback.onChanged(leadingNullCount, min2);
            }
            if (i2 != 0) {
                callback.onInserted(0, i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void loadAroundInternal(int i) {
        int leadingNullCount = this.mConfig.prefetchDistance - (i - this.mStorage.getLeadingNullCount());
        int leadingNullCount2 = (i + this.mConfig.prefetchDistance) - (this.mStorage.getLeadingNullCount() + this.mStorage.getStorageCount());
        this.mPrependItemsRequested = Math.max(leadingNullCount, this.mPrependItemsRequested);
        if (this.mPrependItemsRequested > 0) {
            schedulePrepend();
        }
        this.mAppendItemsRequested = Math.max(leadingNullCount2, this.mAppendItemsRequested);
        if (this.mAppendItemsRequested > 0) {
            scheduleAppend();
        }
    }

    @MainThread
    private void schedulePrepend() {
        if (!this.mPrependWorkerRunning) {
            this.mPrependWorkerRunning = true;
            final int leadingNullCount = this.mStorage.getLeadingNullCount() + this.mStorage.getPositionOffset();
            final Object firstLoadedItem = this.mStorage.getFirstLoadedItem();
            this.mBackgroundThreadExecutor.execute(new Runnable() {
                public void run() {
                    if (!ContiguousPagedList.this.isDetached()) {
                        if (ContiguousPagedList.this.mDataSource.isInvalid()) {
                            ContiguousPagedList.this.detach();
                        } else {
                            ContiguousDataSource access$000 = ContiguousPagedList.this.mDataSource;
                            int i = leadingNullCount;
                            Object obj = firstLoadedItem;
                            ContiguousPagedList contiguousPagedList = ContiguousPagedList.this;
                            access$000.dispatchLoadBefore(i, obj, contiguousPagedList.mConfig.pageSize, contiguousPagedList.mMainThreadExecutor, contiguousPagedList.mReceiver);
                        }
                    }
                }
            });
        }
    }

    @MainThread
    private void scheduleAppend() {
        if (!this.mAppendWorkerRunning) {
            this.mAppendWorkerRunning = true;
            final int leadingNullCount = ((this.mStorage.getLeadingNullCount() + this.mStorage.getStorageCount()) - 1) + this.mStorage.getPositionOffset();
            final Object lastLoadedItem = this.mStorage.getLastLoadedItem();
            this.mBackgroundThreadExecutor.execute(new Runnable() {
                public void run() {
                    if (!ContiguousPagedList.this.isDetached()) {
                        if (ContiguousPagedList.this.mDataSource.isInvalid()) {
                            ContiguousPagedList.this.detach();
                        } else {
                            ContiguousDataSource access$000 = ContiguousPagedList.this.mDataSource;
                            int i = leadingNullCount;
                            Object obj = lastLoadedItem;
                            ContiguousPagedList contiguousPagedList = ContiguousPagedList.this;
                            access$000.dispatchLoadAfter(i, obj, contiguousPagedList.mConfig.pageSize, contiguousPagedList.mMainThreadExecutor, contiguousPagedList.mReceiver);
                        }
                    }
                }
            });
        }
    }

    @NonNull
    public DataSource<?, V> getDataSource() {
        return this.mDataSource;
    }

    @Nullable
    public Object getLastKey() {
        return this.mDataSource.getKey(this.mLastLoad, this.mLastItem);
    }

    @MainThread
    public void onInitialized(int i) {
        notifyInserted(0, i);
    }

    @MainThread
    public void onPagePrepended(int i, int i2, int i3) {
        this.mPrependItemsRequested = (this.mPrependItemsRequested - i2) - i3;
        this.mPrependWorkerRunning = false;
        if (this.mPrependItemsRequested > 0) {
            schedulePrepend();
        }
        notifyChanged(i, i2);
        notifyInserted(0, i3);
        offsetAccessIndices(i3);
    }

    @MainThread
    public void onPageAppended(int i, int i2, int i3) {
        this.mAppendItemsRequested = (this.mAppendItemsRequested - i2) - i3;
        this.mAppendWorkerRunning = false;
        if (this.mAppendItemsRequested > 0) {
            scheduleAppend();
        }
        notifyChanged(i, i2);
        notifyInserted(i + i2, i3);
    }

    @MainThread
    public void onPagePlaceholderInserted(int i) {
        throw new IllegalStateException("Tiled callback on ContiguousPagedList");
    }

    @MainThread
    public void onPageInserted(int i, int i2) {
        throw new IllegalStateException("Tiled callback on ContiguousPagedList");
    }
}
