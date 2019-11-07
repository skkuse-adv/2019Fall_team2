package kr.co.popone.fitts.feature.push.order;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.order.OrderDetailViewData;

final class OrderShippingCompleteFragment$onViewCreated$5<T> implements Observer<OrderDetailViewData> {
    final /* synthetic */ OrderShippingCompleteFragment this$0;

    OrderShippingCompleteFragment$onViewCreated$5(OrderShippingCompleteFragment orderShippingCompleteFragment) {
        this.this$0 = orderShippingCompleteFragment;
    }

    public final void onChanged(OrderDetailViewData orderDetailViewData) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textOrderNumber);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textOrderNumber");
        if (orderDetailViewData == null) {
            Intrinsics.throwNpe();
        }
        textView.setText(orderDetailViewData.getOrderNumber());
        this.this$0.updateOrderStateImage(orderDetailViewData);
    }
}
