package kr.co.popone.fitts.viewmodel.order.complete;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.order.OrderDetailViewData;

final class OrderCompleteRenderViewModel$getOrderLineItem$2<T> implements Consumer<OrderDetailViewData> {
    final /* synthetic */ OrderCompleteRenderViewModel this$0;

    OrderCompleteRenderViewModel$getOrderLineItem$2(OrderCompleteRenderViewModel orderCompleteRenderViewModel) {
        this.this$0 = orderCompleteRenderViewModel;
    }

    public final void accept(OrderDetailViewData orderDetailViewData) {
        this.this$0.getOrderDetailViewDataLiveData().setValue(orderDetailViewData);
    }
}
