package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.showroom.ShowRoomActivity;

public interface ShowRoomActivityComponent extends AndroidInjector<ShowRoomActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<ShowRoomActivity> {
    }
}
