package kr.co.popone.fitts.viewmodel.store.newest;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.paging.store.newest.NewestProductDataSource;
import org.jetbrains.annotations.NotNull;

final class NewestProductViewModel$1$1<I, O> implements Function<X, LiveData<Y>> {
    public static final NewestProductViewModel$1$1 INSTANCE = new NewestProductViewModel$1$1();

    NewestProductViewModel$1$1() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(NewestProductDataSource newestProductDataSource) {
        return newestProductDataSource.getNetworkState();
    }
}
