package kr.co.popone.fitts.feature.push.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;

final class OrderCompleteFragment$onViewCreated$11<T> implements Observer<Throwable> {
    final /* synthetic */ OrderCompleteFragment this$0;

    OrderCompleteFragment$onViewCreated$11(OrderCompleteFragment orderCompleteFragment) {
        this.this$0 = orderCompleteFragment;
    }

    public final void onChanged(Throwable th) {
        FragmentExtensionKt.handleError(this.this$0, th);
    }
}
