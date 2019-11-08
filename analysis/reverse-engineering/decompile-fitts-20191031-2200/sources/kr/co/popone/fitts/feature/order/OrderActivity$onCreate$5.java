package kr.co.popone.fitts.feature.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.order.OrderInfoViewData;
import kr.co.popone.fitts.ui.custom.DiscountChoiceSelector;

final class OrderActivity$onCreate$5<T> implements Observer<OrderInfoViewData> {
    final /* synthetic */ OrderActivity this$0;

    OrderActivity$onCreate$5(OrderActivity orderActivity) {
        this.this$0 = orderActivity;
    }

    public final void onChanged(OrderInfoViewData orderInfoViewData) {
        if (orderInfoViewData != null) {
            this.this$0.updateUserInfoView(orderInfoViewData.getUserInfo());
            this.this$0.updateProductLineItemsView(orderInfoViewData);
            this.this$0.updateBankInfoView(orderInfoViewData);
            this.this$0.userDefaultAddressInfo(orderInfoViewData.getUserAddress());
            ((DiscountChoiceSelector) this.this$0._$_findCachedViewById(C0010R$id.discountSelector)).setAdjustment(orderInfoViewData.getTotalProductPrice(), orderInfoViewData.getPointAdjustmentPolicy());
        }
    }
}
