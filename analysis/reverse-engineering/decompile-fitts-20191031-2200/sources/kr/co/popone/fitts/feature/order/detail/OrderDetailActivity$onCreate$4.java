package kr.co.popone.fitts.feature.order.detail;

import androidx.lifecycle.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

final class OrderDetailActivity$onCreate$4<T> implements Observer<Unit> {
    final /* synthetic */ OrderDetailActivity this$0;

    OrderDetailActivity$onCreate$4(OrderDetailActivity orderDetailActivity) {
        this.this$0 = orderDetailActivity;
    }

    public final void onChanged(Unit unit) {
        this.this$0.getViewModel().initDetailOrderId(new Function0<Long>(this) {
            final /* synthetic */ OrderDetailActivity$onCreate$4 this$0;

            {
                this.this$0 = r1;
            }

            public final long invoke() {
                return this.this$0.this$0.getIntent().getLongExtra(OrderDetailActivity.KEY_ORDER_NUMBER, 0);
            }
        });
    }
}
