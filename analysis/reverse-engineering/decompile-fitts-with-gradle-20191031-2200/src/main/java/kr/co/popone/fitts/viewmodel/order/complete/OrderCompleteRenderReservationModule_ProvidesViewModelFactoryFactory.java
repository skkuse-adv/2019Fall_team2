package kr.co.popone.fitts.viewmodel.order.complete;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class OrderCompleteRenderReservationModule_ProvidesViewModelFactoryFactory implements Factory<OrderCompleteRenderViewModelFactory> {
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final OrderCompleteRenderReservationModule module;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;

    public OrderCompleteRenderReservationModule_ProvidesViewModelFactoryFactory(OrderCompleteRenderReservationModule orderCompleteRenderReservationModule, Provider<FittsCommerceRepository> provider, Provider<FittsSchemeHandler> provider2) {
        this.module = orderCompleteRenderReservationModule;
        this.commerceRepositoryProvider = provider;
        this.schemeHandlerProvider = provider2;
    }

    public OrderCompleteRenderViewModelFactory get() {
        return provideInstance(this.module, this.commerceRepositoryProvider, this.schemeHandlerProvider);
    }

    public static OrderCompleteRenderViewModelFactory provideInstance(OrderCompleteRenderReservationModule orderCompleteRenderReservationModule, Provider<FittsCommerceRepository> provider, Provider<FittsSchemeHandler> provider2) {
        return proxyProvidesViewModelFactory(orderCompleteRenderReservationModule, (FittsCommerceRepository) provider.get(), (FittsSchemeHandler) provider2.get());
    }

    public static OrderCompleteRenderReservationModule_ProvidesViewModelFactoryFactory create(OrderCompleteRenderReservationModule orderCompleteRenderReservationModule, Provider<FittsCommerceRepository> provider, Provider<FittsSchemeHandler> provider2) {
        return new OrderCompleteRenderReservationModule_ProvidesViewModelFactoryFactory(orderCompleteRenderReservationModule, provider, provider2);
    }

    public static OrderCompleteRenderViewModelFactory proxyProvidesViewModelFactory(OrderCompleteRenderReservationModule orderCompleteRenderReservationModule, FittsCommerceRepository fittsCommerceRepository, FittsSchemeHandler fittsSchemeHandler) {
        return (OrderCompleteRenderViewModelFactory) Preconditions.checkNotNull(orderCompleteRenderReservationModule.providesViewModelFactory(fittsCommerceRepository, fittsSchemeHandler), "Cannot return null from a non-@Nullable @Provides method");
    }
}
