package kr.co.popone.fitts.feature.push.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;

final class OrderAllCancelFragment$onViewCreated$6<T> implements Observer<Throwable> {
    final /* synthetic */ OrderAllCancelFragment this$0;

    OrderAllCancelFragment$onViewCreated$6(OrderAllCancelFragment orderAllCancelFragment) {
        this.this$0 = orderAllCancelFragment;
    }

    public final void onChanged(Throwable th) {
        FragmentExtensionKt.handleError(this.this$0, th);
    }
}
