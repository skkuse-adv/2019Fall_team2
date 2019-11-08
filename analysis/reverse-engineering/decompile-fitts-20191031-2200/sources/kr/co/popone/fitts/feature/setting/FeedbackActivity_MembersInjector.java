package kr.co.popone.fitts.feature.setting;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;

public final class FeedbackActivity_MembersInjector implements MembersInjector<FeedbackActivity> {
    private final Provider<FittsServiceRepository> fittsServiceRepositoryProvider;

    public FeedbackActivity_MembersInjector(Provider<FittsServiceRepository> provider) {
        this.fittsServiceRepositoryProvider = provider;
    }

    public static MembersInjector<FeedbackActivity> create(Provider<FittsServiceRepository> provider) {
        return new FeedbackActivity_MembersInjector(provider);
    }

    public void injectMembers(FeedbackActivity feedbackActivity) {
        injectFittsServiceRepository(feedbackActivity, (FittsServiceRepository) this.fittsServiceRepositoryProvider.get());
    }

    public static void injectFittsServiceRepository(FeedbackActivity feedbackActivity, FittsServiceRepository fittsServiceRepository) {
        feedbackActivity.fittsServiceRepository = fittsServiceRepository;
    }
}
