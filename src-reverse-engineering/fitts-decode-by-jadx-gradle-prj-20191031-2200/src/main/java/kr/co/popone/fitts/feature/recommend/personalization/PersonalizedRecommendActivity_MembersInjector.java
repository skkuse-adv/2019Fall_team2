package kr.co.popone.fitts.feature.recommend.personalization;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.utils.ActionLogUtil;

public final class PersonalizedRecommendActivity_MembersInjector implements MembersInjector<PersonalizedRecommendActivity> {
    private final Provider<ActionLogUtil> actionLogUtilProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<FittsSocialRepository> socialRepositoryProvider;
    private final Provider<UserAPI> userAPIProvider;

    public PersonalizedRecommendActivity_MembersInjector(Provider<EventTracker> provider, Provider<FittsSocialRepository> provider2, Provider<UserAPI> provider3, Provider<ActionLogUtil> provider4) {
        this.eventTrackerProvider = provider;
        this.socialRepositoryProvider = provider2;
        this.userAPIProvider = provider3;
        this.actionLogUtilProvider = provider4;
    }

    public static MembersInjector<PersonalizedRecommendActivity> create(Provider<EventTracker> provider, Provider<FittsSocialRepository> provider2, Provider<UserAPI> provider3, Provider<ActionLogUtil> provider4) {
        return new PersonalizedRecommendActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(PersonalizedRecommendActivity personalizedRecommendActivity) {
        injectEventTracker(personalizedRecommendActivity, (EventTracker) this.eventTrackerProvider.get());
        injectSocialRepository(personalizedRecommendActivity, (FittsSocialRepository) this.socialRepositoryProvider.get());
        injectUserAPI(personalizedRecommendActivity, (UserAPI) this.userAPIProvider.get());
        injectActionLogUtil(personalizedRecommendActivity, (ActionLogUtil) this.actionLogUtilProvider.get());
    }

    public static void injectEventTracker(PersonalizedRecommendActivity personalizedRecommendActivity, EventTracker eventTracker) {
        personalizedRecommendActivity.eventTracker = eventTracker;
    }

    public static void injectSocialRepository(PersonalizedRecommendActivity personalizedRecommendActivity, FittsSocialRepository fittsSocialRepository) {
        personalizedRecommendActivity.socialRepository = fittsSocialRepository;
    }

    public static void injectUserAPI(PersonalizedRecommendActivity personalizedRecommendActivity, UserAPI userAPI) {
        personalizedRecommendActivity.userAPI = userAPI;
    }

    public static void injectActionLogUtil(PersonalizedRecommendActivity personalizedRecommendActivity, ActionLogUtil actionLogUtil) {
        personalizedRecommendActivity.actionLogUtil = actionLogUtil;
    }
}
