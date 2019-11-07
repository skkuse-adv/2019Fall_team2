package kr.co.popone.fitts.feature.post;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class PostVerificationFinishNoticeActivity_MembersInjector implements MembersInjector<PostVerificationFinishNoticeActivity> {
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;

    public PostVerificationFinishNoticeActivity_MembersInjector(Provider<FittsSchemeHandler> provider) {
        this.schemeHandlerProvider = provider;
    }

    public static MembersInjector<PostVerificationFinishNoticeActivity> create(Provider<FittsSchemeHandler> provider) {
        return new PostVerificationFinishNoticeActivity_MembersInjector(provider);
    }

    public void injectMembers(PostVerificationFinishNoticeActivity postVerificationFinishNoticeActivity) {
        injectSchemeHandler(postVerificationFinishNoticeActivity, (FittsSchemeHandler) this.schemeHandlerProvider.get());
    }

    public static void injectSchemeHandler(PostVerificationFinishNoticeActivity postVerificationFinishNoticeActivity, FittsSchemeHandler fittsSchemeHandler) {
        postVerificationFinishNoticeActivity.schemeHandler = fittsSchemeHandler;
    }
}
