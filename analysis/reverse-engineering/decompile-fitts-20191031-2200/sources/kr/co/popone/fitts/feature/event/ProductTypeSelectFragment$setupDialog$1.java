package kr.co.popone.fitts.feature.event;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.event.ProductTypeSelectFragment.ProductAdapter.Delegate;
import org.jetbrains.annotations.NotNull;

public final class ProductTypeSelectFragment$setupDialog$1 implements Delegate {
    final /* synthetic */ ProductTypeSelectFragment this$0;

    ProductTypeSelectFragment$setupDialog$1(ProductTypeSelectFragment productTypeSelectFragment) {
        this.this$0 = productTypeSelectFragment;
    }

    public void onProductSelected(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "item");
        this.this$0.dismiss();
        this.this$0.getDelegate().onProductSelected(str);
    }
}
