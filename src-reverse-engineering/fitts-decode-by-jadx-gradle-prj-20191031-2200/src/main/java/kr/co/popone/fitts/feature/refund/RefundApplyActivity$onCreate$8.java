package kr.co.popone.fitts.feature.refund;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.custom.ExchangeReasonSelector.ExchangeReason;
import org.jetbrains.annotations.Nullable;

final class RefundApplyActivity$onCreate$8<T> implements Observer<ExchangeReason> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$8(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final void onChanged(@Nullable ExchangeReason exchangeReason) {
        String str = "textRefundReason";
        if (exchangeReason == null) {
            RefundApplyActivity refundApplyActivity = this.this$0;
            TextView textView = (TextView) refundApplyActivity._$_findCachedViewById(C0010R$id.textRefundReason);
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            refundApplyActivity.updateTextViewColor(textView, C0006R$color.neon_red);
            return;
        }
        RefundApplyActivity refundApplyActivity2 = this.this$0;
        TextView textView2 = (TextView) refundApplyActivity2._$_findCachedViewById(C0010R$id.textRefundReason);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str);
        refundApplyActivity2.updateTextViewColor(textView2, C0006R$color.gray6);
    }
}
