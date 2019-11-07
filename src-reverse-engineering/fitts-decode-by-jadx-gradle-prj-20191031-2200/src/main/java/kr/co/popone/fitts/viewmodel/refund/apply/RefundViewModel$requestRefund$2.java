package kr.co.popone.fitts.viewmodel.refund.apply;

import io.reactivex.functions.Consumer;

final class RefundViewModel$requestRefund$2<T> implements Consumer<Throwable> {
    final /* synthetic */ RefundViewModel this$0;

    RefundViewModel$requestRefund$2(RefundViewModel refundViewModel) {
        this.this$0 = refundViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorLiveData().setValue(th);
    }
}
