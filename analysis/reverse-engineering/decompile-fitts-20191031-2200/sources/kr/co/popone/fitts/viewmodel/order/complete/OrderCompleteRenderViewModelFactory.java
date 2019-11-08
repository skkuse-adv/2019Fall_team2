package kr.co.popone.fitts.viewmodel.order.complete;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class OrderCompleteRenderViewModelFactory extends BaseViewModelFactory {
    @NotNull
    private final FittsCommerceRepository commerceRepository;
    @NotNull
    private final FittsSchemeHandler schemeHandler;

    @NotNull
    public final FittsCommerceRepository getCommerceRepository() {
        return this.commerceRepository;
    }

    public OrderCompleteRenderViewModelFactory(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        this.commerceRepository = fittsCommerceRepository;
        this.schemeHandler = fittsSchemeHandler;
    }

    @NotNull
    public final FittsSchemeHandler getSchemeHandler() {
        return this.schemeHandler;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new OrderCompleteRenderViewModel(this.commerceRepository, this.schemeHandler);
    }
}
