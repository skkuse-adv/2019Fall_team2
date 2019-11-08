package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.product.ProductAPI;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideProductAPIFactory implements Factory<ProductAPI> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideProductAPIFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public ProductAPI get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static ProductAPI provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideProductAPI(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvideProductAPIFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideProductAPIFactory(serviceModule, provider);
    }

    public static ProductAPI proxyProvideProductAPI(ServiceModule serviceModule, Retrofit retrofit) {
        return (ProductAPI) Preconditions.checkNotNull(serviceModule.provideProductAPI(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
