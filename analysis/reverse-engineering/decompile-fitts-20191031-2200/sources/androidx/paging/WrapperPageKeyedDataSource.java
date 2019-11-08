package androidx.paging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.paging.DataSource.InvalidatedCallback;
import androidx.paging.PageKeyedDataSource.LoadCallback;
import androidx.paging.PageKeyedDataSource.LoadInitialCallback;
import androidx.paging.PageKeyedDataSource.LoadInitialParams;
import androidx.paging.PageKeyedDataSource.LoadParams;
import java.util.List;

class WrapperPageKeyedDataSource<K, A, B> extends PageKeyedDataSource<K, B> {
    /* access modifiers changed from: private */
    public final Function<List<A>, List<B>> mListFunction;
    private final PageKeyedDataSource<K, A> mSource;

    WrapperPageKeyedDataSource(PageKeyedDataSource<K, A> pageKeyedDataSource, Function<List<A>, List<B>> function) {
        this.mSource = pageKeyedDataSource;
        this.mListFunction = function;
    }

    public void addInvalidatedCallback(@NonNull InvalidatedCallback invalidatedCallback) {
        this.mSource.addInvalidatedCallback(invalidatedCallback);
    }

    public void removeInvalidatedCallback(@NonNull InvalidatedCallback invalidatedCallback) {
        this.mSource.removeInvalidatedCallback(invalidatedCallback);
    }

    public void invalidate() {
        this.mSource.invalidate();
    }

    public boolean isInvalid() {
        return this.mSource.isInvalid();
    }

    public void loadInitial(@NonNull LoadInitialParams<K> loadInitialParams, @NonNull final LoadInitialCallback<K, B> loadInitialCallback) {
        this.mSource.loadInitial(loadInitialParams, new LoadInitialCallback<K, A>() {
            public void onResult(@NonNull List<A> list, int i, int i2, @Nullable K k, @Nullable K k2) {
                loadInitialCallback.onResult(DataSource.convert(WrapperPageKeyedDataSource.this.mListFunction, list), i, i2, k, k2);
            }

            public void onResult(@NonNull List<A> list, @Nullable K k, @Nullable K k2) {
                loadInitialCallback.onResult(DataSource.convert(WrapperPageKeyedDataSource.this.mListFunction, list), k, k2);
            }
        });
    }

    public void loadBefore(@NonNull LoadParams<K> loadParams, @NonNull final LoadCallback<K, B> loadCallback) {
        this.mSource.loadBefore(loadParams, new LoadCallback<K, A>() {
            public void onResult(@NonNull List<A> list, @Nullable K k) {
                loadCallback.onResult(DataSource.convert(WrapperPageKeyedDataSource.this.mListFunction, list), k);
            }
        });
    }

    public void loadAfter(@NonNull LoadParams<K> loadParams, @NonNull final LoadCallback<K, B> loadCallback) {
        this.mSource.loadAfter(loadParams, new LoadCallback<K, A>() {
            public void onResult(@NonNull List<A> list, @Nullable K k) {
                loadCallback.onResult(DataSource.convert(WrapperPageKeyedDataSource.this.mListFunction, list), k);
            }
        });
    }
}
