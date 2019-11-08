package kr.co.popone.fitts.viewmodel.push;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.order.OrderDetailViewData;

final class OrderPushRendingViewModel$requestOrderInfo$1<T> implements Consumer<OrderDetailViewData> {
    final /* synthetic */ OrderPushRendingViewModel this$0;

    OrderPushRendingViewModel$requestOrderInfo$1(OrderPushRendingViewModel orderPushRendingViewModel) {
        this.this$0 = orderPushRendingViewModel;
    }

    public final void accept(OrderDetailViewData orderDetailViewData) {
        this.this$0.getOrderDetailViewDataLiveData().setValue(orderDetailViewData);
    }
}
