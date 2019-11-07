package kr.co.popone.fitts.viewmodel.store.list;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.store.bookmark.ShopBookmarkActivity;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.utils.ActionLogUtil;
import org.jetbrains.annotations.NotNull;

public final class ShopBookmarkModule {
    @NotNull
    public final ShopBookmarkViewModel provideStoreHomeViewModel(@NotNull ShopBookmarkActivity shopBookmarkActivity, @NotNull ShopBookmarkViewModelFactory shopBookmarkViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(shopBookmarkActivity, "activity");
        Intrinsics.checkParameterIsNotNull(shopBookmarkViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) shopBookmarkActivity, (Factory) shopBookmarkViewModelFactory).get(ShopBookmarkViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…rkViewModel::class.java)]");
        return (ShopBookmarkViewModel) viewModel;
    }

    @NotNull
    public final ShopBookmarkViewModelFactory providesViewModelFactory(@NotNull StoreRepository storeRepository, @NotNull EventTracker eventTracker, @NotNull ActionLogUtil actionLogUtil, @NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(storeRepository, "storeRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        Intrinsics.checkParameterIsNotNull(actionLogUtil, "actionLogUtil");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        return new ShopBookmarkViewModelFactory(storeRepository, eventTracker, actionLogUtil, fittsSchemeHandler);
    }
}
