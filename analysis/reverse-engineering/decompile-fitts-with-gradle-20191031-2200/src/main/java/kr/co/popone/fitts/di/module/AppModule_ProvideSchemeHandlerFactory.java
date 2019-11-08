package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class AppModule_ProvideSchemeHandlerFactory implements Factory<FittsSchemeHandler> {
    private final Provider<CreatePostActivityUtil> createPostActivityUtilProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final AppModule module;
    private final Provider<FittsServiceRepository> serviceRepositoryProvider;

    public AppModule_ProvideSchemeHandlerFactory(AppModule appModule, Provider<EventTracker> provider, Provider<FittsServiceRepository> provider2, Provider<CreatePostActivityUtil> provider3) {
        this.module = appModule;
        this.eventTrackerProvider = provider;
        this.serviceRepositoryProvider = provider2;
        this.createPostActivityUtilProvider = provider3;
    }

    public FittsSchemeHandler get() {
        return provideInstance(this.module, this.eventTrackerProvider, this.serviceRepositoryProvider, this.createPostActivityUtilProvider);
    }

    public static FittsSchemeHandler provideInstance(AppModule appModule, Provider<EventTracker> provider, Provider<FittsServiceRepository> provider2, Provider<CreatePostActivityUtil> provider3) {
        return proxyProvideSchemeHandler(appModule, (EventTracker) provider.get(), (FittsServiceRepository) provider2.get(), (CreatePostActivityUtil) provider3.get());
    }

    public static AppModule_ProvideSchemeHandlerFactory create(AppModule appModule, Provider<EventTracker> provider, Provider<FittsServiceRepository> provider2, Provider<CreatePostActivityUtil> provider3) {
        return new AppModule_ProvideSchemeHandlerFactory(appModule, provider, provider2, provider3);
    }

    public static FittsSchemeHandler proxyProvideSchemeHandler(AppModule appModule, EventTracker eventTracker, FittsServiceRepository fittsServiceRepository, CreatePostActivityUtil createPostActivityUtil) {
        return (FittsSchemeHandler) Preconditions.checkNotNull(appModule.provideSchemeHandler(eventTracker, fittsServiceRepository, createPostActivityUtil), "Cannot return null from a non-@Nullable @Provides method");
    }
}
