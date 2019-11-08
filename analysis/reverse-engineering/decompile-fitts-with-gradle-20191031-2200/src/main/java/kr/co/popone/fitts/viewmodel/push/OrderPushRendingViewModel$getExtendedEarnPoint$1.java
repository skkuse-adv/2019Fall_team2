package kr.co.popone.fitts.viewmodel.push;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint;

final class OrderPushRendingViewModel$getExtendedEarnPoint$1<T> implements Consumer<ExpectedReceivablePoint> {
    final /* synthetic */ OrderPushRendingViewModel this$0;

    OrderPushRendingViewModel$getExtendedEarnPoint$1(OrderPushRendingViewModel orderPushRendingViewModel) {
        this.this$0 = orderPushRendingViewModel;
    }

    public final void accept(ExpectedReceivablePoint expectedReceivablePoint) {
        this.this$0._expectedReceivablePoint.setValue(expectedReceivablePoint);
    }
}
