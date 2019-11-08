package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.event.EventAPI;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideEventAPIFactory implements Factory<EventAPI> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideEventAPIFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public EventAPI get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static EventAPI provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideEventAPI(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvideEventAPIFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideEventAPIFactory(serviceModule, provider);
    }

    public static EventAPI proxyProvideEventAPI(ServiceModule serviceModule, Retrofit retrofit) {
        return (EventAPI) Preconditions.checkNotNull(serviceModule.provideEventAPI(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
