package kr.co.popone.fitts.viewmodel.store.browser;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.repository.CartRepository;
import kr.co.popone.fitts.repository.ProductRepository;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class StoreBrowserModule {
    @NotNull
    public final StoreBrowserViewModel provideStoreViewModel(@NotNull StoreBrowserActivity storeBrowserActivity, @NotNull StoreBrowserViewModelFactory storeBrowserViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(storeBrowserActivity, "activity");
        Intrinsics.checkParameterIsNotNull(storeBrowserViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) storeBrowserActivity, (Factory) storeBrowserViewModelFactory).get(StoreBrowserViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…erViewModel::class.java)]");
        return (StoreBrowserViewModel) viewModel;
    }

    @NotNull
    public final StoreBrowserViewModelFactory providesViewModelFactory(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull ProductRepository productRepository, @NotNull StoreRepository storeRepository, @NotNull CartRepository cartRepository, @NotNull EventTracker eventTracker, @NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(productRepository, "productRepository");
        Intrinsics.checkParameterIsNotNull(storeRepository, "storeRepository");
        Intrinsics.checkParameterIsNotNull(cartRepository, "cartRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        StoreBrowserViewModelFactory storeBrowserViewModelFactory = new StoreBrowserViewModelFactory(fittsCommerceRepository, productRepository, storeRepository, cartRepository, eventTracker, fittsSchemeHandler);
        return storeBrowserViewModelFactory;
    }
}
