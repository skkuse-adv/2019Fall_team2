package kr.co.popone.fitts.viewmodel.order;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint;

final class OrderViewModel$getExpectedReceivablePoint$2<T> implements Consumer<Throwable> {
    final /* synthetic */ OrderViewModel this$0;

    OrderViewModel$getExpectedReceivablePoint$2(OrderViewModel orderViewModel) {
        this.this$0 = orderViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0._expectedReceivablePoint.setValue(ExpectedReceivablePoint.Companion.newEmpty());
    }
}
