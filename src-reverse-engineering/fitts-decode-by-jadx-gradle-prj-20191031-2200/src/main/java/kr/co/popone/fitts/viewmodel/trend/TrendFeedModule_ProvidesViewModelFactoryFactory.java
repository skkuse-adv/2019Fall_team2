package kr.co.popone.fitts.viewmodel.trend;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.trend.TrendFeedActivity;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class TrendFeedModule_ProvidesViewModelFactoryFactory implements Factory<TrendFeedViewModelFactory> {
    private final Provider<TrendFeedActivity> activityProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final TrendFeedModule module;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<FittsSocialRepository> socialRepositoryProvider;

    public TrendFeedModule_ProvidesViewModelFactoryFactory(TrendFeedModule trendFeedModule, Provider<TrendFeedActivity> provider, Provider<SessionManager> provider2, Provider<FittsSchemeHandler> provider3, Provider<EventTracker> provider4, Provider<FittsSocialRepository> provider5) {
        this.module = trendFeedModule;
        this.activityProvider = provider;
        this.sessionManagerProvider = provider2;
        this.schemeHandlerProvider = provider3;
        this.eventTrackerProvider = provider4;
        this.socialRepositoryProvider = provider5;
    }

    public TrendFeedViewModelFactory get() {
        return provideInstance(this.module, this.activityProvider, this.sessionManagerProvider, this.schemeHandlerProvider, this.eventTrackerProvider, this.socialRepositoryProvider);
    }

    public static TrendFeedViewModelFactory provideInstance(TrendFeedModule trendFeedModule, Provider<TrendFeedActivity> provider, Provider<SessionManager> provider2, Provider<FittsSchemeHandler> provider3, Provider<EventTracker> provider4, Provider<FittsSocialRepository> provider5) {
        return proxyProvidesViewModelFactory(trendFeedModule, (TrendFeedActivity) provider.get(), (SessionManager) provider2.get(), (FittsSchemeHandler) provider3.get(), (EventTracker) provider4.get(), (FittsSocialRepository) provider5.get());
    }

    public static TrendFeedModule_ProvidesViewModelFactoryFactory create(TrendFeedModule trendFeedModule, Provider<TrendFeedActivity> provider, Provider<SessionManager> provider2, Provider<FittsSchemeHandler> provider3, Provider<EventTracker> provider4, Provider<FittsSocialRepository> provider5) {
        TrendFeedModule_ProvidesViewModelFactoryFactory trendFeedModule_ProvidesViewModelFactoryFactory = new TrendFeedModule_ProvidesViewModelFactoryFactory(trendFeedModule, provider, provider2, provider3, provider4, provider5);
        return trendFeedModule_ProvidesViewModelFactoryFactory;
    }

    public static TrendFeedViewModelFactory proxyProvidesViewModelFactory(TrendFeedModule trendFeedModule, TrendFeedActivity trendFeedActivity, SessionManager sessionManager, FittsSchemeHandler fittsSchemeHandler, EventTracker eventTracker, FittsSocialRepository fittsSocialRepository) {
        return (TrendFeedViewModelFactory) Preconditions.checkNotNull(trendFeedModule.providesViewModelFactory(trendFeedActivity, sessionManager, fittsSchemeHandler, eventTracker, fittsSocialRepository), "Cannot return null from a non-@Nullable @Provides method");
    }
}
