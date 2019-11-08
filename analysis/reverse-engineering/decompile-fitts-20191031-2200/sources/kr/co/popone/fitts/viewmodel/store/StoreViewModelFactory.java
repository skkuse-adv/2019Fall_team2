package kr.co.popone.fitts.viewmodel.store;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;

public final class StoreViewModelFactory extends BaseViewModelFactory {
    private final EventTracker eventTracker;
    private final FittsServiceRepository serviceRepository;
    private final UserAPI userAPI;

    public StoreViewModelFactory(@NotNull UserAPI userAPI2, @NotNull EventTracker eventTracker2, @NotNull FittsServiceRepository fittsServiceRepository) {
        Intrinsics.checkParameterIsNotNull(userAPI2, "userAPI");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        this.userAPI = userAPI2;
        this.eventTracker = eventTracker2;
        this.serviceRepository = fittsServiceRepository;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new StoreViewModel(this.userAPI, this.eventTracker, this.serviceRepository);
    }
}
