package kr.co.popone.fitts.viewmodel.push;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kr.co.popone.fitts.model.remote.model.RefundAccount;

final class OrderPushRendingViewModel$updateRefundAccountInfo$1<T> implements Consumer<RefundAccount> {
    final /* synthetic */ OrderPushRendingViewModel this$0;

    OrderPushRendingViewModel$updateRefundAccountInfo$1(OrderPushRendingViewModel orderPushRendingViewModel) {
        this.this$0 = orderPushRendingViewModel;
    }

    public final void accept(RefundAccount refundAccount) {
        this.this$0.getRefundAccountInputedLiveData().setValue(Unit.INSTANCE);
    }
}
