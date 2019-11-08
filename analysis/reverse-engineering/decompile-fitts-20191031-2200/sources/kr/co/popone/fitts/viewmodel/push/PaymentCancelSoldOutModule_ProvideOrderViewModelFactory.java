package kr.co.popone.fitts.viewmodel.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.push.order.PaymentCancelSoldOutFragment;

public final class PaymentCancelSoldOutModule_ProvideOrderViewModelFactory implements Factory<OrderPushRendingViewModel> {
    private final Provider<PaymentCancelSoldOutFragment> fragmentProvider;
    private final PaymentCancelSoldOutModule module;
    private final Provider<OrderPushRendingViewModelFactory> viewModelFactoryProvider;

    public PaymentCancelSoldOutModule_ProvideOrderViewModelFactory(PaymentCancelSoldOutModule paymentCancelSoldOutModule, Provider<PaymentCancelSoldOutFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        this.module = paymentCancelSoldOutModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderPushRendingViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static OrderPushRendingViewModel provideInstance(PaymentCancelSoldOutModule paymentCancelSoldOutModule, Provider<PaymentCancelSoldOutFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(paymentCancelSoldOutModule, (PaymentCancelSoldOutFragment) provider.get(), (OrderPushRendingViewModelFactory) provider2.get());
    }

    public static PaymentCancelSoldOutModule_ProvideOrderViewModelFactory create(PaymentCancelSoldOutModule paymentCancelSoldOutModule, Provider<PaymentCancelSoldOutFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return new PaymentCancelSoldOutModule_ProvideOrderViewModelFactory(paymentCancelSoldOutModule, provider, provider2);
    }

    public static OrderPushRendingViewModel proxyProvideOrderViewModel(PaymentCancelSoldOutModule paymentCancelSoldOutModule, PaymentCancelSoldOutFragment paymentCancelSoldOutFragment, OrderPushRendingViewModelFactory orderPushRendingViewModelFactory) {
        return (OrderPushRendingViewModel) Preconditions.checkNotNull(paymentCancelSoldOutModule.provideOrderViewModel(paymentCancelSoldOutFragment, orderPushRendingViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
