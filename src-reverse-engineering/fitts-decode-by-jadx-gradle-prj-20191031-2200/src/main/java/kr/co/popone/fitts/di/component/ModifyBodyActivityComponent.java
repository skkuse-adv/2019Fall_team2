package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.me.ModifyBodyActivity;

public interface ModifyBodyActivityComponent extends AndroidInjector<ModifyBodyActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<ModifyBodyActivity> {
    }
}
