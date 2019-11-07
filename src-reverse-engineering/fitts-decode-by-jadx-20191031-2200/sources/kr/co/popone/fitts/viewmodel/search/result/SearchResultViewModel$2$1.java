package kr.co.popone.fitts.viewmodel.search.result;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.paging.search.ProductResultDataSource;
import org.jetbrains.annotations.NotNull;

final class SearchResultViewModel$2$1<I, O> implements Function<X, LiveData<Y>> {
    public static final SearchResultViewModel$2$1 INSTANCE = new SearchResultViewModel$2$1();

    SearchResultViewModel$2$1() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(ProductResultDataSource productResultDataSource) {
        return productResultDataSource.getNetworkStateLiveData();
    }
}
