package kr.co.popone.fitts.feature.refund;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.remote.refund.RefundApplyResponse;

final class RefundApplyCompleteFragment$onViewCreated$4<T> implements Observer<RefundApplyResponse> {
    final /* synthetic */ RefundApplyCompleteFragment this$0;

    RefundApplyCompleteFragment$onViewCreated$4(RefundApplyCompleteFragment refundApplyCompleteFragment) {
        this.this$0 = refundApplyCompleteFragment;
    }

    public final void onChanged(RefundApplyResponse refundApplyResponse) {
        RefundApplyCompleteFragment refundApplyCompleteFragment = this.this$0;
        if (refundApplyResponse == null) {
            Intrinsics.throwNpe();
        }
        refundApplyCompleteFragment.updateRefundDetailUi(refundApplyResponse);
    }
}
