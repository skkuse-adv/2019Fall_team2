package kr.co.popone.fitts.viewmodel.ncommerce;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.ncommerce.PointRevenueDetailFragment;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.repository.UserRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class RevenueDetailModule {
    @NotNull
    public final NCommerceViewModel provideOrderViewModel(@NotNull PointRevenueDetailFragment pointRevenueDetailFragment, @NotNull NCommerceViewModelFactory nCommerceViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(pointRevenueDetailFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(nCommerceViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((Fragment) pointRevenueDetailFragment, (Factory) nCommerceViewModelFactory).get(NCommerceViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(fr…ceViewModel::class.java)]");
        return (NCommerceViewModel) viewModel;
    }

    @NotNull
    public final NCommerceViewModelFactory providesViewModelFactory(@NotNull UserRepository userRepository, @NotNull PaymentAPI paymentAPI, @NotNull EventTracker eventTracker, @NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(paymentAPI, "paymentAPI");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        return new NCommerceViewModelFactory(userRepository, paymentAPI, eventTracker, fittsSchemeHandler);
    }
}
