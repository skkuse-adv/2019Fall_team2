package kr.co.popone.fitts.feature.store.browser;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.ui.custom.StoreOptionSelectDialog;

final class StoreBrowserActivity$onCreate$11<T> implements Observer<Integer> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$11(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(Integer num) {
        StoreOptionSelectDialog access$getOptionSelectDialog$p = this.this$0.getOptionSelectDialog();
        if (num == null) {
            Intrinsics.throwNpe();
        }
        access$getOptionSelectDialog$p.setTotalPrice(num.intValue());
    }
}
