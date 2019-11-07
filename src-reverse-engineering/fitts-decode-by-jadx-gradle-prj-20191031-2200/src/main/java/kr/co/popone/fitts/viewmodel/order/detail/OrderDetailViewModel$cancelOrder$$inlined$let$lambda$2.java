package kr.co.popone.fitts.viewmodel.order.detail;

import io.reactivex.functions.Consumer;

final class OrderDetailViewModel$cancelOrder$$inlined$let$lambda$2<T> implements Consumer<Throwable> {
    final /* synthetic */ OrderDetailViewModel this$0;

    OrderDetailViewModel$cancelOrder$$inlined$let$lambda$2(OrderDetailViewModel orderDetailViewModel) {
        this.this$0 = orderDetailViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorLiveData().setValue(th);
    }
}
