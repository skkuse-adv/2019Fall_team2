package kr.co.popone.fitts.feature.order.detail;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class OrderDetailActivity$onResume$1 extends Lambda implements Function0<Long> {
    final /* synthetic */ OrderDetailActivity this$0;

    OrderDetailActivity$onResume$1(OrderDetailActivity orderDetailActivity) {
        this.this$0 = orderDetailActivity;
        super(0);
    }

    public final long invoke() {
        return this.this$0.getIntent().getLongExtra(OrderDetailActivity.KEY_ORDER_NUMBER, 0);
    }
}
