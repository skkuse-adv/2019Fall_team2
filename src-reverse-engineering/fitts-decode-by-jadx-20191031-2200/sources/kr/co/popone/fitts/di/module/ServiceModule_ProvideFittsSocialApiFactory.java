package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.api.FittsSocialApi;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideFittsSocialApiFactory implements Factory<FittsSocialApi> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideFittsSocialApiFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public FittsSocialApi get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static FittsSocialApi provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideFittsSocialApi(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvideFittsSocialApiFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideFittsSocialApiFactory(serviceModule, provider);
    }

    public static FittsSocialApi proxyProvideFittsSocialApi(ServiceModule serviceModule, Retrofit retrofit) {
        return (FittsSocialApi) Preconditions.checkNotNull(serviceModule.provideFittsSocialApi(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
