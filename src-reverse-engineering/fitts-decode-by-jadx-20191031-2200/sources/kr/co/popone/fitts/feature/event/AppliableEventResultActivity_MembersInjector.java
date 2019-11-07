package kr.co.popone.fitts.feature.event;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.event.EventAPI;

public final class AppliableEventResultActivity_MembersInjector implements MembersInjector<AppliableEventResultActivity> {
    private final Provider<EventAPI> eventAPIProvider;

    public AppliableEventResultActivity_MembersInjector(Provider<EventAPI> provider) {
        this.eventAPIProvider = provider;
    }

    public static MembersInjector<AppliableEventResultActivity> create(Provider<EventAPI> provider) {
        return new AppliableEventResultActivity_MembersInjector(provider);
    }

    public void injectMembers(AppliableEventResultActivity appliableEventResultActivity) {
        injectEventAPI(appliableEventResultActivity, (EventAPI) this.eventAPIProvider.get());
    }

    public static void injectEventAPI(AppliableEventResultActivity appliableEventResultActivity, EventAPI eventAPI) {
        appliableEventResultActivity.eventAPI = eventAPI;
    }
}
