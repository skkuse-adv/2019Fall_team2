package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.api.FittsServiceApi;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideFittsServiceApiFactory implements Factory<FittsServiceApi> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideFittsServiceApiFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public FittsServiceApi get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static FittsServiceApi provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideFittsServiceApi(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvideFittsServiceApiFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideFittsServiceApiFactory(serviceModule, provider);
    }

    public static FittsServiceApi proxyProvideFittsServiceApi(ServiceModule serviceModule, Retrofit retrofit) {
        return (FittsServiceApi) Preconditions.checkNotNull(serviceModule.provideFittsServiceApi(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
