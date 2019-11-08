package kr.co.popone.fitts.viewmodel.ncommerce;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.paging.ncommerce.PointHistoryDataSource;
import org.jetbrains.annotations.NotNull;

final class NCommerceViewModel$requestPointHistory$2<I, O> implements Function<X, LiveData<Y>> {
    public static final NCommerceViewModel$requestPointHistory$2 INSTANCE = new NCommerceViewModel$requestPointHistory$2();

    NCommerceViewModel$requestPointHistory$2() {
    }

    @NotNull
    public final MutableLiveData<Boolean> apply(PointHistoryDataSource pointHistoryDataSource) {
        return pointHistoryDataSource.getEmptyListLiveData();
    }
}
