package androidx.paging;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.paging.DataSource.InvalidatedCallback;
import androidx.paging.PositionalDataSource.LoadInitialCallback;
import androidx.paging.PositionalDataSource.LoadInitialParams;
import androidx.paging.PositionalDataSource.LoadRangeCallback;
import androidx.paging.PositionalDataSource.LoadRangeParams;
import java.util.List;

class WrapperPositionalDataSource<A, B> extends PositionalDataSource<B> {
    /* access modifiers changed from: private */
    public final Function<List<A>, List<B>> mListFunction;
    private final PositionalDataSource<A> mSource;

    WrapperPositionalDataSource(PositionalDataSource<A> positionalDataSource, Function<List<A>, List<B>> function) {
        this.mSource = positionalDataSource;
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

    public void loadInitial(@NonNull LoadInitialParams loadInitialParams, @NonNull final LoadInitialCallback<B> loadInitialCallback) {
        this.mSource.loadInitial(loadInitialParams, new LoadInitialCallback<A>() {
            public void onResult(@NonNull List<A> list, int i, int i2) {
                loadInitialCallback.onResult(DataSource.convert(WrapperPositionalDataSource.this.mListFunction, list), i, i2);
            }

            public void onResult(@NonNull List<A> list, int i) {
                loadInitialCallback.onResult(DataSource.convert(WrapperPositionalDataSource.this.mListFunction, list), i);
            }
        });
    }

    public void loadRange(@NonNull LoadRangeParams loadRangeParams, @NonNull final LoadRangeCallback<B> loadRangeCallback) {
        this.mSource.loadRange(loadRangeParams, new LoadRangeCallback<A>() {
            public void onResult(@NonNull List<A> list) {
                loadRangeCallback.onResult(DataSource.convert(WrapperPositionalDataSource.this.mListFunction, list));
            }
        });
    }
}
