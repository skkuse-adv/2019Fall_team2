package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.post.ProfileInputActivity;

public interface ProfileInputActivityComponent extends AndroidInjector<ProfileInputActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<ProfileInputActivity> {
    }
}
