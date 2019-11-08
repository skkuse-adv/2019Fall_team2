package kr.co.popone.fitts.feature.order.detail;

import androidx.lifecycle.Observer;
import java.util.List;
import kr.co.popone.fitts.model.order.OrderDetailViewData;

final class OrderDetailActivity$onCreate$2<T> implements Observer<OrderDetailViewData> {
    final /* synthetic */ OrderDetailActivity this$0;

    OrderDetailActivity$onCreate$2(OrderDetailActivity orderDetailActivity) {
        this.this$0 = orderDetailActivity;
    }

    public final void onChanged(OrderDetailViewData orderDetailViewData) {
        this.this$0.updateOrderHeadInfo(orderDetailViewData);
        this.this$0.updateBillingInfo(orderDetailViewData);
        this.this$0.updateBankInfo(orderDetailViewData);
        this.this$0.updateUserInfo(orderDetailViewData);
        this.this$0.updateShippingInfo(orderDetailViewData);
        this.this$0.updatePredictPoint(orderDetailViewData);
        this.this$0.updateCancelButton(orderDetailViewData != null ? orderDetailViewData.getOrderState() : null);
        if (orderDetailViewData != null) {
            List orderListItems = orderDetailViewData.getOrderListItems();
            if (orderListItems != null) {
                this.this$0.orderDetailAdapter.setItems(orderListItems);
                this.this$0.postOrderStateChangeEvent(orderListItems);
            }
        }
    }
}
