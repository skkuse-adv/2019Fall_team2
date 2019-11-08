package kr.co.popone.fitts.feature.store.bridge;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.ui.ViewExtensionsKt;

final class ShopBridgeActivity$offset$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ ShopBridgeActivity this$0;

    ShopBridgeActivity$offset$2(ShopBridgeActivity shopBridgeActivity) {
        this.this$0 = shopBridgeActivity;
        super(0);
    }

    public final int invoke() {
        return ViewExtensionsKt.dpToPx((Context) this.this$0, 141);
    }
}
