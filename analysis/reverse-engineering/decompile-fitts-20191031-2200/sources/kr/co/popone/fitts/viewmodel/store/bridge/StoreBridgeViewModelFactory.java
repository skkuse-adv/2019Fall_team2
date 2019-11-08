package kr.co.popone.fitts.viewmodel.store.bridge;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class StoreBridgeViewModelFactory extends BaseViewModelFactory {
    @NotNull
    private final ActionLogAPI actionLogAPI;
    @NotNull
    private final FittsCommerceRepository commerceRepository;
    @NotNull
    private final EventTracker eventTracker;
    @NotNull
    private final FittsSchemeHandler schemeHandler;
    @NotNull
    private final SessionManager sessionManager;
    private final long storeId;
    @NotNull
    private final StoreRepository storeRepository;

    public final long getStoreId() {
        return this.storeId;
    }

    @NotNull
    public final FittsCommerceRepository getCommerceRepository() {
        return this.commerceRepository;
    }

    @NotNull
    public final StoreRepository getStoreRepository() {
        return this.storeRepository;
    }

    @NotNull
    public final ActionLogAPI getActionLogAPI() {
        return this.actionLogAPI;
    }

    @NotNull
    public final FittsSchemeHandler getSchemeHandler() {
        return this.schemeHandler;
    }

    @NotNull
    public final SessionManager getSessionManager() {
        return this.sessionManager;
    }

    @NotNull
    public final EventTracker getEventTracker() {
        return this.eventTracker;
    }

    public StoreBridgeViewModelFactory(long j, @NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull StoreRepository storeRepository2, @NotNull ActionLogAPI actionLogAPI2, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull SessionManager sessionManager2, @NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        Intrinsics.checkParameterIsNotNull(actionLogAPI2, "actionLogAPI");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.storeId = j;
        this.commerceRepository = fittsCommerceRepository;
        this.storeRepository = storeRepository2;
        this.actionLogAPI = actionLogAPI2;
        this.schemeHandler = fittsSchemeHandler;
        this.sessionManager = sessionManager2;
        this.eventTracker = eventTracker2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        ShopBridgeViewModel shopBridgeViewModel = new ShopBridgeViewModel(this.storeId, this.commerceRepository, this.storeRepository, this.actionLogAPI, this.schemeHandler, this.sessionManager, this.eventTracker);
        return shopBridgeViewModel;
    }
}
