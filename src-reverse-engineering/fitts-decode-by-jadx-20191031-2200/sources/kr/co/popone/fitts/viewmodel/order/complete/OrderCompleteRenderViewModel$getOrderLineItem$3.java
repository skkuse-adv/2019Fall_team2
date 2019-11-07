package kr.co.popone.fitts.viewmodel.order.complete;

import io.reactivex.functions.Consumer;

final class OrderCompleteRenderViewModel$getOrderLineItem$3<T> implements Consumer<Throwable> {
    final /* synthetic */ OrderCompleteRenderViewModel this$0;

    OrderCompleteRenderViewModel$getOrderLineItem$3(OrderCompleteRenderViewModel orderCompleteRenderViewModel) {
        this.this$0 = orderCompleteRenderViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorLiveData().setValue(th);
    }
}
