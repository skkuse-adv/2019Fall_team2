package kr.co.popone.fitts.feature.push.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.model.order.OrderDetailViewData;

final class OrderPartCancelFragment$onViewCreated$5<T> implements Observer<OrderDetailViewData> {
    final /* synthetic */ OrderPartCancelFragment this$0;

    OrderPartCancelFragment$onViewCreated$5(OrderPartCancelFragment orderPartCancelFragment) {
        this.this$0 = orderPartCancelFragment;
    }

    public final void onChanged(OrderDetailViewData orderDetailViewData) {
        this.this$0.updateViewByPaymentType(orderDetailViewData);
    }
}
