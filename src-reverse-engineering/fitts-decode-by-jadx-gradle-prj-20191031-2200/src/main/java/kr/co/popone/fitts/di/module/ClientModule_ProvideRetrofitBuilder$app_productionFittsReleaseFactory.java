package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.Retrofit.Builder;

public final class ClientModule_ProvideRetrofitBuilder$app_productionFittsReleaseFactory implements Factory<Builder> {
    private final ClientModule module;

    public ClientModule_ProvideRetrofitBuilder$app_productionFittsReleaseFactory(ClientModule clientModule) {
        this.module = clientModule;
    }

    public Builder get() {
        return provideInstance(this.module);
    }

    public static Builder provideInstance(ClientModule clientModule) {
        return proxyProvideRetrofitBuilder$app_productionFittsRelease(clientModule);
    }

    public static ClientModule_ProvideRetrofitBuilder$app_productionFittsReleaseFactory create(ClientModule clientModule) {
        return new ClientModule_ProvideRetrofitBuilder$app_productionFittsReleaseFactory(clientModule);
    }

    public static Builder proxyProvideRetrofitBuilder$app_productionFittsRelease(ClientModule clientModule) {
        return (Builder) Preconditions.checkNotNull(clientModule.provideRetrofitBuilder$app_productionFittsRelease(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
