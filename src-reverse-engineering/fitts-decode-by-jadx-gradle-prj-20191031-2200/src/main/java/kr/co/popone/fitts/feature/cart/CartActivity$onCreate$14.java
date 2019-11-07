package kr.co.popone.fitts.feature.cart;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.order.OrderActivity;
import kr.co.popone.fitts.feature.order.OrderActivity.Companion;
import kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData;
import kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData.Type;
import kr.co.popone.fitts.model.order.OrderInfoViewData;

final class CartActivity$onCreate$14<T> implements Observer<OrderInfoViewData> {
    final /* synthetic */ CartActivity this$0;

    CartActivity$onCreate$14(CartActivity cartActivity) {
        this.this$0 = cartActivity;
    }

    public final void onChanged(OrderInfoViewData orderInfoViewData) {
        Companion companion = OrderActivity.Companion;
        CartActivity cartActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(orderInfoViewData, "it");
        OrderInitialData orderInitialData = new OrderInitialData(orderInfoViewData, Type.CART, -1, null);
        companion.startActivity(cartActivity, orderInitialData);
    }
}
