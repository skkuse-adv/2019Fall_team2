package kr.co.popone.fitts.feature.post;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.post.PostAPI;

public final class PostingViolationNoticeActivity_MembersInjector implements MembersInjector<PostingViolationNoticeActivity> {
    private final Provider<PostAPI> postAPIProvider;

    public PostingViolationNoticeActivity_MembersInjector(Provider<PostAPI> provider) {
        this.postAPIProvider = provider;
    }

    public static MembersInjector<PostingViolationNoticeActivity> create(Provider<PostAPI> provider) {
        return new PostingViolationNoticeActivity_MembersInjector(provider);
    }

    public void injectMembers(PostingViolationNoticeActivity postingViolationNoticeActivity) {
        injectPostAPI(postingViolationNoticeActivity, (PostAPI) this.postAPIProvider.get());
    }

    public static void injectPostAPI(PostingViolationNoticeActivity postingViolationNoticeActivity, PostAPI postAPI) {
        postingViolationNoticeActivity.postAPI = postAPI;
    }
}
