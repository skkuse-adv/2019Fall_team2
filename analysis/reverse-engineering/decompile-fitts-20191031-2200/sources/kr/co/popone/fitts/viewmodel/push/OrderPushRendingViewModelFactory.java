package kr.co.popone.fitts.viewmodel.push;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.repository.RefundRepository;
import kr.co.popone.fitts.repository.UserRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class OrderPushRendingViewModelFactory extends BaseViewModelFactory {
    @NotNull
    private final FittsCommerceRepository commerceRepository;
    @NotNull
    private final FittsSchemeHandler fittsSchemeHandler;
    @NotNull
    private final RefundRepository refundRepository;
    @NotNull
    private final UserRepository userRepository;

    @NotNull
    public final FittsCommerceRepository getCommerceRepository() {
        return this.commerceRepository;
    }

    @NotNull
    public final UserRepository getUserRepository() {
        return this.userRepository;
    }

    @NotNull
    public final RefundRepository getRefundRepository() {
        return this.refundRepository;
    }

    public OrderPushRendingViewModelFactory(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull UserRepository userRepository2, @NotNull RefundRepository refundRepository2, @NotNull FittsSchemeHandler fittsSchemeHandler2) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        Intrinsics.checkParameterIsNotNull(refundRepository2, "refundRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler2, "fittsSchemeHandler");
        this.commerceRepository = fittsCommerceRepository;
        this.userRepository = userRepository2;
        this.refundRepository = refundRepository2;
        this.fittsSchemeHandler = fittsSchemeHandler2;
    }

    @NotNull
    public final FittsSchemeHandler getFittsSchemeHandler() {
        return this.fittsSchemeHandler;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new OrderPushRendingViewModel(this.commerceRepository, this.userRepository, this.refundRepository, this.fittsSchemeHandler);
    }
}
