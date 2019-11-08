package kr.co.popone.fitts.viewmodel.home;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.home.HomeFragment;
import kr.co.popone.fitts.repository.home.HomeRepository;
import org.jetbrains.annotations.NotNull;

public final class HomeModule {
    @NotNull
    public final HomeViewModel provideHomeViewModel(@NotNull HomeFragment homeFragment, @NotNull HomeViewModelFactory homeViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(homeFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(homeViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((Fragment) homeFragment, (Factory) homeViewModelFactory).get(HomeViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(fr…meViewModel::class.java)]");
        return (HomeViewModel) viewModel;
    }

    @NotNull
    public final HomeViewModelFactory providesViewModelFactory(@NotNull HomeRepository homeRepository, @NotNull EventTracker eventTracker) {
        Intrinsics.checkParameterIsNotNull(homeRepository, "repository");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        return new HomeViewModelFactory(homeRepository, eventTracker);
    }
}
