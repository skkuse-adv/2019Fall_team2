package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.cart.CartAPI;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideCartAPIFactory implements Factory<CartAPI> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideCartAPIFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public CartAPI get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static CartAPI provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideCartAPI(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvideCartAPIFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideCartAPIFactory(serviceModule, provider);
    }

    public static CartAPI proxyProvideCartAPI(ServiceModule serviceModule, Retrofit retrofit) {
        return (CartAPI) Preconditions.checkNotNull(serviceModule.provideCartAPI(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
