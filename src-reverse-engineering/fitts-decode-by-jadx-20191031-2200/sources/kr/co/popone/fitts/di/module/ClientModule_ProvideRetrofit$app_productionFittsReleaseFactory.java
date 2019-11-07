package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;

public final class ClientModule_ProvideRetrofit$app_productionFittsReleaseFactory implements Factory<Retrofit> {
    private final Provider<Builder> builderProvider;
    private final Provider<OkHttpClient> clientProvider;
    private final Provider<HttpUrl> httpUrlProvider;
    private final ClientModule module;

    public ClientModule_ProvideRetrofit$app_productionFittsReleaseFactory(ClientModule clientModule, Provider<Builder> provider, Provider<OkHttpClient> provider2, Provider<HttpUrl> provider3) {
        this.module = clientModule;
        this.builderProvider = provider;
        this.clientProvider = provider2;
        this.httpUrlProvider = provider3;
    }

    public Retrofit get() {
        return provideInstance(this.module, this.builderProvider, this.clientProvider, this.httpUrlProvider);
    }

    public static Retrofit provideInstance(ClientModule clientModule, Provider<Builder> provider, Provider<OkHttpClient> provider2, Provider<HttpUrl> provider3) {
        return proxyProvideRetrofit$app_productionFittsRelease(clientModule, (Builder) provider.get(), (OkHttpClient) provider2.get(), (HttpUrl) provider3.get());
    }

    public static ClientModule_ProvideRetrofit$app_productionFittsReleaseFactory create(ClientModule clientModule, Provider<Builder> provider, Provider<OkHttpClient> provider2, Provider<HttpUrl> provider3) {
        return new ClientModule_ProvideRetrofit$app_productionFittsReleaseFactory(clientModule, provider, provider2, provider3);
    }

    public static Retrofit proxyProvideRetrofit$app_productionFittsRelease(ClientModule clientModule, Builder builder, OkHttpClient okHttpClient, HttpUrl httpUrl) {
        return (Retrofit) Preconditions.checkNotNull(clientModule.provideRetrofit$app_productionFittsRelease(builder, okHttpClient, httpUrl), "Cannot return null from a non-@Nullable @Provides method");
    }
}
