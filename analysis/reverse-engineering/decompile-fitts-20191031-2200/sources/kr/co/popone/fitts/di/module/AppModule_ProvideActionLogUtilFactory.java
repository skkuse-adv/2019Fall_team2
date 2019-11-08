package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.utils.ActionLogUtil;

public final class AppModule_ProvideActionLogUtilFactory implements Factory<ActionLogUtil> {
    private final Provider<ActionLogAPI> actionLogApiProvider;
    private final AppModule module;

    public AppModule_ProvideActionLogUtilFactory(AppModule appModule, Provider<ActionLogAPI> provider) {
        this.module = appModule;
        this.actionLogApiProvider = provider;
    }

    public ActionLogUtil get() {
        return provideInstance(this.module, this.actionLogApiProvider);
    }

    public static ActionLogUtil provideInstance(AppModule appModule, Provider<ActionLogAPI> provider) {
        return proxyProvideActionLogUtil(appModule, (ActionLogAPI) provider.get());
    }

    public static AppModule_ProvideActionLogUtilFactory create(AppModule appModule, Provider<ActionLogAPI> provider) {
        return new AppModule_ProvideActionLogUtilFactory(appModule, provider);
    }

    public static ActionLogUtil proxyProvideActionLogUtil(AppModule appModule, ActionLogAPI actionLogAPI) {
        return (ActionLogUtil) Preconditions.checkNotNull(appModule.provideActionLogUtil(actionLogAPI), "Cannot return null from a non-@Nullable @Provides method");
    }
}
