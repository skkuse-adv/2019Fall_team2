package kr.co.popone.fitts.viewmodel.store.bridge.product;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.repository.PostRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class ProductBridgeViewModelFactory extends BaseViewModelFactory {
    @NotNull
    private final EventTracker eventTracker;
    @NotNull
    private final PostRepository postRepository;
    @NotNull
    private final FittsSchemeHandler schemeHandler;
    @NotNull
    private final FittsServiceRepository serviceRepository;
    @NotNull
    private final SessionManager sessionManager;

    @NotNull
    public final FittsServiceRepository getServiceRepository() {
        return this.serviceRepository;
    }

    @NotNull
    public final PostRepository getPostRepository() {
        return this.postRepository;
    }

    @NotNull
    public final FittsSchemeHandler getSchemeHandler() {
        return this.schemeHandler;
    }

    @NotNull
    public final EventTracker getEventTracker() {
        return this.eventTracker;
    }

    @NotNull
    public final SessionManager getSessionManager() {
        return this.sessionManager;
    }

    public ProductBridgeViewModelFactory(@NotNull FittsServiceRepository fittsServiceRepository, @NotNull PostRepository postRepository2, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull EventTracker eventTracker2, @NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(postRepository2, "postRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        this.serviceRepository = fittsServiceRepository;
        this.postRepository = postRepository2;
        this.schemeHandler = fittsSchemeHandler;
        this.eventTracker = eventTracker2;
        this.sessionManager = sessionManager2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        ProductBridgeViewModel productBridgeViewModel = new ProductBridgeViewModel(this.serviceRepository, this.postRepository, this.schemeHandler, this.eventTracker, this.sessionManager);
        return productBridgeViewModel;
    }
}
