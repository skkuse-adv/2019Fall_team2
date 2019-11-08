package kr.co.popone.fitts.viewmodel.exchange.detail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.repository.ExchangeRepository;

public final class ExchangeApplyCompleteFragmentModule_ProvidesViewModelFactoryFactory implements Factory<ExchangeDetailViewModelFactory> {
    private final Provider<ExchangeRepository> exchangeRepositoryProvider;
    private final ExchangeApplyCompleteFragmentModule module;

    public ExchangeApplyCompleteFragmentModule_ProvidesViewModelFactoryFactory(ExchangeApplyCompleteFragmentModule exchangeApplyCompleteFragmentModule, Provider<ExchangeRepository> provider) {
        this.module = exchangeApplyCompleteFragmentModule;
        this.exchangeRepositoryProvider = provider;
    }

    public ExchangeDetailViewModelFactory get() {
        return provideInstance(this.module, this.exchangeRepositoryProvider);
    }

    public static ExchangeDetailViewModelFactory provideInstance(ExchangeApplyCompleteFragmentModule exchangeApplyCompleteFragmentModule, Provider<ExchangeRepository> provider) {
        return proxyProvidesViewModelFactory(exchangeApplyCompleteFragmentModule, (ExchangeRepository) provider.get());
    }

    public static ExchangeApplyCompleteFragmentModule_ProvidesViewModelFactoryFactory create(ExchangeApplyCompleteFragmentModule exchangeApplyCompleteFragmentModule, Provider<ExchangeRepository> provider) {
        return new ExchangeApplyCompleteFragmentModule_ProvidesViewModelFactoryFactory(exchangeApplyCompleteFragmentModule, provider);
    }

    public static ExchangeDetailViewModelFactory proxyProvidesViewModelFactory(ExchangeApplyCompleteFragmentModule exchangeApplyCompleteFragmentModule, ExchangeRepository exchangeRepository) {
        return (ExchangeDetailViewModelFactory) Preconditions.checkNotNull(exchangeApplyCompleteFragmentModule.providesViewModelFactory(exchangeRepository), "Cannot return null from a non-@Nullable @Provides method");
    }
}
