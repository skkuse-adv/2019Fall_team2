package kr.co.popone.fitts.viewmodel.store.bridge;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Action;

final class ShopBridgeViewModel$shopBridgeActionLog$1 implements Action {
    final /* synthetic */ ShopBridgeViewModel this$0;

    ShopBridgeViewModel$shopBridgeActionLog$1(ShopBridgeViewModel shopBridgeViewModel) {
        this.this$0 = shopBridgeViewModel;
    }

    public final void run() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionLogSuccess:: Type = Product, MainPath = ShopBridge, subId = ");
        sb.append(this.this$0.storeId);
        Logger.d(sb.toString(), new Object[0]);
    }
}
