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
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentHistory;
import org.jetbrains.annotations.NotNull;

public final class PointHistoryDataSource extends ItemKeyedDataSource<Long, PaymentHistory> {
    @NotNull
    private final MutableLiveData<Boolean> emptyListLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<NetworkState> networkStateLiveData = new MutableLiveData<>();
    private final PaymentAPI paymentAPI;

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<PaymentHistory> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public PointHistoryDataSource(@NotNull PaymentAPI paymentAPI2) {
        Intrinsics.checkParameterIsNotNull(paymentAPI2, "paymentAPI");
        this.paymentAPI = paymentAPI2;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkStateLiveData() {
        return this.networkStateLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getEmptyListLiveData() {
        return this.emptyListLiveData;
    }

    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<PaymentHistory> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getINIT_LOADING());
        this.paymentAPI.requestPaymentHistoryList((Long) loadInitialParams.requestedInitialKey, Integer.valueOf(loadInitialParams.requestedLoadSize)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new PointHistoryDataSource$loadInitial$1(this, loadInitialCallback), new PointHistoryDataSource$loadInitial$2(this));
    }

    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<PaymentHistory> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getLOADING());
        this.paymentAPI.requestPaymentHistoryList((Long) loadParams.key, Integer.valueOf(loadParams.requestedLoadSize)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new PointHistoryDataSource$loadAfter$1(this, loadCallback), new PointHistoryDataSource$loadAfter$2(this));
    }

    @NotNull
    public Long getKey(@NotNull PaymentHistory paymentHistory) {
        Intrinsics.checkParameterIsNotNull(paymentHistory, "item");
        return Long.valueOf(paymentHistory.getId());
    }
}
