package kr.co.popone.fitts.feature.order.orderlist;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.event.OrderEvent$OrderStateChangeEvent;

final class OrderListActivity$onCreate$7<T> implements Consumer<OrderEvent$OrderStateChangeEvent> {
    final /* synthetic */ OrderListActivity this$0;

    OrderListActivity$onCreate$7(OrderListActivity orderListActivity) {
        this.this$0 = orderListActivity;
    }

    public final void accept(OrderEvent$OrderStateChangeEvent orderEvent$OrderStateChangeEvent) {
        this.this$0.orderListAdapter.updateOrderLineItemState(orderEvent$OrderStateChangeEvent.getOrderId(), orderEvent$OrderStateChangeEvent.getOrderLineItems());
    }
}
