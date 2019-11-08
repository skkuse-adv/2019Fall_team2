package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.HttpUrl;

public final class GlobeConfigModule_ProvideBaseUrl$app_productionFittsReleaseFactory implements Factory<HttpUrl> {
    private final GlobeConfigModule module;

    public GlobeConfigModule_ProvideBaseUrl$app_productionFittsReleaseFactory(GlobeConfigModule globeConfigModule) {
        this.module = globeConfigModule;
    }

    public HttpUrl get() {
        return provideInstance(this.module);
    }

    public static HttpUrl provideInstance(GlobeConfigModule globeConfigModule) {
        return proxyProvideBaseUrl$app_productionFittsRelease(globeConfigModule);
    }

    public static GlobeConfigModule_ProvideBaseUrl$app_productionFittsReleaseFactory create(GlobeConfigModule globeConfigModule) {
        return new GlobeConfigModule_ProvideBaseUrl$app_productionFittsReleaseFactory(globeConfigModule);
    }

    public static HttpUrl proxyProvideBaseUrl$app_productionFittsRelease(GlobeConfigModule globeConfigModule) {
        return (HttpUrl) Preconditions.checkNotNull(globeConfigModule.provideBaseUrl$app_productionFittsRelease(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
