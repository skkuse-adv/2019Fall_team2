package kr.co.popone.fitts.di.module;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AppModule_ProvideApplicationFactory implements Factory<Application> {
    private final AppModule module;

    public AppModule_ProvideApplicationFactory(AppModule appModule) {
        this.module = appModule;
    }

    public Application get() {
        return provideInstance(this.module);
    }

    public static Application provideInstance(AppModule appModule) {
        return proxyProvideApplication(appModule);
    }

    public static AppModule_ProvideApplicationFactory create(AppModule appModule) {
        return new AppModule_ProvideApplicationFactory(appModule);
    }

    public static Application proxyProvideApplication(AppModule appModule) {
        return (Application) Preconditions.checkNotNull(appModule.provideApplication(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
