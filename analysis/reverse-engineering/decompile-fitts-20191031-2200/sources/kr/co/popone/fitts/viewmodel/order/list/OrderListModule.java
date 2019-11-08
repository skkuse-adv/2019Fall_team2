package kr.co.popone.fitts.viewmodel.order.list;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.order.orderlist.OrderListActivity;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import org.jetbrains.annotations.NotNull;

public final class OrderListModule {
    @NotNull
    public final OrderListViewModel provideOrderListViewModel(@NotNull OrderListActivity orderListActivity, @NotNull OrderListViewModelFactory orderListViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(orderListActivity, "activity");
        Intrinsics.checkParameterIsNotNull(orderListViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) orderListActivity, (Factory) orderListViewModelFactory).get(OrderListViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…stViewModel::class.java)]");
        return (OrderListViewModel) viewModel;
    }

    @NotNull
    public final OrderListViewModelFactory providesViewModelFactory(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull EventTracker eventTracker) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        return new OrderListViewModelFactory(fittsCommerceRepository, eventTracker);
    }
}
