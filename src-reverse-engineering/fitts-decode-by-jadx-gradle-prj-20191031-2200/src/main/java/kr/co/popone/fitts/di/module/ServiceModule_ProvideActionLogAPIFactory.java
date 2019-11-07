package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideActionLogAPIFactory implements Factory<ActionLogAPI> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideActionLogAPIFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public ActionLogAPI get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static ActionLogAPI provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideActionLogAPI(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvideActionLogAPIFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideActionLogAPIFactory(serviceModule, provider);
    }

    public static ActionLogAPI proxyProvideActionLogAPI(ServiceModule serviceModule, Retrofit retrofit) {
        return (ActionLogAPI) Preconditions.checkNotNull(serviceModule.provideActionLogAPI(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
