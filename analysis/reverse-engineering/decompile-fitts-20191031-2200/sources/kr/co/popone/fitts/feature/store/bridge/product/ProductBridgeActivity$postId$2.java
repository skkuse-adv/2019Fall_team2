package kr.co.popone.fitts.feature.store.bridge.product;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class ProductBridgeActivity$postId$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ ProductBridgeActivity this$0;

    ProductBridgeActivity$postId$2(ProductBridgeActivity productBridgeActivity) {
        this.this$0 = productBridgeActivity;
        super(0);
    }

    public final long invoke() {
        return this.this$0.getIntent().getLongExtra("post_id", -1);
    }
}
