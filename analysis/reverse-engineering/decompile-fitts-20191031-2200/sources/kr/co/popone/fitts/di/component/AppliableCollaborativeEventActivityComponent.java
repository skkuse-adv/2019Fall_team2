package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.event.AppliableCollaborativeEventActivity;

public interface AppliableCollaborativeEventActivityComponent extends AndroidInjector<AppliableCollaborativeEventActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<AppliableCollaborativeEventActivity> {
    }
}
