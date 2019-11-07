package kr.co.popone.fitts.viewmodel.store.list;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.paging.store.list.ShopBookmarkDataSource;
import org.jetbrains.annotations.NotNull;

final class ShopBookmarkViewModel$1$2<I, O> implements Function<X, LiveData<Y>> {
    public static final ShopBookmarkViewModel$1$2 INSTANCE = new ShopBookmarkViewModel$1$2();

    ShopBookmarkViewModel$1$2() {
    }

    @NotNull
    public final MutableLiveData<Boolean> apply(ShopBookmarkDataSource shopBookmarkDataSource) {
        return shopBookmarkDataSource.getEmptyListLiveData();
    }
}
