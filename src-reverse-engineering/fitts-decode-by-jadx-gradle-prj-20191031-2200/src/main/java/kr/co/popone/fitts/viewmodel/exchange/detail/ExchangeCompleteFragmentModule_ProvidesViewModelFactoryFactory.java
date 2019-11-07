package kr.co.popone.fitts.viewmodel.exchange.detail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.repository.ExchangeRepository;

public final class ExchangeCompleteFragmentModule_ProvidesViewModelFactoryFactory implements Factory<ExchangeDetailViewModelFactory> {
    private final Provider<ExchangeRepository> exchangeRepositoryProvider;
    private final ExchangeCompleteFragmentModule module;

    public ExchangeCompleteFragmentModule_ProvidesViewModelFactoryFactory(ExchangeCompleteFragmentModule exchangeCompleteFragmentModule, Provider<ExchangeRepository> provider) {
        this.module = exchangeCompleteFragmentModule;
        this.exchangeRepositoryProvider = provider;
    }

    public ExchangeDetailViewModelFactory get() {
        return provideInstance(this.module, this.exchangeRepositoryProvider);
    }

    public static ExchangeDetailViewModelFactory provideInstance(ExchangeCompleteFragmentModule exchangeCompleteFragmentModule, Provider<ExchangeRepository> provider) {
        return proxyProvidesViewModelFactory(exchangeCompleteFragmentModule, (ExchangeRepository) provider.get());
    }

    public static ExchangeCompleteFragmentModule_ProvidesViewModelFactoryFactory create(ExchangeCompleteFragmentModule exchangeCompleteFragmentModule, Provider<ExchangeRepository> provider) {
        return new ExchangeCompleteFragmentModule_ProvidesViewModelFactoryFactory(exchangeCompleteFragmentModule, provider);
    }

    public static ExchangeDetailViewModelFactory proxyProvidesViewModelFactory(ExchangeCompleteFragmentModule exchangeCompleteFragmentModule, ExchangeRepository exchangeRepository) {
        return (ExchangeDetailViewModelFactory) Preconditions.checkNotNull(exchangeCompleteFragmentModule.providesViewModelFactory(exchangeRepository), "Cannot return null from a non-@Nullable @Provides method");
    }
}
