package kr.co.popone.fitts.viewmodel.push;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.push.order.OrderReservationCancelFragment;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.repository.RefundRepository;
import kr.co.popone.fitts.repository.UserRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class OrderReservationCancelModule {
    @NotNull
    public final OrderPushRendingViewModel provideOrderViewModel(@NotNull OrderReservationCancelFragment orderReservationCancelFragment, @NotNull OrderPushRendingViewModelFactory orderPushRendingViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(orderReservationCancelFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(orderPushRendingViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((Fragment) orderReservationCancelFragment, (Factory) orderPushRendingViewModelFactory).get(OrderPushRendingViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(fr…ngViewModel::class.java)]");
        return (OrderPushRendingViewModel) viewModel;
    }

    @NotNull
    public final OrderPushRendingViewModelFactory providesViewModelFactory(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull UserRepository userRepository, @NotNull RefundRepository refundRepository, @NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(refundRepository, "refundRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "fittsSchemeHandler");
        return new OrderPushRendingViewModelFactory(fittsCommerceRepository, userRepository, refundRepository, fittsSchemeHandler);
    }
}
