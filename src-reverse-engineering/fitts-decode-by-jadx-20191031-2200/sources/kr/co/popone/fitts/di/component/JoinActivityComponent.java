package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.intro.join.JoinActivity;

public interface JoinActivityComponent extends AndroidInjector<JoinActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<JoinActivity> {
    }
}
