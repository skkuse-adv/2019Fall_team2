package kr.co.popone.fitts.viewmodel.banner;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.banner.BannerActivity;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class BannerModule {
    @NotNull
    public final BannerViewModel provideCartViewModel(@NotNull BannerActivity bannerActivity, @NotNull BannerViewModelFactory bannerViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(bannerActivity, "activity");
        Intrinsics.checkParameterIsNotNull(bannerViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) bannerActivity, (Factory) bannerViewModelFactory).get(BannerViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…erViewModel::class.java)]");
        return (BannerViewModel) viewModel;
    }

    @NotNull
    public final BannerViewModelFactory providesViewModelFactory(@NotNull FittsServiceRepository fittsServiceRepository, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull ActionLogAPI actionLogAPI) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(actionLogAPI, "actionLogAPI");
        return new BannerViewModelFactory(fittsServiceRepository, fittsSchemeHandler, actionLogAPI);
    }
}
