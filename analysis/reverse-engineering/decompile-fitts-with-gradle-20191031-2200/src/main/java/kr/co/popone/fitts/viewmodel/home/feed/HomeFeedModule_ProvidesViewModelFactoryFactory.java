package kr.co.popone.fitts.viewmodel.home.feed;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.home.feed.HomeFeedFragment;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class HomeFeedModule_ProvidesViewModelFactoryFactory implements Factory<HomeFeedViewModelFactory> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<HomeFeedFragment> fragmentProvider;
    private final HomeFeedModule module;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<FittsSocialRepository> socialRepositoryProvider;

    public HomeFeedModule_ProvidesViewModelFactoryFactory(HomeFeedModule homeFeedModule, Provider<HomeFeedFragment> provider, Provider<FittsSocialRepository> provider2, Provider<FittsSchemeHandler> provider3, Provider<EventTracker> provider4, Provider<SessionManager> provider5) {
        this.module = homeFeedModule;
        this.fragmentProvider = provider;
        this.socialRepositoryProvider = provider2;
        this.schemeHandlerProvider = provider3;
        this.eventTrackerProvider = provider4;
        this.sessionManagerProvider = provider5;
    }

    public HomeFeedViewModelFactory get() {
        return provideInstance(this.module, this.fragmentProvider, this.socialRepositoryProvider, this.schemeHandlerProvider, this.eventTrackerProvider, this.sessionManagerProvider);
    }

    public static HomeFeedViewModelFactory provideInstance(HomeFeedModule homeFeedModule, Provider<HomeFeedFragment> provider, Provider<FittsSocialRepository> provider2, Provider<FittsSchemeHandler> provider3, Provider<EventTracker> provider4, Provider<SessionManager> provider5) {
        return proxyProvidesViewModelFactory(homeFeedModule, (HomeFeedFragment) provider.get(), (FittsSocialRepository) provider2.get(), (FittsSchemeHandler) provider3.get(), (EventTracker) provider4.get(), (SessionManager) provider5.get());
    }

    public static HomeFeedModule_ProvidesViewModelFactoryFactory create(HomeFeedModule homeFeedModule, Provider<HomeFeedFragment> provider, Provider<FittsSocialRepository> provider2, Provider<FittsSchemeHandler> provider3, Provider<EventTracker> provider4, Provider<SessionManager> provider5) {
        HomeFeedModule_ProvidesViewModelFactoryFactory homeFeedModule_ProvidesViewModelFactoryFactory = new HomeFeedModule_ProvidesViewModelFactoryFactory(homeFeedModule, provider, provider2, provider3, provider4, provider5);
        return homeFeedModule_ProvidesViewModelFactoryFactory;
    }

    public static HomeFeedViewModelFactory proxyProvidesViewModelFactory(HomeFeedModule homeFeedModule, HomeFeedFragment homeFeedFragment, FittsSocialRepository fittsSocialRepository, FittsSchemeHandler fittsSchemeHandler, EventTracker eventTracker, SessionManager sessionManager) {
        return (HomeFeedViewModelFactory) Preconditions.checkNotNull(homeFeedModule.providesViewModelFactory(homeFeedFragment, fittsSocialRepository, fittsSchemeHandler, eventTracker, sessionManager), "Cannot return null from a non-@Nullable @Provides method");
    }
}
