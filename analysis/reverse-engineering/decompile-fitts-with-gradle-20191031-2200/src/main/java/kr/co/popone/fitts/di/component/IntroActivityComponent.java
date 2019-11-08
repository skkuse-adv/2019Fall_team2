package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.intro.IntroActivity;

public interface IntroActivityComponent extends AndroidInjector<IntroActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<IntroActivity> {
    }
}
