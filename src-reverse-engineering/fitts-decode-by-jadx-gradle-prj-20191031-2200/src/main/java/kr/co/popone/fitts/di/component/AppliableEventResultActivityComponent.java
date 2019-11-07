package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.event.AppliableEventResultActivity;

public interface AppliableEventResultActivityComponent extends AndroidInjector<AppliableEventResultActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<AppliableEventResultActivity> {
    }
}
