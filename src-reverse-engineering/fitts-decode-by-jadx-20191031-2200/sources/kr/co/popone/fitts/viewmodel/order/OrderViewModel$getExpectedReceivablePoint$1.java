package kr.co.popone.fitts.viewmodel.order;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint;

final class OrderViewModel$getExpectedReceivablePoint$1<T> implements Consumer<ExpectedReceivablePoint> {
    final /* synthetic */ OrderViewModel this$0;

    OrderViewModel$getExpectedReceivablePoint$1(OrderViewModel orderViewModel) {
        this.this$0 = orderViewModel;
    }

    public final void accept(ExpectedReceivablePoint expectedReceivablePoint) {
        this.this$0._expectedReceivablePoint.setValue(expectedReceivablePoint);
    }
}
