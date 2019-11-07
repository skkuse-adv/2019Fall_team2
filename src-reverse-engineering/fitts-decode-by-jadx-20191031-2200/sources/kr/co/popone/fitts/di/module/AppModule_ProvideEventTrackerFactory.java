package kr.co.popone.fitts.di.module;

import com.google.firebase.analytics.FirebaseAnalytics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;

public final class AppModule_ProvideEventTrackerFactory implements Factory<EventTracker> {
    private final Provider<FirebaseAnalytics> firebaseAnalyticsProvider;
    private final AppModule module;

    public AppModule_ProvideEventTrackerFactory(AppModule appModule, Provider<FirebaseAnalytics> provider) {
        this.module = appModule;
        this.firebaseAnalyticsProvider = provider;
    }

    public EventTracker get() {
        return provideInstance(this.module, this.firebaseAnalyticsProvider);
    }

    public static EventTracker provideInstance(AppModule appModule, Provider<FirebaseAnalytics> provider) {
        return proxyProvideEventTracker(appModule, (FirebaseAnalytics) provider.get());
    }

    public static AppModule_ProvideEventTrackerFactory create(AppModule appModule, Provider<FirebaseAnalytics> provider) {
        return new AppModule_ProvideEventTrackerFactory(appModule, provider);
    }

    public static EventTracker proxyProvideEventTracker(AppModule appModule, FirebaseAnalytics firebaseAnalytics) {
        return (EventTracker) Preconditions.checkNotNull(appModule.provideEventTracker(firebaseAnalytics), "Cannot return null from a non-@Nullable @Provides method");
    }
}
