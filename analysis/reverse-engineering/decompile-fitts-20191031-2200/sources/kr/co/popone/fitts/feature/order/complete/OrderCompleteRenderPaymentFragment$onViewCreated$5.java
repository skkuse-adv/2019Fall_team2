package kr.co.popone.fitts.feature.order.complete;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.model.order.OrderDetailViewData;

final class OrderCompleteRenderPaymentFragment$onViewCreated$5<T> implements Observer<OrderDetailViewData> {
    final /* synthetic */ OrderCompleteRenderPaymentFragment this$0;

    OrderCompleteRenderPaymentFragment$onViewCreated$5(OrderCompleteRenderPaymentFragment orderCompleteRenderPaymentFragment) {
        this.this$0 = orderCompleteRenderPaymentFragment;
    }

    public final void onChanged(OrderDetailViewData orderDetailViewData) {
        this.this$0.updateOrderInfoUi(orderDetailViewData);
        this.this$0.updateOrderDiscountTypeUi(orderDetailViewData);
    }
}
