package kr.co.popone.fitts.viewmodel.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.push.order.PaymentCancelMisPriceFragment;

public final class PaymentCancelMisPriceModule_ProvideOrderViewModelFactory implements Factory<OrderPushRendingViewModel> {
    private final Provider<PaymentCancelMisPriceFragment> fragmentProvider;
    private final PaymentCancelMisPriceModule module;
    private final Provider<OrderPushRendingViewModelFactory> viewModelFactoryProvider;

    public PaymentCancelMisPriceModule_ProvideOrderViewModelFactory(PaymentCancelMisPriceModule paymentCancelMisPriceModule, Provider<PaymentCancelMisPriceFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        this.module = paymentCancelMisPriceModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderPushRendingViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static OrderPushRendingViewModel provideInstance(PaymentCancelMisPriceModule paymentCancelMisPriceModule, Provider<PaymentCancelMisPriceFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(paymentCancelMisPriceModule, (PaymentCancelMisPriceFragment) provider.get(), (OrderPushRendingViewModelFactory) provider2.get());
    }

    public static PaymentCancelMisPriceModule_ProvideOrderViewModelFactory create(PaymentCancelMisPriceModule paymentCancelMisPriceModule, Provider<PaymentCancelMisPriceFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return new PaymentCancelMisPriceModule_ProvideOrderViewModelFactory(paymentCancelMisPriceModule, provider, provider2);
    }

    public static OrderPushRendingViewModel proxyProvideOrderViewModel(PaymentCancelMisPriceModule paymentCancelMisPriceModule, PaymentCancelMisPriceFragment paymentCancelMisPriceFragment, OrderPushRendingViewModelFactory orderPushRendingViewModelFactory) {
        return (OrderPushRendingViewModel) Preconditions.checkNotNull(paymentCancelMisPriceModule.provideOrderViewModel(paymentCancelMisPriceFragment, orderPushRendingViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
