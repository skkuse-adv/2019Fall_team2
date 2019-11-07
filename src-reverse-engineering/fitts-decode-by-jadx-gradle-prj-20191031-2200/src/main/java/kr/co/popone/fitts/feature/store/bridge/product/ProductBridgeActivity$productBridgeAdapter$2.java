package kr.co.popone.fitts.feature.store.bridge.product;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class ProductBridgeActivity$productBridgeAdapter$2 extends Lambda implements Function0<ProductBridgeAdapter> {
    final /* synthetic */ ProductBridgeActivity this$0;

    ProductBridgeActivity$productBridgeAdapter$2(ProductBridgeActivity productBridgeActivity) {
        this.this$0 = productBridgeActivity;
        super(0);
    }

    @NotNull
    public final ProductBridgeAdapter invoke() {
        return new ProductBridgeAdapter(this.this$0, this.this$0.getIntent().getBooleanExtra("has_product_info", false));
    }
}
