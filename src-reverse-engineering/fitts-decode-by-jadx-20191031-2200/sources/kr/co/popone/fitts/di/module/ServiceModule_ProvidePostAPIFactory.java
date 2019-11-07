package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.post.PostAPI;
import retrofit2.Retrofit;

public final class ServiceModule_ProvidePostAPIFactory implements Factory<PostAPI> {
    private final ServiceModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvidePostAPIFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public PostAPI get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static PostAPI provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvidePostAPI(serviceModule, (Retrofit) provider.get());
    }

    public static ServiceModule_ProvidePostAPIFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvidePostAPIFactory(serviceModule, provider);
    }

    public static PostAPI proxyProvidePostAPI(ServiceModule serviceModule, Retrofit retrofit) {
        return (PostAPI) Preconditions.checkNotNull(serviceModule.providePostAPI(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
