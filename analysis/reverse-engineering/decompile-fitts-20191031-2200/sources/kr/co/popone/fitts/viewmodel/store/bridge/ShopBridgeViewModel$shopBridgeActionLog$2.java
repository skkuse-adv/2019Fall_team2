package kr.co.popone.fitts.viewmodel.store.bridge;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class ShopBridgeViewModel$shopBridgeActionLog$2<T> implements Consumer<Throwable> {
    final /* synthetic */ ShopBridgeViewModel this$0;

    ShopBridgeViewModel$shopBridgeActionLog$2(ShopBridgeViewModel shopBridgeViewModel) {
        this.this$0 = shopBridgeViewModel;
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionLogFail:: Type = Product, MainPath = ShopBridge, subId = ");
        sb.append(this.this$0.storeId);
        Logger.d(sb.toString(), new Object[0]);
    }
}
