package kr.co.popone.fitts.feature.refund;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.remote.refund.RefundApplyResponse;

final class RefundCompleteFragment$onViewCreated$3<T> implements Observer<RefundApplyResponse> {
    final /* synthetic */ RefundCompleteFragment this$0;

    RefundCompleteFragment$onViewCreated$3(RefundCompleteFragment refundCompleteFragment) {
        this.this$0 = refundCompleteFragment;
    }

    public final void onChanged(RefundApplyResponse refundApplyResponse) {
        RefundCompleteFragment refundCompleteFragment = this.this$0;
        if (refundApplyResponse == null) {
            Intrinsics.throwNpe();
        }
        refundCompleteFragment.updateExchangeDetailUi(refundApplyResponse);
    }
}
