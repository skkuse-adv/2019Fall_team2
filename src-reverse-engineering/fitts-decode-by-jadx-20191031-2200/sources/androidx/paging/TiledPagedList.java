package androidx.paging;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.paging.PagedList.BoundaryCallback;
import androidx.paging.PagedList.Callback;
import androidx.paging.PagedList.Config;
import java.util.concurrent.Executor;

class TiledPagedList<T> extends PagedList<T> implements Callback {
    /* access modifiers changed from: private */
    public final PositionalDataSource<T> mDataSource;
    /* access modifiers changed from: private */
    public Receiver<T> mReceiver = new Receiver<T>() {
        @AnyThread
        public void onPageResult(int i, @NonNull PageResult<T> pageResult) {
            if (pageResult.isInvalid()) {
                TiledPagedList.this.detach();
            } else if (!TiledPagedList.this.isDetached()) {
                if (i == 0 || i == 3) {
                    if (TiledPagedList.this.mStorage.getPageCount() == 0) {
                        TiledPagedList tiledPagedList = TiledPagedList.this;
                        tiledPagedList.mStorage.initAndSplit(pageResult.leadingNulls, pageResult.page, pageResult.trailingNulls, pageResult.positionOffset, tiledPagedList.mConfig.pageSize, tiledPagedList);
                    } else {
                        TiledPagedList tiledPagedList2 = TiledPagedList.this;
                        tiledPagedList2.mStorage.insertPage(pageResult.positionOffset, pageResult.page, tiledPagedList2);
                    }
                    TiledPagedList tiledPagedList3 = TiledPagedList.this;
                    if (tiledPagedList3.mBoundaryCallback != null) {
                        boolean z = true;
                        boolean z2 = tiledPagedList3.mStorage.size() == 0;
                        boolean z3 = !z2 && pageResult.leadingNulls == 0 && pageResult.positionOffset == 0;
                        int size = TiledPagedList.this.size();
                        if (z2 || (!(i == 0 && pageResult.trailingNulls == 0) && (i != 3 || pageResult.positionOffset + TiledPagedList.this.mConfig.pageSize < size))) {
                            z = false;
                        }
                        TiledPagedList.this.deferBoundaryCallbacks(z2, z3, z);
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected resultType");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
        }
    };

    /* access modifiers changed from: 0000 */
    public boolean isContiguous() {
        return false;
    }

    @WorkerThread
    TiledPagedList(@NonNull PositionalDataSource<T> positionalDataSource, @NonNull Executor executor, @NonNull Executor executor2, @Nullable BoundaryCallback<T> boundaryCallback, @NonNull Config config, int i) {
        super(new PagedStorage(), executor, executor2, boundaryCallback, config);
        this.mDataSource = positionalDataSource;
        int i2 = this.mConfig.pageSize;
        this.mLastLoad = i;
        if (this.mDataSource.isInvalid()) {
            detach();
            return;
        }
        int max = Math.max(Math.round((float) (this.mConfig.initialLoadSizeHint / i2)), 2) * i2;
        this.mDataSource.dispatchLoadInitial(true, Math.max(0, Math.round((float) ((i - (max / 2)) / i2)) * i2), max, i2, this.mMainThreadExecutor, this.mReceiver);
    }

    @NonNull
    public DataSource<?, T> getDataSource() {
        return this.mDataSource;
    }

    @Nullable
    public Object getLastKey() {
        return Integer.valueOf(this.mLastLoad);
    }

    /* access modifiers changed from: protected */
    public void dispatchUpdatesSinceSnapshot(@NonNull PagedList<T> pagedList, @NonNull Callback callback) {
        PagedStorage<T> pagedStorage = pagedList.mStorage;
        if (pagedStorage.isEmpty() || this.mStorage.size() != pagedStorage.size()) {
            throw new IllegalArgumentException("Invalid snapshot provided - doesn't appear to be a snapshot of this PagedList");
        }
        int i = this.mConfig.pageSize;
        int leadingNullCount = this.mStorage.getLeadingNullCount() / i;
        int pageCount = this.mStorage.getPageCount();
        int i2 = 0;
        while (i2 < pageCount) {
            int i3 = i2 + leadingNullCount;
            int i4 = 0;
            while (i4 < this.mStorage.getPageCount()) {
                int i5 = i3 + i4;
                if (!this.mStorage.hasPage(i, i5) || pagedStorage.hasPage(i, i5)) {
                    break;
                }
                i4++;
            }
            if (i4 > 0) {
                callback.onChanged(i3 * i, i * i4);
                i2 += i4 - 1;
            }
            i2++;
        }
    }

    /* access modifiers changed from: protected */
    public void loadAroundInternal(int i) {
        PagedStorage<T> pagedStorage = this.mStorage;
        Config config = this.mConfig;
        pagedStorage.allocatePlaceholders(i, config.prefetchDistance, config.pageSize, this);
    }

    public void onInitialized(int i) {
        notifyInserted(0, i);
    }

    public void onPagePrepended(int i, int i2, int i3) {
        throw new IllegalStateException("Contiguous callback on TiledPagedList");
    }

    public void onPageAppended(int i, int i2, int i3) {
        throw new IllegalStateException("Contiguous callback on TiledPagedList");
    }

    public void onPagePlaceholderInserted(final int i) {
        this.mBackgroundThreadExecutor.execute(new Runnable() {
            public void run() {
                if (!TiledPagedList.this.isDetached()) {
                    TiledPagedList tiledPagedList = TiledPagedList.this;
                    int i = tiledPagedList.mConfig.pageSize;
                    if (tiledPagedList.mDataSource.isInvalid()) {
                        TiledPagedList.this.detach();
                    } else {
                        int i2 = i * i;
                        int min = Math.min(i, TiledPagedList.this.mStorage.size() - i2);
                        PositionalDataSource access$000 = TiledPagedList.this.mDataSource;
                        TiledPagedList tiledPagedList2 = TiledPagedList.this;
                        access$000.dispatchLoadRange(3, i2, min, tiledPagedList2.mMainThreadExecutor, tiledPagedList2.mReceiver);
                    }
                }
            }
        });
    }

    public void onPageInserted(int i, int i2) {
        notifyChanged(i, i2);
    }
}
