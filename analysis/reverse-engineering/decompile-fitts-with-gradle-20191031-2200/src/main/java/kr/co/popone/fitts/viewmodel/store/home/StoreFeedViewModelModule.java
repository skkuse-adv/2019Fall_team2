package kr.co.popone.fitts.viewmodel.store.home;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.store.recommend.StoreFeedFragment;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.viewmodel.store.home.StoreFeedViewModel.StoreFeedType;
import org.jetbrains.annotations.NotNull;

public final class StoreFeedViewModelModule {
    @NotNull
    public final StoreFeedViewModel provideStoreHomeViewModel(@NotNull StoreFeedFragment storeFeedFragment, @NotNull StoreFeedViewModelFactory storeFeedViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(storeFeedFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(storeFeedViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((Fragment) storeFeedFragment, (Factory) storeFeedViewModelFactory).get(StoreFeedViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(fr…edViewModel::class.java)]");
        return (StoreFeedViewModel) viewModel;
    }

    @NotNull
    public final StoreFeedViewModelFactory providesViewModelFactory(@NotNull StoreFeedFragment storeFeedFragment, @NotNull StoreRepository storeRepository, @NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull EventTracker eventTracker, @NotNull SessionManager sessionManager, @NotNull FittsServiceRepository fittsServiceRepository) {
        StoreFeedFragment storeFeedFragment2 = storeFeedFragment;
        Intrinsics.checkParameterIsNotNull(storeFeedFragment, "fragment");
        StoreRepository storeRepository2 = storeRepository;
        Intrinsics.checkParameterIsNotNull(storeRepository, "storeRepository");
        FittsCommerceRepository fittsCommerceRepository2 = fittsCommerceRepository;
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        FittsSchemeHandler fittsSchemeHandler2 = fittsSchemeHandler;
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        EventTracker eventTracker2 = eventTracker;
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        SessionManager sessionManager2 = sessionManager;
        Intrinsics.checkParameterIsNotNull(sessionManager, "sessionManager");
        FittsServiceRepository fittsServiceRepository2 = fittsServiceRepository;
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository2, "serviceRepository");
        StoreFeedViewModelFactory storeFeedViewModelFactory = new StoreFeedViewModelFactory(storeRepository2, fittsCommerceRepository2, fittsSchemeHandler2, eventTracker2, fittsServiceRepository2, sessionManager2, getStoreFeedType(storeFeedFragment));
        return storeFeedViewModelFactory;
    }

    private final StoreFeedType getStoreFeedType(StoreFeedFragment storeFeedFragment) {
        Bundle arguments = storeFeedFragment.getArguments();
        if (arguments != null) {
            String str = StoreFeedFragment.KEY_STORE_FEED_TYPE;
            StoreFeedType storeFeedType = StoreFeedType.TODAY;
            try {
                String string = arguments.getString(str);
                Intrinsics.checkExpressionValueIsNotNull(string, "getString(key)");
                storeFeedType = StoreFeedType.valueOf(string);
            } catch (Exception unused) {
            }
            if (storeFeedType != null) {
                return storeFeedType;
            }
        }
        return StoreFeedType.TODAY;
    }
}
