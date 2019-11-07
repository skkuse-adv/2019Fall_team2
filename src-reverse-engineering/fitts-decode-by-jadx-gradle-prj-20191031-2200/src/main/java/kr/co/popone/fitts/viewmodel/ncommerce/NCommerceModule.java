package kr.co.popone.fitts.viewmodel.ncommerce;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.ncommerce.NCommerceActivity;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.repository.UserRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class NCommerceModule {
    @NotNull
    public final NCommerceViewModel provideOrderViewModel(@NotNull NCommerceActivity nCommerceActivity, @NotNull NCommerceViewModelFactory nCommerceViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(nCommerceActivity, "activity");
        Intrinsics.checkParameterIsNotNull(nCommerceViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) nCommerceActivity, (Factory) nCommerceViewModelFactory).get(NCommerceViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…ceViewModel::class.java)]");
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
