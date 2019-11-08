package kr.co.popone.fitts.viewmodel.search.result;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.paging.search.PostSearchResultDataSource;
import org.jetbrains.annotations.NotNull;

final class SearchResultViewModel$1$2<I, O> implements Function<X, LiveData<Y>> {
    public static final SearchResultViewModel$1$2 INSTANCE = new SearchResultViewModel$1$2();

    SearchResultViewModel$1$2() {
    }

    @NotNull
    public final MutableLiveData<Boolean> apply(PostSearchResultDataSource postSearchResultDataSource) {
        return postSearchResultDataSource.getEmptyListLiveData();
    }
}
