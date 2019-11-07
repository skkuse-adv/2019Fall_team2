package kr.co.popone.fitts.viewmodel.order.complete;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.order.complete.OrderCompleteRenderActivity;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class OrderCompleteRenderModule {
    @NotNull
    public final OrderCompleteRenderViewModel provideOrderViewModel(@NotNull OrderCompleteRenderActivity orderCompleteRenderActivity, @NotNull OrderCompleteRenderViewModelFactory orderCompleteRenderViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(orderCompleteRenderActivity, "activity");
        Intrinsics.checkParameterIsNotNull(orderCompleteRenderViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) orderCompleteRenderActivity, (Factory) orderCompleteRenderViewModelFactory).get(OrderCompleteRenderViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…erViewModel::class.java)]");
        return (OrderCompleteRenderViewModel) viewModel;
    }

    @NotNull
    public final OrderCompleteRenderViewModelFactory providesViewModelFactory(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        return new OrderCompleteRenderViewModelFactory(fittsCommerceRepository, fittsSchemeHandler);
    }
}
