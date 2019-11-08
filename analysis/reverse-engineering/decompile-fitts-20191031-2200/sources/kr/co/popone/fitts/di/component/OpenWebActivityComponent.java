package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.openweb.OpenWebActivity;

public interface OpenWebActivityComponent extends AndroidInjector<OpenWebActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<OpenWebActivity> {
    }
}
