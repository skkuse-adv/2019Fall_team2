package kr.co.popone.fitts.viewmodel.store.bridge;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.store.bridge.ShopBridgeActivity;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class StoreBridgeModule {
    @NotNull
    public final ShopBridgeViewModel provideStoreViewModel(@NotNull ShopBridgeActivity shopBridgeActivity, @NotNull StoreBridgeViewModelFactory storeBridgeViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(shopBridgeActivity, "activity");
        Intrinsics.checkParameterIsNotNull(storeBridgeViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) shopBridgeActivity, (Factory) storeBridgeViewModelFactory).get(ShopBridgeViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…geViewModel::class.java)]");
        return (ShopBridgeViewModel) viewModel;
    }

    @NotNull
    public final StoreBridgeViewModelFactory providesViewModelFactory(@NotNull ShopBridgeActivity shopBridgeActivity, @NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull StoreRepository storeRepository, @NotNull ActionLogAPI actionLogAPI, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull SessionManager sessionManager, @NotNull EventTracker eventTracker) {
        ShopBridgeActivity shopBridgeActivity2 = shopBridgeActivity;
        Intrinsics.checkParameterIsNotNull(shopBridgeActivity, "activity");
        FittsCommerceRepository fittsCommerceRepository2 = fittsCommerceRepository;
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        StoreRepository storeRepository2 = storeRepository;
        Intrinsics.checkParameterIsNotNull(storeRepository, "storeRepository");
        ActionLogAPI actionLogAPI2 = actionLogAPI;
        Intrinsics.checkParameterIsNotNull(actionLogAPI, "actionLogAPI");
        FittsSchemeHandler fittsSchemeHandler2 = fittsSchemeHandler;
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        SessionManager sessionManager2 = sessionManager;
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        EventTracker eventTracker2 = eventTracker;
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        StoreBridgeViewModelFactory storeBridgeViewModelFactory = new StoreBridgeViewModelFactory(shopBridgeActivity.getIntent().getLongExtra(ShopBridgeActivity.KEY_STORE_ID, -1), fittsCommerceRepository2, storeRepository2, actionLogAPI2, fittsSchemeHandler2, sessionManager2, eventTracker2);
        return storeBridgeViewModelFactory;
    }
}
