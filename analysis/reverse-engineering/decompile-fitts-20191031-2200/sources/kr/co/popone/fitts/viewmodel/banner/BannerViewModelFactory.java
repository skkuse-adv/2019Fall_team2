package kr.co.popone.fitts.viewmodel.banner;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class BannerViewModelFactory extends BaseViewModelFactory {
    @NotNull
    private final ActionLogAPI actionLogAPI;
    @NotNull
    private final FittsSchemeHandler schemeHandler;
    @NotNull
    private final FittsServiceRepository serviceRepository;

    @NotNull
    public final FittsServiceRepository getServiceRepository() {
        return this.serviceRepository;
    }

    @NotNull
    public final FittsSchemeHandler getSchemeHandler() {
        return this.schemeHandler;
    }

    @NotNull
    public final ActionLogAPI getActionLogAPI() {
        return this.actionLogAPI;
    }

    public BannerViewModelFactory(@NotNull FittsServiceRepository fittsServiceRepository, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull ActionLogAPI actionLogAPI2) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(actionLogAPI2, "actionLogAPI");
        this.serviceRepository = fittsServiceRepository;
        this.schemeHandler = fittsSchemeHandler;
        this.actionLogAPI = actionLogAPI2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new BannerViewModel(this.serviceRepository, this.schemeHandler, this.actionLogAPI);
    }
}
