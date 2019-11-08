package kr.co.popone.fitts.paging.ncommerce;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentHistory;
import org.jetbrains.annotations.NotNull;

public final class PointHistorySourceFactory extends Factory<Long, PaymentHistory> {
    private final PaymentAPI paymentAPI;
    @NotNull
    private final MutableLiveData<PointHistoryDataSource> pointHistoryLiveData = new MutableLiveData<>();

    public PointHistorySourceFactory(@NotNull PaymentAPI paymentAPI2) {
        Intrinsics.checkParameterIsNotNull(paymentAPI2, "paymentAPI");
        this.paymentAPI = paymentAPI2;
    }

    @NotNull
    public final MutableLiveData<PointHistoryDataSource> getPointHistoryLiveData() {
        return this.pointHistoryLiveData;
    }

    @NotNull
    public DataSource<Long, PaymentHistory> create() {
        PointHistoryDataSource pointHistoryDataSource = new PointHistoryDataSource(this.paymentAPI);
        this.pointHistoryLiveData.postValue(pointHistoryDataSource);
        return pointHistoryDataSource;
    }
}
