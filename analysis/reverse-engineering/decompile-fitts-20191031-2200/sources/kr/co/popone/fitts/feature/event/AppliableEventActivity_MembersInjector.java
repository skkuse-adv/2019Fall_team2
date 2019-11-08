package kr.co.popone.fitts.feature.event;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.event.EventAPI;

public final class AppliableEventActivity_MembersInjector implements MembersInjector<AppliableEventActivity> {
    private final Provider<EventAPI> eventAPIProvider;
    private final Provider<EventTracker> eventTrackerProvider;

    public AppliableEventActivity_MembersInjector(Provider<EventAPI> provider, Provider<EventTracker> provider2) {
        this.eventAPIProvider = provider;
        this.eventTrackerProvider = provider2;
    }

    public static MembersInjector<AppliableEventActivity> create(Provider<EventAPI> provider, Provider<EventTracker> provider2) {
        return new AppliableEventActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(AppliableEventActivity appliableEventActivity) {
        injectEventAPI(appliableEventActivity, (EventAPI) this.eventAPIProvider.get());
        injectEventTracker(appliableEventActivity, (EventTracker) this.eventTrackerProvider.get());
    }

    public static void injectEventAPI(AppliableEventActivity appliableEventActivity, EventAPI eventAPI) {
        appliableEventActivity.eventAPI = eventAPI;
    }

    public static void injectEventTracker(AppliableEventActivity appliableEventActivity, EventTracker eventTracker) {
        appliableEventActivity.eventTracker = eventTracker;
    }
}
