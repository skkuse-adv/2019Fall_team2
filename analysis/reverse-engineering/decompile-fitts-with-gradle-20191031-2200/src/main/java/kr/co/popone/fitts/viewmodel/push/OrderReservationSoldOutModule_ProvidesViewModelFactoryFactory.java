package kr.co.popone.fitts.viewmodel.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.repository.RefundRepository;
import kr.co.popone.fitts.repository.UserRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class OrderReservationSoldOutModule_ProvidesViewModelFactoryFactory implements Factory<OrderPushRendingViewModelFactory> {
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final Provider<FittsSchemeHandler> fittsSchemeHandlerProvider;
    private final OrderReservationSoldOutModule module;
    private final Provider<RefundRepository> refundRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public OrderReservationSoldOutModule_ProvidesViewModelFactoryFactory(OrderReservationSoldOutModule orderReservationSoldOutModule, Provider<FittsCommerceRepository> provider, Provider<UserRepository> provider2, Provider<RefundRepository> provider3, Provider<FittsSchemeHandler> provider4) {
        this.module = orderReservationSoldOutModule;
        this.commerceRepositoryProvider = provider;
        this.userRepositoryProvider = provider2;
        this.refundRepositoryProvider = provider3;
        this.fittsSchemeHandlerProvider = provider4;
    }

    public OrderPushRendingViewModelFactory get() {
        return provideInstance(this.module, this.commerceRepositoryProvider, this.userRepositoryProvider, this.refundRepositoryProvider, this.fittsSchemeHandlerProvider);
    }

    public static OrderPushRendingViewModelFactory provideInstance(OrderReservationSoldOutModule orderReservationSoldOutModule, Provider<FittsCommerceRepository> provider, Provider<UserRepository> provider2, Provider<RefundRepository> provider3, Provider<FittsSchemeHandler> provider4) {
        return proxyProvidesViewModelFactory(orderReservationSoldOutModule, (FittsCommerceRepository) provider.get(), (UserRepository) provider2.get(), (RefundRepository) provider3.get(), (FittsSchemeHandler) provider4.get());
    }

    public static OrderReservationSoldOutModule_ProvidesViewModelFactoryFactory create(OrderReservationSoldOutModule orderReservationSoldOutModule, Provider<FittsCommerceRepository> provider, Provider<UserRepository> provider2, Provider<RefundRepository> provider3, Provider<FittsSchemeHandler> provider4) {
        OrderReservationSoldOutModule_ProvidesViewModelFactoryFactory orderReservationSoldOutModule_ProvidesViewModelFactoryFactory = new OrderReservationSoldOutModule_ProvidesViewModelFactoryFactory(orderReservationSoldOutModule, provider, provider2, provider3, provider4);
        return orderReservationSoldOutModule_ProvidesViewModelFactoryFactory;
    }

    public static OrderPushRendingViewModelFactory proxyProvidesViewModelFactory(OrderReservationSoldOutModule orderReservationSoldOutModule, FittsCommerceRepository fittsCommerceRepository, UserRepository userRepository, RefundRepository refundRepository, FittsSchemeHandler fittsSchemeHandler) {
        return (OrderPushRendingViewModelFactory) Preconditions.checkNotNull(orderReservationSoldOutModule.providesViewModelFactory(fittsCommerceRepository, userRepository, refundRepository, fittsSchemeHandler), "Cannot return null from a non-@Nullable @Provides method");
    }
}
