package kr.co.popone.fitts.viewmodel.cart;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.order.OrderInfoViewData;

final class CartViewModel$getPreOrderItems$1<T1, T2> implements BiConsumer<OrderInfoViewData, Throwable> {
    final /* synthetic */ CartViewModel this$0;

    CartViewModel$getPreOrderItems$1(CartViewModel cartViewModel) {
        this.this$0 = cartViewModel;
    }

    public final void accept(OrderInfoViewData orderInfoViewData, Throwable th) {
        if (orderInfoViewData != null) {
            this.this$0.getOrderableLiveData().setValue(orderInfoViewData);
        } else {
            this.this$0.getErrorLiveData().setValue(th);
        }
    }
}
