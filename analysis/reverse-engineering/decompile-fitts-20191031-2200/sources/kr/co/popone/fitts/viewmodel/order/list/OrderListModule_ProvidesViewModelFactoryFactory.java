package kr.co.popone.fitts.viewmodel.order.list;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;

public final class OrderListModule_ProvidesViewModelFactoryFactory implements Factory<OrderListViewModelFactory> {
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final OrderListModule module;

    public OrderListModule_ProvidesViewModelFactoryFactory(OrderListModule orderListModule, Provider<FittsCommerceRepository> provider, Provider<EventTracker> provider2) {
        this.module = orderListModule;
        this.commerceRepositoryProvider = provider;
        this.eventTrackerProvider = provider2;
    }

    public OrderListViewModelFactory get() {
        return provideInstance(this.module, this.commerceRepositoryProvider, this.eventTrackerProvider);
    }

    public static OrderListViewModelFactory provideInstance(OrderListModule orderListModule, Provider<FittsCommerceRepository> provider, Provider<EventTracker> provider2) {
        return proxyProvidesViewModelFactory(orderListModule, (FittsCommerceRepository) provider.get(), (EventTracker) provider2.get());
    }

    public static OrderListModule_ProvidesViewModelFactoryFactory create(OrderListModule orderListModule, Provider<FittsCommerceRepository> provider, Provider<EventTracker> provider2) {
        return new OrderListModule_ProvidesViewModelFactoryFactory(orderListModule, provider, provider2);
    }

    public static OrderListViewModelFactory proxyProvidesViewModelFactory(OrderListModule orderListModule, FittsCommerceRepository fittsCommerceRepository, EventTracker eventTracker) {
        return (OrderListViewModelFactory) Preconditions.checkNotNull(orderListModule.providesViewModelFactory(fittsCommerceRepository, eventTracker), "Cannot return null from a non-@Nullable @Provides method");
    }
}
