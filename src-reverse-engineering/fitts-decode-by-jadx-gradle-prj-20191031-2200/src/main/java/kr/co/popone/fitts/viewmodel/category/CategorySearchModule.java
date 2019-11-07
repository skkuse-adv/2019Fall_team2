package kr.co.popone.fitts.viewmodel.category;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.category.CategorySearchActivity;
import org.jetbrains.annotations.NotNull;

public final class CategorySearchModule {
    @NotNull
    public final CategorySearchViewModel provideCategorySearchActivityViewModel(@NotNull CategorySearchActivity categorySearchActivity, @NotNull CategorySearchViewModelFactory categorySearchViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(categorySearchActivity, "activity");
        Intrinsics.checkParameterIsNotNull(categorySearchViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) categorySearchActivity, (Factory) categorySearchViewModelFactory).get(CategorySearchViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…chViewModel::class.java)]");
        return (CategorySearchViewModel) viewModel;
    }

    @NotNull
    public final CategorySearchViewModelFactory providesViewModelFactory(@NotNull EventTracker eventTracker) {
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        return new CategorySearchViewModelFactory(eventTracker);
    }
}
