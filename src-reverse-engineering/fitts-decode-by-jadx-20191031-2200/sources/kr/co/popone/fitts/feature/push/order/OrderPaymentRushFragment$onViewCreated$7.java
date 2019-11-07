package kr.co.popone.fitts.feature.push.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.model.order.OrderDetailViewData;

final class OrderPaymentRushFragment$onViewCreated$7<T> implements Observer<OrderDetailViewData> {
    final /* synthetic */ OrderPaymentRushFragment this$0;

    OrderPaymentRushFragment$onViewCreated$7(OrderPaymentRushFragment orderPaymentRushFragment) {
        this.this$0 = orderPaymentRushFragment;
    }

    public final void onChanged(OrderDetailViewData orderDetailViewData) {
        this.this$0.updateOrderStateImage(orderDetailViewData);
        this.this$0.updateDepositUi(orderDetailViewData);
    }
}
