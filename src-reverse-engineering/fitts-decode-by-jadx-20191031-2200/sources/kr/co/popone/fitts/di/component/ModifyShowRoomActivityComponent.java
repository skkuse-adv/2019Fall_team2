package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.showroom.ModifyShowRoomActivity;

public interface ModifyShowRoomActivityComponent extends AndroidInjector<ModifyShowRoomActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<ModifyShowRoomActivity> {
    }
}
