package kr.co.popone.fitts.feature.event;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.event.EventAPI;
import kr.co.popone.fitts.model.user.UserAPI;

public final class AppliableEventWinnerInputActivity_MembersInjector implements MembersInjector<AppliableEventWinnerInputActivity> {
    private final Provider<EventAPI> eventAPIProvider;
    private final Provider<UserAPI> userAPIProvider;

    public AppliableEventWinnerInputActivity_MembersInjector(Provider<EventAPI> provider, Provider<UserAPI> provider2) {
        this.eventAPIProvider = provider;
        this.userAPIProvider = provider2;
    }

    public static MembersInjector<AppliableEventWinnerInputActivity> create(Provider<EventAPI> provider, Provider<UserAPI> provider2) {
        return new AppliableEventWinnerInputActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity) {
        injectEventAPI(appliableEventWinnerInputActivity, (EventAPI) this.eventAPIProvider.get());
        injectUserAPI(appliableEventWinnerInputActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectEventAPI(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity, EventAPI eventAPI) {
        appliableEventWinnerInputActivity.eventAPI = eventAPI;
    }

    public static void injectUserAPI(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity, UserAPI userAPI) {
        appliableEventWinnerInputActivity.userAPI = userAPI;
    }
}
