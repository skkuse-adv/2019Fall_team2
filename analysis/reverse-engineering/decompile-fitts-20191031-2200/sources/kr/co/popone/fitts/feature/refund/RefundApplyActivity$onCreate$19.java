package kr.co.popone.fitts.feature.refund;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;

final class RefundApplyActivity$onCreate$19<T> implements Consumer<Boolean> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$19(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final void accept(Boolean bool) {
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        String str = "textAgreeNotice";
        String str2 = "textAgreeWithTerms";
        if (bool.booleanValue()) {
            RefundApplyActivity refundApplyActivity = this.this$0;
            TextView textView = (TextView) refundApplyActivity._$_findCachedViewById(C0010R$id.textAgreeWithTerms);
            Intrinsics.checkExpressionValueIsNotNull(textView, str2);
            refundApplyActivity.updateTextViewColor(textView, C0006R$color.gray6);
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textAgreeNotice);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            textView2.setVisibility(4);
            return;
        }
        RefundApplyActivity refundApplyActivity2 = this.this$0;
        TextView textView3 = (TextView) refundApplyActivity2._$_findCachedViewById(C0010R$id.textAgreeWithTerms);
        Intrinsics.checkExpressionValueIsNotNull(textView3, str2);
        refundApplyActivity2.updateTextViewColor(textView3, C0006R$color.neon_red);
        TextView textView4 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textAgreeNotice);
        Intrinsics.checkExpressionValueIsNotNull(textView4, str);
        textView4.setVisibility(0);
    }
}
