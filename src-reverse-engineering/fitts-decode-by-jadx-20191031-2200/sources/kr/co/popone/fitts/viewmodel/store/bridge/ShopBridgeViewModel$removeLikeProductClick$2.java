package kr.co.popone.fitts.viewmodel.store.bridge;

import io.reactivex.functions.Consumer;

final class ShopBridgeViewModel$removeLikeProductClick$2<T> implements Consumer<Throwable> {
    final /* synthetic */ ShopBridgeViewModel this$0;

    ShopBridgeViewModel$removeLikeProductClick$2(ShopBridgeViewModel shopBridgeViewModel) {
        this.this$0 = shopBridgeViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorLiveData().setValue(th);
    }
}
