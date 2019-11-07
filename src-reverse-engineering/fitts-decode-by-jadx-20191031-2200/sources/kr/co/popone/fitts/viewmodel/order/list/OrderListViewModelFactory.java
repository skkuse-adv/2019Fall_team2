package kr.co.popone.fitts.viewmodel.order.list;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import org.jetbrains.annotations.NotNull;

public final class OrderListViewModelFactory extends BaseViewModelFactory {
    private final FittsCommerceRepository commerceRepository;
    private final EventTracker eventTracker;

    public OrderListViewModelFactory(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.commerceRepository = fittsCommerceRepository;
        this.eventTracker = eventTracker2;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new OrderListViewModel(this.commerceRepository, this.eventTracker);
    }
}
