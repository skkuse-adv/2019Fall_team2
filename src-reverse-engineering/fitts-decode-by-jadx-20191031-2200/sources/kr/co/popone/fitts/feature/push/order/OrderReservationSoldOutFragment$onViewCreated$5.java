package kr.co.popone.fitts.feature.push.order;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.order.OrderDetailViewData;

final class OrderReservationSoldOutFragment$onViewCreated$5<T> implements Observer<OrderDetailViewData> {
    final /* synthetic */ OrderReservationSoldOutFragment this$0;

    OrderReservationSoldOutFragment$onViewCreated$5(OrderReservationSoldOutFragment orderReservationSoldOutFragment) {
        this.this$0 = orderReservationSoldOutFragment;
    }

    public final void onChanged(OrderDetailViewData orderDetailViewData) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textOrderNumber);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textOrderNumber");
        if (orderDetailViewData == null) {
            Intrinsics.throwNpe();
        }
        textView.setText(orderDetailViewData.getOrderNumber());
    }
}
