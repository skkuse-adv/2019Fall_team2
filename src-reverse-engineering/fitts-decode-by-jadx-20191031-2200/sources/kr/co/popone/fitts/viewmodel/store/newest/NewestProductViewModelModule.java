package kr.co.popone.fitts.viewmodel.store.newest;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.store.newest.StoreNewFeedFragment;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class NewestProductViewModelModule {
    @NotNull
    public final NewestProductViewModel provideHomeFeedViewModel(@NotNull StoreNewFeedFragment storeNewFeedFragment, @NotNull NewestProductViewModelFactory newestProductViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(storeNewFeedFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(newestProductViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((Fragment) storeNewFeedFragment, (Factory) newestProductViewModelFactory).get(NewestProductViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(fr…ctViewModel::class.java)]");
        return (NewestProductViewModel) viewModel;
    }

    @NotNull
    public final NewestProductViewModelFactory providesViewModelFactory(@NotNull StoreRepository storeRepository, @NotNull FittsServiceRepository fittsServiceRepository, @NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull SessionManager sessionManager, @NotNull EventTracker eventTracker) {
        Intrinsics.checkParameterIsNotNull(storeRepository, "storeRepository");
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(sessionManager, "sessionManager");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        NewestProductViewModelFactory newestProductViewModelFactory = new NewestProductViewModelFactory(storeRepository, fittsServiceRepository, fittsCommerceRepository, fittsSchemeHandler, sessionManager, eventTracker);
        return newestProductViewModelFactory;
    }
}
