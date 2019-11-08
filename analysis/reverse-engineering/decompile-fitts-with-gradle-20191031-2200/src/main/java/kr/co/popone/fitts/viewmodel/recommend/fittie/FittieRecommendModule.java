package kr.co.popone.fitts.viewmodel.recommend.fittie;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.feature.recommend.fittie.FittieRecommendActivity;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;

public final class FittieRecommendModule {
    @NotNull
    public final FittieRecommendViewModel provideOrderViewModel(@NotNull FittieRecommendActivity fittieRecommendActivity, @NotNull FittieRecommendViewModelFactory fittieRecommendViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(fittieRecommendActivity, "activity");
        Intrinsics.checkParameterIsNotNull(fittieRecommendViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) fittieRecommendActivity, (Factory) fittieRecommendViewModelFactory).get(FittieRecommendViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…ndViewModel::class.java)]");
        return (FittieRecommendViewModel) viewModel;
    }

    @NotNull
    public final FittieRecommendViewModelFactory providesViewModelFactory(@NotNull FittsServiceRepository fittsServiceRepository, @NotNull UserAPI userAPI, @NotNull SessionManager sessionManager) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(userAPI, "userAPI");
        Intrinsics.checkParameterIsNotNull(sessionManager, "sessionManager");
        return new FittieRecommendViewModelFactory(fittsServiceRepository, userAPI, sessionManager);
    }
}
