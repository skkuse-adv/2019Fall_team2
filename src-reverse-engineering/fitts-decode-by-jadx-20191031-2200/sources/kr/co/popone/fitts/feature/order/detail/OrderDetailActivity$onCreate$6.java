package kr.co.popone.fitts.feature.order.detail;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class OrderDetailActivity$onCreate$6<T> implements Observer<Throwable> {
    final /* synthetic */ OrderDetailActivity this$0;

    OrderDetailActivity$onCreate$6(OrderDetailActivity orderDetailActivity) {
        this.this$0 = orderDetailActivity;
    }

    public final void onChanged(Throwable th) {
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
