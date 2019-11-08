package kr.co.popone.fitts.viewmodel.exchange.detail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.repository.ExchangeRepository;

public final class ExchangeCompleteActivityModule_ProvidesViewModelFactoryFactory implements Factory<ExchangeDetailViewModelFactory> {
    private final Provider<ExchangeRepository> exchangeRepositoryProvider;
    private final ExchangeCompleteActivityModule module;

    public ExchangeCompleteActivityModule_ProvidesViewModelFactoryFactory(ExchangeCompleteActivityModule exchangeCompleteActivityModule, Provider<ExchangeRepository> provider) {
        this.module = exchangeCompleteActivityModule;
        this.exchangeRepositoryProvider = provider;
    }

    public ExchangeDetailViewModelFactory get() {
        return provideInstance(this.module, this.exchangeRepositoryProvider);
    }

    public static ExchangeDetailViewModelFactory provideInstance(ExchangeCompleteActivityModule exchangeCompleteActivityModule, Provider<ExchangeRepository> provider) {
        return proxyProvidesViewModelFactory(exchangeCompleteActivityModule, (ExchangeRepository) provider.get());
    }

    public static ExchangeCompleteActivityModule_ProvidesViewModelFactoryFactory create(ExchangeCompleteActivityModule exchangeCompleteActivityModule, Provider<ExchangeRepository> provider) {
        return new ExchangeCompleteActivityModule_ProvidesViewModelFactoryFactory(exchangeCompleteActivityModule, provider);
    }

    public static ExchangeDetailViewModelFactory proxyProvidesViewModelFactory(ExchangeCompleteActivityModule exchangeCompleteActivityModule, ExchangeRepository exchangeRepository) {
        return (ExchangeDetailViewModelFactory) Preconditions.checkNotNull(exchangeCompleteActivityModule.providesViewModelFactory(exchangeRepository), "Cannot return null from a non-@Nullable @Provides method");
    }
}
