package kr.co.popone.fitts.viewmodel.exchange.detail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.exchange.ExchangeCompleteActivity;

public final class ExchangeApplyCompleteFragmentModule_ProvideExchangeDetailViewModelFactory implements Factory<ExchangeDetailViewModel> {
    private final Provider<ExchangeCompleteActivity> activityProvider;
    private final ExchangeApplyCompleteFragmentModule module;
    private final Provider<ExchangeDetailViewModelFactory> viewModelFactoryProvider;

    public ExchangeApplyCompleteFragmentModule_ProvideExchangeDetailViewModelFactory(ExchangeApplyCompleteFragmentModule exchangeApplyCompleteFragmentModule, Provider<ExchangeCompleteActivity> provider, Provider<ExchangeDetailViewModelFactory> provider2) {
        this.module = exchangeApplyCompleteFragmentModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public ExchangeDetailViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static ExchangeDetailViewModel provideInstance(ExchangeApplyCompleteFragmentModule exchangeApplyCompleteFragmentModule, Provider<ExchangeCompleteActivity> provider, Provider<ExchangeDetailViewModelFactory> provider2) {
        return proxyProvideExchangeDetailViewModel(exchangeApplyCompleteFragmentModule, (ExchangeCompleteActivity) provider.get(), (ExchangeDetailViewModelFactory) provider2.get());
    }

    public static ExchangeApplyCompleteFragmentModule_ProvideExchangeDetailViewModelFactory create(ExchangeApplyCompleteFragmentModule exchangeApplyCompleteFragmentModule, Provider<ExchangeCompleteActivity> provider, Provider<ExchangeDetailViewModelFactory> provider2) {
        return new ExchangeApplyCompleteFragmentModule_ProvideExchangeDetailViewModelFactory(exchangeApplyCompleteFragmentModule, provider, provider2);
    }

    public static ExchangeDetailViewModel proxyProvideExchangeDetailViewModel(ExchangeApplyCompleteFragmentModule exchangeApplyCompleteFragmentModule, ExchangeCompleteActivity exchangeCompleteActivity, ExchangeDetailViewModelFactory exchangeDetailViewModelFactory) {
        return (ExchangeDetailViewModel) Preconditions.checkNotNull(exchangeApplyCompleteFragmentModule.provideExchangeDetailViewModel(exchangeCompleteActivity, exchangeDetailViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
