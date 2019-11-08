package kr.co.popone.fitts.viewmodel.store.list;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.utils.ActionLogUtil;
import org.jetbrains.annotations.NotNull;

public final class ShopBookmarkViewModelFactory extends BaseViewModelFactory {
    private final ActionLogUtil actionLogUtil;
    private final EventTracker eventTracker;
    private final FittsSchemeHandler schemeHandler;
    private final StoreRepository storeRepository;

    public ShopBookmarkViewModelFactory(@NotNull StoreRepository storeRepository2, @NotNull EventTracker eventTracker2, @NotNull ActionLogUtil actionLogUtil2, @NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(actionLogUtil2, "actionLogUtil");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        this.storeRepository = storeRepository2;
        this.eventTracker = eventTracker2;
        this.actionLogUtil = actionLogUtil2;
        this.schemeHandler = fittsSchemeHandler;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new ShopBookmarkViewModel(this.storeRepository, this.eventTracker, this.actionLogUtil, this.schemeHandler);
    }
}
