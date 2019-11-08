package kr.co.popone.fitts.viewmodel.refund.detail;

import io.reactivex.functions.Action;
import kotlin.Unit;

final class RefundDetailViewModel$cancelExchange$1 implements Action {
    final /* synthetic */ RefundDetailViewModel this$0;

    RefundDetailViewModel$cancelExchange$1(RefundDetailViewModel refundDetailViewModel) {
        this.this$0 = refundDetailViewModel;
    }

    public final void run() {
        this.this$0.getCancelCompleteLiveData().setValue(Unit.INSTANCE);
    }
}
