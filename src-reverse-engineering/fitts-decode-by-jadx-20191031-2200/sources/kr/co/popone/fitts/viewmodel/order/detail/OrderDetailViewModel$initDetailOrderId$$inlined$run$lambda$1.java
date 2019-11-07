package kr.co.popone.fitts.viewmodel.order.detail;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.order.OrderDetailViewData;

final class OrderDetailViewModel$initDetailOrderId$$inlined$run$lambda$1<T1, T2> implements BiConsumer<OrderDetailViewData, Throwable> {
    final /* synthetic */ OrderDetailViewModel this$0;

    OrderDetailViewModel$initDetailOrderId$$inlined$run$lambda$1(OrderDetailViewModel orderDetailViewModel) {
        this.this$0 = orderDetailViewModel;
    }

    public final void accept(OrderDetailViewData orderDetailViewData, Throwable th) {
        if (orderDetailViewData != null) {
            this.this$0.getOrderDetailLiveData().setValue(orderDetailViewData);
        } else {
            this.this$0.getErrorLiveData().setValue(th);
        }
    }
}
