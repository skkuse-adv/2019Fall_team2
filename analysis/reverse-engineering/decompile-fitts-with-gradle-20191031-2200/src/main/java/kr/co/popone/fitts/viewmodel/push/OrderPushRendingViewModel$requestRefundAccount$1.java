package kr.co.popone.fitts.viewmodel.push;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.remote.model.RefundAccount;

final class OrderPushRendingViewModel$requestRefundAccount$1<T> implements Consumer<RefundAccount> {
    final /* synthetic */ OrderPushRendingViewModel this$0;

    OrderPushRendingViewModel$requestRefundAccount$1(OrderPushRendingViewModel orderPushRendingViewModel) {
        this.this$0 = orderPushRendingViewModel;
    }

    public final void accept(RefundAccount refundAccount) {
        this.this$0.getRefundAccountLiveData().setValue(refundAccount);
    }
}
