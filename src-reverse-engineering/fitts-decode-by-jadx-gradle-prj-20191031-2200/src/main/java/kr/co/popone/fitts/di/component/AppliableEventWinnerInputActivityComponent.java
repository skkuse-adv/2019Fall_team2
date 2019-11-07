package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.event.AppliableEventWinnerInputActivity;

public interface AppliableEventWinnerInputActivityComponent extends AndroidInjector<AppliableEventWinnerInputActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<AppliableEventWinnerInputActivity> {
    }
}
