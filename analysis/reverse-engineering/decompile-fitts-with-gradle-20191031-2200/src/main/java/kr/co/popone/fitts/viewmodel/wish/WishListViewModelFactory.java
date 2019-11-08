package kr.co.popone.fitts.viewmodel.wish;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import org.jetbrains.annotations.NotNull;

public final class WishListViewModelFactory extends BaseViewModelFactory {
    @NotNull
    private final FittsCommerceRepository commerceRepository;
    @NotNull
    private final EventTracker eventTracker;

    @NotNull
    public final FittsCommerceRepository getCommerceRepository() {
        return this.commerceRepository;
    }

    @NotNull
    public final EventTracker getEventTracker() {
        return this.eventTracker;
    }

    public WishListViewModelFactory(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.commerceRepository = fittsCommerceRepository;
        this.eventTracker = eventTracker2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new WishListViewModel(this.commerceRepository, this.eventTracker);
    }
}
