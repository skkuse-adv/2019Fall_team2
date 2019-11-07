package kr.co.popone.fitts.feature.order.detail;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class OrderDetailActivity$onCreate$8<T> implements Consumer<Throwable> {
    final /* synthetic */ OrderDetailActivity this$0;

    OrderDetailActivity$onCreate$8(OrderDetailActivity orderDetailActivity) {
        this.this$0 = orderDetailActivity;
    }

    public final void accept(Throwable th) {
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
