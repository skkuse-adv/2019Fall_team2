package kr.co.popone.fitts.viewmodel.wish;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.paging.wish.WishListDataSource;
import org.jetbrains.annotations.NotNull;

final class WishListViewModel$1$2<I, O> implements Function<X, LiveData<Y>> {
    public static final WishListViewModel$1$2 INSTANCE = new WishListViewModel$1$2();

    WishListViewModel$1$2() {
    }

    @NotNull
    public final MutableLiveData<Boolean> apply(WishListDataSource wishListDataSource) {
        return wishListDataSource.isEmptyList();
    }
}
