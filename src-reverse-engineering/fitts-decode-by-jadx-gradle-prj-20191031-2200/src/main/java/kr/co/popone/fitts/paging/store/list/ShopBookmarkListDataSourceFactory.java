package kr.co.popone.fitts.paging.store.list;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.store.StoreInfo;
import kr.co.popone.fitts.repository.StoreRepository;
import org.jetbrains.annotations.NotNull;

public final class ShopBookmarkListDataSourceFactory extends Factory<Long, StoreInfo> {
    @NotNull
    private final MutableLiveData<ShopBookmarkDataSource> shopBookmarkLiveData = new MutableLiveData<>();
    private final StoreRepository storeRepository;

    public ShopBookmarkListDataSourceFactory(@NotNull StoreRepository storeRepository2) {
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        this.storeRepository = storeRepository2;
    }

    @NotNull
    public final MutableLiveData<ShopBookmarkDataSource> getShopBookmarkLiveData() {
        return this.shopBookmarkLiveData;
    }

    @NotNull
    public DataSource<Long, StoreInfo> create() {
        ShopBookmarkDataSource shopBookmarkDataSource = new ShopBookmarkDataSource(this.storeRepository);
        this.shopBookmarkLiveData.postValue(shopBookmarkDataSource);
        return shopBookmarkDataSource;
    }
}
