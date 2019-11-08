package kr.co.popone.fitts.viewmodel.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.repository.RefundRepository;
import kr.co.popone.fitts.repository.UserRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class OrderCompleteModule_ProvidesViewModelFactoryFactory implements Factory<OrderPushRendingViewModelFactory> {
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final Provider<FittsSchemeHandler> fittsSchemeHandlerProvider;
    private final OrderCompleteModule module;
    private final Provider<RefundRepository> refundRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public OrderCompleteModule_ProvidesViewModelFactoryFactory(OrderCompleteModule orderCompleteModule, Provider<FittsCommerceRepository> provider, Provider<UserRepository> provider2, Provider<RefundRepository> provider3, Provider<FittsSchemeHandler> provider4) {
        this.module = orderCompleteModule;
        this.commerceRepositoryProvider = provider;
        this.userRepositoryProvider = provider2;
        this.refundRepositoryProvider = provider3;
        this.fittsSchemeHandlerProvider = provider4;
    }

    public OrderPushRendingViewModelFactory get() {
        return provideInstance(this.module, this.commerceRepositoryProvider, this.userRepositoryProvider, this.refundRepositoryProvider, this.fittsSchemeHandlerProvider);
    }

    public static OrderPushRendingViewModelFactory provideInstance(OrderCompleteModule orderCompleteModule, Provider<FittsCommerceRepository> provider, Provider<UserRepository> provider2, Provider<RefundRepository> provider3, Provider<FittsSchemeHandler> provider4) {
        return proxyProvidesViewModelFactory(orderCompleteModule, (FittsCommerceRepository) provider.get(), (UserRepository) provider2.get(), (RefundRepository) provider3.get(), (FittsSchemeHandler) provider4.get());
    }

    public static OrderCompleteModule_ProvidesViewModelFactoryFactory create(OrderCompleteModule orderCompleteModule, Provider<FittsCommerceRepository> provider, Provider<UserRepository> provider2, Provider<RefundRepository> provider3, Provider<FittsSchemeHandler> provider4) {
        OrderCompleteModule_ProvidesViewModelFactoryFactory orderCompleteModule_ProvidesViewModelFactoryFactory = new OrderCompleteModule_ProvidesViewModelFactoryFactory(orderCompleteModule, provider, provider2, provider3, provider4);
        return orderCompleteModule_ProvidesViewModelFactoryFactory;
    }

    public static OrderPushRendingViewModelFactory proxyProvidesViewModelFactory(OrderCompleteModule orderCompleteModule, FittsCommerceRepository fittsCommerceRepository, UserRepository userRepository, RefundRepository refundRepository, FittsSchemeHandler fittsSchemeHandler) {
        return (OrderPushRendingViewModelFactory) Preconditions.checkNotNull(orderCompleteModule.providesViewModelFactory(fittsCommerceRepository, userRepository, refundRepository, fittsSchemeHandler), "Cannot return null from a non-@Nullable @Provides method");
    }
}
