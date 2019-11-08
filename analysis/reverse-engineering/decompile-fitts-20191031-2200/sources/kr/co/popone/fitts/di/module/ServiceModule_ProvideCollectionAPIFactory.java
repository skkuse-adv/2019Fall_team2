package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.collection.CollectionAPI;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideCollectionAPIFactory implements Factory<CollectionAPI> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideCollectionAPIFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public CollectionAPI get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static CollectionAPI provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideCollectionAPI(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvideCollectionAPIFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideCollectionAPIFactory(serviceModule, provider);
    }

    public static CollectionAPI proxyProvideCollectionAPI(ServiceModule serviceModule, Retrofit retrofit) {
        return (CollectionAPI) Preconditions.checkNotNull(serviceModule.provideCollectionAPI(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
