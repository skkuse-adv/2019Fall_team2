package kr.co.popone.fitts.feature.event;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.event.EventAPI;

public final class AppliableCollaborativeEventApplyActivity_MembersInjector implements MembersInjector<AppliableCollaborativeEventApplyActivity> {
    private final Provider<EventAPI> eventAPIProvider;

    public AppliableCollaborativeEventApplyActivity_MembersInjector(Provider<EventAPI> provider) {
        this.eventAPIProvider = provider;
    }

    public static MembersInjector<AppliableCollaborativeEventApplyActivity> create(Provider<EventAPI> provider) {
        return new AppliableCollaborativeEventApplyActivity_MembersInjector(provider);
    }

    public void injectMembers(AppliableCollaborativeEventApplyActivity appliableCollaborativeEventApplyActivity) {
        injectEventAPI(appliableCollaborativeEventApplyActivity, (EventAPI) this.eventAPIProvider.get());
    }

    public static void injectEventAPI(AppliableCollaborativeEventApplyActivity appliableCollaborativeEventApplyActivity, EventAPI eventAPI) {
        appliableCollaborativeEventApplyActivity.eventAPI = eventAPI;
    }
}
