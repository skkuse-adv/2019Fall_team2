package kr.co.popone.fitts.feature.refund;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;

final class RefundApplyActivity$onCreate$13<T> implements Consumer<Integer> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$13(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final void accept(Integer num) {
        String str = "textRefundDetailReason";
        if (Intrinsics.compare(num.intValue(), 1) < 0) {
            RefundApplyActivity refundApplyActivity = this.this$0;
            TextView textView = (TextView) refundApplyActivity._$_findCachedViewById(C0010R$id.textRefundDetailReason);
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            refundApplyActivity.updateTextViewColor(textView, C0006R$color.neon_red);
            return;
        }
        RefundApplyActivity refundApplyActivity2 = this.this$0;
        TextView textView2 = (TextView) refundApplyActivity2._$_findCachedViewById(C0010R$id.textRefundDetailReason);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str);
        refundApplyActivity2.updateTextViewColor(textView2, C0006R$color.gray6);
    }
}
