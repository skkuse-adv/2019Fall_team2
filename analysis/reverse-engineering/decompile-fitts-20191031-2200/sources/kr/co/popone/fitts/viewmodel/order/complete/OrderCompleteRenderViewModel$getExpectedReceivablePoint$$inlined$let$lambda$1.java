package kr.co.popone.fitts.viewmodel.order.complete;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint;

final class OrderCompleteRenderViewModel$getExpectedReceivablePoint$$inlined$let$lambda$1<T> implements Consumer<ExpectedReceivablePoint> {
    final /* synthetic */ OrderCompleteRenderViewModel this$0;

    OrderCompleteRenderViewModel$getExpectedReceivablePoint$$inlined$let$lambda$1(OrderCompleteRenderViewModel orderCompleteRenderViewModel) {
        this.this$0 = orderCompleteRenderViewModel;
    }

    public final void accept(ExpectedReceivablePoint expectedReceivablePoint) {
        this.this$0._expectedReceivablePoint.setValue(expectedReceivablePoint);
    }
}
