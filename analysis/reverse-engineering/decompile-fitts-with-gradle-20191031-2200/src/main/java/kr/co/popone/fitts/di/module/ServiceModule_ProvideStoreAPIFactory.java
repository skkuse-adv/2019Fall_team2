package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.store.StoreAPI;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideStoreAPIFactory implements Factory<StoreAPI> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideStoreAPIFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public StoreAPI get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static StoreAPI provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideStoreAPI(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvideStoreAPIFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideStoreAPIFactory(serviceModule, provider);
    }

    public static StoreAPI proxyProvideStoreAPI(ServiceModule serviceModule, Retrofit retrofit) {
        return (StoreAPI) Preconditions.checkNotNull(serviceModule.provideStoreAPI(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
