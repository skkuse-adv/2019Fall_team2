package kr.co.popone.fitts.feature.store.browser;

import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.store.ProductVariantViewData;
import kr.co.popone.fitts.ui.custom.StoreOptionSelectDialog;

final class StoreBrowserActivity$onCreate$5<T> implements Observer<List<? extends ProductVariantViewData>> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$5(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(List<ProductVariantViewData> list) {
        StoreOptionSelectDialog access$getOptionSelectDialog$p = this.this$0.getOptionSelectDialog();
        if (list == null) {
            Intrinsics.throwNpe();
        }
        access$getOptionSelectDialog$p.setOptions(list);
    }
}
