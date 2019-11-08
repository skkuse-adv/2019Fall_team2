package kr.co.popone.fitts.viewmodel.order;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.order.OrderActivity;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import kr.co.popone.fitts.repository.CartRepository;
import kr.co.popone.fitts.repository.ProductRepository;

public final class OrderModule_ProvidesViewModelFactoryFactory implements Factory<OrderViewModelFactory> {
    private final Provider<OrderActivity> activityProvider;
    private final Provider<CartRepository> cartRepositoryProvider;
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final OrderModule module;
    private final Provider<ProductRepository> productRepositoryProvider;
    private final Provider<FittsSocialRepository> socialRepositoryProvider;

    public OrderModule_ProvidesViewModelFactoryFactory(OrderModule orderModule, Provider<OrderActivity> provider, Provider<FittsCommerceRepository> provider2, Provider<FittsSocialRepository> provider3, Provider<ProductRepository> provider4, Provider<CartRepository> provider5, Provider<EventTracker> provider6) {
        this.module = orderModule;
        this.activityProvider = provider;
        this.commerceRepositoryProvider = provider2;
        this.socialRepositoryProvider = provider3;
        this.productRepositoryProvider = provider4;
        this.cartRepositoryProvider = provider5;
        this.eventTrackerProvider = provider6;
    }

    public OrderViewModelFactory get() {
        return provideInstance(this.module, this.activityProvider, this.commerceRepositoryProvider, this.socialRepositoryProvider, this.productRepositoryProvider, this.cartRepositoryProvider, this.eventTrackerProvider);
    }

    public static OrderViewModelFactory provideInstance(OrderModule orderModule, Provider<OrderActivity> provider, Provider<FittsCommerceRepository> provider2, Provider<FittsSocialRepository> provider3, Provider<ProductRepository> provider4, Provider<CartRepository> provider5, Provider<EventTracker> provider6) {
        return proxyProvidesViewModelFactory(orderModule, (OrderActivity) provider.get(), (FittsCommerceRepository) provider2.get(), (FittsSocialRepository) provider3.get(), (ProductRepository) provider4.get(), (CartRepository) provider5.get(), (EventTracker) provider6.get());
    }

    public static OrderModule_ProvidesViewModelFactoryFactory create(OrderModule orderModule, Provider<OrderActivity> provider, Provider<FittsCommerceRepository> provider2, Provider<FittsSocialRepository> provider3, Provider<ProductRepository> provider4, Provider<CartRepository> provider5, Provider<EventTracker> provider6) {
        OrderModule_ProvidesViewModelFactoryFactory orderModule_ProvidesViewModelFactoryFactory = new OrderModule_ProvidesViewModelFactoryFactory(orderModule, provider, provider2, provider3, provider4, provider5, provider6);
        return orderModule_ProvidesViewModelFactoryFactory;
    }

    public static OrderViewModelFactory proxyProvidesViewModelFactory(OrderModule orderModule, OrderActivity orderActivity, FittsCommerceRepository fittsCommerceRepository, FittsSocialRepository fittsSocialRepository, ProductRepository productRepository, CartRepository cartRepository, EventTracker eventTracker) {
        return (OrderViewModelFactory) Preconditions.checkNotNull(orderModule.providesViewModelFactory(orderActivity, fittsCommerceRepository, fittsSocialRepository, productRepository, cartRepository, eventTracker), "Cannot return null from a non-@Nullable @Provides method");
    }
}
