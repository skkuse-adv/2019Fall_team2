package kr.co.popone.fitts.paging.order;

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
import kr.co.popone.fitts.model.order.OrderListViewData;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import org.jetbrains.annotations.NotNull;

public final class OrderListDataSource extends ItemKeyedDataSource<Long, OrderListViewData> {
    private final FittsCommerceRepository commerceRepository;
    @NotNull
    private final MutableLiveData<Boolean> isEmptyList = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<NetworkState> networkStateLiveData = new MutableLiveData<>();

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<OrderListViewData> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public OrderListDataSource(@NotNull FittsCommerceRepository fittsCommerceRepository) {
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

    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<OrderListViewData> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getINIT_LOADING());
        this.commerceRepository.getOrderLineItemList((Long) loadInitialParams.requestedInitialKey, Integer.valueOf(loadInitialParams.requestedLoadSize)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new OrderListDataSource$loadInitial$1<Object,Object>(this, loadInitialCallback));
    }

    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<OrderListViewData> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getLOADING());
        this.commerceRepository.getOrderLineItemList((Long) loadParams.key, Integer.valueOf(loadParams.requestedLoadSize)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new OrderListDataSource$loadAfter$1<Object,Object>(this, loadCallback));
    }

    @NotNull
    public Long getKey(@NotNull OrderListViewData orderListViewData) {
        Intrinsics.checkParameterIsNotNull(orderListViewData, "item");
        return Long.valueOf(orderListViewData.getOrderId());
    }
}
