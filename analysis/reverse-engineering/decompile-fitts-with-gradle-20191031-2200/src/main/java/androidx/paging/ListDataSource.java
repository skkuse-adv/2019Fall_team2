package androidx.paging;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource.LoadInitialCallback;
import androidx.paging.PositionalDataSource.LoadInitialParams;
import androidx.paging.PositionalDataSource.LoadRangeCallback;
import androidx.paging.PositionalDataSource.LoadRangeParams;
import java.util.ArrayList;
import java.util.List;

class ListDataSource<T> extends PositionalDataSource<T> {
    private final List<T> mList;

    public ListDataSource(List<T> list) {
        this.mList = new ArrayList(list);
    }

    public void loadInitial(@NonNull LoadInitialParams loadInitialParams, @NonNull LoadInitialCallback<T> loadInitialCallback) {
        int size = this.mList.size();
        int computeInitialLoadPosition = PositionalDataSource.computeInitialLoadPosition(loadInitialParams, size);
        loadInitialCallback.onResult(this.mList.subList(computeInitialLoadPosition, PositionalDataSource.computeInitialLoadSize(loadInitialParams, computeInitialLoadPosition, size) + computeInitialLoadPosition), computeInitialLoadPosition, size);
    }

    public void loadRange(@NonNull LoadRangeParams loadRangeParams, @NonNull LoadRangeCallback<T> loadRangeCallback) {
        List<T> list = this.mList;
        int i = loadRangeParams.startPosition;
        loadRangeCallback.onResult(list.subList(i, loadRangeParams.loadSize + i));
    }
}
