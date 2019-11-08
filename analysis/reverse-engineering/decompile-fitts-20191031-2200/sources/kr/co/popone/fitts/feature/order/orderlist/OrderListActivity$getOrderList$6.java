package kr.co.popone.fitts.feature.order.orderlist;

import androidx.lifecycle.Observer;

final class OrderListActivity$getOrderList$6<T> implements Observer<Boolean> {
    final /* synthetic */ OrderListActivity this$0;

    OrderListActivity$getOrderList$6(OrderListActivity orderListActivity) {
        this.this$0 = orderListActivity;
    }

    public final void onChanged(Boolean bool) {
        this.this$0.isEmptyList(bool != null ? bool.booleanValue() : true);
    }
}
