package kr.co.popone.fitts.viewmodel.exchange.detail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.exchange.ExchangeApplyCompleteFragment;

public final class ExchangeCompleteActivityModule_ProvideExchangeDetailViewModelFactory implements Factory<ExchangeDetailViewModel> {
    private final Provider<ExchangeApplyCompleteFragment> fragmentProvider;
    private final ExchangeCompleteActivityModule module;
    private final Provider<ExchangeDetailViewModelFactory> viewModelFactoryProvider;

    public ExchangeCompleteActivityModule_ProvideExchangeDetailViewModelFactory(ExchangeCompleteActivityModule exchangeCompleteActivityModule, Provider<ExchangeApplyCompleteFragment> provider, Provider<ExchangeDetailViewModelFactory> provider2) {
        this.module = exchangeCompleteActivityModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public ExchangeDetailViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static ExchangeDetailViewModel provideInstance(ExchangeCompleteActivityModule exchangeCompleteActivityModule, Provider<ExchangeApplyCompleteFragment> provider, Provider<ExchangeDetailViewModelFactory> provider2) {
        return proxyProvideExchangeDetailViewModel(exchangeCompleteActivityModule, (ExchangeApplyCompleteFragment) provider.get(), (ExchangeDetailViewModelFactory) provider2.get());
    }

    public static ExchangeCompleteActivityModule_ProvideExchangeDetailViewModelFactory create(ExchangeCompleteActivityModule exchangeCompleteActivityModule, Provider<ExchangeApplyCompleteFragment> provider, Provider<ExchangeDetailViewModelFactory> provider2) {
        return new ExchangeCompleteActivityModule_ProvideExchangeDetailViewModelFactory(exchangeCompleteActivityModule, provider, provider2);
    }

    public static ExchangeDetailViewModel proxyProvideExchangeDetailViewModel(ExchangeCompleteActivityModule exchangeCompleteActivityModule, ExchangeApplyCompleteFragment exchangeApplyCompleteFragment, ExchangeDetailViewModelFactory exchangeDetailViewModelFactory) {
        return (ExchangeDetailViewModel) Preconditions.checkNotNull(exchangeCompleteActivityModule.provideExchangeDetailViewModel(exchangeApplyCompleteFragment, exchangeDetailViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
