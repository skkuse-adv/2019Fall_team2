package kr.co.popone.fitts.paging.ncommerce;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialParams;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import com.facebook.internal.NativeProtocol;
import com.kakao.auth.StringSet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import org.jetbrains.annotations.NotNull;

public final class PointUsageHistoryDataSource extends ItemKeyedDataSource<Long, PaymentUsage> {
    @NotNull
    private final MutableLiveData<NetworkState> networkStateLiveData = new MutableLiveData<>();
    private final PaymentAPI paymentAPI;

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<PaymentUsage> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public PointUsageHistoryDataSource(@NotNull PaymentAPI paymentAPI2) {
        Intrinsics.checkParameterIsNotNull(paymentAPI2, "paymentAPI");
        this.paymentAPI = paymentAPI2;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkStateLiveData() {
        return this.networkStateLiveData;
    }

    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<PaymentUsage> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getINIT_LOADING());
        this.paymentAPI.requestPaymentInvoiceList((Long) loadInitialParams.requestedInitialKey, Integer.valueOf(loadInitialParams.requestedLoadSize), "reward").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new PointUsageHistoryDataSource$loadInitial$1(this, loadInitialCallback), new PointUsageHistoryDataSource$loadInitial$2(this));
    }

    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<PaymentUsage> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getLOADING());
        this.paymentAPI.requestPaymentInvoiceList((Long) loadParams.key, Integer.valueOf(loadParams.requestedLoadSize), "reward").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new PointUsageHistoryDataSource$loadAfter$1(this, loadCallback), new PointUsageHistoryDataSource$loadAfter$2(this));
    }

    @NotNull
    public Long getKey(@NotNull PaymentUsage paymentUsage) {
        Intrinsics.checkParameterIsNotNull(paymentUsage, "item");
        return Long.valueOf(paymentUsage.getId());
    }
}
