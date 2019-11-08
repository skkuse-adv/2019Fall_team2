package kr.co.popone.fitts.paging.store.bridge;

import android.annotation.SuppressLint;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialParams;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import com.facebook.internal.NativeProtocol;
import com.kakao.auth.StringSet;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeProduct;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.repository.StoreRepository;
import org.jetbrains.annotations.NotNull;

public final class StoreBridgeDataSource extends ItemKeyedDataSource<Long, FeedItem> {
    @NotNull
    private final MutableLiveData<NetworkState> networkStateLiveData = new MutableLiveData<>();
    private final long storeId;
    private final StoreRepository storeRepository;

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<FeedItem> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public StoreBridgeDataSource(@NotNull StoreRepository storeRepository2, long j) {
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        this.storeRepository = storeRepository2;
        this.storeId = j;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkStateLiveData() {
        return this.networkStateLiveData;
    }

    @SuppressLint({"CheckResult"})
    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<FeedItem> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getLOADING());
        this.storeRepository.getShopBridgeInfo(this.storeId, null, Integer.valueOf(loadInitialParams.requestedLoadSize)).subscribe(new StoreBridgeDataSource$loadInitial$1(loadInitialCallback), new StoreBridgeDataSource$loadInitial$2(this));
    }

    @SuppressLint({"CheckResult"})
    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<FeedItem> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getLOADING());
        this.storeRepository.getStoreProducts(this.storeId, (Long) loadParams.key, Integer.valueOf(loadParams.requestedLoadSize)).subscribe(new StoreBridgeDataSource$loadAfter$1(this, loadCallback), new StoreBridgeDataSource$loadAfter$2(this));
    }

    @NotNull
    public Long getKey(@NotNull FeedItem feedItem) {
        Intrinsics.checkParameterIsNotNull(feedItem, "item");
        long j = feedItem instanceof ShopBridgeProduct ? ((Product) CollectionsKt___CollectionsKt.last(((ShopBridgeProduct) feedItem).getProducts())).getId() : feedItem instanceof Product ? ((Product) feedItem).getId() : -1;
        return Long.valueOf(j);
    }
}
