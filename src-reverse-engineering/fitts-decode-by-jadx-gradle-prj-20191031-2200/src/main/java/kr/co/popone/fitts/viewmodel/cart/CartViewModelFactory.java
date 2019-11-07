package kr.co.popone.fitts.viewmodel.cart;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.BaseViewModelFactory;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.repository.CartRepository;
import org.jetbrains.annotations.NotNull;

public final class CartViewModelFactory extends BaseViewModelFactory {
    @NotNull
    private final CartRepository cartRepository;
    @NotNull
    private final EventTracker eventTracker;

    public CartViewModelFactory(@NotNull CartRepository cartRepository2, @NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(cartRepository2, "cartRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.cartRepository = cartRepository2;
        this.eventTracker = eventTracker2;
    }

    @NotNull
    public final CartRepository getCartRepository() {
        return this.cartRepository;
    }

    @NotNull
    public final EventTracker getEventTracker() {
        return this.eventTracker;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public BaseViewModel createViewModel() {
        return new CartViewModel(this.cartRepository, this.eventTracker);
    }
}
