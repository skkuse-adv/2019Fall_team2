package kr.co.popone.fitts.viewmodel.search.result;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.paging.search.FittieResultDataSource;
import org.jetbrains.annotations.NotNull;

final class SearchResultViewModel$3$1<I, O> implements Function<X, LiveData<Y>> {
    public static final SearchResultViewModel$3$1 INSTANCE = new SearchResultViewModel$3$1();

    SearchResultViewModel$3$1() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(FittieResultDataSource fittieResultDataSource) {
        return fittieResultDataSource.getNetworkStateLiveData();
    }
}
