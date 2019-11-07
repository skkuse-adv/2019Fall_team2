package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.event.EventShopWebActivity;

public interface EventShopWebActivityComponent extends AndroidInjector<EventShopWebActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<EventShopWebActivity> {
    }
}
