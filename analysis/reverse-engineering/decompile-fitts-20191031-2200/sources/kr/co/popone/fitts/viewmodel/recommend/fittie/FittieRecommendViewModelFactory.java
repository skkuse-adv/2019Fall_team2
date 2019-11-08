package kr.co.popone.fitts.viewmodel.recommend.fittie;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;

public final class FittieRecommendViewModelFactory extends BaseViewModelFactory {
    private final FittsServiceRepository serviceRepository;
    private final SessionManager sessionManager;
    private final UserAPI userAPI;

    public FittieRecommendViewModelFactory(@NotNull FittsServiceRepository fittsServiceRepository, @NotNull UserAPI userAPI2, @NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(userAPI2, "userAPI");
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        this.serviceRepository = fittsServiceRepository;
        this.userAPI = userAPI2;
        this.sessionManager = sessionManager2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new FittieRecommendViewModel(this.serviceRepository, this.userAPI, this.sessionManager);
    }
}
