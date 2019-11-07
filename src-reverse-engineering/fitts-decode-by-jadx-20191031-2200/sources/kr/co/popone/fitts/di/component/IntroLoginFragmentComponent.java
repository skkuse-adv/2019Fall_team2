package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.intro.IntroLoginFragment;

public interface IntroLoginFragmentComponent extends AndroidInjector<IntroLoginFragment> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<IntroLoginFragment> {
    }
}
