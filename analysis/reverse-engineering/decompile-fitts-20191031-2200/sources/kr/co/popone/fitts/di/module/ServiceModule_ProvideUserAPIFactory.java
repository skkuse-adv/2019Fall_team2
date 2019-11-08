package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.user.UserAPI;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideUserAPIFactory implements Factory<UserAPI> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideUserAPIFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public UserAPI get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static UserAPI provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideUserAPI(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvideUserAPIFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideUserAPIFactory(serviceModule, provider);
    }

    public static UserAPI proxyProvideUserAPI(ServiceModule serviceModule, Retrofit retrofit) {
        return (UserAPI) Preconditions.checkNotNull(serviceModule.provideUserAPI(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
