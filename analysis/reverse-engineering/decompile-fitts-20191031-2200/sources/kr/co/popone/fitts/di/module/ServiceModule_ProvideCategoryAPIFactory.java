package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.category.CategoryAPI;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideCategoryAPIFactory implements Factory<CategoryAPI> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideCategoryAPIFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public CategoryAPI get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static CategoryAPI provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideCategoryAPI(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvideCategoryAPIFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideCategoryAPIFactory(serviceModule, provider);
    }

    public static CategoryAPI proxyProvideCategoryAPI(ServiceModule serviceModule, Retrofit retrofit) {
        return (CategoryAPI) Preconditions.checkNotNull(serviceModule.provideCategoryAPI(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
