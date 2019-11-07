package kr.co.popone.fitts.feature.store;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kr.co.popone.fitts.feature.cart.CartActivity;

final class StoreFragment$onViewCreated$4<T> implements Consumer<Unit> {
    final /* synthetic */ StoreFragment this$0;

    StoreFragment$onViewCreated$4(StoreFragment storeFragment) {
        this.this$0 = storeFragment;
    }

    public final void accept(Unit unit) {
        CartActivity.Companion.start(this.this$0.getContext(), "store");
    }
}
