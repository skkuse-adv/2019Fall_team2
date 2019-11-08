package kr.co.popone.fitts.feature.event;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.event.EventAPI;
import kr.co.popone.fitts.model.post.PostAPI;

public final class AppliableEventApplyActivity_MembersInjector implements MembersInjector<AppliableEventApplyActivity> {
    private final Provider<EventAPI> eventAPIProvider;
    private final Provider<PostAPI> postAPIProvider;

    public AppliableEventApplyActivity_MembersInjector(Provider<EventAPI> provider, Provider<PostAPI> provider2) {
        this.eventAPIProvider = provider;
        this.postAPIProvider = provider2;
    }

    public static MembersInjector<AppliableEventApplyActivity> create(Provider<EventAPI> provider, Provider<PostAPI> provider2) {
        return new AppliableEventApplyActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(AppliableEventApplyActivity appliableEventApplyActivity) {
        injectEventAPI(appliableEventApplyActivity, (EventAPI) this.eventAPIProvider.get());
        injectPostAPI(appliableEventApplyActivity, (PostAPI) this.postAPIProvider.get());
    }

    public static void injectEventAPI(AppliableEventApplyActivity appliableEventApplyActivity, EventAPI eventAPI) {
        appliableEventApplyActivity.eventAPI = eventAPI;
    }

    public static void injectPostAPI(AppliableEventApplyActivity appliableEventApplyActivity, PostAPI postAPI) {
        appliableEventApplyActivity.postAPI = postAPI;
    }
}
