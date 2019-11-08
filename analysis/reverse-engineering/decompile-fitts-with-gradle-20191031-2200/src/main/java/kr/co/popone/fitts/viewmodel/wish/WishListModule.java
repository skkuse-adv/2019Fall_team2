package kr.co.popone.fitts.viewmodel.wish;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.wish.WishListActvitity;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import org.jetbrains.annotations.NotNull;

public final class WishListModule {
    @NotNull
    public final WishListViewModel provideOrderViewModel(@NotNull WishListActvitity wishListActvitity, @NotNull WishListViewModelFactory wishListViewModelFactory) {
        Intrinsics.checkParameterIsNotNull(wishListActvitity, "activity");
        Intrinsics.checkParameterIsNotNull(wishListViewModelFactory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of((FragmentActivity) wishListActvitity, (Factory) wishListViewModelFactory).get(WishListViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProviders.of(ac…stViewModel::class.java)]");
        return (WishListViewModel) viewModel;
    }

    @NotNull
    public final WishListViewModelFactory providesViewModelFactory(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull EventTracker eventTracker) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        return new WishListViewModelFactory(fittsCommerceRepository, eventTracker);
    }
}
