package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.collection.MixedCollectionActivity;

public interface MixedCollectionActivityComponent extends AndroidInjector<MixedCollectionActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<MixedCollectionActivity> {
    }
}
