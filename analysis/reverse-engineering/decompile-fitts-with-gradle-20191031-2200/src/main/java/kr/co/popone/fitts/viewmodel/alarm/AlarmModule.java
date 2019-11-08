package kr.co.popone.fitts.viewmodel.alarm;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.alarm.AlarmFragment;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.utils.ActionLogUtil;
import org.jetbrains.annotations.NotNull;

public final class AlarmModule {
    @NotNull
    public final AlarmViewModel provideAlarmViewModel(@NotNull AlarmFragment alarmFragment, @NotNull AlarmViewModelFactory alarmViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(alarmFragment, "fragment");
        Intrinsics.checkParameterIsNotNull(alarmViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((Fragment) alarmFragment, (Factory) alarmViewModelFactory).get(AlarmViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(fr…rmViewModel::class.java)]");
        return (AlarmViewModel) viewModel;
    }

    @NotNull
    public final AlarmViewModelFactory providesViewModelFactory(@NotNull FittsServiceRepository fittsServiceRepository, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull EventTracker eventTracker, @NotNull ActionLogUtil actionLogUtil) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "fittsServiceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "fittsSchemeHandler");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        Intrinsics.checkParameterIsNotNull(actionLogUtil, "actionLogUtil");
        return new AlarmViewModelFactory(fittsServiceRepository, fittsSchemeHandler, eventTracker, actionLogUtil);
    }
}
