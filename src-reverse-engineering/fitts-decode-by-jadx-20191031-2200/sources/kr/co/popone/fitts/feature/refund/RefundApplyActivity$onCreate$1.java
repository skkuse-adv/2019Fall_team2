package kr.co.popone.fitts.feature.refund;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class RefundApplyActivity$onCreate$1 extends Lambda implements Function0<String> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$1(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
        super(0);
    }

    public final String invoke() {
        return this.this$0.getIntent().getStringExtra(RefundApplyActivity.KEY_PAYMENT_METHOD);
    }
}
