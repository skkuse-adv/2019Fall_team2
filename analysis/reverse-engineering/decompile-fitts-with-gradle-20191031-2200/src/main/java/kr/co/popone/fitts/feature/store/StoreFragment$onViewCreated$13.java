package kr.co.popone.fitts.feature.store;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;

final class StoreFragment$onViewCreated$13<T> implements Observer<Throwable> {
    final /* synthetic */ StoreFragment this$0;

    StoreFragment$onViewCreated$13(StoreFragment storeFragment) {
        this.this$0 = storeFragment;
    }

    public final void onChanged(Throwable th) {
        FragmentExtensionKt.handleError(this.this$0, th);
    }
}
