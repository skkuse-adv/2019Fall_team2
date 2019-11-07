package androidx.paging;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource.Factory;
import androidx.paging.DataSource.InvalidatedCallback;
import androidx.paging.PagedList.BoundaryCallback;
import androidx.paging.PagedList.Config;
import androidx.paging.PagedList.Config.Builder;
import java.util.concurrent.Executor;

public final class LivePagedListBuilder<Key, Value> {
    private BoundaryCallback mBoundaryCallback;
    private Config mConfig;
    private Factory<Key, Value> mDataSourceFactory;
    private Executor mFetchExecutor;
    private Key mInitialLoadKey;

    public LivePagedListBuilder(@NonNull Factory<Key, Value> factory, @NonNull Config config) {
        this.mFetchExecutor = ArchTaskExecutor.getIOThreadExecutor();
        if (config == null) {
            throw new IllegalArgumentException("PagedList.Config must be provided");
        } else if (factory != null) {
            this.mDataSourceFactory = factory;
            this.mConfig = config;
        } else {
            throw new IllegalArgumentException("DataSource.Factory must be provided");
        }
    }

    public LivePagedListBuilder(@NonNull Factory<Key, Value> factory, int i) {
        this(factory, new Builder().setPageSize(i).build());
    }

    @NonNull
    public LivePagedListBuilder<Key, Value> setInitialLoadKey(@Nullable Key key) {
        this.mInitialLoadKey = key;
        return this;
    }

    @NonNull
    public LivePagedListBuilder<Key, Value> setBoundaryCallback(@Nullable BoundaryCallback<Value> boundaryCallback) {
        this.mBoundaryCallback = boundaryCallback;
        return this;
    }

    @NonNull
    public LivePagedListBuilder<Key, Value> setFetchExecutor(@NonNull Executor executor) {
        this.mFetchExecutor = executor;
        return this;
    }

    @NonNull
    public LiveData<PagedList<Value>> build() {
        return create(this.mInitialLoadKey, this.mConfig, this.mBoundaryCallback, this.mDataSourceFactory, ArchTaskExecutor.getMainThreadExecutor(), this.mFetchExecutor);
    }

    @NonNull
    @AnyThread
    private static <Key, Value> LiveData<PagedList<Value>> create(@Nullable Key key, @NonNull Config config, @Nullable BoundaryCallback boundaryCallback, @NonNull Factory<Key, Value> factory, @NonNull Executor executor, @NonNull Executor executor2) {
        final Key key2 = key;
        final Factory<Key, Value> factory2 = factory;
        final Config config2 = config;
        final Executor executor3 = executor;
        final Executor executor4 = executor2;
        final BoundaryCallback boundaryCallback2 = boundaryCallback;
        AnonymousClass1 r0 = new ComputableLiveData<PagedList<Value>>(executor2) {
            private final InvalidatedCallback mCallback = new InvalidatedCallback() {
                public void onInvalidated() {
                    AnonymousClass1.this.invalidate();
                }
            };
            @Nullable
            private DataSource<Key, Value> mDataSource;
            @Nullable
            private PagedList<Value> mList;

            /* access modifiers changed from: protected */
            public PagedList<Value> compute() {
                Object obj = key2;
                PagedList<Value> pagedList = this.mList;
                if (pagedList != null) {
                    obj = pagedList.getLastKey();
                }
                do {
                    DataSource<Key, Value> dataSource = this.mDataSource;
                    if (dataSource != null) {
                        dataSource.removeInvalidatedCallback(this.mCallback);
                    }
                    this.mDataSource = factory2.create();
                    this.mDataSource.addInvalidatedCallback(this.mCallback);
                    this.mList = new PagedList.Builder(this.mDataSource, config2).setNotifyExecutor(executor3).setFetchExecutor(executor4).setBoundaryCallback(boundaryCallback2).setInitialKey(obj).build();
                } while (this.mList.isDetached());
                return this.mList;
            }
        };
        return r0.getLiveData();
    }
}
