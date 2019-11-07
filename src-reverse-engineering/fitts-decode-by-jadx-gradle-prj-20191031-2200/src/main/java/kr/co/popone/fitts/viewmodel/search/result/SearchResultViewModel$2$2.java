package kr.co.popone.fitts.viewmodel.search.result;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.paging.search.ProductResultDataSource;
import org.jetbrains.annotations.NotNull;

final class SearchResultViewModel$2$2<I, O> implements Function<X, LiveData<Y>> {
    public static final SearchResultViewModel$2$2 INSTANCE = new SearchResultViewModel$2$2();

    SearchResultViewModel$2$2() {
    }

    @NotNull
    public final MutableLiveData<Boolean> apply(ProductResultDataSource productResultDataSource) {
        return productResultDataSource.isEmptyProducts();
    }
}
