package androidx.paging;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo.Scope;
import androidx.annotation.WorkerThread;
import androidx.paging.PositionalDataSource.LoadInitialCallback;
import androidx.paging.PositionalDataSource.LoadInitialParams;
import androidx.paging.PositionalDataSource.LoadRangeCallback;
import androidx.paging.PositionalDataSource.LoadRangeParams;
import java.util.Collections;
import java.util.List;

@Deprecated
@RestrictTo({Scope.LIBRARY_GROUP})
public abstract class TiledDataSource<T> extends PositionalDataSource<T> {
    @WorkerThread
    public abstract int countItems();

    /* access modifiers changed from: 0000 */
    public boolean isContiguous() {
        return false;
    }

    @WorkerThread
    public abstract List<T> loadRange(int i, int i2);

    public void loadInitial(@NonNull LoadInitialParams loadInitialParams, @NonNull LoadInitialCallback<T> loadInitialCallback) {
        int countItems = countItems();
        if (countItems == 0) {
            loadInitialCallback.onResult(Collections.emptyList(), 0, 0);
            return;
        }
        int computeInitialLoadPosition = PositionalDataSource.computeInitialLoadPosition(loadInitialParams, countItems);
        int computeInitialLoadSize = PositionalDataSource.computeInitialLoadSize(loadInitialParams, computeInitialLoadPosition, countItems);
        List loadRange = loadRange(computeInitialLoadPosition, computeInitialLoadSize);
        if (loadRange == null || loadRange.size() != computeInitialLoadSize) {
            invalidate();
        } else {
            loadInitialCallback.onResult(loadRange, computeInitialLoadPosition, countItems);
        }
    }

    public void loadRange(@NonNull LoadRangeParams loadRangeParams, @NonNull LoadRangeCallback<T> loadRangeCallback) {
        List loadRange = loadRange(loadRangeParams.startPosition, loadRangeParams.loadSize);
        if (loadRange != null) {
            loadRangeCallback.onResult(loadRange);
        } else {
            invalidate();
        }
    }
}
