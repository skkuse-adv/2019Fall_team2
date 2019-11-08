package kr.co.popone.fitts.feature.category;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.category.CategorySearchViewModel;

public final class CategorySearchActivity_MembersInjector implements MembersInjector<CategorySearchActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<CategorySearchViewModel> viewModelProvider;

    public CategorySearchActivity_MembersInjector(Provider<CategorySearchViewModel> provider, Provider<DispatchingAndroidInjector<Fragment>> provider2) {
        this.viewModelProvider = provider;
        this.dispatchingAndroidInjectorProvider = provider2;
    }

    public static MembersInjector<CategorySearchActivity> create(Provider<CategorySearchViewModel> provider, Provider<DispatchingAndroidInjector<Fragment>> provider2) {
        return new CategorySearchActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(CategorySearchActivity categorySearchActivity) {
        injectViewModel(categorySearchActivity, (CategorySearchViewModel) this.viewModelProvider.get());
        injectDispatchingAndroidInjector(categorySearchActivity, (DispatchingAndroidInjector) this.dispatchingAndroidInjectorProvider.get());
    }

    public static void injectViewModel(CategorySearchActivity categorySearchActivity, CategorySearchViewModel categorySearchViewModel) {
        categorySearchActivity.viewModel = categorySearchViewModel;
    }

    public static void injectDispatchingAndroidInjector(CategorySearchActivity categorySearchActivity, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        categorySearchActivity.dispatchingAndroidInjector = dispatchingAndroidInjector;
    }
}
