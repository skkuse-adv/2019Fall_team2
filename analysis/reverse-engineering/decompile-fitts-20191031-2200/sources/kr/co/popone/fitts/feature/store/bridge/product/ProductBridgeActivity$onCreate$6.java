package kr.co.popone.fitts.feature.store.bridge.product;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class ProductBridgeActivity$onCreate$6<T> implements Observer<Throwable> {
    final /* synthetic */ ProductBridgeActivity this$0;

    ProductBridgeActivity$onCreate$6(ProductBridgeActivity productBridgeActivity) {
        this.this$0 = productBridgeActivity;
    }

    public final void onChanged(Throwable th) {
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
