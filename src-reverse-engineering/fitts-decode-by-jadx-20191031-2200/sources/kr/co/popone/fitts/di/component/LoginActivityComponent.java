package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.intro.login.LoginActivity;

public interface LoginActivityComponent extends AndroidInjector<LoginActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<LoginActivity> {
    }
}
