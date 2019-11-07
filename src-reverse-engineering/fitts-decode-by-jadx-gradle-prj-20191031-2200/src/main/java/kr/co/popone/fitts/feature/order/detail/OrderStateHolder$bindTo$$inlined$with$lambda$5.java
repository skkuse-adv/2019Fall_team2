package kr.co.popone.fitts.feature.order.detail;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.event.OrderEvent$OrderExchangeDetailEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.order.detail.OrderStateHolder.OrderStateType;
import kr.co.popone.fitts.model.order.OrderListDetailViewData;

final class OrderStateHolder$bindTo$$inlined$with$lambda$5 implements OnClickListener {
    final /* synthetic */ OrderListDetailViewData $item$inlined;

    OrderStateHolder$bindTo$$inlined$with$lambda$5(View view, OrderStateHolder orderStateHolder, OrderStateType orderStateType, OrderListDetailViewData orderListDetailViewData) {
        this.$item$inlined = orderListDetailViewData;
    }

    public final void onClick(View view) {
        Long exchangeId = this.$item$inlined.getExchangeId();
        if (exchangeId != null) {
            RxBus.INSTANCE.post(new OrderEvent$OrderExchangeDetailEvent(this.$item$inlined.getOrderLineItemVariantId(), exchangeId.longValue()));
        }
    }
}
