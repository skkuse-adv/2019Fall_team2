package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.event.AppliableEventActivity;

public interface AppliableEventActivityComponent extends AndroidInjector<AppliableEventActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<AppliableEventActivity> {
    }
}
