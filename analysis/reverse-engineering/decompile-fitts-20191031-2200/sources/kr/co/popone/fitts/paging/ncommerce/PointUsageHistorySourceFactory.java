package kr.co.popone.fitts.paging.ncommerce;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import org.jetbrains.annotations.NotNull;

public final class PointUsageHistorySourceFactory extends Factory<Long, PaymentUsage> {
    private final PaymentAPI paymentAPI;
    @NotNull
    private final MutableLiveData<PointUsageHistoryDataSource> pointUsageHistoryLiveData = new MutableLiveData<>();

    public PointUsageHistorySourceFactory(@NotNull PaymentAPI paymentAPI2) {
        Intrinsics.checkParameterIsNotNull(paymentAPI2, "paymentAPI");
        this.paymentAPI = paymentAPI2;
    }

    @NotNull
    public final MutableLiveData<PointUsageHistoryDataSource> getPointUsageHistoryLiveData() {
        return this.pointUsageHistoryLiveData;
    }

    @NotNull
    public DataSource<Long, PaymentUsage> create() {
        PointUsageHistoryDataSource pointUsageHistoryDataSource = new PointUsageHistoryDataSource(this.paymentAPI);
        this.pointUsageHistoryLiveData.postValue(pointUsageHistoryDataSource);
        return pointUsageHistoryDataSource;
    }
}
