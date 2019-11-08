package kr.co.popone.fitts.feature.refund;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class RefundApplyActivity$onCreate$22 extends Lambda implements Function0<Long> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$22(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
        super(0);
    }

    public final long invoke() {
        return this.this$0.getIntent().getLongExtra(RefundApplyActivity.KEY_ORDER_LINE_ITEM_VARIANT_ID, -1);
    }
}
