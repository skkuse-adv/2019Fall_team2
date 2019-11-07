package kr.co.popone.fitts.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AppModule_ProvideContextFactory implements Factory<Context> {
    private final AppModule module;

    public AppModule_ProvideContextFactory(AppModule appModule) {
        this.module = appModule;
    }

    public Context get() {
        return provideInstance(this.module);
    }

    public static Context provideInstance(AppModule appModule) {
        return proxyProvideContext(appModule);
    }

    public static AppModule_ProvideContextFactory create(AppModule appModule) {
        return new AppModule_ProvideContextFactory(appModule);
    }

    public static Context proxyProvideContext(AppModule appModule) {
        return (Context) Preconditions.checkNotNull(appModule.provideContext(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
