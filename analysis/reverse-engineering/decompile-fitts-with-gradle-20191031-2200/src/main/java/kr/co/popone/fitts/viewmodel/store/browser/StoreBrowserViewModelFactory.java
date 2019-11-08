package kr.co.popone.fitts.viewmodel.store.browser;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.repository.CartRepository;
import kr.co.popone.fitts.repository.ProductRepository;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class StoreBrowserViewModelFactory extends BaseViewModelFactory {
    private final CartRepository cartRepository;
    private final FittsCommerceRepository commerceRepository;
    private final EventTracker eventTracker;
    private final ProductRepository productRepository;
    private final FittsSchemeHandler schemeHandler;
    private final StoreRepository storeRepository;

    public StoreBrowserViewModelFactory(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull ProductRepository productRepository2, @NotNull StoreRepository storeRepository2, @NotNull CartRepository cartRepository2, @NotNull EventTracker eventTracker2, @NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(productRepository2, "productRepository");
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        Intrinsics.checkParameterIsNotNull(cartRepository2, "cartRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        this.commerceRepository = fittsCommerceRepository;
        this.productRepository = productRepository2;
        this.storeRepository = storeRepository2;
        this.cartRepository = cartRepository2;
        this.eventTracker = eventTracker2;
        this.schemeHandler = fittsSchemeHandler;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        StoreBrowserViewModel storeBrowserViewModel = new StoreBrowserViewModel(this.commerceRepository, this.productRepository, this.storeRepository, this.cartRepository, this.eventTracker, this.schemeHandler);
        return storeBrowserViewModel;
    }
}
