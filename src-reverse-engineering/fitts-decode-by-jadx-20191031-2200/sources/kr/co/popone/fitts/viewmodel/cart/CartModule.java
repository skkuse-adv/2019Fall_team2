package kr.co.popone.fitts.viewmodel.cart;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.cart.CartActivity;
import kr.co.popone.fitts.repository.CartRepository;
import org.jetbrains.annotations.NotNull;

public final class CartModule {
    @NotNull
    public final CartViewModel provideCartViewModel(@NotNull CartActivity cartActivity, @NotNull CartViewModelFactory cartViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(cartActivity, "activity");
        Intrinsics.checkParameterIsNotNull(cartViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) cartActivity, (Factory) cartViewModelFactory).get(CartViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…rtViewModel::class.java)]");
        return (CartViewModel) viewModel;
    }

    @NotNull
    public final CartViewModelFactory providesViewModelFactory(@NotNull CartRepository cartRepository, @NotNull EventTracker eventTracker) {
        Intrinsics.checkParameterIsNotNull(cartRepository, "cartRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        return new CartViewModelFactory(cartRepository, eventTracker);
    }
}
