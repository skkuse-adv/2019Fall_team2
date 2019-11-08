package kr.co.popone.fitts.viewmodel.alarm;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.utils.ActionLogUtil;
import org.jetbrains.annotations.NotNull;

public final class AlarmViewModelFactory extends BaseViewModelFactory {
    private final ActionLogUtil actionLogUtil;
    private final EventTracker eventTracker;
    private final FittsSchemeHandler fittsSchemeHandler;
    private final FittsServiceRepository fittsServiceRepository;

    public AlarmViewModelFactory(@NotNull FittsServiceRepository fittsServiceRepository2, @NotNull FittsSchemeHandler fittsSchemeHandler2, @NotNull EventTracker eventTracker2, @NotNull ActionLogUtil actionLogUtil2) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository2, "fittsServiceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler2, "fittsSchemeHandler");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(actionLogUtil2, "actionLogUtil");
        this.fittsServiceRepository = fittsServiceRepository2;
        this.fittsSchemeHandler = fittsSchemeHandler2;
        this.eventTracker = eventTracker2;
        this.actionLogUtil = actionLogUtil2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new AlarmViewModel(this.fittsServiceRepository, this.fittsSchemeHandler, this.eventTracker, this.actionLogUtil);
    }
}
