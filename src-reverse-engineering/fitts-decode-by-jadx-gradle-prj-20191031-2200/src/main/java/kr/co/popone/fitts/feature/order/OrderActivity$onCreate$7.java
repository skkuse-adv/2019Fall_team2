package kr.co.popone.fitts.feature.order;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.OrderEvent$OrderCompleteEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.order.complete.OrderCompleteRenderActivity;
import kr.co.popone.fitts.feature.order.complete.OrderCompleteRenderActivity.Companion;
import kr.co.popone.fitts.model.order.OrderCompleteViewData;

final class OrderActivity$onCreate$7<T> implements Observer<OrderCompleteViewData> {
    final /* synthetic */ OrderActivity this$0;

    OrderActivity$onCreate$7(OrderActivity orderActivity) {
        this.this$0 = orderActivity;
    }

    public final void onChanged(OrderCompleteViewData orderCompleteViewData) {
        RxBus.INSTANCE.post(new OrderEvent$OrderCompleteEvent());
        Companion companion = OrderCompleteRenderActivity.Companion;
        OrderActivity orderActivity = this.this$0;
        Long valueOf = orderCompleteViewData != null ? Long.valueOf(orderCompleteViewData.getOrderId()) : null;
        if (valueOf == null) {
            Intrinsics.throwNpe();
        }
        companion.start(orderActivity, valueOf.longValue());
    }
}
