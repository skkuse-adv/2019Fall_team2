package kr.co.popone.fitts.feature.openweb;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class OpenWebActivity_MembersInjector implements MembersInjector<OpenWebActivity> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<FittsSchemeHandler> fittsSchemeHandlerProvider;

    public OpenWebActivity_MembersInjector(Provider<FittsSchemeHandler> provider, Provider<EventTracker> provider2) {
        this.fittsSchemeHandlerProvider = provider;
        this.eventTrackerProvider = provider2;
    }

    public static MembersInjector<OpenWebActivity> create(Provider<FittsSchemeHandler> provider, Provider<EventTracker> provider2) {
        return new OpenWebActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(OpenWebActivity openWebActivity) {
        injectFittsSchemeHandler(openWebActivity, (FittsSchemeHandler) this.fittsSchemeHandlerProvider.get());
        injectEventTracker(openWebActivity, (EventTracker) this.eventTrackerProvider.get());
    }

    public static void injectFittsSchemeHandler(OpenWebActivity openWebActivity, FittsSchemeHandler fittsSchemeHandler) {
        openWebActivity.fittsSchemeHandler = fittsSchemeHandler;
    }

    public static void injectEventTracker(OpenWebActivity openWebActivity, EventTracker eventTracker) {
        openWebActivity.eventTracker = eventTracker;
    }
}
