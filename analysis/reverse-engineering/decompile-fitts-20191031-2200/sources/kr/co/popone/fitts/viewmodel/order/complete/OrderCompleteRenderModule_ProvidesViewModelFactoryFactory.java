package kr.co.popone.fitts.viewmodel.order.complete;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class OrderCompleteRenderModule_ProvidesViewModelFactoryFactory implements Factory<OrderCompleteRenderViewModelFactory> {
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final OrderCompleteRenderModule module;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;

    public OrderCompleteRenderModule_ProvidesViewModelFactoryFactory(OrderCompleteRenderModule orderCompleteRenderModule, Provider<FittsCommerceRepository> provider, Provider<FittsSchemeHandler> provider2) {
        this.module = orderCompleteRenderModule;
        this.commerceRepositoryProvider = provider;
        this.schemeHandlerProvider = provider2;
    }

    public OrderCompleteRenderViewModelFactory get() {
        return provideInstance(this.module, this.commerceRepositoryProvider, this.schemeHandlerProvider);
    }

    public static OrderCompleteRenderViewModelFactory provideInstance(OrderCompleteRenderModule orderCompleteRenderModule, Provider<FittsCommerceRepository> provider, Provider<FittsSchemeHandler> provider2) {
        return proxyProvidesViewModelFactory(orderCompleteRenderModule, (FittsCommerceRepository) provider.get(), (FittsSchemeHandler) provider2.get());
    }

    public static OrderCompleteRenderModule_ProvidesViewModelFactoryFactory create(OrderCompleteRenderModule orderCompleteRenderModule, Provider<FittsCommerceRepository> provider, Provider<FittsSchemeHandler> provider2) {
        return new OrderCompleteRenderModule_ProvidesViewModelFactoryFactory(orderCompleteRenderModule, provider, provider2);
    }

    public static OrderCompleteRenderViewModelFactory proxyProvidesViewModelFactory(OrderCompleteRenderModule orderCompleteRenderModule, FittsCommerceRepository fittsCommerceRepository, FittsSchemeHandler fittsSchemeHandler) {
        return (OrderCompleteRenderViewModelFactory) Preconditions.checkNotNull(orderCompleteRenderModule.providesViewModelFactory(fittsCommerceRepository, fittsSchemeHandler), "Cannot return null from a non-@Nullable @Provides method");
    }
}
