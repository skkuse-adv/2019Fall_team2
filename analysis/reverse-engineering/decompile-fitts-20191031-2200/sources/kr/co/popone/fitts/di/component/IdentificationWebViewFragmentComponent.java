package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.identification.view.IdentificationWebViewFragment;

public interface IdentificationWebViewFragmentComponent extends AndroidInjector<IdentificationWebViewFragment> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<IdentificationWebViewFragment> {
    }
}
