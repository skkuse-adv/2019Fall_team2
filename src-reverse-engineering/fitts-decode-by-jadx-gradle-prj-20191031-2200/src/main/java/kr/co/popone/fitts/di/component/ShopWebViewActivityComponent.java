package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity;

public interface ShopWebViewActivityComponent extends AndroidInjector<ShopWebViewActivity> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<ShopWebViewActivity> {
    }
}
