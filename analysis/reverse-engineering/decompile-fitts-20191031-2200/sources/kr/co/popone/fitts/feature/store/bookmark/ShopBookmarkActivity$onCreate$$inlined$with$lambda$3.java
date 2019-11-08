package kr.co.popone.fitts.feature.store.bookmark;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.store.list.StoreListAdapter;

final class ShopBookmarkActivity$onCreate$$inlined$with$lambda$3<T> implements Observer<Boolean> {
    final /* synthetic */ ShopBookmarkActivity this$0;

    ShopBookmarkActivity$onCreate$$inlined$with$lambda$3(ShopBookmarkActivity shopBookmarkActivity, StoreListAdapter storeListAdapter) {
        this.this$0 = shopBookmarkActivity;
    }

    public final void onChanged(Boolean bool) {
        ShopBookmarkActivity shopBookmarkActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        shopBookmarkActivity.updateViewVisiblity(bool.booleanValue());
    }
}
