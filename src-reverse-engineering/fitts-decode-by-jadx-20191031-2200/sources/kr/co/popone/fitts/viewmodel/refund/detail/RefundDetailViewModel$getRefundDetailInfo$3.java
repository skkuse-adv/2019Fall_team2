package kr.co.popone.fitts.viewmodel.refund.detail;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.remote.refund.RefundApplyResponse;

final class RefundDetailViewModel$getRefundDetailInfo$3<T> implements Consumer<RefundApplyResponse> {
    final /* synthetic */ RefundDetailViewModel this$0;

    RefundDetailViewModel$getRefundDetailInfo$3(RefundDetailViewModel refundDetailViewModel) {
        this.this$0 = refundDetailViewModel;
    }

    public final void accept(RefundApplyResponse refundApplyResponse) {
        this.this$0.getRefundInfoLiveData().setValue(refundApplyResponse);
    }
}
