package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.remote.exchange.ExchangeApi;
import kr.co.popone.fitts.repository.ExchangeRepository;

public final class RepositoryModule_ProvideExchangeRepositoryFactory implements Factory<ExchangeRepository> {
    private final Provider<ExchangeApi> exchangeApiProvider;
    private final RepositoryModule module;

    public RepositoryModule_ProvideExchangeRepositoryFactory(RepositoryModule repositoryModule, Provider<ExchangeApi> provider) {
        this.module = repositoryModule;
        this.exchangeApiProvider = provider;
    }

    public ExchangeRepository get() {
        return provideInstance(this.module, this.exchangeApiProvider);
    }

    public static ExchangeRepository provideInstance(RepositoryModule repositoryModule, Provider<ExchangeApi> provider) {
        return proxyProvideExchangeRepository(repositoryModule, (ExchangeApi) provider.get());
    }

    public static RepositoryModule_ProvideExchangeRepositoryFactory create(RepositoryModule repositoryModule, Provider<ExchangeApi> provider) {
        return new RepositoryModule_ProvideExchangeRepositoryFactory(repositoryModule, provider);
    }

    public static ExchangeRepository proxyProvideExchangeRepository(RepositoryModule repositoryModule, ExchangeApi exchangeApi) {
        return (ExchangeRepository) Preconditions.checkNotNull(repositoryModule.provideExchangeRepository(exchangeApi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
