package kr.co.popone.fitts.viewmodel.home;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.repository.home.HomeRepository;
import org.jetbrains.annotations.NotNull;

public final class HomeViewModelFactory extends BaseViewModelFactory {
    private final EventTracker eventTracker;
    private final HomeRepository repository;

    public HomeViewModelFactory(@NotNull HomeRepository homeRepository, @NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(homeRepository, "repository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.repository = homeRepository;
        this.eventTracker = eventTracker2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new HomeViewModel(this.repository, this.eventTracker);
    }
}
