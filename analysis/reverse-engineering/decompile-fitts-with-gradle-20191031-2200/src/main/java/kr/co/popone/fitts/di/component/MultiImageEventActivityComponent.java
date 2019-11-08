package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.event.MultiImageEventActivity;

public interface MultiImageEventActivityComponent extends AndroidInjector<MultiImageEventActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<MultiImageEventActivity> {
    }
}
