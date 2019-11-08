package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.search.SearchAPI;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideSearchAPIFactory implements Factory<SearchAPI> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideSearchAPIFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public SearchAPI get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static SearchAPI provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideSearchAPI(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvideSearchAPIFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideSearchAPIFactory(serviceModule, provider);
    }

    public static SearchAPI proxyProvideSearchAPI(ServiceModule serviceModule, Retrofit retrofit) {
        return (SearchAPI) Preconditions.checkNotNull(serviceModule.provideSearchAPI(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
