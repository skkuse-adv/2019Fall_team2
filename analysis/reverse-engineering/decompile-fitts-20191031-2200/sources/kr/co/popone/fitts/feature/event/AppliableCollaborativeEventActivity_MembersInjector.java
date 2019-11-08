package kr.co.popone.fitts.feature.event;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.event.EventAPI;

public final class AppliableCollaborativeEventActivity_MembersInjector implements MembersInjector<AppliableCollaborativeEventActivity> {
    private final Provider<EventAPI> eventAPIProvider;
    private final Provider<EventTracker> eventTrackerProvider;

    public AppliableCollaborativeEventActivity_MembersInjector(Provider<EventAPI> provider, Provider<EventTracker> provider2) {
        this.eventAPIProvider = provider;
        this.eventTrackerProvider = provider2;
    }

    public static MembersInjector<AppliableCollaborativeEventActivity> create(Provider<EventAPI> provider, Provider<EventTracker> provider2) {
        return new AppliableCollaborativeEventActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(AppliableCollaborativeEventActivity appliableCollaborativeEventActivity) {
        injectEventAPI(appliableCollaborativeEventActivity, (EventAPI) this.eventAPIProvider.get());
        injectEventTracker(appliableCollaborativeEventActivity, (EventTracker) this.eventTrackerProvider.get());
    }

    public static void injectEventAPI(AppliableCollaborativeEventActivity appliableCollaborativeEventActivity, EventAPI eventAPI) {
        appliableCollaborativeEventActivity.eventAPI = eventAPI;
    }

    public static void injectEventTracker(AppliableCollaborativeEventActivity appliableCollaborativeEventActivity, EventTracker eventTracker) {
        appliableCollaborativeEventActivity.eventTracker = eventTracker;
    }
}
