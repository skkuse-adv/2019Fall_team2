package kr.co.popone.fitts.paging.wish;

import android.annotation.SuppressLint;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialParams;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import com.facebook.internal.NativeProtocol;
import com.kakao.auth.StringSet;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import org.jetbrains.annotations.NotNull;

public final class WishListDataSource extends ItemKeyedDataSource<Long, ProductFeedViewData> {
    private final FittsCommerceRepository commerceRepository;
    @NotNull
    private final MutableLiveData<Boolean> isEmptyList = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<NetworkState> networkStateLiveData = new MutableLiveData<>();

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<ProductFeedViewData> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public WishListDataSource(@NotNull FittsCommerceRepository fittsCommerceRepository) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        this.commerceRepository = fittsCommerceRepository;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkStateLiveData() {
        return this.networkStateLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> isEmptyList() {
        return this.isEmptyList;
    }

    @SuppressLint({"CheckResult"})
    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<ProductFeedViewData> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getINIT_LOADING());
        this.commerceRepository.getWishProducts(null, Integer.valueOf(loadInitialParams.requestedLoadSize)).subscribe((BiConsumer<? super T, ? super Throwable>) new WishListDataSource$loadInitial$1<Object,Object>(this, loadInitialCallback));
    }

    @SuppressLint({"CheckResult"})
    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<ProductFeedViewData> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getLOADING());
        this.commerceRepository.getWishProducts((Long) loadParams.key, Integer.valueOf(loadParams.requestedLoadSize)).subscribe((BiConsumer<? super T, ? super Throwable>) new WishListDataSource$loadAfter$1<Object,Object>(this, loadCallback));
    }

    @NotNull
    public Long getKey(@NotNull ProductFeedViewData productFeedViewData) {
        Intrinsics.checkParameterIsNotNull(productFeedViewData, "item");
        return Long.valueOf(productFeedViewData.getId());
    }
}
