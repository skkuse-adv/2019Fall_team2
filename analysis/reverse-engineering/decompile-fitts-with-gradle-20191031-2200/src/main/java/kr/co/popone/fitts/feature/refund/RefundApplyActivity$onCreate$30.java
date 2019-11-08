package kr.co.popone.fitts.feature.refund;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class RefundApplyActivity$onCreate$30<T> implements Observer<Throwable> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$30(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final void onChanged(Throwable th) {
        ActivityExtensionKt.handleErrorCodeMessage(this.this$0, th);
    }
}
