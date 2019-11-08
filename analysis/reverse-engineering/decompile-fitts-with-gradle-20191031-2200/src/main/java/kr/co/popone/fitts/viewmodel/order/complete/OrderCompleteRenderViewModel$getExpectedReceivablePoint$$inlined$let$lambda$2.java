package kr.co.popone.fitts.viewmodel.order.complete;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint;

final class OrderCompleteRenderViewModel$getExpectedReceivablePoint$$inlined$let$lambda$2<T> implements Consumer<Throwable> {
    final /* synthetic */ OrderCompleteRenderViewModel this$0;

    OrderCompleteRenderViewModel$getExpectedReceivablePoint$$inlined$let$lambda$2(OrderCompleteRenderViewModel orderCompleteRenderViewModel) {
        this.this$0 = orderCompleteRenderViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0._expectedReceivablePoint.setValue(ExpectedReceivablePoint.Companion.newEmpty());
    }
}
