package kr.co.popone.fitts.feature.refund;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class RefundCompleteActivity$onCreate$4<T> implements Observer<Throwable> {
    final /* synthetic */ RefundCompleteActivity this$0;

    RefundCompleteActivity$onCreate$4(RefundCompleteActivity refundCompleteActivity) {
        this.this$0 = refundCompleteActivity;
    }

    public final void onChanged(Throwable th) {
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
