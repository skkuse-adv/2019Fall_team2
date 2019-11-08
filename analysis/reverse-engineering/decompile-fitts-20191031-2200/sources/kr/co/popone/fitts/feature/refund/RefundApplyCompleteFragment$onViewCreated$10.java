package kr.co.popone.fitts.feature.refund;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;

final class RefundApplyCompleteFragment$onViewCreated$10<T> implements Observer<Throwable> {
    final /* synthetic */ RefundApplyCompleteFragment this$0;

    RefundApplyCompleteFragment$onViewCreated$10(RefundApplyCompleteFragment refundApplyCompleteFragment) {
        this.this$0 = refundApplyCompleteFragment;
    }

    public final void onChanged(Throwable th) {
        FragmentExtensionKt.handleError(this.this$0, th);
    }
}
