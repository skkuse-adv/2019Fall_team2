package kr.co.popone.fitts.feature.push.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.model.order.OrderDetailViewData;

final class OrderAllCancelFragment$onViewCreated$4<T> implements Observer<OrderDetailViewData> {
    final /* synthetic */ OrderAllCancelFragment this$0;

    OrderAllCancelFragment$onViewCreated$4(OrderAllCancelFragment orderAllCancelFragment) {
        this.this$0 = orderAllCancelFragment;
    }

    public final void onChanged(OrderDetailViewData orderDetailViewData) {
        this.this$0.updateUiByPaymentMethod(orderDetailViewData);
    }
}
