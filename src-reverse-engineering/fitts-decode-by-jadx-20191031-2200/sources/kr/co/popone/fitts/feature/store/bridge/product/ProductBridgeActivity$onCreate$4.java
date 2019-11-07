package kr.co.popone.fitts.feature.store.bridge.product;

import androidx.lifecycle.Observer;
import java.util.ArrayList;
import kr.co.popone.fitts.model.store.ProductBridgeViewData;

final class ProductBridgeActivity$onCreate$4<T> implements Observer<ArrayList<ProductBridgeViewData>> {
    final /* synthetic */ ProductBridgeActivity this$0;

    ProductBridgeActivity$onCreate$4(ProductBridgeActivity productBridgeActivity) {
        this.this$0 = productBridgeActivity;
    }

    public final void onChanged(ArrayList<ProductBridgeViewData> arrayList) {
        this.this$0.getProductBridgeAdapter().submitList(arrayList);
    }
}
