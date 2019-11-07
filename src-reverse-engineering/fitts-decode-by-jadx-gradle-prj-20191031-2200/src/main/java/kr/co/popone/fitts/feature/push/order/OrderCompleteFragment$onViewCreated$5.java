package kr.co.popone.fitts.feature.push.order;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.order.OrderDetailViewData;

final class OrderCompleteFragment$onViewCreated$5<T> implements Observer<OrderDetailViewData> {
    final /* synthetic */ OrderCompleteFragment this$0;

    OrderCompleteFragment$onViewCreated$5(OrderCompleteFragment orderCompleteFragment) {
        this.this$0 = orderCompleteFragment;
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
