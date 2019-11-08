package kr.co.popone.fitts.viewmodel.order.detail;

import io.reactivex.functions.Action;
import kotlin.Unit;

final class OrderDetailViewModel$cancelOrder$$inlined$let$lambda$1 implements Action {
    final /* synthetic */ OrderDetailViewModel this$0;

    OrderDetailViewModel$cancelOrder$$inlined$let$lambda$1(OrderDetailViewModel orderDetailViewModel) {
        this.this$0 = orderDetailViewModel;
    }

    public final void run() {
        this.this$0.getCancelCompleteLiveData().setValue(Unit.INSTANCE);
    }
}
