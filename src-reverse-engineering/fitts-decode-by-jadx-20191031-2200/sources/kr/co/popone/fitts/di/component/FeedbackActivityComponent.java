package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.setting.FeedbackActivity;

public interface FeedbackActivityComponent extends AndroidInjector<FeedbackActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<FeedbackActivity> {
    }
}
