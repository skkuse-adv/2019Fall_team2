package kr.co.popone.fitts.feature.post;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class PostFirstWriteNoticeActivity_MembersInjector implements MembersInjector<PostFirstWriteNoticeActivity> {
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;

    public PostFirstWriteNoticeActivity_MembersInjector(Provider<FittsSchemeHandler> provider) {
        this.schemeHandlerProvider = provider;
    }

    public static MembersInjector<PostFirstWriteNoticeActivity> create(Provider<FittsSchemeHandler> provider) {
        return new PostFirstWriteNoticeActivity_MembersInjector(provider);
    }

    public void injectMembers(PostFirstWriteNoticeActivity postFirstWriteNoticeActivity) {
        injectSchemeHandler(postFirstWriteNoticeActivity, (FittsSchemeHandler) this.schemeHandlerProvider.get());
    }

    public static void injectSchemeHandler(PostFirstWriteNoticeActivity postFirstWriteNoticeActivity, FittsSchemeHandler fittsSchemeHandler) {
        postFirstWriteNoticeActivity.schemeHandler = fittsSchemeHandler;
    }
}
