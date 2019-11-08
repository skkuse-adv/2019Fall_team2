package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient.Builder;

public final class ClientModule_ProvideClientBuilder$app_productionFittsReleaseFactory implements Factory<Builder> {
    private final ClientModule module;

    public ClientModule_ProvideClientBuilder$app_productionFittsReleaseFactory(ClientModule clientModule) {
        this.module = clientModule;
    }

    public Builder get() {
        return provideInstance(this.module);
    }

    public static Builder provideInstance(ClientModule clientModule) {
        return proxyProvideClientBuilder$app_productionFittsRelease(clientModule);
    }

    public static ClientModule_ProvideClientBuilder$app_productionFittsReleaseFactory create(ClientModule clientModule) {
        return new ClientModule_ProvideClientBuilder$app_productionFittsReleaseFactory(clientModule);
    }

    public static Builder proxyProvideClientBuilder$app_productionFittsRelease(ClientModule clientModule) {
        return (Builder) Preconditions.checkNotNull(clientModule.provideClientBuilder$app_productionFittsRelease(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
