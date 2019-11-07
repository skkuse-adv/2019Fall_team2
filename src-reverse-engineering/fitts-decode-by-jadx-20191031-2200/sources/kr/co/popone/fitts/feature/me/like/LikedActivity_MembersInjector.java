package kr.co.popone.fitts.feature.me.like;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.utils.ActionLogUtil;

public final class LikedActivity_MembersInjector implements MembersInjector<LikedActivity> {
    private final Provider<ActionLogUtil> actionLogUtilProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<PostAPI> postAPIProvider;
    private final Provider<UserAPI> userAPIProvider;

    public LikedActivity_MembersInjector(Provider<EventTracker> provider, Provider<PostAPI> provider2, Provider<UserAPI> provider3, Provider<ActionLogUtil> provider4) {
        this.eventTrackerProvider = provider;
        this.postAPIProvider = provider2;
        this.userAPIProvider = provider3;
        this.actionLogUtilProvider = provider4;
    }

    public static MembersInjector<LikedActivity> create(Provider<EventTracker> provider, Provider<PostAPI> provider2, Provider<UserAPI> provider3, Provider<ActionLogUtil> provider4) {
        return new LikedActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(LikedActivity likedActivity) {
        injectEventTracker(likedActivity, (EventTracker) this.eventTrackerProvider.get());
        injectPostAPI(likedActivity, (PostAPI) this.postAPIProvider.get());
        injectUserAPI(likedActivity, (UserAPI) this.userAPIProvider.get());
        injectActionLogUtil(likedActivity, (ActionLogUtil) this.actionLogUtilProvider.get());
    }

    public static void injectEventTracker(LikedActivity likedActivity, EventTracker eventTracker) {
        likedActivity.eventTracker = eventTracker;
    }

    public static void injectPostAPI(LikedActivity likedActivity, PostAPI postAPI) {
        likedActivity.postAPI = postAPI;
    }

    public static void injectUserAPI(LikedActivity likedActivity, UserAPI userAPI) {
        likedActivity.userAPI = userAPI;
    }

    public static void injectActionLogUtil(LikedActivity likedActivity, ActionLogUtil actionLogUtil) {
        likedActivity.actionLogUtil = actionLogUtil;
    }
}
