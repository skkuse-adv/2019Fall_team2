package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kr.co.popone.fitts.services.FittsNotificationHandler;

public final class AppModule_ProvideNotificationHandlerFactory implements Factory<FittsNotificationHandler> {
    private final AppModule module;

    public AppModule_ProvideNotificationHandlerFactory(AppModule appModule) {
        this.module = appModule;
    }

    public FittsNotificationHandler get() {
        return provideInstance(this.module);
    }

    public static FittsNotificationHandler provideInstance(AppModule appModule) {
        return proxyProvideNotificationHandler(appModule);
    }

    public static AppModule_ProvideNotificationHandlerFactory create(AppModule appModule) {
        return new AppModule_ProvideNotificationHandlerFactory(appModule);
    }

    public static FittsNotificationHandler proxyProvideNotificationHandler(AppModule appModule) {
        return (FittsNotificationHandler) Preconditions.checkNotNull(appModule.provideNotificationHandler(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
