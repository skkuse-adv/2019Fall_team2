package kr.co.popone.fitts.feature.store.bookmark;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.store.bridge.ShopBridgeActivity;
import kr.co.popone.fitts.feature.store.bridge.ShopBridgeActivity.Companion;
import kr.co.popone.fitts.feature.store.list.StoreListAdapter;

final class ShopBookmarkActivity$onCreate$$inlined$with$lambda$4<T> implements Observer<Long> {
    final /* synthetic */ ShopBookmarkActivity this$0;

    ShopBookmarkActivity$onCreate$$inlined$with$lambda$4(ShopBookmarkActivity shopBookmarkActivity, StoreListAdapter storeListAdapter) {
        this.this$0 = shopBookmarkActivity;
    }

    public final void onChanged(Long l) {
        Companion companion = ShopBridgeActivity.Companion;
        ShopBookmarkActivity shopBookmarkActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(l, "it");
        companion.start(shopBookmarkActivity, l.longValue());
    }
}
