package androidx.paging;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import java.util.List;
import java.util.concurrent.Executor;

public abstract class PageKeyedDataSource<Key, Value> extends ContiguousDataSource<Key, Value> {
    private final Object mKeyLock = new Object();
    @GuardedBy("mKeyLock")
    @Nullable
    private Key mNextKey = null;
    @GuardedBy("mKeyLock")
    @Nullable
    private Key mPreviousKey = null;

    public static abstract class LoadCallback<Key, Value> {
        public abstract void onResult(@NonNull List<Value> list, @Nullable Key key);
    }

    static class LoadCallbackImpl<Key, Value> extends LoadCallback<Key, Value> {
        final LoadCallbackHelper<Value> mCallbackHelper;
        private final PageKeyedDataSource<Key, Value> mDataSource;

        LoadCallbackImpl(@NonNull PageKeyedDataSource<Key, Value> pageKeyedDataSource, int i, @Nullable Executor executor, @NonNull Receiver<Value> receiver) {
            this.mCallbackHelper = new LoadCallbackHelper<>(pageKeyedDataSource, i, executor, receiver);
            this.mDataSource = pageKeyedDataSource;
        }

        public void onResult(@NonNull List<Value> list, @Nullable Key key) {
            if (!this.mCallbackHelper.dispatchInvalidResultIfInvalid()) {
                if (this.mCallbackHelper.mResultType == 1) {
                    this.mDataSource.setNextKey(key);
                } else {
                    this.mDataSource.setPreviousKey(key);
                }
                this.mCallbackHelper.dispatchResultToReceiver(new PageResult(list, 0, 0, 0));
            }
        }
    }

    public static abstract class LoadInitialCallback<Key, Value> {
        public abstract void onResult(@NonNull List<Value> list, int i, int i2, @Nullable Key key, @Nullable Key key2);

        public abstract void onResult(@NonNull List<Value> list, @Nullable Key key, @Nullable Key key2);
    }

    static class LoadInitialCallbackImpl<Key, Value> extends LoadInitialCallback<Key, Value> {
        final LoadCallbackHelper<Value> mCallbackHelper;
        private final boolean mCountingEnabled;
        private final PageKeyedDataSource<Key, Value> mDataSource;

        LoadInitialCallbackImpl(@NonNull PageKeyedDataSource<Key, Value> pageKeyedDataSource, boolean z, @NonNull Receiver<Value> receiver) {
            this.mCallbackHelper = new LoadCallbackHelper<>(pageKeyedDataSource, 0, null, receiver);
            this.mDataSource = pageKeyedDataSource;
            this.mCountingEnabled = z;
        }

        public void onResult(@NonNull List<Value> list, int i, int i2, @Nullable Key key, @Nullable Key key2) {
            if (!this.mCallbackHelper.dispatchInvalidResultIfInvalid()) {
                LoadCallbackHelper.validateInitialLoadParams(list, i, i2);
                this.mDataSource.initKeys(key, key2);
                int size = (i2 - i) - list.size();
                if (this.mCountingEnabled) {
                    this.mCallbackHelper.dispatchResultToReceiver(new PageResult(list, i, size, 0));
                } else {
                    this.mCallbackHelper.dispatchResultToReceiver(new PageResult(list, i));
                }
            }
        }

        public void onResult(@NonNull List<Value> list, @Nullable Key key, @Nullable Key key2) {
            if (!this.mCallbackHelper.dispatchInvalidResultIfInvalid()) {
                this.mDataSource.initKeys(key, key2);
                this.mCallbackHelper.dispatchResultToReceiver(new PageResult(list, 0, 0, 0));
            }
        }
    }

    public static class LoadInitialParams<Key> {
        public final boolean placeholdersEnabled;
        public final int requestedLoadSize;

        public LoadInitialParams(int i, boolean z) {
            this.requestedLoadSize = i;
            this.placeholdersEnabled = z;
        }
    }

    public static class LoadParams<Key> {
        public final Key key;
        public final int requestedLoadSize;

        public LoadParams(Key key2, int i) {
            this.key = key2;
            this.requestedLoadSize = i;
        }
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    public final Key getKey(int i, Value value) {
        return null;
    }

    public abstract void loadAfter(@NonNull LoadParams<Key> loadParams, @NonNull LoadCallback<Key, Value> loadCallback);

    public abstract void loadBefore(@NonNull LoadParams<Key> loadParams, @NonNull LoadCallback<Key, Value> loadCallback);

    public abstract void loadInitial(@NonNull LoadInitialParams<Key> loadInitialParams, @NonNull LoadInitialCallback<Key, Value> loadInitialCallback);

    /* access modifiers changed from: private */
    public void initKeys(@Nullable Key key, @Nullable Key key2) {
        synchronized (this.mKeyLock) {
            this.mPreviousKey = key;
            this.mNextKey = key2;
        }
    }

    /* access modifiers changed from: private */
    public void setPreviousKey(@Nullable Key key) {
        synchronized (this.mKeyLock) {
            this.mPreviousKey = key;
        }
    }

    /* access modifiers changed from: private */
    public void setNextKey(@Nullable Key key) {
        synchronized (this.mKeyLock) {
            this.mNextKey = key;
        }
    }

    @Nullable
    private Key getPreviousKey() {
        Key key;
        synchronized (this.mKeyLock) {
            key = this.mPreviousKey;
        }
        return key;
    }

    @Nullable
    private Key getNextKey() {
        Key key;
        synchronized (this.mKeyLock) {
            key = this.mNextKey;
        }
        return key;
    }

    /* access modifiers changed from: 0000 */
    public final void dispatchLoadInitial(@Nullable Key key, int i, int i2, boolean z, @NonNull Executor executor, @NonNull Receiver<Value> receiver) {
        LoadInitialCallbackImpl loadInitialCallbackImpl = new LoadInitialCallbackImpl(this, z, receiver);
        loadInitial(new LoadInitialParams(i, z), loadInitialCallbackImpl);
        loadInitialCallbackImpl.mCallbackHelper.setPostExecutor(executor);
    }

    /* access modifiers changed from: 0000 */
    public final void dispatchLoadAfter(int i, @NonNull Value value, int i2, @NonNull Executor executor, @NonNull Receiver<Value> receiver) {
        Object nextKey = getNextKey();
        if (nextKey != null) {
            loadAfter(new LoadParams(nextKey, i2), new LoadCallbackImpl(this, 1, executor, receiver));
        } else {
            receiver.onPageResult(1, PageResult.getEmptyResult());
        }
    }

    /* access modifiers changed from: 0000 */
    public final void dispatchLoadBefore(int i, @NonNull Value value, int i2, @NonNull Executor executor, @NonNull Receiver<Value> receiver) {
        Object previousKey = getPreviousKey();
        if (previousKey != null) {
            loadBefore(new LoadParams(previousKey, i2), new LoadCallbackImpl(this, 2, executor, receiver));
        } else {
            receiver.onPageResult(2, PageResult.getEmptyResult());
        }
    }

    @NonNull
    public final <ToValue> PageKeyedDataSource<Key, ToValue> mapByPage(@NonNull Function<List<Value>, List<ToValue>> function) {
        return new WrapperPageKeyedDataSource(this, function);
    }

    @NonNull
    public final <ToValue> PageKeyedDataSource<Key, ToValue> map(@NonNull Function<Value, ToValue> function) {
        return mapByPage(DataSource.createListFunction(function));
    }
}
