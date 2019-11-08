package kr.co.popone.fitts.viewmodel.store.bridge.product;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.store.bridge.product.ProductBridgeActivity;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.repository.PostRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;

public final class ProductBridgeModule {
    @NotNull
    public final ProductBridgeViewModel provideStoreViewModel(@NotNull ProductBridgeActivity productBridgeActivity, @NotNull ProductBridgeViewModelFactory productBridgeViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(productBridgeActivity, "activity");
        Intrinsics.checkParameterIsNotNull(productBridgeViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) productBridgeActivity, (Factory) productBridgeViewModelFactory).get(ProductBridgeViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…geViewModel::class.java)]");
        return (ProductBridgeViewModel) viewModel;
    }

    @NotNull
    public final ProductBridgeViewModelFactory providesViewModelFactory(@NotNull FittsServiceRepository fittsServiceRepository, @NotNull PostRepository postRepository, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull EventTracker eventTracker, @NotNull SessionManager sessionManager) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(postRepository, "postRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        Intrinsics.checkParameterIsNotNull(sessionManager, "sessionManager");
        ProductBridgeViewModelFactory productBridgeViewModelFactory = new ProductBridgeViewModelFactory(fittsServiceRepository, postRepository, fittsSchemeHandler, eventTracker, sessionManager);
        return productBridgeViewModelFactory;
    }
}
