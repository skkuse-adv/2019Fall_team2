package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.post.UserSizeInputActivity;

public interface UserSizeInputActivityComponent extends AndroidInjector<UserSizeInputActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<UserSizeInputActivity> {
    }
}
