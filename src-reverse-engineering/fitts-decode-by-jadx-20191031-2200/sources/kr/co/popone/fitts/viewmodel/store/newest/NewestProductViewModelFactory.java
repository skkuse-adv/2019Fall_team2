package kr.co.popone.fitts.viewmodel.store.newest;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class NewestProductViewModelFactory extends BaseViewModelFactory {
    private final FittsCommerceRepository commerceRepository;
    private final EventTracker eventTracker;
    private final FittsSchemeHandler schemeHandler;
    private final FittsServiceRepository serviceRepository;
    private final SessionManager sessionManager;
    private final StoreRepository storeRepository;

    public NewestProductViewModelFactory(@NotNull StoreRepository storeRepository2, @NotNull FittsServiceRepository fittsServiceRepository, @NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull SessionManager sessionManager2, @NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.storeRepository = storeRepository2;
        this.serviceRepository = fittsServiceRepository;
        this.commerceRepository = fittsCommerceRepository;
        this.schemeHandler = fittsSchemeHandler;
        this.sessionManager = sessionManager2;
        this.eventTracker = eventTracker2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        NewestProductViewModel newestProductViewModel = new NewestProductViewModel(this.storeRepository, this.serviceRepository, this.commerceRepository, this.schemeHandler, this.sessionManager, this.eventTracker);
        return newestProductViewModel;
    }
}
