package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.event.AppliableEventApplyActivity;

public interface AppliableEventApplyActivityComponent extends AndroidInjector<AppliableEventApplyActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<AppliableEventApplyActivity> {
    }
}
