package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.setting.ModifyUserInfoActivity;

public interface ModifyUserInfoActivityComponent extends AndroidInjector<ModifyUserInfoActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<ModifyUserInfoActivity> {
    }
}
