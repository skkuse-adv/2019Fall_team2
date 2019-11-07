package kr.co.popone.fitts.di.module;

import com.google.firebase.analytics.FirebaseAnalytics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AppModule_ProvideFirebaseAnalyticsFactory implements Factory<FirebaseAnalytics> {
    private final AppModule module;

    public AppModule_ProvideFirebaseAnalyticsFactory(AppModule appModule) {
        this.module = appModule;
    }

    public FirebaseAnalytics get() {
        return provideInstance(this.module);
    }

    public static FirebaseAnalytics provideInstance(AppModule appModule) {
        return proxyProvideFirebaseAnalytics(appModule);
    }

    public static AppModule_ProvideFirebaseAnalyticsFactory create(AppModule appModule) {
        return new AppModule_ProvideFirebaseAnalyticsFactory(appModule);
    }

    public static FirebaseAnalytics proxyProvideFirebaseAnalytics(AppModule appModule) {
        return (FirebaseAnalytics) Preconditions.checkNotNull(appModule.provideFirebaseAnalytics(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
