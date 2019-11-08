package kr.co.popone.fitts.feature.store.bridge.product;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import photopicker.utils.ScreenUtils;

final class ProductBridgeActivity$HEADER_HEIGHT$2 extends Lambda implements Function0<Double> {
    final /* synthetic */ ProductBridgeActivity this$0;

    ProductBridgeActivity$HEADER_HEIGHT$2(ProductBridgeActivity productBridgeActivity) {
        this.this$0 = productBridgeActivity;
        super(0);
    }

    public final double invoke() {
        double screenWidth = (double) ScreenUtils.INSTANCE.getScreenWidth(this.this$0);
        Double.isNaN(screenWidth);
        return screenWidth * 0.5694d;
    }
}
