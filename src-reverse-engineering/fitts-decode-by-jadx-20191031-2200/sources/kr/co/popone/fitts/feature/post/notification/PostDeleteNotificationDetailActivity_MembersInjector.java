package kr.co.popone.fitts.feature.post.notification;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.post.PostAPI;

public final class PostDeleteNotificationDetailActivity_MembersInjector implements MembersInjector<PostDeleteNotificationDetailActivity> {
    private final Provider<PostAPI> postAPIProvider;

    public PostDeleteNotificationDetailActivity_MembersInjector(Provider<PostAPI> provider) {
        this.postAPIProvider = provider;
    }

    public static MembersInjector<PostDeleteNotificationDetailActivity> create(Provider<PostAPI> provider) {
        return new PostDeleteNotificationDetailActivity_MembersInjector(provider);
    }

    public void injectMembers(PostDeleteNotificationDetailActivity postDeleteNotificationDetailActivity) {
        injectPostAPI(postDeleteNotificationDetailActivity, (PostAPI) this.postAPIProvider.get());
    }

    public static void injectPostAPI(PostDeleteNotificationDetailActivity postDeleteNotificationDetailActivity, PostAPI postAPI) {
        postDeleteNotificationDetailActivity.postAPI = postAPI;
    }
}
