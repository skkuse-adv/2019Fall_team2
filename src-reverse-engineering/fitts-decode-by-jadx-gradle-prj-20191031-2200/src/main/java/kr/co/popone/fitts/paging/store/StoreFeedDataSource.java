package kr.co.popone.fitts.paging.store;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialParams;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import com.facebook.internal.NativeProtocol;
import com.kakao.auth.StringSet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import kr.co.popone.fitts.repository.ProductRepository;
import org.jetbrains.annotations.NotNull;

public final class StoreFeedDataSource extends ItemKeyedDataSource<Long, ProductFeedViewData> implements LifecycleObserver {
    @NotNull
    private final MutableLiveData<NetworkState> networkStateLiveData = new MutableLiveData<>();
    private final ProductRepository productRepository;
    private final String type;

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<ProductFeedViewData> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public StoreFeedDataSource(@NotNull ProductRepository productRepository2, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(productRepository2, "productRepository");
        Intrinsics.checkParameterIsNotNull(str, "type");
        this.productRepository = productRepository2;
        this.type = str;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkStateLiveData() {
        return this.networkStateLiveData;
    }

    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<ProductFeedViewData> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getINIT_LOADING());
        this.productRepository.getProductList(this.type, null, Integer.valueOf(loadInitialParams.requestedLoadSize)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new StoreFeedDataSource$loadInitial$1<Object,Object>(this, loadInitialCallback));
    }

    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<ProductFeedViewData> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getLOADING());
        this.productRepository.getProductList(this.type, (Long) loadParams.key, Integer.valueOf(loadParams.requestedLoadSize)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new StoreFeedDataSource$loadAfter$1<Object,Object>(this, loadCallback));
    }

    @NotNull
    public Long getKey(@NotNull ProductFeedViewData productFeedViewData) {
        Intrinsics.checkParameterIsNotNull(productFeedViewData, "item");
        return Long.valueOf(productFeedViewData.getId());
    }
}
