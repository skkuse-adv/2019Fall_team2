package kr.co.popone.fitts.feature.store.bridge.product;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class ProductBridgeActivity$fromPost$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ ProductBridgeActivity this$0;

    ProductBridgeActivity$fromPost$2(ProductBridgeActivity productBridgeActivity) {
        this.this$0 = productBridgeActivity;
        super(0);
    }

    public final boolean invoke() {
        return this.this$0.getIntent().getBooleanExtra("from_post", false);
    }
}
