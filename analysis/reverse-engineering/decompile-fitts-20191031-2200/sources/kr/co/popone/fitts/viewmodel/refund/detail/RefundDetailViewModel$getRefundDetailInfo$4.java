package kr.co.popone.fitts.viewmodel.refund.detail;

import io.reactivex.functions.Consumer;

final class RefundDetailViewModel$getRefundDetailInfo$4<T> implements Consumer<Throwable> {
    final /* synthetic */ RefundDetailViewModel this$0;

    RefundDetailViewModel$getRefundDetailInfo$4(RefundDetailViewModel refundDetailViewModel) {
        this.this$0 = refundDetailViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorLiveData().setValue(th);
    }
}
