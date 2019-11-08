package kr.co.popone.fitts.feature.push.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;

final class OrderPartCancelFragment$onViewCreated$10<T> implements Observer<Throwable> {
    final /* synthetic */ OrderPartCancelFragment this$0;

    OrderPartCancelFragment$onViewCreated$10(OrderPartCancelFragment orderPartCancelFragment) {
        this.this$0 = orderPartCancelFragment;
    }

    public final void onChanged(Throwable th) {
        FragmentExtensionKt.handleError(this.this$0, th);
    }
}
