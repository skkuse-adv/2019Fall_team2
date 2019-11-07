package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kr.co.popone.fitts.http.GlobeHttpHandler;

public final class GlobeConfigModule_ProvideGlobeHttpHandler$app_productionFittsReleaseFactory implements Factory<GlobeHttpHandler> {
    private final GlobeConfigModule module;

    public GlobeConfigModule_ProvideGlobeHttpHandler$app_productionFittsReleaseFactory(GlobeConfigModule globeConfigModule) {
        this.module = globeConfigModule;
    }

    public GlobeHttpHandler get() {
        return provideInstance(this.module);
    }

    public static GlobeHttpHandler provideInstance(GlobeConfigModule globeConfigModule) {
        return proxyProvideGlobeHttpHandler$app_productionFittsRelease(globeConfigModule);
    }

    public static GlobeConfigModule_ProvideGlobeHttpHandler$app_productionFittsReleaseFactory create(GlobeConfigModule globeConfigModule) {
        return new GlobeConfigModule_ProvideGlobeHttpHandler$app_productionFittsReleaseFactory(globeConfigModule);
    }

    public static GlobeHttpHandler proxyProvideGlobeHttpHandler$app_productionFittsRelease(GlobeConfigModule globeConfigModule) {
        return (GlobeHttpHandler) Preconditions.checkNotNull(globeConfigModule.provideGlobeHttpHandler$app_productionFittsRelease(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
