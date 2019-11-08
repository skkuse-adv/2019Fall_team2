package kr.co.popone.fitts.viewmodel.store.home;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.viewmodel.store.home.StoreFeedViewModel.StoreFeedType;
import org.jetbrains.annotations.NotNull;

public final class StoreFeedViewModelFactory extends BaseViewModelFactory {
    private final FittsCommerceRepository commerceRepository;
    private final EventTracker eventTracker;
    private final FittsSchemeHandler schemeHandler;
    private final FittsServiceRepository serviceRepository;
    private final SessionManager sessionManager;
    private final StoreFeedType storeFeedType;
    private final StoreRepository storeRepository;

    public StoreFeedViewModelFactory(@NotNull StoreRepository storeRepository2, @NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull EventTracker eventTracker2, @NotNull FittsServiceRepository fittsServiceRepository, @NotNull SessionManager sessionManager2, @NotNull StoreFeedType storeFeedType2) {
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        Intrinsics.checkParameterIsNotNull(storeFeedType2, "storeFeedType");
        this.storeRepository = storeRepository2;
        this.commerceRepository = fittsCommerceRepository;
        this.schemeHandler = fittsSchemeHandler;
        this.eventTracker = eventTracker2;
        this.serviceRepository = fittsServiceRepository;
        this.sessionManager = sessionManager2;
        this.storeFeedType = storeFeedType2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        StoreFeedViewModel storeFeedViewModel = new StoreFeedViewModel(this.storeRepository, this.commerceRepository, this.schemeHandler, this.eventTracker, this.serviceRepository, this.sessionManager, this.storeFeedType);
        return storeFeedViewModel;
    }
}
