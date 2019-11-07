package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.remote.exchange.ExchangeApi;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideExchangeApiFactory implements Factory<ExchangeApi> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideExchangeApiFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public ExchangeApi get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static ExchangeApi provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideExchangeApi(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvideExchangeApiFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideExchangeApiFactory(serviceModule, provider);
    }

    public static ExchangeApi proxyProvideExchangeApi(ServiceModule serviceModule, Retrofit retrofit) {
        return (ExchangeApi) Preconditions.checkNotNull(serviceModule.provideExchangeApi(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
