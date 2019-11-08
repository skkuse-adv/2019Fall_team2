package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.WebActivity;

public interface WebComponent extends AndroidInjector<WebActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<WebActivity> {
    }
}
