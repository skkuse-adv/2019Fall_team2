package kr.co.popone.fitts.ui.custom;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.ui.custom.StoreOptionSelectDialog.Delegate;

final class StoreOptionSelectDialog$initializeView$3 implements OnClickListener {
    final /* synthetic */ StoreOptionSelectDialog this$0;

    StoreOptionSelectDialog$initializeView$3(StoreOptionSelectDialog storeOptionSelectDialog) {
        this.this$0 = storeOptionSelectDialog;
    }

    public final void onClick(View view) {
        Delegate delegate = this.this$0.getDelegate();
        String parsePriceAsJson = this.this$0.orderableOptionAdatper.parsePriceAsJson();
        Intrinsics.checkExpressionValueIsNotNull(parsePriceAsJson, "orderableOptionAdatper.parsePriceAsJson()");
        delegate.onCartButtonClicked(parsePriceAsJson);
    }
}
