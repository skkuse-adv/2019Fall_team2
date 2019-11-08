package kr.co.popone.fitts.viewmodel.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.repository.RefundRepository;
import kr.co.popone.fitts.repository.UserRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class PaymentCancelSoldOutModule_ProvidesViewModelFactoryFactory implements Factory<OrderPushRendingViewModelFactory> {
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final Provider<FittsSchemeHandler> fittsSchemeHandlerProvider;
    private final PaymentCancelSoldOutModule module;
    private final Provider<RefundRepository> refundRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public PaymentCancelSoldOutModule_ProvidesViewModelFactoryFactory(PaymentCancelSoldOutModule paymentCancelSoldOutModule, Provider<FittsCommerceRepository> provider, Provider<UserRepository> provider2, Provider<RefundRepository> provider3, Provider<FittsSchemeHandler> provider4) {
        this.module = paymentCancelSoldOutModule;
        this.commerceRepositoryProvider = provider;
        this.userRepositoryProvider = provider2;
        this.refundRepositoryProvider = provider3;
        this.fittsSchemeHandlerProvider = provider4;
    }

    public OrderPushRendingViewModelFactory get() {
        return provideInstance(this.module, this.commerceRepositoryProvider, this.userRepositoryProvider, this.refundRepositoryProvider, this.fittsSchemeHandlerProvider);
    }

    public static OrderPushRendingViewModelFactory provideInstance(PaymentCancelSoldOutModule paymentCancelSoldOutModule, Provider<FittsCommerceRepository> provider, Provider<UserRepository> provider2, Provider<RefundRepository> provider3, Provider<FittsSchemeHandler> provider4) {
        return proxyProvidesViewModelFactory(paymentCancelSoldOutModule, (FittsCommerceRepository) provider.get(), (UserRepository) provider2.get(), (RefundRepository) provider3.get(), (FittsSchemeHandler) provider4.get());
    }

    public static PaymentCancelSoldOutModule_ProvidesViewModelFactoryFactory create(PaymentCancelSoldOutModule paymentCancelSoldOutModule, Provider<FittsCommerceRepository> provider, Provider<UserRepository> provider2, Provider<RefundRepository> provider3, Provider<FittsSchemeHandler> provider4) {
        PaymentCancelSoldOutModule_ProvidesViewModelFactoryFactory paymentCancelSoldOutModule_ProvidesViewModelFactoryFactory = new PaymentCancelSoldOutModule_ProvidesViewModelFactoryFactory(paymentCancelSoldOutModule, provider, provider2, provider3, provider4);
        return paymentCancelSoldOutModule_ProvidesViewModelFactoryFactory;
    }

    public static OrderPushRendingViewModelFactory proxyProvidesViewModelFactory(PaymentCancelSoldOutModule paymentCancelSoldOutModule, FittsCommerceRepository fittsCommerceRepository, UserRepository userRepository, RefundRepository refundRepository, FittsSchemeHandler fittsSchemeHandler) {
        return (OrderPushRendingViewModelFactory) Preconditions.checkNotNull(paymentCancelSoldOutModule.providesViewModelFactory(fittsCommerceRepository, userRepository, refundRepository, fittsSchemeHandler), "Cannot return null from a non-@Nullable @Provides method");
    }
}
