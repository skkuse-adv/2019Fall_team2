package kr.co.popone.fitts.feature.refund;

import androidx.lifecycle.Observer;
import kotlin.Unit;

final class RefundApplyActivity$onCreate$28<T> implements Observer<Unit> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$28(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final void onChanged(Unit unit) {
        this.this$0.showConfirmDialog();
    }
}
