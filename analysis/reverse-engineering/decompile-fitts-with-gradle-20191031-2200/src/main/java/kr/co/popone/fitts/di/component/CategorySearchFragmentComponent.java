package kr.co.popone.fitts.di.component;

import dagger.android.AndroidInjector;
import kr.co.popone.fitts.feature.category.CategorySearchFragment;

public interface CategorySearchFragmentComponent extends AndroidInjector<CategorySearchFragment> {

    public static abstract class Builder extends dagger.android.AndroidInjector.Builder<CategorySearchFragment> {
    }
}
