package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.recommend.personalization.PersonalizedRecommendActivity;

public interface PersonalizedRecommendActivityComponent extends AndroidInjector<PersonalizedRecommendActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<PersonalizedRecommendActivity> {
    }
}
