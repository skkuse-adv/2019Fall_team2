package kr.co.popone.fitts.viewmodel.order.complete;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class OrderCompleteRenderPaymentModule_ProvidesViewModelFactoryFactory implements Factory<OrderCompleteRenderViewModelFactory> {
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final OrderCompleteRenderPaymentModule module;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;

    public OrderCompleteRenderPaymentModule_ProvidesViewModelFactoryFactory(OrderCompleteRenderPaymentModule orderCompleteRenderPaymentModule, Provider<FittsCommerceRepository> provider, Provider<FittsSchemeHandler> provider2) {
        this.module = orderCompleteRenderPaymentModule;
        this.commerceRepositoryProvider = provider;
        this.schemeHandlerProvider = provider2;
    }

    public OrderCompleteRenderViewModelFactory get() {
        return provideInstance(this.module, this.commerceRepositoryProvider, this.schemeHandlerProvider);
    }

    public static OrderCompleteRenderViewModelFactory provideInstance(OrderCompleteRenderPaymentModule orderCompleteRenderPaymentModule, Provider<FittsCommerceRepository> provider, Provider<FittsSchemeHandler> provider2) {
        return proxyProvidesViewModelFactory(orderCompleteRenderPaymentModule, (FittsCommerceRepository) provider.get(), (FittsSchemeHandler) provider2.get());
    }

    public static OrderCompleteRenderPaymentModule_ProvidesViewModelFactoryFactory create(OrderCompleteRenderPaymentModule orderCompleteRenderPaymentModule, Provider<FittsCommerceRepository> provider, Provider<FittsSchemeHandler> provider2) {
        return new OrderCompleteRenderPaymentModule_ProvidesViewModelFactoryFactory(orderCompleteRenderPaymentModule, provider, provider2);
    }

    public static OrderCompleteRenderViewModelFactory proxyProvidesViewModelFactory(OrderCompleteRenderPaymentModule orderCompleteRenderPaymentModule, FittsCommerceRepository fittsCommerceRepository, FittsSchemeHandler fittsSchemeHandler) {
        return (OrderCompleteRenderViewModelFactory) Preconditions.checkNotNull(orderCompleteRenderPaymentModule.providesViewModelFactory(fittsCommerceRepository, fittsSchemeHandler), "Cannot return null from a non-@Nullable @Provides method");
    }
}
