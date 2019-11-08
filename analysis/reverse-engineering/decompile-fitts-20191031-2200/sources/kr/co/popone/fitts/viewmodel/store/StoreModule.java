package kr.co.popone.fitts.viewmodel.store;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.store.StoreFragment;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;

public final class StoreModule {
    @NotNull
    public final StoreViewModel provideStoreViewModel(@NotNull StoreFragment storeFragment, @NotNull StoreViewModelFactory storeViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(storeFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(storeViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((Fragment) storeFragment, (Factory) storeViewModelFactory).get(StoreViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(fr…reViewModel::class.java)]");
        return (StoreViewModel) viewModel;
    }

    @NotNull
    public final StoreViewModelFactory providesViewModelFactory(@NotNull UserAPI userAPI, @NotNull EventTracker eventTracker, @NotNull FittsServiceRepository fittsServiceRepository) {
        Intrinsics.checkParameterIsNotNull(userAPI, "userAPI");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        return new StoreViewModelFactory(userAPI, eventTracker, fittsServiceRepository);
    }
}
