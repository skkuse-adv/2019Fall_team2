package kr.co.popone.fitts.feature.push.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.model.order.OrderDetailViewData;

final class OrderReservationCompleteFragment$onViewCreated$7<T> implements Observer<OrderDetailViewData> {
    final /* synthetic */ OrderReservationCompleteFragment this$0;

    OrderReservationCompleteFragment$onViewCreated$7(OrderReservationCompleteFragment orderReservationCompleteFragment) {
        this.this$0 = orderReservationCompleteFragment;
    }

    public final void onChanged(OrderDetailViewData orderDetailViewData) {
        this.this$0.updateDepositUi(orderDetailViewData);
        this.this$0.updateOrderStateImage(orderDetailViewData);
    }
}
