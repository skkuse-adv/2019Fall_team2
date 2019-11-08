package kr.co.popone.fitts.feature.event;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.event.EventAPI;
import kr.co.popone.fitts.model.user.UserAPI;

public final class EventShopWebActivity_MembersInjector implements MembersInjector<EventShopWebActivity> {
    private final Provider<EventAPI> eventAPIProvider;
    private final Provider<UserAPI> userAPIProvider;

    public EventShopWebActivity_MembersInjector(Provider<EventAPI> provider, Provider<UserAPI> provider2) {
        this.eventAPIProvider = provider;
        this.userAPIProvider = provider2;
    }

    public static MembersInjector<EventShopWebActivity> create(Provider<EventAPI> provider, Provider<UserAPI> provider2) {
        return new EventShopWebActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(EventShopWebActivity eventShopWebActivity) {
        injectEventAPI(eventShopWebActivity, (EventAPI) this.eventAPIProvider.get());
        injectUserAPI(eventShopWebActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectEventAPI(EventShopWebActivity eventShopWebActivity, EventAPI eventAPI) {
        eventShopWebActivity.eventAPI = eventAPI;
    }

    public static void injectUserAPI(EventShopWebActivity eventShopWebActivity, UserAPI userAPI) {
        eventShopWebActivity.userAPI = userAPI;
    }
}
