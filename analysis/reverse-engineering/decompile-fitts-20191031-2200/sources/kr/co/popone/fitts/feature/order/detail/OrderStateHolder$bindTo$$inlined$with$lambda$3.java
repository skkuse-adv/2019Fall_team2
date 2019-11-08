package kr.co.popone.fitts.feature.order.detail;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.event.OrderEvent$OrderExchangeEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.order.detail.OrderStateHolder.OrderStateType;
import kr.co.popone.fitts.model.order.OrderListDetailViewData;

final class OrderStateHolder$bindTo$$inlined$with$lambda$3 implements OnClickListener {
    final /* synthetic */ OrderListDetailViewData $item$inlined;

    OrderStateHolder$bindTo$$inlined$with$lambda$3(View view, OrderStateHolder orderStateHolder, OrderStateType orderStateType, OrderListDetailViewData orderListDetailViewData) {
        this.$item$inlined = orderListDetailViewData;
    }

    public final void onClick(View view) {
        RxBus.INSTANCE.post(new OrderEvent$OrderExchangeEvent(this.$item$inlined.getOrderLineItemVariantId()));
    }
}
