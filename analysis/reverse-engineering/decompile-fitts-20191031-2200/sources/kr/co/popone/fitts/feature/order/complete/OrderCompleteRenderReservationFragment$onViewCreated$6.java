package kr.co.popone.fitts.feature.order.complete;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.model.order.OrderDetailViewData;

final class OrderCompleteRenderReservationFragment$onViewCreated$6<T> implements Observer<OrderDetailViewData> {
    final /* synthetic */ OrderCompleteRenderReservationFragment this$0;

    OrderCompleteRenderReservationFragment$onViewCreated$6(OrderCompleteRenderReservationFragment orderCompleteRenderReservationFragment) {
        this.this$0 = orderCompleteRenderReservationFragment;
    }

    public final void onChanged(OrderDetailViewData orderDetailViewData) {
        this.this$0.updateDepositUi(orderDetailViewData);
        this.this$0.updateOrderStateImage(orderDetailViewData);
    }
}
