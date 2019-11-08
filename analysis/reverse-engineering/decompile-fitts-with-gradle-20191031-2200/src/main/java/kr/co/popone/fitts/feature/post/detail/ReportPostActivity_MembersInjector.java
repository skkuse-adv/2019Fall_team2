package kr.co.popone.fitts.feature.post.detail;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.post.PostAPI;

public final class ReportPostActivity_MembersInjector implements MembersInjector<ReportPostActivity> {
    private final Provider<PostAPI> postAPIProvider;

    public ReportPostActivity_MembersInjector(Provider<PostAPI> provider) {
        this.postAPIProvider = provider;
    }

    public static MembersInjector<ReportPostActivity> create(Provider<PostAPI> provider) {
        return new ReportPostActivity_MembersInjector(provider);
    }

    public void injectMembers(ReportPostActivity reportPostActivity) {
        injectPostAPI(reportPostActivity, (PostAPI) this.postAPIProvider.get());
    }

    public static void injectPostAPI(ReportPostActivity reportPostActivity, PostAPI postAPI) {
        reportPostActivity.postAPI = postAPI;
    }
}
