package kr.co.popone.fitts.feature.tag;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.utils.ActionLogUtil;

public final class TagSearchActivity_MembersInjector implements MembersInjector<TagSearchActivity> {
    private final Provider<ActionLogUtil> actionLogUtilProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<PostAPI> postAPIProvider;

    public TagSearchActivity_MembersInjector(Provider<EventTracker> provider, Provider<PostAPI> provider2, Provider<ActionLogUtil> provider3) {
        this.eventTrackerProvider = provider;
        this.postAPIProvider = provider2;
        this.actionLogUtilProvider = provider3;
    }

    public static MembersInjector<TagSearchActivity> create(Provider<EventTracker> provider, Provider<PostAPI> provider2, Provider<ActionLogUtil> provider3) {
        return new TagSearchActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(TagSearchActivity tagSearchActivity) {
        injectEventTracker(tagSearchActivity, (EventTracker) this.eventTrackerProvider.get());
        injectPostAPI(tagSearchActivity, (PostAPI) this.postAPIProvider.get());
        injectActionLogUtil(tagSearchActivity, (ActionLogUtil) this.actionLogUtilProvider.get());
    }

    public static void injectEventTracker(TagSearchActivity tagSearchActivity, EventTracker eventTracker) {
        tagSearchActivity.eventTracker = eventTracker;
    }

    public static void injectPostAPI(TagSearchActivity tagSearchActivity, PostAPI postAPI) {
        tagSearchActivity.postAPI = postAPI;
    }

    public static void injectActionLogUtil(TagSearchActivity tagSearchActivity, ActionLogUtil actionLogUtil) {
        tagSearchActivity.actionLogUtil = actionLogUtil;
    }
}
