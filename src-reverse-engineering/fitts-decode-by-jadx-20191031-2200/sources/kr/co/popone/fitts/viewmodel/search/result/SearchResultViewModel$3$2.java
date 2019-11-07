package kr.co.popone.fitts.viewmodel.search.result;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.paging.search.FittieResultDataSource;
import org.jetbrains.annotations.NotNull;

final class SearchResultViewModel$3$2<I, O> implements Function<X, LiveData<Y>> {
    public static final SearchResultViewModel$3$2 INSTANCE = new SearchResultViewModel$3$2();

    SearchResultViewModel$3$2() {
    }

    @NotNull
    public final MutableLiveData<Boolean> apply(FittieResultDataSource fittieResultDataSource) {
        return fittieResultDataSource.isEmptyFitties();
    }
}
