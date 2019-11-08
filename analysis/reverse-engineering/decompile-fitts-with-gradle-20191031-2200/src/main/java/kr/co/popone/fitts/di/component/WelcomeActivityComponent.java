package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.home.WelcomeActivity;

public interface WelcomeActivityComponent extends AndroidInjector<WelcomeActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<WelcomeActivity> {
    }
}
