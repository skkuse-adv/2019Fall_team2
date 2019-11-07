package androidx.paging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagedList.Callback;

class SnapshotPagedList<T> extends PagedList<T> {
    private final boolean mContiguous;
    private final DataSource<?, T> mDataSource;
    private final Object mLastKey;

    /* access modifiers changed from: 0000 */
    public void dispatchUpdatesSinceSnapshot(@NonNull PagedList<T> pagedList, @NonNull Callback callback) {
    }

    public boolean isDetached() {
        return true;
    }

    public boolean isImmutable() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void loadAroundInternal(int i) {
    }

    SnapshotPagedList(@NonNull PagedList<T> pagedList) {
        super(pagedList.mStorage.snapshot(), pagedList.mMainThreadExecutor, pagedList.mBackgroundThreadExecutor, null, pagedList.mConfig);
        this.mDataSource = pagedList.getDataSource();
        this.mContiguous = pagedList.isContiguous();
        this.mLastLoad = pagedList.mLastLoad;
        this.mLastKey = pagedList.getLastKey();
    }

    /* access modifiers changed from: 0000 */
    public boolean isContiguous() {
        return this.mContiguous;
    }

    @Nullable
    public Object getLastKey() {
        return this.mLastKey;
    }

    @NonNull
    public DataSource<?, T> getDataSource() {
        return this.mDataSource;
    }
}
