package kr.co.popone.fitts.feature.event;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.event.EventAPI;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class MultiImageEventActivity_MembersInjector implements MembersInjector<MultiImageEventActivity> {
    private final Provider<EventAPI> eventAPIProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;

    public MultiImageEventActivity_MembersInjector(Provider<EventAPI> provider, Provider<FittsSchemeHandler> provider2, Provider<EventTracker> provider3) {
        this.eventAPIProvider = provider;
        this.schemeHandlerProvider = provider2;
        this.eventTrackerProvider = provider3;
    }

    public static MembersInjector<MultiImageEventActivity> create(Provider<EventAPI> provider, Provider<FittsSchemeHandler> provider2, Provider<EventTracker> provider3) {
        return new MultiImageEventActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(MultiImageEventActivity multiImageEventActivity) {
        injectEventAPI(multiImageEventActivity, (EventAPI) this.eventAPIProvider.get());
        injectSchemeHandler(multiImageEventActivity, (FittsSchemeHandler) this.schemeHandlerProvider.get());
        injectEventTracker(multiImageEventActivity, (EventTracker) this.eventTrackerProvider.get());
    }

    public static void injectEventAPI(MultiImageEventActivity multiImageEventActivity, EventAPI eventAPI) {
        multiImageEventActivity.eventAPI = eventAPI;
    }

    public static void injectSchemeHandler(MultiImageEventActivity multiImageEventActivity, FittsSchemeHandler fittsSchemeHandler) {
        multiImageEventActivity.schemeHandler = fittsSchemeHandler;
    }

    public static void injectEventTracker(MultiImageEventActivity multiImageEventActivity, EventTracker eventTracker) {
        multiImageEventActivity.eventTracker = eventTracker;
    }
}
