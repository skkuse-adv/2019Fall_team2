package kr.co.popone.fitts.viewmodel.ncommerce;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.repository.UserRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class NCommerceViewModelFactory extends BaseViewModelFactory {
    @NotNull
    private final EventTracker eventTracker;
    @NotNull
    private final PaymentAPI paymentAPI;
    @NotNull
    private final FittsSchemeHandler schemeHandler;
    @NotNull
    private final UserRepository userRepository;

    @NotNull
    public final UserRepository getUserRepository() {
        return this.userRepository;
    }

    @NotNull
    public final PaymentAPI getPaymentAPI() {
        return this.paymentAPI;
    }

    @NotNull
    public final EventTracker getEventTracker() {
        return this.eventTracker;
    }

    @NotNull
    public final FittsSchemeHandler getSchemeHandler() {
        return this.schemeHandler;
    }

    public NCommerceViewModelFactory(@NotNull UserRepository userRepository2, @NotNull PaymentAPI paymentAPI2, @NotNull EventTracker eventTracker2, @NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        Intrinsics.checkParameterIsNotNull(paymentAPI2, "paymentAPI");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        this.userRepository = userRepository2;
        this.paymentAPI = paymentAPI2;
        this.eventTracker = eventTracker2;
        this.schemeHandler = fittsSchemeHandler;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new NCommerceViewModel(this.userRepository, this.paymentAPI, this.eventTracker, this.schemeHandler);
    }
}
