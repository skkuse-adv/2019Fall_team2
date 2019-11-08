package kr.co.popone.fitts.viewmodel.order.complete;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.order.complete.OrderCompleteRenderPaymentFragment;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class OrderCompleteRenderPaymentModule {
    @NotNull
    public final OrderCompleteRenderViewModel provideOrderViewModel(@NotNull OrderCompleteRenderPaymentFragment orderCompleteRenderPaymentFragment, @NotNull OrderCompleteRenderViewModelFactory orderCompleteRenderViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(orderCompleteRenderPaymentFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(orderCompleteRenderViewModelFactory, "viewModelFactory");
        FragmentActivity activity = orderCompleteRenderPaymentFragment.getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        ViewModel viewModel = ViewModelProviders.of(activity, (Factory) orderCompleteRenderViewModelFactory).get(OrderCompleteRenderViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(fr…erViewModel::class.java)]");
        return (OrderCompleteRenderViewModel) viewModel;
    }

    @NotNull
    public final OrderCompleteRenderViewModelFactory providesViewModelFactory(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        return new OrderCompleteRenderViewModelFactory(fittsCommerceRepository, fittsSchemeHandler);
    }
}
