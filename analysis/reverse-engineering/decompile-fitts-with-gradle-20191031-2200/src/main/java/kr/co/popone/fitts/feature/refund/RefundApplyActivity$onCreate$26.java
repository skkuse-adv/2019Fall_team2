package kr.co.popone.fitts.feature.refund;

import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.domain.refund.RefundInvalidViewState;

final class RefundApplyActivity$onCreate$26<T> implements Observer<List<? extends RefundInvalidViewState>> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$26(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final void onChanged(List<? extends RefundInvalidViewState> list) {
        RefundApplyActivity refundApplyActivity = this.this$0;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        refundApplyActivity.updateInvalidateView(list);
    }
}
