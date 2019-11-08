package kr.co.popone.fitts.viewmodel.exchange.detail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.exchange.ExchangeCompleteFragment;

public final class ExchangeCompleteFragmentModule_ProvideExchangeDetailViewModelFactory implements Factory<ExchangeDetailViewModel> {
    private final Provider<ExchangeCompleteFragment> fragmentProvider;
    private final ExchangeCompleteFragmentModule module;
    private final Provider<ExchangeDetailViewModelFactory> viewModelFactoryProvider;

    public ExchangeCompleteFragmentModule_ProvideExchangeDetailViewModelFactory(ExchangeCompleteFragmentModule exchangeCompleteFragmentModule, Provider<ExchangeCompleteFragment> provider, Provider<ExchangeDetailViewModelFactory> provider2) {
        this.module = exchangeCompleteFragmentModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public ExchangeDetailViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static ExchangeDetailViewModel provideInstance(ExchangeCompleteFragmentModule exchangeCompleteFragmentModule, Provider<ExchangeCompleteFragment> provider, Provider<ExchangeDetailViewModelFactory> provider2) {
        return proxyProvideExchangeDetailViewModel(exchangeCompleteFragmentModule, (ExchangeCompleteFragment) provider.get(), (ExchangeDetailViewModelFactory) provider2.get());
    }

    public static ExchangeCompleteFragmentModule_ProvideExchangeDetailViewModelFactory create(ExchangeCompleteFragmentModule exchangeCompleteFragmentModule, Provider<ExchangeCompleteFragment> provider, Provider<ExchangeDetailViewModelFactory> provider2) {
        return new ExchangeCompleteFragmentModule_ProvideExchangeDetailViewModelFactory(exchangeCompleteFragmentModule, provider, provider2);
    }

    public static ExchangeDetailViewModel proxyProvideExchangeDetailViewModel(ExchangeCompleteFragmentModule exchangeCompleteFragmentModule, ExchangeCompleteFragment exchangeCompleteFragment, ExchangeDetailViewModelFactory exchangeDetailViewModelFactory) {
        return (ExchangeDetailViewModel) Preconditions.checkNotNull(exchangeCompleteFragmentModule.provideExchangeDetailViewModel(exchangeCompleteFragment, exchangeDetailViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
