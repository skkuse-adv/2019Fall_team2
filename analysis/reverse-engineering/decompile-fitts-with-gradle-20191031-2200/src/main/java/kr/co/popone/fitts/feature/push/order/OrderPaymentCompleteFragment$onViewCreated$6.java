package kr.co.popone.fitts.feature.push.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.model.order.OrderDetailViewData;

final class OrderPaymentCompleteFragment$onViewCreated$6<T> implements Observer<OrderDetailViewData> {
    final /* synthetic */ OrderPaymentCompleteFragment this$0;

    OrderPaymentCompleteFragment$onViewCreated$6(OrderPaymentCompleteFragment orderPaymentCompleteFragment) {
        this.this$0 = orderPaymentCompleteFragment;
    }

    public final void onChanged(OrderDetailViewData orderDetailViewData) {
        this.this$0.updateDepositUi(orderDetailViewData);
        this.this$0.updateOrderStateImage(orderDetailViewData);
    }
}
