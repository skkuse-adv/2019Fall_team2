package kr.co.popone.fitts.viewmodel.exchange.apply;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.exchange.ExchangeApplyActivity;

public final class ExchangeModule_ProvideRefundViewModelFactory implements Factory<ExchangeViewModel> {
    private final Provider<ExchangeApplyActivity> activityProvider;
    private final ExchangeModule module;
    private final Provider<ExchangeViewModelFactory> viewModelFactoryProvider;

    public ExchangeModule_ProvideRefundViewModelFactory(ExchangeModule exchangeModule, Provider<ExchangeApplyActivity> provider, Provider<ExchangeViewModelFactory> provider2) {
        this.module = exchangeModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public ExchangeViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static ExchangeViewModel provideInstance(ExchangeModule exchangeModule, Provider<ExchangeApplyActivity> provider, Provider<ExchangeViewModelFactory> provider2) {
        return proxyProvideRefundViewModel(exchangeModule, (ExchangeApplyActivity) provider.get(), (ExchangeViewModelFactory) provider2.get());
    }

    public static ExchangeModule_ProvideRefundViewModelFactory create(ExchangeModule exchangeModule, Provider<ExchangeApplyActivity> provider, Provider<ExchangeViewModelFactory> provider2) {
        return new ExchangeModule_ProvideRefundViewModelFactory(exchangeModule, provider, provider2);
    }

    public static ExchangeViewModel proxyProvideRefundViewModel(ExchangeModule exchangeModule, ExchangeApplyActivity exchangeApplyActivity, ExchangeViewModelFactory exchangeViewModelFactory) {
        return (ExchangeViewModel) Preconditions.checkNotNull(exchangeModule.provideRefundViewModel(exchangeApplyActivity, exchangeViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
