package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kr.co.popone.fitts.utils.DataHolderManager;

public final class AppModule_ProvideDataHoldermanagerFactory implements Factory<DataHolderManager> {
    private final AppModule module;

    public AppModule_ProvideDataHoldermanagerFactory(AppModule appModule) {
        this.module = appModule;
    }

    public DataHolderManager get() {
        return provideInstance(this.module);
    }

    public static DataHolderManager provideInstance(AppModule appModule) {
        return proxyProvideDataHoldermanager(appModule);
    }

    public static AppModule_ProvideDataHoldermanagerFactory create(AppModule appModule) {
        return new AppModule_ProvideDataHoldermanagerFactory(appModule);
    }

    public static DataHolderManager proxyProvideDataHoldermanager(AppModule appModule) {
        return (DataHolderManager) Preconditions.checkNotNull(appModule.provideDataHoldermanager(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
