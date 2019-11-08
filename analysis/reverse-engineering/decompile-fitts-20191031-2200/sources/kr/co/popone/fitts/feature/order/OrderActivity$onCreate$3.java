package kr.co.popone.fitts.feature.order;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.event.OrderEvent$OrderCompleteEvent;

final class OrderActivity$onCreate$3<T> implements Consumer<Object> {
    final /* synthetic */ OrderActivity this$0;

    OrderActivity$onCreate$3(OrderActivity orderActivity) {
        this.this$0 = orderActivity;
    }

    public final void accept(Object obj) {
        if (obj instanceof OrderEvent$OrderCompleteEvent) {
            this.this$0.finish();
        }
    }
}
