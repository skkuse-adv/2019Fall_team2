package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.collection.PostCollectionActivity;

public interface PostCollectionActivityComponent extends AndroidInjector<PostCollectionActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<PostCollectionActivity> {
    }
}
