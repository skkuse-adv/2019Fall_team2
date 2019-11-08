package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.api.FittsCommerceApi;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideFittsCommerceApiFactory implements Factory<FittsCommerceApi> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideFittsCommerceApiFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public FittsCommerceApi get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static FittsCommerceApi provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideFittsCommerceApi(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvideFittsCommerceApiFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideFittsCommerceApiFactory(serviceModule, provider);
    }

    public static FittsCommerceApi proxyProvideFittsCommerceApi(ServiceModule serviceModule, Retrofit retrofit) {
        return (FittsCommerceApi) Preconditions.checkNotNull(serviceModule.provideFittsCommerceApi(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
