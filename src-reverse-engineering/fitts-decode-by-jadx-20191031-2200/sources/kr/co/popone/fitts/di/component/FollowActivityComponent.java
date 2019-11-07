package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.follow.FollowActivity;

public interface FollowActivityComponent extends AndroidInjector<FollowActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<FollowActivity> {
    }
}
