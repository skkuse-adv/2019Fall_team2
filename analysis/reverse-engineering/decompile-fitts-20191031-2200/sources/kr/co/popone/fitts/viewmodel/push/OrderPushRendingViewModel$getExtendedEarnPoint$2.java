package kr.co.popone.fitts.viewmodel.push;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint;

final class OrderPushRendingViewModel$getExtendedEarnPoint$2<T> implements Consumer<Throwable> {
    final /* synthetic */ OrderPushRendingViewModel this$0;

    OrderPushRendingViewModel$getExtendedEarnPoint$2(OrderPushRendingViewModel orderPushRendingViewModel) {
        this.this$0 = orderPushRendingViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0._expectedReceivablePoint.setValue(ExpectedReceivablePoint.Companion.newEmpty());
    }
}
