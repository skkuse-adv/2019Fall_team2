package kr.co.popone.fitts.feature.store.bridge.product;

import android.widget.ProgressBar;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class ProductBridgeActivity$onCreate$7<T> implements Observer<Integer> {
    final /* synthetic */ ProductBridgeActivity this$0;

    ProductBridgeActivity$onCreate$7(ProductBridgeActivity productBridgeActivity) {
        this.this$0 = productBridgeActivity;
    }

    public final void onChanged(Integer num) {
        ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(C0010R$id.progressBar);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, "progressBar");
        Intrinsics.checkExpressionValueIsNotNull(num, "it");
        progressBar.setVisibility(num.intValue());
    }
}
