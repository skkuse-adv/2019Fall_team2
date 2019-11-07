package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.identification.view.IdentificationActivity;

public interface IdentificationActivityComponent extends AndroidInjector<IdentificationActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<IdentificationActivity> {
    }
}
