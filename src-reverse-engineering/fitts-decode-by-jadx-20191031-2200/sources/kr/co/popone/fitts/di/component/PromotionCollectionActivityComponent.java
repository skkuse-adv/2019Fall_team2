package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.collection.PromotionCollectionActivity;

public interface PromotionCollectionActivityComponent extends AndroidInjector<PromotionCollectionActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<PromotionCollectionActivity> {
    }
}
