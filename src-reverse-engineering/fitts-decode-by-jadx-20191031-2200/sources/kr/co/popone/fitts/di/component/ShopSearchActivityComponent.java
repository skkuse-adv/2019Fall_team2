package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.search.ShopSearchActivity;

public interface ShopSearchActivityComponent extends AndroidInjector<ShopSearchActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<ShopSearchActivity> {
    }
}
