package kr.co.popone.fitts.paging.order;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderListViewData;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import org.jetbrains.annotations.NotNull;

public final class OrderListSourceFactory extends Factory<Long, OrderListViewData> {
    private final FittsCommerceRepository commerceRepository;
    @NotNull
    private final MutableLiveData<OrderListDataSource> orderListLiveData = new MutableLiveData<>();

    public OrderListSourceFactory(@NotNull FittsCommerceRepository fittsCommerceRepository) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        this.commerceRepository = fittsCommerceRepository;
    }

    @NotNull
    public final MutableLiveData<OrderListDataSource> getOrderListLiveData() {
        return this.orderListLiveData;
    }

    @NotNull
    public DataSource<Long, OrderListViewData> create() {
        OrderListDataSource orderListDataSource = new OrderListDataSource(this.commerceRepository);
        this.orderListLiveData.postValue(orderListDataSource);
        return orderListDataSource;
    }
}
