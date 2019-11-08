package androidx.paging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.paging.DataSource.Factory;
import androidx.paging.DataSource.InvalidatedCallback;
import androidx.paging.PagedList.BoundaryCallback;
import androidx.paging.PagedList.Builder;
import androidx.paging.PagedList.Config;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.functions.Cancellable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;

public final class RxPagedListBuilder<Key, Value> {
    private BoundaryCallback mBoundaryCallback;
    private Config mConfig;
    private Factory<Key, Value> mDataSourceFactory;
    private Executor mFetchExecutor;
    private Scheduler mFetchScheduler;
    private Key mInitialLoadKey;
    private Executor mNotifyExecutor;
    private Scheduler mNotifyScheduler;

    static class PagingObservableOnSubscribe<Key, Value> implements ObservableOnSubscribe<PagedList<Value>>, InvalidatedCallback, Cancellable, Runnable {
        @Nullable
        private final BoundaryCallback mBoundaryCallback;
        @NonNull
        private final Config mConfig;
        @Nullable
        private DataSource<Key, Value> mDataSource;
        @NonNull
        private final Factory<Key, Value> mDataSourceFactory;
        private ObservableEmitter<PagedList<Value>> mEmitter;
        @NonNull
        private final Executor mFetchExecutor;
        @Nullable
        private final Key mInitialLoadKey;
        @Nullable
        private PagedList<Value> mList;
        @NonNull
        private final Executor mNotifyExecutor;

        PagingObservableOnSubscribe(@Nullable Key key, @NonNull Config config, @Nullable BoundaryCallback boundaryCallback, @NonNull Factory<Key, Value> factory, @NonNull Executor executor, @NonNull Executor executor2) {
            this.mInitialLoadKey = key;
            this.mConfig = config;
            this.mBoundaryCallback = boundaryCallback;
            this.mDataSourceFactory = factory;
            this.mNotifyExecutor = executor;
            this.mFetchExecutor = executor2;
        }

        public void subscribe(ObservableEmitter<PagedList<Value>> observableEmitter) throws Exception {
            this.mEmitter = observableEmitter;
            this.mEmitter.setCancellable(this);
            this.mEmitter.onNext(createPagedList());
        }

        public void cancel() throws Exception {
            DataSource<Key, Value> dataSource = this.mDataSource;
            if (dataSource != null) {
                dataSource.removeInvalidatedCallback(this);
            }
        }

        public void run() {
            this.mEmitter.onNext(createPagedList());
        }

        public void onInvalidated() {
            if (!this.mEmitter.isDisposed()) {
                this.mFetchExecutor.execute(this);
            }
        }

        private PagedList<Value> createPagedList() {
            Key key = this.mInitialLoadKey;
            PagedList<Value> pagedList = this.mList;
            if (pagedList != null) {
                key = pagedList.getLastKey();
            }
            do {
                DataSource<Key, Value> dataSource = this.mDataSource;
                if (dataSource != null) {
                    dataSource.removeInvalidatedCallback(this);
                }
                this.mDataSource = this.mDataSourceFactory.create();
                this.mDataSource.addInvalidatedCallback(this);
                this.mList = new Builder(this.mDataSource, this.mConfig).setNotifyExecutor(this.mNotifyExecutor).setFetchExecutor(this.mFetchExecutor).setBoundaryCallback(this.mBoundaryCallback).setInitialKey(key).build();
            } while (this.mList.isDetached());
            return this.mList;
        }
    }

    public RxPagedListBuilder(@NonNull Factory<Key, Value> factory, @NonNull Config config) {
        if (config == null) {
            throw new IllegalArgumentException("PagedList.Config must be provided");
        } else if (factory != null) {
            this.mDataSourceFactory = factory;
            this.mConfig = config;
        } else {
            throw new IllegalArgumentException("DataSource.Factory must be provided");
        }
    }

    public RxPagedListBuilder(@NonNull Factory<Key, Value> factory, int i) {
        this(factory, new Config.Builder().setPageSize(i).build());
    }

    @NonNull
    public RxPagedListBuilder<Key, Value> setInitialLoadKey(@Nullable Key key) {
        this.mInitialLoadKey = key;
        return this;
    }

    @NonNull
    public RxPagedListBuilder<Key, Value> setBoundaryCallback(@Nullable BoundaryCallback<Value> boundaryCallback) {
        this.mBoundaryCallback = boundaryCallback;
        return this;
    }

    public RxPagedListBuilder<Key, Value> setNotifyScheduler(@NonNull Scheduler scheduler) {
        this.mNotifyScheduler = scheduler;
        final Worker createWorker = scheduler.createWorker();
        this.mNotifyExecutor = new Executor() {
            public void execute(@NonNull Runnable runnable) {
                createWorker.schedule(runnable);
            }
        };
        return this;
    }

    @NonNull
    public RxPagedListBuilder<Key, Value> setFetchScheduler(@NonNull final Scheduler scheduler) {
        this.mFetchExecutor = new Executor() {
            public void execute(@NonNull Runnable runnable) {
                scheduler.scheduleDirect(runnable);
            }
        };
        this.mFetchScheduler = scheduler;
        return this;
    }

    @NonNull
    public Observable<PagedList<Value>> buildObservable() {
        if (this.mNotifyExecutor == null) {
            this.mNotifyExecutor = ArchTaskExecutor.getMainThreadExecutor();
            this.mNotifyScheduler = Schedulers.from(this.mNotifyExecutor);
        }
        if (this.mFetchExecutor == null) {
            this.mFetchExecutor = ArchTaskExecutor.getIOThreadExecutor();
            this.mFetchScheduler = Schedulers.from(this.mFetchExecutor);
        }
        PagingObservableOnSubscribe pagingObservableOnSubscribe = new PagingObservableOnSubscribe(this.mInitialLoadKey, this.mConfig, this.mBoundaryCallback, this.mDataSourceFactory, this.mNotifyExecutor, this.mFetchExecutor);
        return Observable.create(pagingObservableOnSubscribe).observeOn(this.mNotifyScheduler).subscribeOn(this.mFetchScheduler);
    }

    @NonNull
    public Flowable<PagedList<Value>> buildFlowable(BackpressureStrategy backpressureStrategy) {
        return buildObservable().toFlowable(backpressureStrategy);
    }
}
