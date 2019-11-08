package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.user.UserAPI;

public final class AppModule_ProvideCreatePostActivityUtilFactory implements Factory<CreatePostActivityUtil> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final AppModule module;
    private final Provider<FittsServiceRepository> serviceRepositoryProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public AppModule_ProvideCreatePostActivityUtilFactory(AppModule appModule, Provider<EventTracker> provider, Provider<UserAPI> provider2, Provider<FittsServiceRepository> provider3, Provider<SessionManager> provider4) {
        this.module = appModule;
        this.eventTrackerProvider = provider;
        this.userAPIProvider = provider2;
        this.serviceRepositoryProvider = provider3;
        this.sessionManagerProvider = provider4;
    }

    public CreatePostActivityUtil get() {
        return provideInstance(this.module, this.eventTrackerProvider, this.userAPIProvider, this.serviceRepositoryProvider, this.sessionManagerProvider);
    }

    public static CreatePostActivityUtil provideInstance(AppModule appModule, Provider<EventTracker> provider, Provider<UserAPI> provider2, Provider<FittsServiceRepository> provider3, Provider<SessionManager> provider4) {
        return proxyProvideCreatePostActivityUtil(appModule, (EventTracker) provider.get(), (UserAPI) provider2.get(), (FittsServiceRepository) provider3.get(), (SessionManager) provider4.get());
    }

    public static AppModule_ProvideCreatePostActivityUtilFactory create(AppModule appModule, Provider<EventTracker> provider, Provider<UserAPI> provider2, Provider<FittsServiceRepository> provider3, Provider<SessionManager> provider4) {
        AppModule_ProvideCreatePostActivityUtilFactory appModule_ProvideCreatePostActivityUtilFactory = new AppModule_ProvideCreatePostActivityUtilFactory(appModule, provider, provider2, provider3, provider4);
        return appModule_ProvideCreatePostActivityUtilFactory;
    }

    public static CreatePostActivityUtil proxyProvideCreatePostActivityUtil(AppModule appModule, EventTracker eventTracker, UserAPI userAPI, FittsServiceRepository fittsServiceRepository, SessionManager sessionManager) {
        return (CreatePostActivityUtil) Preconditions.checkNotNull(appModule.provideCreatePostActivityUtil(eventTracker, userAPI, fittsServiceRepository, sessionManager), "Cannot return null from a non-@Nullable @Provides method");
    }
}
