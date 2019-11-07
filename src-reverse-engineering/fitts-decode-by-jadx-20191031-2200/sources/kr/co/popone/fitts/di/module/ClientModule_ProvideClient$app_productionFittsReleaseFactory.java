package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

public final class ClientModule_ProvideClient$app_productionFittsReleaseFactory implements Factory<OkHttpClient> {
    private final Provider<Interceptor> interceptProvider;
    private final ClientModule module;
    private final Provider<Builder> okHttpClientProvider;

    public ClientModule_ProvideClient$app_productionFittsReleaseFactory(ClientModule clientModule, Provider<Builder> provider, Provider<Interceptor> provider2) {
        this.module = clientModule;
        this.okHttpClientProvider = provider;
        this.interceptProvider = provider2;
    }

    public OkHttpClient get() {
        return provideInstance(this.module, this.okHttpClientProvider, this.interceptProvider);
    }

    public static OkHttpClient provideInstance(ClientModule clientModule, Provider<Builder> provider, Provider<Interceptor> provider2) {
        return proxyProvideClient$app_productionFittsRelease(clientModule, (Builder) provider.get(), (Interceptor) provider2.get());
    }

    public static ClientModule_ProvideClient$app_productionFittsReleaseFactory create(ClientModule clientModule, Provider<Builder> provider, Provider<Interceptor> provider2) {
        return new ClientModule_ProvideClient$app_productionFittsReleaseFactory(clientModule, provider, provider2);
    }

    public static OkHttpClient proxyProvideClient$app_productionFittsRelease(ClientModule clientModule, Builder builder, Interceptor interceptor) {
        return (OkHttpClient) Preconditions.checkNotNull(clientModule.provideClient$app_productionFittsRelease(builder, interceptor), "Cannot return null from a non-@Nullable @Provides method");
    }
}
