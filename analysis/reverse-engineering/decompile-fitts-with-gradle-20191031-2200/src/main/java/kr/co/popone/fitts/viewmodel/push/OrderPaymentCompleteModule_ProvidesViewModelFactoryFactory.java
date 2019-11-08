package kr.co.popone.fitts.viewmodel.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.repository.RefundRepository;
import kr.co.popone.fitts.repository.UserRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class OrderPaymentCompleteModule_ProvidesViewModelFactoryFactory implements Factory<OrderPushRendingViewModelFactory> {
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final Provider<FittsSchemeHandler> fittsSchemeHandlerProvider;
    private final OrderPaymentCompleteModule module;
    private final Provider<RefundRepository> refundRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public OrderPaymentCompleteModule_ProvidesViewModelFactoryFactory(OrderPaymentCompleteModule orderPaymentCompleteModule, Provider<FittsCommerceRepository> provider, Provider<UserRepository> provider2, Provider<RefundRepository> provider3, Provider<FittsSchemeHandler> provider4) {
        this.module = orderPaymentCompleteModule;
        this.commerceRepositoryProvider = provider;
        this.userRepositoryProvider = provider2;
        this.refundRepositoryProvider = provider3;
        this.fittsSchemeHandlerProvider = provider4;
    }

    public OrderPushRendingViewModelFactory get() {
        return provideInstance(this.module, this.commerceRepositoryProvider, this.userRepositoryProvider, this.refundRepositoryProvider, this.fittsSchemeHandlerProvider);
    }

    public static OrderPushRendingViewModelFactory provideInstance(OrderPaymentCompleteModule orderPaymentCompleteModule, Provider<FittsCommerceRepository> provider, Provider<UserRepository> provider2, Provider<RefundRepository> provider3, Provider<FittsSchemeHandler> provider4) {
        return proxyProvidesViewModelFactory(orderPaymentCompleteModule, (FittsCommerceRepository) provider.get(), (UserRepository) provider2.get(), (RefundRepository) provider3.get(), (FittsSchemeHandler) provider4.get());
    }

    public static OrderPaymentCompleteModule_ProvidesViewModelFactoryFactory create(OrderPaymentCompleteModule orderPaymentCompleteModule, Provider<FittsCommerceRepository> provider, Provider<UserRepository> provider2, Provider<RefundRepository> provider3, Provider<FittsSchemeHandler> provider4) {
        OrderPaymentCompleteModule_ProvidesViewModelFactoryFactory orderPaymentCompleteModule_ProvidesViewModelFactoryFactory = new OrderPaymentCompleteModule_ProvidesViewModelFactoryFactory(orderPaymentCompleteModule, provider, provider2, provider3, provider4);
        return orderPaymentCompleteModule_ProvidesViewModelFactoryFactory;
    }

    public static OrderPushRendingViewModelFactory proxyProvidesViewModelFactory(OrderPaymentCompleteModule orderPaymentCompleteModule, FittsCommerceRepository fittsCommerceRepository, UserRepository userRepository, RefundRepository refundRepository, FittsSchemeHandler fittsSchemeHandler) {
        return (OrderPushRendingViewModelFactory) Preconditions.checkNotNull(orderPaymentCompleteModule.providesViewModelFactory(fittsCommerceRepository, userRepository, refundRepository, fittsSchemeHandler), "Cannot return null from a non-@Nullable @Provides method");
    }
}
