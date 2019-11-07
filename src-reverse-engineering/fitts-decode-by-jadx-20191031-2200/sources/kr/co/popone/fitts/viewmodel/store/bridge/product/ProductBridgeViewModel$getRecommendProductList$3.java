package kr.co.popone.fitts.viewmodel.store.bridge.product;

import io.reactivex.functions.Consumer;

final class ProductBridgeViewModel$getRecommendProductList$3<T> implements Consumer<Throwable> {
    final /* synthetic */ ProductBridgeViewModel this$0;

    ProductBridgeViewModel$getRecommendProductList$3(ProductBridgeViewModel productBridgeViewModel) {
        this.this$0 = productBridgeViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorLiveData().setValue(th);
        this.this$0._progressViewState.setValue(Integer.valueOf(8));
    }
}
