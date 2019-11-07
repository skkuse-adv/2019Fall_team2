package kr.co.popone.fitts.viewmodel.exchange.apply;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.repository.ExchangeRepository;

public final class ExchangeModule_ProvidesViewModelFactoryFactory implements Factory<ExchangeViewModelFactory> {
    private final Provider<ExchangeRepository> exchangeRepositoryProvider;
    private final ExchangeModule module;

    public ExchangeModule_ProvidesViewModelFactoryFactory(ExchangeModule exchangeModule, Provider<ExchangeRepository> provider) {
        this.module = exchangeModule;
        this.exchangeRepositoryProvider = provider;
    }

    public ExchangeViewModelFactory get() {
        return provideInstance(this.module, this.exchangeRepositoryProvider);
    }

    public static ExchangeViewModelFactory provideInstance(ExchangeModule exchangeModule, Provider<ExchangeRepository> provider) {
        return proxyProvidesViewModelFactory(exchangeModule, (ExchangeRepository) provider.get());
    }

    public static ExchangeModule_ProvidesViewModelFactoryFactory create(ExchangeModule exchangeModule, Provider<ExchangeRepository> provider) {
        return new ExchangeModule_ProvidesViewModelFactoryFactory(exchangeModule, provider);
    }

    public static ExchangeViewModelFactory proxyProvidesViewModelFactory(ExchangeModule exchangeModule, ExchangeRepository exchangeRepository) {
        return (ExchangeViewModelFactory) Preconditions.checkNotNull(exchangeModule.providesViewModelFactory(exchangeRepository), "Cannot return null from a non-@Nullable @Provides method");
    }
}
