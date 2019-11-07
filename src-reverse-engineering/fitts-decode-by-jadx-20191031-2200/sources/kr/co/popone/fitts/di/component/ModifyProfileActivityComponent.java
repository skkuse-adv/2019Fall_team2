package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.me.ModifyProfileActivity;

public interface ModifyProfileActivityComponent extends AndroidInjector<ModifyProfileActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<ModifyProfileActivity> {
    }
}
