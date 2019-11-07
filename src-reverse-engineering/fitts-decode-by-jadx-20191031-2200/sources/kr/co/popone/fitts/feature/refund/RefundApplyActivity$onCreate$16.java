package kr.co.popone.fitts.feature.refund;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;

final class RefundApplyActivity$onCreate$16<T> implements Consumer<Boolean> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$16(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final void accept(Boolean bool) {
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        String str = "textBankInfo";
        if (bool.booleanValue()) {
            RefundApplyActivity refundApplyActivity = this.this$0;
            TextView textView = (TextView) refundApplyActivity._$_findCachedViewById(C0010R$id.textBankInfo);
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            refundApplyActivity.updateTextViewColor(textView, C0006R$color.gray6);
            return;
        }
        RefundApplyActivity refundApplyActivity2 = this.this$0;
        TextView textView2 = (TextView) refundApplyActivity2._$_findCachedViewById(C0010R$id.textBankInfo);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str);
        refundApplyActivity2.updateTextViewColor(textView2, C0006R$color.neon_red);
    }
}
