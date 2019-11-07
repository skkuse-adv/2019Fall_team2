package kr.co.popone.fitts.feature.ncommerce;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class NCommerceActivity$onCreate$9<T> implements Observer<Throwable> {
    final /* synthetic */ NCommerceActivity this$0;

    NCommerceActivity$onCreate$9(NCommerceActivity nCommerceActivity) {
        this.this$0 = nCommerceActivity;
    }

    public final void onChanged(Throwable th) {
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
