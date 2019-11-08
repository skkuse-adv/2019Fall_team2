package kr.co.popone.fitts.viewmodel.store.bridge.product;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kr.co.popone.fitts.model.store.ProductBridgeViewData;

final class ProductBridgeViewModel$getRecommendProductList$2<T> implements Consumer<ArrayList<ProductBridgeViewData>> {
    final /* synthetic */ ProductBridgeViewModel this$0;

    ProductBridgeViewModel$getRecommendProductList$2(ProductBridgeViewModel productBridgeViewModel) {
        this.this$0 = productBridgeViewModel;
    }

    public final void accept(ArrayList<ProductBridgeViewData> arrayList) {
        this.this$0.getProductItemsLiveData().setValue(arrayList);
        this.this$0._progressViewState.setValue(Integer.valueOf(8));
    }
}
