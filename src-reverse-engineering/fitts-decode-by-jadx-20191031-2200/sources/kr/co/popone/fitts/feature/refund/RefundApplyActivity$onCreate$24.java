package kr.co.popone.fitts.feature.refund;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class RefundApplyActivity$onCreate$24<T> implements Observer<Integer> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$24(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final void onChanged(Integer num) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textProductCount);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductCount");
        textView.setText(String.valueOf(num.intValue()));
    }
}
