package kr.co.popone.fitts.viewmodel.order.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.DataSource.Factory;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedList.Config;
import androidx.paging.PagedList.Config.Builder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.order.OrderListViewData;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.paging.order.OrderListSourceFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderListViewModel extends BaseViewModel {
    private final FittsCommerceRepository commerceRepository;
    private final EventTracker eventTracker;
    @Nullable
    private LiveData<Boolean> isEmptyList;
    @Nullable
    private LiveData<NetworkState> networkState;
    @Nullable
    private LiveData<PagedList<OrderListViewData>> pagedOrderListLiveData;

    public OrderListViewModel(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.commerceRepository = fittsCommerceRepository;
        this.eventTracker = eventTracker2;
        this.eventTracker.customLogEnterOrderList();
    }

    @Nullable
    public final LiveData<PagedList<OrderListViewData>> getPagedOrderListLiveData() {
        return this.pagedOrderListLiveData;
    }

    public final void setPagedOrderListLiveData(@Nullable LiveData<PagedList<OrderListViewData>> liveData) {
        this.pagedOrderListLiveData = liveData;
    }

    @Nullable
    public final LiveData<NetworkState> getNetworkState() {
        return this.networkState;
    }

    public final void setNetworkState(@Nullable LiveData<NetworkState> liveData) {
        this.networkState = liveData;
    }

    @Nullable
    public final LiveData<Boolean> isEmptyList() {
        return this.isEmptyList;
    }

    public final void setEmptyList(@Nullable LiveData<Boolean> liveData) {
        this.isEmptyList = liveData;
    }

    public final void requestOrderList() {
        OrderListSourceFactory orderListSourceFactory = new OrderListSourceFactory(this.commerceRepository);
        this.networkState = Transformations.switchMap(orderListSourceFactory.getOrderListLiveData(), OrderListViewModel$requestOrderList$1.INSTANCE);
        this.isEmptyList = Transformations.switchMap(orderListSourceFactory.getOrderListLiveData(), OrderListViewModel$requestOrderList$2.INSTANCE);
        this.pagedOrderListLiveData = new LivePagedListBuilder((Factory<Key, Value>) orderListSourceFactory, getPagedListConfig()).build();
    }

    private final Config getPagedListConfig() {
        Config build = new Builder().setEnablePlaceholders(true).setInitialLoadSizeHint(12).setPageSize(12).setPrefetchDistance(3).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "PagedList.Config.Builder…                 .build()");
        return build;
    }
}
